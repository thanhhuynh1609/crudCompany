package com.example.baitaph2buoi1.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.baitaph2buoi1.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

