package com.cherry.catalogo.domain;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record Dress(
        Long id,
        @NotBlank String name,
        String description,
        @NotBlank String category,
        @NotBlank String size,
        String color,
        @NotNull @DecimalMin("0.0") BigDecimal price,
        @Min(0) int stock,
        String imageUrl,
        boolean available
) {
    public Dress withId(Long newId) {
        return new Dress(newId, name, description, category, size, color, price, stock, imageUrl, available);
    }
}
