package com.market.her.domain.repository;



import com.market.her.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
//    List<User> getAll();
    //Optional<List<User>> getByCategory(int categoryId);
    //Optional<List<User>> getScarseUsers(int quantity);
//    Optional<User> getUser(int userId);
    Optional<User> loginUser(String user, String password);
   // User save(User user);
   // void delete(int userId);
}
