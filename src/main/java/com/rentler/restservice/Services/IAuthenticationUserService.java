package com.rentler.restservice.Services;

import com.rentler.restservice.Model.*;

import java.util.List;

public interface IAuthenticationUserService {
    boolean checkIfUserIsCreated(User user);
    List<UserData> getAllUsers();
    String addUser(UserData userData);
    UserData getUserById(String userId);
}
