package com.ecloudsystems.user_service_for_ecloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAll() {
        return  userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        Optional<User> userById = userRepository.findById(id);
        return userById.orElse(null);
    }

    public User updateUser(Long id, User user) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isEmpty())
            throw new RuntimeException("User with id " + id + " is not found!");
        else {
            user.setId(id);
            return userRepository.save(user);
        }

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
