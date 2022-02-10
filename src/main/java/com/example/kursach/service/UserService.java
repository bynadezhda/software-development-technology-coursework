package com.example.kursach.service;

import com.example.kursach.model.User;

public interface UserService {
    User findByLogin(String login);

    void save(User user);
}
