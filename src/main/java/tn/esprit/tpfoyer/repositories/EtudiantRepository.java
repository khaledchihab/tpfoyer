package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Etudiant;

import java.time.LocalDate;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	List<Etudiant> findByNomEtLike(String nomEt);

	List<Etudiant> findByNomEtContains(String nomEt);

	List<Etudiant> findByEcoleIsNull();

	List<Etudiant> findByEcoleIsNotNull();

	List<Etudiant> findByDateNaissanceBetween(LocalDate from, LocalDate to);
}
