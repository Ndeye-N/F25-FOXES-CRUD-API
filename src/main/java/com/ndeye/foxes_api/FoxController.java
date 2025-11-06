package com.ndeye.foxes_api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/api/foxes")
@CrossOrigin
public class FoxController {

    private final FoxService service;

    public FoxController(FoxService service) {
        this.service = service;
    }

    // GET /api/foxes — show list page
    @GetMapping
    public String listFoxes(Model model) {
        List<Fox> foxes = service.getAll();
        model.addAttribute("foxList", foxes);
        return "fox-list";  // will look for templates/fox-list.ftlh
    }

    // GET /api/foxes/{id} — show details page
    @GetMapping("/{id}")
    public String foxDetails(@PathVariable Long id, Model model) {
        Fox fox = service.getById(id);
        if (fox == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fox not found");
        }
        model.addAttribute("fox", fox);
        return "fox-details";  // will look for templates/fox-details.ftlh
    }

    // (The POST/PUT/DELETE mappings will be updated in later steps)
}
