package com.ecolemusique.controller;

import com.ecolemusique.model.Instrument;
import com.ecolemusique.repository.InstrumentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instruments")
@RequiredArgsConstructor
public class InstrumentController {

    private final InstrumentRepository repository;

    @GetMapping
    public String listInstruments(
            @RequestParam(required = false) String famille,
            @RequestParam(required = false) Boolean disponibilite,
            Model model) {
        
        List<Instrument> instruments;
        
        if (famille != null && !famille.isEmpty() && disponibilite != null) {
            instruments = repository.findByFamilleIgnoreCaseContainingAndDisponibilite(famille, disponibilite);
        } else if (famille != null && !famille.isEmpty()) {
            instruments = repository.findByFamilleIgnoreCaseContaining(famille);
        } else if (disponibilite != null) {
            instruments = repository.findByDisponibilite(disponibilite);
        } else {
            instruments = repository.findAll();
        }
        
        model.addAttribute("instruments", instruments);
        model.addAttribute("familleSearch", famille);
        model.addAttribute("disponibiliteSearch", disponibilite);
        return "instruments/list";
    }

    @GetMapping("/new")
    public String newInstrumentForm(Model model) {
        model.addAttribute("instrument", new Instrument());
        return "instruments/form";
    }

    @PostMapping
    public String saveInstrument(@Valid @ModelAttribute("instrument") Instrument instrument, BindingResult result) {
        if (result.hasErrors()) {
            return "instruments/form";
        }
        repository.save(instrument);
        return "redirect:/instruments";
    }

    @GetMapping("/edit/{id}")
    public String editInstrumentForm(@PathVariable Long id, Model model) {
        Instrument instrument = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid instrument Id:" + id));
        model.addAttribute("instrument", instrument);
        return "instruments/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteInstrument(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/instruments";
    }
}
