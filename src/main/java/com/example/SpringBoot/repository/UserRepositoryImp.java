package com.example.SpringBoot.repository;


import com.example.SpringBoot.model.User;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserRepositoryImp {
    private final UserRepository userRepository;

    public UserRepositoryImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void update(User user) {
        userRepository.save(user);
    }
}
