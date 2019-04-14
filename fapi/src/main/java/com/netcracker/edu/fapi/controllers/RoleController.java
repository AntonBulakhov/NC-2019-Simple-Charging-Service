package com.netcracker.edu.fapi.controllers;

import com.netcracker.edu.fapi.dto.Role;
import com.netcracker.edu.fapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/get_all")
    public List<Role> getAllRoles(){
        return roleService.findAll();
    }
}
