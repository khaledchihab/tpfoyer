package tn.esprit.tpfoyer.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entities.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findByAnneeUniversitaireGreaterThan(LocalDate date);

	List<Reservation> findByAnneeUniversitaireLessThan(LocalDate date);

	List<Reservation> findByAnneeUniversitaireBetween(LocalDate startDate, LocalDate endDate);

	List<Reservation> findByEtudiantsIsNotNull();

	List<Reservation> findByEstValideTrue();

	@Query("SELECT r FROM Reservation r WHERE r.anneeUniversitaire = :annee")
	List<Reservation> retrieveReservationsByAnneeUniversitaire(@Param("annee") LocalDate annee);

	@Query("SELECT r FROM Reservation r JOIN r.etudiants e WHERE e.nomEt = :nomEt")
	List<Reservation> retrieveReservationsByEtudiantNom(@Param("nomEt") String nomEt);

	@Query(value = "SELECT * FROM reservation r WHERE r.est_valide = :valide", nativeQuery = true)
	List<Reservation> retrieveReservationsByEstValideNative(@Param("valide") boolean valide);

	@Transactional
	@Modifying
	@Query("UPDATE Reservation r SET r.estValide = :valide WHERE r.idReservation = :idReservation")
	int updateReservationValidity(@Param("idReservation") Long idReservation, @Param("valide") boolean valide);

	@Transactional
	@Modifying
	@Query("DELETE FROM Reservation r WHERE r.estValide = false")
	int deleteInvalidReservations();

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO reservation (annee_universitaire, est_valide) VALUES (:anneeUniversitaire, :estValide)", nativeQuery = true)
	int insertReservationNative(@Param("anneeUniversitaire") LocalDate anneeUniversitaire,
							   @Param("estValide") boolean estValide);
}
