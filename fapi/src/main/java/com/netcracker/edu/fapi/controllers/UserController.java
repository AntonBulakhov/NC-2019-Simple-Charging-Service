package com.netcracker.edu.fapi.controllers;

import com.netcracker.edu.fapi.dto.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        if(user != null){
            return ResponseEntity.ok(userService.saveUser(user));
        }else return null;
    }
}
