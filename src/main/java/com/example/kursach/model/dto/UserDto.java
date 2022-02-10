package com.example.kursach.model.dto;

import com.example.kursach.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;

    private String login;

    private String password;

    private Set<String> roles;
}
