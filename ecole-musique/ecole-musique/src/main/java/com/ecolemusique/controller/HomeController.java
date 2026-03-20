package com.ecolemusique.controller;

import com.ecolemusique.repository.CoursRepository;
import com.ecolemusique.repository.InstrumentRepository;
import com.ecolemusique.repository.ProfRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstrumentRepository instrumentRepository;
    private final ProfRepository profRepository;
    private final CoursRepository coursRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalInstruments", instrumentRepository.count());
        model.addAttribute("totalProfs", profRepository.count());
        model.addAttribute("totalCours", coursRepository.count());

        // Statistiques supplémentaires
        model.addAttribute("statsCoursJour", coursRepository.countCoursByJour());
        model.addAttribute("statsInstrumentsFamille", instrumentRepository.countInstrumentsByFamille());

        return "index";
    }
}
