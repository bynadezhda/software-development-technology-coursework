package com.example.kursach.service;

import com.example.kursach.model.Role;
import com.example.kursach.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
@EnableCaching
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Override
    @Transactional
    @Caching
    public Map<String, Role> findAll() {
        Map<String, Role> map = new HashMap<>();

        roleRepository.findAll().forEach(element -> {
            map.put(element.getAuthority(), element);
        });
        return map;
    }

    @Override
    @Transactional
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
