package com.market.her.domain.service;


import com.market.her.domain.dto.User;
import com.market.her.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
//    @Override
//    public Optional<User> getUser(int userId) {
//        return userRepository.getUser(userId);
//    }
    @Override
    @Transactional(readOnly = true)
    public Optional<User> userLogin(String user, String password) throws NoSuchElementException {
        return userRepository.loginUser(user,password);
    }
//    @Override
//    public List<User> getAll() {
//        return userRepository.getAll();
//    }

}
