package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.converter.UserToUserDTO;
import com.netcracker.edu.back.backend.dto.AuthToken;
import com.netcracker.edu.back.backend.dto.UserDTO;
import com.netcracker.edu.back.backend.entity.User;
import com.netcracker.edu.back.backend.security.TokenProvider;
import com.netcracker.edu.back.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @RequestMapping (value = "/sign-up", method = RequestMethod.POST)
    public ResponseEntity regNewUser(@RequestBody User user){
        User userAuth = copyUser(user);
        User userResult = userService.save(user);
        if(userResult == null) return ResponseEntity.badRequest().build();

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userAuth.getLogin(),
                        userAuth.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    private User copyUser(User user){
        User copy = new User();
        copy.setLogin(user.getLogin());
        copy.setPassword(user.getPassword());
        return copy;
    }


    @GetMapping("/user")
    public ResponseEntity<UserDTO> authUser(Principal userInfo){
        UserToUserDTO converter = new UserToUserDTO();
        User user = userService.findByLogin(userInfo.getName());
        if(user != null){
            return ResponseEntity.ok(converter.convert(user));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
