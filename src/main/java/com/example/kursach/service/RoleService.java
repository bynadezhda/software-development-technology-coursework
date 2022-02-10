package com.example.kursach.service;

import com.example.kursach.model.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RoleService {
    Map<String, Role> findAll();

    Role findByRole(String role);
}
