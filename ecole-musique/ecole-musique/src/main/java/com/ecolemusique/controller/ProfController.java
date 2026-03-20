package com.ecolemusique.controller;

import com.ecolemusique.model.Prof;
import com.ecolemusique.repository.ProfRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profs")
@RequiredArgsConstructor
public class ProfController {

    private final ProfRepository repository;

    @GetMapping
    public String listProfs(Model model) {
        model.addAttribute("profs", repository.findAll());
        return "profs/list";
    }

    @GetMapping("/new")
    public String newProfForm(Model model) {
        model.addAttribute("prof", new Prof());
        return "profs/form";
    }

    @PostMapping
    public String saveProf(@Valid @ModelAttribute("prof") Prof prof, BindingResult result) {
        if (result.hasErrors()) {
            return "profs/form";
        }
        repository.save(prof);
        return "redirect:/profs";
    }

    @GetMapping("/edit/{id}")
    public String editProfForm(@PathVariable Long id, Model model) {
        Prof prof = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid prof Id:" + id));
        model.addAttribute("prof", prof);
        return "profs/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProf(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/profs";
    }
}
