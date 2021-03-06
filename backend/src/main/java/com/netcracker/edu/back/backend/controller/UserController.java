package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.entity.User;
import com.netcracker.edu.back.backend.service.RoleService;
import com.netcracker.edu.back.backend.service.StorageService;
import com.netcracker.edu.back.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private StorageService storageService;

    private final int USERS_COUNT_ON_PAGE = 10;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<User> getAllUsers(@RequestParam int page, @RequestParam String filter){
        Role role;
        Page<User> result;
        switch (filter){
            case "admins":{
                role = roleService.findRoleByName("admin");
                result = userService.findAllInRole(new PageRequest(page, USERS_COUNT_ON_PAGE), role);
                return result;
            }
            case "users":{
                role = roleService.findRoleByName("user");
                result = userService.findAllInRole(new PageRequest(page, USERS_COUNT_ON_PAGE), role);
                return result;
            }
            case "blocked":{
                role = roleService.findRoleByName("seller");
                result = userService.findAllBlockedUsers(new PageRequest(page, USERS_COUNT_ON_PAGE), (byte)1, role);
                return result;
            }
            default:{
                role = roleService.findRoleByName("seller");
                result = userService.findAllUsers(new PageRequest(page, USERS_COUNT_ON_PAGE), role);
                return result;
            }
        }
    }

    @RequestMapping(value = "/block/id/{id}", method = RequestMethod.PUT)
    public User blockUser(@PathVariable int id){
        Optional<User> user = userService.findById(id);
        User entity = user.get();
        entity.setBlocked((byte)1);
        return userService.save(entity);
    }

    @RequestMapping(value = "/unblock/id/{id}", method = RequestMethod.PUT)
    public User unblockUser(@PathVariable int id){
        Optional<User> user = userService.findById(id);
        User entity = user.get();
        entity.setBlocked((byte)0);
        return userService.save(entity);
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public Page<User> getAllCompanies(@RequestParam int page){
        Role role = roleService.findRoleByName("seller");
        return userService.findAllCompanies(new PageRequest(page, USERS_COUNT_ON_PAGE), role);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findById(id).get();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

        if(user.getLogin().equals(principal.getUsername()) || hasAdminRole){
            return ResponseEntity.ok(user);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/blocked/{login}", method = RequestMethod.GET)
    public Boolean isUserBlocked(@PathVariable String login) {
        User user = userService.findByLogin(login);
        return user.getBlocked() != 0;
    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByLogin(@PathVariable(name = "login") String login) {
        User user = userService.findByLogin(login);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        userService.save(user);
        return userService.findByLogin(user.getLogin());
    }

    @PostMapping("/image")
    public ResponseEntity saveProductImage(@RequestParam("image") MultipartFile file){
        if(storageService.storeUserImage(file)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/image/{name}")
    public ResponseEntity<Resource> getProductImage(@PathVariable String name){
        Resource res = storageService.getUserImage(name);
        if(res != null){
            return ResponseEntity.ok(res);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
