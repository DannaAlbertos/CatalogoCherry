package com.cherry.catalogo.domain.repository;

import com.cherry.catalogo.domain.Dress;

import java.util.List;
import java.util.Optional;

public interface DressRepository {
    List<Dress> getAll();
    Optional<Dress> getById(Long id);
    List<Dress> getByCategory(String category);
    Dress save(Dress dress);
    boolean exists(Long id);
    void delete(Long id);
}
