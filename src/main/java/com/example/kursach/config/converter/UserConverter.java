package com.example.kursach.config.converter;

import com.example.kursach.model.Role;
import com.example.kursach.model.User;
import com.example.kursach.model.dto.UserDto;
import com.example.kursach.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserConverter {
    @Qualifier("userModelMapper")
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserDto toDto(User user){
        UserDto userDto = modelMapper.map(user, UserDto.class);
        Set<String> roles = new HashSet<>();
        user.getRoles().forEach(element -> {
            roles.add(element.getAuthority());
        });
        userDto.setRoles(roles);
        return userDto;
    }

    public User toEntity(UserDto userDto) {
        Set<Role> roles = new HashSet<>();
        User user = modelMapper.map(userDto, User.class);
        userDto.getRoles().forEach(element -> {
            roles.add(roleService.findAll().get(element));
        });
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }
}
