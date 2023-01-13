package com.rentler.restservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Users")
public class User {

    @Id
    @Column(name = "UserId")
    String userId;
    @Column(name = "PasswordHashCode")
    String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User(){}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
