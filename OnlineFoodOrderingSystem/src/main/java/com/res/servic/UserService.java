package com.res.servic;

import java.util.List;
import java.util.Optional;

import com.res.entity.User;

public interface UserService {
    User registerUser(User user);
    Optional<User> findByEmail(String email);
	List<User> getAllUsers();
}
