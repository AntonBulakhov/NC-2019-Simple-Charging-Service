package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.User;
import com.netcracker.edu.back.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByLogin(@PathVariable(name = "login") String login) {
        User user = userService.findByLogin(login);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }
}
