package com.example.pironeer.service;

import com.example.pironeer.domain.User;
import com.example.pironeer.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // 유저 생성 메서드
    public Long createUser(User user) {
        userRepository.save(user);
        return user.id;
    }


}
