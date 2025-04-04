package com.pironeer.Assignment4.service;

import com.pironeer.Assignment4.dto.request.UserCreateReq;
import com.pironeer.Assignment4.entity.User;
import com.pironeer.Assignment4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long create(UserCreateReq req) {
        User user = User.create(req.getName());
        user = userRepository.save(user);

        return user.getId();
    }
}
