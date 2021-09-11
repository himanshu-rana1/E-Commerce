package com.ecommerce.catalogservice.repository;

import com.ecommerce.catalogservice.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long > {

    List<Products> findByCategoryEquals(String Category);

    List<Products> findByNameEquals(String name);

    Optional<Products> findById(Long id);
}
