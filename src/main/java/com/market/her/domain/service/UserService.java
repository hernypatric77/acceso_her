package com.market.her.domain.service;


import com.market.her.domain.dto.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface UserService {

//    public Optional<User> getUser(int userId);
    public Optional<User> userLogin(String user, String password) throws NoSuchElementException;
//    public List<User> getAll();

}
