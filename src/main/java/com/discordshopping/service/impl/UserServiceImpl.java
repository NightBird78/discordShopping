package com.discordshopping.service.impl;

import com.discordshopping.entity.User;
import com.discordshopping.entity.dto.UserDto;
import com.discordshopping.mapper.UserMapper;
import com.discordshopping.service.UserService;
import com.discordshopping.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User create(UserDto userDto) {
        User user = userMapper.dtoToUser(userDto);

        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public boolean create(User user) {
        if (userRepository.findById(user.getId()).isPresent()){
            return false;
        }
        userRepository.save(user);
        return true;
    }
}
