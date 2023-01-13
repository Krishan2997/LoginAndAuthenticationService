package com.rentler.restservice.Repository;

import com.rentler.restservice.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, String> {
}
