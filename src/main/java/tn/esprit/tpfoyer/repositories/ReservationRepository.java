package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findByAnneeUniversitaireGreaterThan(LocalDate date);

	List<Reservation> findByAnneeUniversitaireLessThan(LocalDate date);

	List<Reservation> findByAnneeUniversitaireBetween(LocalDate startDate, LocalDate endDate);

	List<Reservation> findByEtudiantsIsNotNull();

	List<Reservation> findByEstValideTrue();
}
