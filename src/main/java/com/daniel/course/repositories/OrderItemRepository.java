package com.daniel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
