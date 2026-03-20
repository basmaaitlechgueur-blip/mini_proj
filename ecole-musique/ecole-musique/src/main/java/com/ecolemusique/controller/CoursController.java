package com.ecolemusique.controller;

import com.ecolemusique.model.Cours;
import com.ecolemusique.repository.CoursRepository;
import com.ecolemusique.repository.ProfRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cours")
@RequiredArgsConstructor
public class CoursController {

    private final CoursRepository repository;
    private final ProfRepository profRepository;

    @GetMapping
    public String listCours(
            @RequestParam(required = false) String niveau,
            @RequestParam(required = false) String jour,
            Model model) {
        
        List<Cours> coursList;
        
        if (niveau != null && !niveau.isEmpty() && jour != null && !jour.isEmpty()) {
            coursList = repository.findByNiveauIgnoreCaseContainingAndJourIgnoreCaseContaining(niveau, jour);
        } else if (niveau != null && !niveau.isEmpty()) {
            coursList = repository.findByNiveauIgnoreCaseContaining(niveau);
        } else if (jour != null && !jour.isEmpty()) {
            coursList = repository.findByJourIgnoreCaseContaining(jour);
        } else {
            coursList = repository.findAll();
        }
        
        model.addAttribute("cours", coursList);
        model.addAttribute("niveauSearch", niveau);
        model.addAttribute("jourSearch", jour);
        return "cours/list";
    }

    @GetMapping("/new")
    public String newCoursForm(Model model) {
        model.addAttribute("cours", new Cours());
        model.addAttribute("profs", profRepository.findAll());
        return "cours/form";
    }

    @PostMapping
    public String saveCours(@Valid @ModelAttribute("cours") Cours cours, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("profs", profRepository.findAll());
            return "cours/form";
        }
        repository.save(cours);
        return "redirect:/cours";
    }

    @GetMapping("/edit/{id}")
    public String editCoursForm(@PathVariable Long id, Model model) {
        Cours cours = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cours Id:" + id));
        model.addAttribute("cours", cours);
        model.addAttribute("profs", profRepository.findAll());
        return "cours/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCours(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/cours";
    }
}
