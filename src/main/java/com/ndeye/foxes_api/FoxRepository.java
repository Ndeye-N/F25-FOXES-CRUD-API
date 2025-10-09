package com.ndeye.foxes_api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FoxRepository extends JpaRepository<Fox, Long> {

    // derived queries
    List<Fox> findBySpeciesIgnoreCase(String species);

    List<Fox> findByNameContainingIgnoreCase(String name);

    // example custom JPQL (counts by species)
    @Query("SELECT COUNT(f) FROM Fox f WHERE LOWER(f.species) = LOWER(:species)")
    long countBySpecies(@Param("species") String species);
}
