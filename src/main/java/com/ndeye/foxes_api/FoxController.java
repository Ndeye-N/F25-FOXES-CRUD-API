package com.ndeye.foxes_api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "fox-list";
    }

    // GET /api/foxes/{id} — show details page
    @GetMapping("/{id}")
    public String foxDetails(@PathVariable Long id, Model model) {
        Fox fox = service.getById(id);
        if (fox == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fox not found");
        }
        model.addAttribute("fox", fox);
        return "fox-details";
    }

    // OPTIONAL filters/search
    @GetMapping("/category/{species}")
    public String foxesBySpecies(@PathVariable String species, Model model) {
        List<Fox> foxes = service.bySpecies(species);
        model.addAttribute("foxList", foxes);
        model.addAttribute("filter", "Species: " + species);
        return "fox-list";
    }

    @GetMapping("/search")
    public String searchFoxesByName(@RequestParam("name") String name, Model model) {
        List<Fox> foxes = service.searchByName(name);
        model.addAttribute("foxList", foxes);
        model.addAttribute("filter", "Name contains: " + name);
        return "fox-list";
    }

    // STEP 7: form pages

    // show create form
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("fox", new Fox());
        return "fox-create";
    }

    // show update form
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Fox fox = service.getById(id);
        if (fox == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fox not found");
        }
        model.addAttribute("fox", fox);
        return "fox-update";
    }

    // handle create form submit
    @PostMapping("/new")
    public String createFox(Fox fox) {
        service.create(fox);
        return "redirect:/api/foxes";
    }

    // handle update form submit
    @PostMapping("/update")
    public String updateFox(Fox fox) {
        if (fox.getAnimalId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing fox ID for update");
        }
        service.update(fox.getAnimalId(), fox);
        return "redirect:/api/foxes/" + fox.getAnimalId();
    }
}
