package com.netcracker.edu.fapi.controllers;

import com.netcracker.edu.fapi.dto.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.getUserById(id));
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

    @PostMapping("")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        System.out.println(user.getPassword());
        if(user != null){
            return ResponseEntity.ok(userService.saveUser(user));
        }else return null;
    }
}
