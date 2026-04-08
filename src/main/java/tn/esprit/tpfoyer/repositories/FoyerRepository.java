package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Foyer;

import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {

	List<Foyer> findByNomFoyerContains(String nomFoyer);

	List<Foyer> findByUniversiteNomUniversiteContains(String nomUniversite);

	List<Foyer> findByBlocsIdBloc(Long idBloc);
}
