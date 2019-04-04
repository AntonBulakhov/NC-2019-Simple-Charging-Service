package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.entity.User;
import com.netcracker.edu.back.backend.service.RoleService;
import com.netcracker.edu.back.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByLogin(@PathVariable(name = "login") String login) {
        Role admin = new Role();
        admin.setId(1);
        admin.setName("admin");
        roleService.save(admin);
        User userr = new User();
        userr.setLogin("user");
        userr.setRole(admin);
        userService.save(userr);
        User user = userService.findByLogin(login);
        return ResponseEntity.ok(user);
    }
}
