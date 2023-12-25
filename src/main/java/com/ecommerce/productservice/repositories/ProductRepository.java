package com.ecommerce.productservice.repositories;

import com.ecommerce.productservice.models.Price;
import com.ecommerce.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    <S extends Product> S save(S entity);

    @Override
    List<Product> findAllById(Iterable<UUID> uuids);

    @Override
    Optional<Product> findById(UUID uuid);

    @Override
    void deleteById(UUID uuid);

    List<Product> findByPriceValueGreaterThanEqual(double price_value);

    @Query("SELECT p FROM products p WHERE p.description = ?1")
    Optional<Product> findByTitle(String title);

}
