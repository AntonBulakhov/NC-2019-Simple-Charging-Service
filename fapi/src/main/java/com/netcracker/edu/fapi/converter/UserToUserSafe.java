package com.netcracker.edu.fapi.converter;

import com.netcracker.edu.fapi.dto.User;
import com.netcracker.edu.fapi.dto.UserSafe;
import org.springframework.core.convert.converter.Converter;

public class UserToUserSafe implements Converter<User, UserSafe> {

    @Override
    public UserSafe convert(User user) {
        UserSafe safe = new UserSafe();
        safe.setId(user.getId());
        safe.setEmail(user.getEmail());
        safe.setFirstname(user.getFirstname());
        safe.setSecondname(user.getSecondname());
        safe.setLogoUrl(user.getLogoUrl());
        safe.setRole(user.getRole());
        return safe;
    }
}
