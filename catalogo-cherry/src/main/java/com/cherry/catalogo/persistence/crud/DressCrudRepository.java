package com.cherry.catalogo.persistence.crud;

import com.cherry.catalogo.persistence.entity.DressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DressCrudRepository extends JpaRepository<DressEntity, Long> {
    List<DressEntity> findByCategoryIgnoreCase(String category);
}
