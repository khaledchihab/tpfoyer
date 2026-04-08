package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Universite;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {

	List<Universite> findByNomUniversiteContains(String nomUniversite);

	List<Universite> findByAdresseLike(String adresse);

	List<Universite> findByAdresseIsNotNull();

	List<Universite> findByFoyerIsNull();
}
