package tn.esprit.tpfoyer.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entities.Bloc;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {

	List<Bloc> findByNomBlocLike(String nomBloc);

	List<Bloc> findByNomBlocContains(String nomBloc);

	List<Bloc> findByCapaciteBlocGreaterThan(Long capacite);

	List<Bloc> findByCapaciteBlocBetween(Long minCapacite, Long maxCapacite);

	List<Bloc> findByFoyerNomFoyerContains(String nomFoyer);

	@Query("SELECT b FROM Bloc b JOIN b.foyer f WHERE f.nomFoyer = :nomFoyer")
	List<Bloc> retrieveBlocsByNomFoyerJPQL(@Param("nomFoyer") String nomFoyer);

	@Query("SELECT b FROM Bloc b WHERE b.capaciteBloc >= :capacite")
	List<Bloc> retrieveBlocsByCapaciteMinJPQL(@Param("capacite") Long capacite);

	@Query(value = "SELECT * FROM bloc b WHERE b.nom_bloc LIKE :nomBloc", nativeQuery = true)
	List<Bloc> retrieveBlocsByNomNative(@Param("nomBloc") String nomBloc);

	@Transactional
	@Modifying
	@Query("UPDATE Bloc b SET b.capaciteBloc = :capacite WHERE b.idBloc = :idBloc")
	int updateCapaciteById(@Param("idBloc") Long idBloc, @Param("capacite") Long capacite);

	@Transactional
	@Modifying
	@Query("DELETE FROM Bloc b WHERE b.capaciteBloc < :capacite")
	int deleteBlocsByCapaciteLessThan(@Param("capacite") Long capacite);
}
