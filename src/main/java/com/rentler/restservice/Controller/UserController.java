package com.rentler.restservice.Controller;

import com.rentler.restservice.Exception.ResourceNotFoundException;
import com.rentler.restservice.Model.User;
import com.rentler.restservice.Model.UserData;
import com.rentler.restservice.Services.IAuthenticationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    IAuthenticationUserService authenticationUserService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String logInUser(@RequestBody User user, HttpSession session){
        if(session.getAttribute("username")!=null){
            return "User already logged in";
        }
        if(authenticationUserService.checkIfUserIsCreated(user)){
            session.setAttribute("username", user.getUserId());
            return "Login successful";
        }
        return "Wrong username or password";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public UserData signUpUser(@RequestBody UserData userData, HttpSession session, String password){
        if(session.getAttribute("username")==null){
            authenticationUserService.addUser(userData, password);
            return userData;
        }
        return null;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public boolean logOut(HttpSession session){
        if(session.getAttribute("username")!=null){
            session.setAttribute("username", null);
        }
        return session.getAttribute("username")==null;
    }

    @RequestMapping(value = "allusers", method = RequestMethod.POST)
    public List<UserData> getUsers(){
        return authenticationUserService.getAllUsers();
    }

    @RequestMapping(value = "getCurrentUserData", method = RequestMethod.GET)
    public UserData getCurrentUserData(HttpSession session){
        try{
            int userId= (int) session.getAttribute("username");
            if(userId!=0) {
                return authenticationUserService.getUserById(userId);
            }
            return null;
        }
        catch (Exception ex){
            throw new ResourceNotFoundException("not yet authenticated");
        }
    }
}
