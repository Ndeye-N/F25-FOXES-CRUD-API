package com.ndeye.foxes_api;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FoxService {

    private final FoxRepository repo;

    public FoxService(FoxRepository repo) {
        this.repo = repo;
    }

    public List<Fox> getAll() {
        return repo.findAll();
    }

    public Fox getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Fox create(Fox fox) {
        // ID is auto-generated; ensure null to avoid conflicts
        fox.setAnimalId(null);
        return repo.save(fox);
    }

    public Fox update(Long id, Fox updated) {
        return repo.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setSpecies(updated.getSpecies());
            existing.setAge(updated.getAge());
            existing.setActiveDate(updated.getActiveDate());
            return repo.save(existing);
        }).orElse(null);
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }

    public List<Fox> bySpecies(String species) {
        return repo.findBySpeciesIgnoreCase(species);
    }

    public List<Fox> searchByName(String q) {
        return repo.findByNameContainingIgnoreCase(q);
    }
}
