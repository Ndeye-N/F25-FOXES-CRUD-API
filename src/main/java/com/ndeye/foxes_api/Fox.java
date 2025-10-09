package com.ndeye.foxes_api;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "foxes")
public class Fox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 2000)
    private String description;

    // extra attributes for the assignment
    @Column(nullable = false)
    private String species;      // category field (e.g., Red, Arctic, Fennec)

    private Double age;          // years (can be fractional)

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate activeDate; // when added/featured

    // --- constructors ---
    public Fox() {}

    public Fox(String name, String description, String species, Double age, LocalDate activeDate) {
        this.name = name;
        this.description = description;
        this.species = species;
        this.age = age;
        this.activeDate = activeDate;
    }

    // --- getters & setters ---
    public Long getAnimalId() { return animalId; }
    public void setAnimalId(Long animalId) { this.animalId = animalId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public Double getAge() { return age; }
    public void setAge(Double age) { this.age = age; }

    public LocalDate getActiveDate() { return activeDate; }
    public void setActiveDate(LocalDate activeDate) { this.activeDate = activeDate; }
}
