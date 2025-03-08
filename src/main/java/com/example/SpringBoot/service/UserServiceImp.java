package com.example.SpringBoot.service;

import com.example.SpringBoot.dao.UserDAO;
import com.example.SpringBoot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp {
    private final UserDAO userDAO;

    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Transactional
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.save(user);
    }
}
