package com.netcracker.edu.fapi.controllers;

import com.netcracker.edu.fapi.converter.UserToUserSafe;
import com.netcracker.edu.fapi.dto.AuthToken;
import com.netcracker.edu.fapi.dto.User;
import com.netcracker.edu.fapi.dto.UserSafe;
import com.netcracker.edu.fapi.security.TokenProvider;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity generateToken(@RequestBody User loginUser){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getLogin(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }


//    @RequestMapping (value = "/sign-up", method = RequestMethod.POST)
//    public ResponseEntity regNewUser(@RequestBody User user){
//        User userResult = userService.saveUser(user);
//        if(userResult == null) return ResponseEntity.badRequest().build();
//
//        final Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        userResult.getLogin(),
//                        userResult.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        final String token = tokenProvider.generateToken(authentication);
//        return ResponseEntity.ok(new AuthToken(token));
//    }

    @RequestMapping (value = "/sign-up", method = RequestMethod.POST)
    public ResponseEntity regNewUser(@RequestBody User user){
        User userResult = userService.saveUser(user);
        if(userResult == null) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok(userResult);
    }

    @GetMapping("/user")
    public ResponseEntity<UserSafe> authUser(Principal userInfo){
        UserToUserSafe converter = new UserToUserSafe();
        User user = userService.findUserByLogin(userInfo.getName());
        if(user != null){
            return ResponseEntity.ok(converter.convert(user));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
