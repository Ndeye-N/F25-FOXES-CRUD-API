package com.ndeye.foxes_api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/foxes")
@CrossOrigin // helpful when you later connect a frontend
public class FoxController {

    private final FoxService service;

    public FoxController(FoxService service) {
        this.service = service;
    }

    // GET /api/foxes
    @GetMapping
    public List<Fox> getAll() {
        return service.getAll();
    }

    // GET /api/foxes/{id}
    @GetMapping("/{id}")
    public Fox getById(@PathVariable Long id) {
        Fox fox = service.getById(id);
        if (fox == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fox not found");
        return fox;
    }

    // POST /api/foxes
    @PostMapping
    public ResponseEntity<Fox> create(@RequestBody Fox fox) {
        if (fox.getName() == null || fox.getDescription() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name and description are required");
        }
        Fox created = service.create(fox);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // PUT /api/foxes/{id}
    @PutMapping("/{id}")
    public Fox update(@PathVariable Long id, @RequestBody Fox fox) {
        Fox updated = service.update(id, fox);
        if (updated == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fox not found");
        return updated;
    }

    // DELETE /api/foxes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean ok = service.delete(id);
        if (!ok) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fox not found");
        return ResponseEntity.noContent().build();
    }

    // GET /api/foxes/category/{species}
    @GetMapping("/category/{species}")
    public List<Fox> bySpecies(@PathVariable String species) {
        return service.bySpecies(species);
    }

    // GET /api/foxes/search?name=substring
    @GetMapping("/search")
    public List<Fox> search(@RequestParam("name") String name) {
        return service.searchByName(name);
    }
}
