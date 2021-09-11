package com.ecommerce.cartservice.repository;

import com.ecommerce.cartservice.entity.CartProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartProducts, Long> {

    Optional<CartProducts> findById(Long id);
}
