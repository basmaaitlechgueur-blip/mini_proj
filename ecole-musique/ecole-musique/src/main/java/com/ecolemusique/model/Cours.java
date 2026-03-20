package com.ecolemusique.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le jour est obligatoire")
    private String jour;

    @NotNull(message = "L'heure de début est obligatoire")
    private LocalTime heureDebut;

    @NotNull(message = "La durée est obligatoire (en minutes)")
    private Integer dureeMin;

    @NotBlank(message = "Le niveau est obligatoire")
    private String niveau;

    @ManyToOne
    @JoinColumn(name = "prof_id")
    @NotNull(message = "Un professeur doit être assigné")
    private Prof prof;
}
