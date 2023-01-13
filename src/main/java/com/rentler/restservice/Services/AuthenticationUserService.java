package com.rentler.restservice.Services;

import com.rentler.restservice.Exception.DataMissMatchException;
import com.rentler.restservice.Exception.ResourceNotFoundException;
import com.rentler.restservice.Model.User;
import com.rentler.restservice.Model.UserData;
import com.rentler.restservice.Repository.UserDataRepository;
import com.rentler.restservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthenticationUserService implements IAuthenticationUserService{
    List<User> users;

    List<UserData> userData;

    @Autowired
    UserDataRepository userDataRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checkIfUserIsCreated(User user){
        return checkUsersAreInitiated() && checkUsernameAndPassword(user);
    }

    @Override
    public List<UserData> getAllUsers() {
        if(checkUsersAreInitiated()){
            return userData;
        }
        return null;
    }

    @Override
    public String addUser(UserData userData) {
        try {
            if(checkIfUsedDataIsValid(userData)){
                String userId=userData.getUserId();
                String password=userData.getPassword();
                User user=new User(userId, password);
                userRepository.save(user);
                userDataRepository.save(userData);
                return userId;
            }
        }
        catch (Exception e){
            throw new DataMissMatchException("Some issue while saving the data"+e.getMessage());
        }
        return "Data is not correct";
    }

    @Override
    public UserData getUserById(String userId) {
        Optional<UserData> optionalUserData=userDataRepository.findById(userId);
        if(optionalUserData.isPresent()) {
            return optionalUserData.get();
        }
        return null;
    }

    private boolean checkIfUsedDataIsValid(UserData userData){
        //TODO : Needs to be implemented
        return true;
    }

    private boolean checkIfLogInParametersAreValid(User user, User userDb){
        return user.equals(userDb);
    }

    private boolean checkUsersAreInitiated(){
        if (users == null){
            try {
                users=userRepository.findAll();
            }
            catch (Exception e){
                throw new ResourceNotFoundException("Error while loading data from Userepository"+e.getMessage());
            }
        }
        if(userData == null){
            try {
                userData = userDataRepository.findAll();
            }
            catch (Exception e){
                throw new ResourceNotFoundException("Error while loading data from UserDataRepository"+e.getMessage());
            }
        }
        return true;
    }

    private boolean checkUsernameAndPassword(User user){
        // TODO : Logic behind user check
        return true;
    }
}
