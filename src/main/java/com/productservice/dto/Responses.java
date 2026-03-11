package com.productservice.dto;

import com.productservice.entity.ActivationKey;
import com.productservice.entity.Product;
import com.productservice.entity.Purchase;
import com.productservice.entity.User;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Responses {
    public record UserResponse(UUID id, String email, String username, String role, Instant createdAt) {
        public static UserResponse from(User user) {
            return new UserResponse(user.getId(), user.getEmail(), user.getUsername(),
                    user.getRole().name(), user.getCreatedAt());
        }
    }

    public record ProductResponse(UUID id, String name, String description, BigDecimal price, boolean active,
                                  Instant createdAt) {
        public static ProductResponse from(Product product) {
            return new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                    product.getPrice(), product.isActive(), product.getCreatedAt());
        }
    }

    public record ActivationKeyResponse(UUID id, String keyValue, UUID productId, boolean used, Instant createdAt) {
        public static ActivationKeyResponse from(ActivationKey key) {
            return new ActivationKeyResponse(key.getId(), key.getKeyValue(),
                    key.getProduct().getId(), key.isUsed(), key.getCreatedAt());
        }
    }

    public record PurchaseResponse(UUID id, UUID productId, String productName, String status, String activationKey,
                                   Instant purchasedAt, Instant activatedAt) {
        public static PurchaseResponse from(Purchase purchase) {
            String keyValue = purchase.getActivationKey() != null
                    ? purchase.getActivationKey().getKeyValue() : null;
            return new PurchaseResponse(purchase.getId(), purchase.getProduct().getId(),
                    purchase.getProduct().getName(), purchase.getStatus().name(), keyValue,
                    purchase.getPurchasedAt(), purchase.getActivatedAt());
        }
    }
}
