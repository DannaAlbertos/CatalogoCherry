package com.cherry.catalogo.persistence;

import com.cherry.catalogo.domain.Dress;
import com.cherry.catalogo.domain.repository.DressRepository;
import com.cherry.catalogo.persistence.crud.DressCrudRepository;
import com.cherry.catalogo.persistence.entity.DressEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DressPersistenceRepository implements DressRepository {

    private final DressCrudRepository crud;

    public DressPersistenceRepository(DressCrudRepository crud) {
        this.crud = crud;
    }

    @Override
    public List<Dress> getAll() {
        return crud.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Optional<Dress> getById(Long id) {
        return crud.findById(id).map(this::toDomain);
    }

    @Override
    public List<Dress> getByCategory(String category) {
        return crud.findByCategoryIgnoreCase(category).stream().map(this::toDomain).toList();
    }

    @Override
    public Dress save(Dress dress) {
        return toDomain(crud.save(toEntity(dress)));
    }

    @Override
    public boolean exists(Long id) {
        return crud.existsById(id);
    }

    @Override
    public void delete(Long id) {
        crud.deleteById(id);
    }

    private Dress toDomain(DressEntity e) {
        return new Dress(e.getId(), e.getName(), e.getDescription(), e.getCategory(), e.getSize(),
                e.getColor(), e.getPrice(), e.getStock(), e.getImageUrl(), e.isAvailable());
    }

    private DressEntity toEntity(Dress d) {
        DressEntity e = new DressEntity();
        e.setId(d.id());
        e.setName(d.name());
        e.setDescription(d.description());
        e.setCategory(d.category());
        e.setSize(d.size());
        e.setColor(d.color());
        e.setPrice(d.price());
        e.setStock(d.stock());
        e.setImageUrl(d.imageUrl());
        e.setAvailable(d.available());
        return e;
    }
}
