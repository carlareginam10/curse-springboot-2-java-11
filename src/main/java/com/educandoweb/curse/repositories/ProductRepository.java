package com.educandoweb.curse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curse.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
