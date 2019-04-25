package com.netcracker.edu.back.backend.converter;

import com.netcracker.edu.back.backend.dto.UserDTO;
import com.netcracker.edu.back.backend.entity.User;
import org.springframework.core.convert.converter.Converter;

public class UserToUserDTO implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setLogoUrl(user.getLogoUrl());
        userDTO.setBlocked(user.getBlocked());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setSecondname(user.getSecondname());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
