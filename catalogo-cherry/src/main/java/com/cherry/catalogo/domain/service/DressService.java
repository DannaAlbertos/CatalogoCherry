package com.cherry.catalogo.domain.service;

import com.cherry.catalogo.domain.Dress;
import com.cherry.catalogo.domain.repository.DressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DressService {

    private final DressRepository dressRepository;

    public DressService(DressRepository dressRepository) {
        this.dressRepository = dressRepository;
    }

    public List<Dress> getAll() {
        return dressRepository.getAll();
    }

    public Optional<Dress> getById(Long id) {
        return dressRepository.getById(id);
    }

    public List<Dress> getByCategory(String category) {
        return dressRepository.getByCategory(category);
    }

    public Dress save(Dress dress) {
        return dressRepository.save(dress.withId(null));
    }

    public Optional<Dress> update(Long id, Dress dress) {
        if (!dressRepository.exists(id)) {
            return Optional.empty();
        }
        return Optional.of(dressRepository.save(dress.withId(id)));
    }

    public boolean delete(Long id) {
        if (!dressRepository.exists(id)) {
            return false;
        }
        dressRepository.delete(id);
        return true;
    }
}
