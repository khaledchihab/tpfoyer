package tn.esprit.tpfoyer.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entities.Etudiant;

import java.time.LocalDate;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	List<Etudiant> findByNomEtLike(String nomEt);

	List<Etudiant> findByNomEtContains(String nomEt);

	List<Etudiant> findByEcoleIsNull();

	List<Etudiant> findByEcoleIsNotNull();

	List<Etudiant> findByDateNaissanceBetween(LocalDate from, LocalDate to);

	@Query("SELECT e FROM Etudiant e WHERE e.ecole = :ecole")
	List<Etudiant> retrieveEtudiantsByEcoleJPQL(@Param("ecole") String ecole);

	@Query("SELECT e FROM Etudiant e JOIN e.reservations r WHERE r.estValide = :valide")
	List<Etudiant> retrieveEtudiantsByReservationValiditeJPQL(@Param("valide") boolean valide);

	@Query(value = "SELECT * FROM etudiant e WHERE e.nom_et LIKE :nom", nativeQuery = true)
	List<Etudiant> retrieveEtudiantsByNomNative(@Param("nom") String nom);

	@Transactional
	@Modifying
	@Query("UPDATE Etudiant e SET e.ecole = :ecole WHERE e.idEtudiant = :idEtudiant")
	int updateEcoleById(@Param("idEtudiant") Long idEtudiant, @Param("ecole") String ecole);

	@Transactional
	@Modifying
	@Query("DELETE FROM Etudiant e WHERE e.ecole = :ecole")
	int deleteEtudiantsByEcole(@Param("ecole") String ecole);
}
