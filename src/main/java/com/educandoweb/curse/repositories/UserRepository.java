package com.educandoweb.curse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curse.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
