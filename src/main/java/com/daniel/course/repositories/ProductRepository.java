package com.daniel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
