package com.ecommerce.orderservice.repository;

import com.ecommerce.orderservice.entity.OrderObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderObject, Long> {

    Optional<OrderObject> findById(Long id);
}
