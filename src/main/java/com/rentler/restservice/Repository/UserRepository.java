package com.rentler.restservice.Repository;

import com.rentler.restservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
