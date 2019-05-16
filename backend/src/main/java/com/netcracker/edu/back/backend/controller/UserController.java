package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.entity.User;
import com.netcracker.edu.back.backend.service.RoleService;
import com.netcracker.edu.back.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

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
        Optional<User> user = userService.findById(id);
        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        }else {
            return ResponseEntity.notFound().build();
        }
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
}
