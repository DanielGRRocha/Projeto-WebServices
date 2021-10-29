package com.daniel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
