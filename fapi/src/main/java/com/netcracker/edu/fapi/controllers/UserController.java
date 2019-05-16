package com.netcracker.edu.fapi.controllers;

import com.netcracker.edu.fapi.dto.User;
import com.netcracker.edu.fapi.service.StorageService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StorageService storageService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public ResponseEntity<Page<User>> getAllUsers(@RequestParam int page, @RequestParam String filter){
        Page<User> userPage = userService.getAllUsers(page, filter);
        if(userPage.getContent() != null){
            return ResponseEntity.ok(userPage);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/blocked/{login}")
    public ResponseEntity<Boolean> isBlocked(@PathVariable String login){
        User user = userService.isBlocked(login);
        if(user != null){
            if(user.getBlocked() == 1) return ResponseEntity.ok(true);
            else return ResponseEntity.ok(false);
        }else {
            return ResponseEntity.ok(false);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/block/id/{id}")
    public ResponseEntity blockUser(@PathVariable int id){
        userService.blockUser(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/unblock/id/{id}")
    public ResponseEntity unblockUser(@PathVariable int id){
        userService.unblockUser(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/companies")
    public ResponseEntity<Page<User>> getAllCompanies(@RequestParam int page){
        Page<User> userPage = userService.getAllCompanies(page);
        if(userPage.getContent() != null){
            return ResponseEntity.ok(userPage);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'SELLER')")
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public ResponseEntity<User> saveNewUser(@RequestBody User newUser){
        User user = userService.saveUser(newUser);
        if(user != null){
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> getUserByLogin(@RequestBody String login) {
        User user = userService.findUserByLogin(login);
        if(user == null) return ResponseEntity.ok(false);
        else return ResponseEntity.ok(true);
    }

    @PostMapping("/email")
    public ResponseEntity<Boolean> getUserByEmail(@RequestBody String email){
      User user = userService.findUserByEmail(email);
      if(user == null) return ResponseEntity.ok(false);
      else return ResponseEntity.ok(true);
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
