package tn.esprit.tpfoyer.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entities.Foyer;

import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {

	List<Foyer> findByNomFoyerContains(String nomFoyer);

	List<Foyer> findByUniversiteNomUniversiteContains(String nomUniversite);

	List<Foyer> findByBlocsIdBloc(Long idBloc);

	@Query("SELECT f FROM Foyer f JOIN f.universite u WHERE u.nomUniversite = :nomUniversite")
	List<Foyer> retrieveFoyersByNomUniversiteJPQL(@Param("nomUniversite") String nomUniversite);

	@Query("SELECT f FROM Foyer f WHERE f.capaciteFoyer >= :capacite")
	List<Foyer> retrieveFoyersByCapaciteMinJPQL(@Param("capacite") Long capacite);

	@Query(value = "SELECT * FROM foyer f WHERE f.nom_foyer LIKE :nomFoyer", nativeQuery = true)
	List<Foyer> retrieveFoyersByNomNative(@Param("nomFoyer") String nomFoyer);

	@Transactional
	@Modifying
	@Query("UPDATE Foyer f SET f.capaciteFoyer = :capacite WHERE f.idFoyer = :idFoyer")
	int updateCapaciteById(@Param("idFoyer") Long idFoyer, @Param("capacite") Long capacite);

	@Transactional
	@Modifying
	@Query("DELETE FROM Foyer f WHERE f.capaciteFoyer < :capacite")
	int deleteFoyersByCapaciteLessThan(@Param("capacite") Long capacite);
}
