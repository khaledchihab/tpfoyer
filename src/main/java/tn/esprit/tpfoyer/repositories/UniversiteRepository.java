package tn.esprit.tpfoyer.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entities.Universite;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {

	List<Universite> findByNomUniversiteContains(String nomUniversite);

	List<Universite> findByAdresseLike(String adresse);

	List<Universite> findByAdresseIsNotNull();

	List<Universite> findByFoyerIsNull();

	@Query("SELECT u FROM Universite u WHERE u.adresse LIKE :adresse")
	List<Universite> retrieveUniversitesByAdresseLikeJPQL(@Param("adresse") String adresse);

	@Query("SELECT u FROM Universite u WHERE u.foyer IS NOT NULL")
	List<Universite> retrieveUniversitesWithFoyerJPQL();

	@Query(value = "SELECT * FROM universite u WHERE u.nom_universite LIKE :nom", nativeQuery = true)
	List<Universite> retrieveUniversitesByNomNative(@Param("nom") String nom);

	@Transactional
	@Modifying
	@Query("UPDATE Universite u SET u.adresse = :adresse WHERE u.idUniversite = :idUniversite")
	int updateAdresseById(@Param("idUniversite") Long idUniversite, @Param("adresse") String adresse);

	@Transactional
	@Modifying
	@Query("DELETE FROM Universite u WHERE u.adresse = :adresse")
	int deleteUniversitesByAdresse(@Param("adresse") String adresse);
}
