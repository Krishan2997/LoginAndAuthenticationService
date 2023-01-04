package com.rentler.restservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Users")
public class User {

    @Id
    @Column(name = "UserId")
    int userId;
    @Column(name = "PasswordHashCode")
    String password;

    public User(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User(){}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
