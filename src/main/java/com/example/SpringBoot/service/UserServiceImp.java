package com.example.SpringBoot.service;


import com.example.SpringBoot.model.User;
import com.example.SpringBoot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    @Transactional
    @Override
    public void update(User user) {
        userRepository.save(user);
    }
}
