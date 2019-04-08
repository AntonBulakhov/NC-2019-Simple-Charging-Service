package com.netcracker.edu.fapi.service.implementation;

import com.netcracker.edu.fapi.dto.Role;
import com.netcracker.edu.fapi.service.RoleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Value("${backend.server.url}")
    private String backendURL;

    @Override
    public List<Role> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Role[] roles  = restTemplate.getForObject(backendURL + "/api/role/get_roles", Role[].class);
        return roles == null ? Collections.emptyList() : Arrays.asList(roles);
    }
}
