package com.ecolemusique.repository;

import com.ecolemusique.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<Cours> findByNiveauIgnoreCaseContainingAndJourIgnoreCaseContaining(String niveau, String jour);
    List<Cours> findByNiveauIgnoreCaseContaining(String niveau);
    List<Cours> findByJourIgnoreCaseContaining(String jour);

    @Query("SELECT c.jour, COUNT(c) FROM Cours c GROUP BY c.jour ORDER BY c.jour")
    List<Object[]> countCoursByJour();
}
