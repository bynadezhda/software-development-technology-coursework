package com.example.kursach.controller;

import com.example.kursach.config.converter.UserConverter;
import com.example.kursach.model.User;
import com.example.kursach.model.dto.UserDto;
import com.example.kursach.service.RoleService;
import com.example.kursach.service.UserService;
import liquibase.pro.packaged.E;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserRestController {

    private final UserConverter userConverter;
    private final UserService userService;
    private final RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDto userDto) {
        User user = userConverter.toEntity(userDto);
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(userConverter.toDto(userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName())));
    }

    @GetMapping("/chek")
    public boolean chekAuthUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")) {
            return false;
        }
        return true;
    }

}
