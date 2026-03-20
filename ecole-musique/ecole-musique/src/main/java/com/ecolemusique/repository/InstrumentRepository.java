package com.ecolemusique.repository;

import com.ecolemusique.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    List<Instrument> findByFamilleIgnoreCaseContainingAndDisponibilite(String famille, boolean disponibilite);
    List<Instrument> findByDisponibilite(boolean disponibilite);
    List<Instrument> findByFamilleIgnoreCaseContaining(String famille);

    @Query("SELECT i.famille, COUNT(i) FROM Instrument i GROUP BY i.famille ORDER BY COUNT(i) DESC")
    List<Object[]> countInstrumentsByFamille();
}
