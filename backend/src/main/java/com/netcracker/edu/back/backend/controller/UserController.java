package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Role;
import com.netcracker.edu.back.backend.entity.User;
import com.netcracker.edu.back.backend.service.RoleService;
import com.netcracker.edu.back.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public void saveUser() {
        User user = new User();
        user.setId(1);
        user.setLogin("asd");
        user.setEmail("asdasdsad");
        user.setBlocked((byte)0);
        user.setFirstname("asdasd");
        user.setSecondname("asdasdas");
        user.setLogourl("asdasdasd");
        userService.save(user);

        User user2 = new User();
        user2.setId(2);
        user2.setLogin("qwe");
        user2.setEmail("ewtwet");
        user2.setBlocked((byte)0);
        user2.setFirstname("ewtwet");
        user2.setSecondname("yutyjt");
        user2.setLogourl("rthrthrh");
        userService.save(user2);
    }
}
