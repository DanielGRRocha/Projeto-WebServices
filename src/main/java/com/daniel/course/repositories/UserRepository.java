package com.daniel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
