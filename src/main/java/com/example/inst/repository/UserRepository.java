package com.example.inst.repository;

import com.example.inst.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User getByUsername(String username);
}
