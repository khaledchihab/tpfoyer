package tn.esprit.tpfoyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Bloc;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {

	List<Bloc> findByNomBlocLike(String nomBloc);

	List<Bloc> findByNomBlocContains(String nomBloc);

	List<Bloc> findByCapaciteBlocGreaterThan(Long capacite);

	List<Bloc> findByCapaciteBlocBetween(Long minCapacite, Long maxCapacite);

	List<Bloc> findByFoyerNomFoyerContains(String nomFoyer);
}
