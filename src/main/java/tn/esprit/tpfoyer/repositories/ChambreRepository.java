package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

	List<Chambre> findByNumeroChambreGreaterThan(Long numero);

	List<Chambre> findByNumeroChambreLessThan(Long numero);

	List<Chambre> findByNumeroChambreBetween(Long minNumero, Long maxNumero);

	List<Chambre> findByTypeC(TypeChambre typeChambre);

	List<Chambre> findByBlocNomBlocContains(String nomBloc);

	List<Chambre> findByBlocFoyerNomFoyerContains(String nomFoyer);
}
