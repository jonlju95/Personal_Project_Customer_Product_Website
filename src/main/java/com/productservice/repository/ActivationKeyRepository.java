package com.productservice.repository;

import com.productservice.entity.ActivationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ActivationKeyRepository extends JpaRepository<ActivationKey, UUID> {
    Optional<ActivationKey> findByKeyValue(String keyValue);

    @Query("SELECT ak FROM ActivationKey ak WHERE ak.product.id = :productId AND ak.used = false ORDER BY ak" +
            ".createdAt ASC LIMIT 1")
    Optional<ActivationKey> findFirstAvailableByProductId(UUID productId);

    long countByProductIdAndUsedFalse(UUID productId);
}
