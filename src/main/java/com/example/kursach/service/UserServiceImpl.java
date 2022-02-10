package com.example.kursach.service;

import com.example.kursach.model.User;
import com.example.kursach.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    @Transactional
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    @Transactional
    public void save(User user) {
        if (userRepository.existsByLogin(user.getLogin())) {
            user.setId(userRepository.findByLogin(user.getLogin()).getId());
        }
        userRepository.save(user);
    }
}
