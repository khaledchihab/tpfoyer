package tn.esprit.tpfoyer.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	@Query("SELECT c FROM Chambre c WHERE c.typeC = :typeC")
	List<Chambre> retrieveChambresByTypeJPQL(@Param("typeC") TypeChambre typeC);

	@Query("SELECT c FROM Chambre c JOIN c.bloc b WHERE b.nomBloc = :nomBloc")
	List<Chambre> retrieveChambresByNomBlocJPQL(@Param("nomBloc") String nomBloc);

	@Query(value = "SELECT * FROM chambre c WHERE c.type_c = :typeC", nativeQuery = true)
	List<Chambre> retrieveChambresByTypeNative(@Param("typeC") String typeC);

	@Transactional
	@Modifying
	@Query("UPDATE Chambre c SET c.typeC = :typeC WHERE c.idChambre = :idChambre")
	int updateTypeById(@Param("idChambre") Long idChambre, @Param("typeC") TypeChambre typeC);

	@Transactional
	@Modifying
	@Query("DELETE FROM Chambre c WHERE c.numeroChambre < :maxNumero")
	int deleteChambresByNumeroLessThan(@Param("maxNumero") Long maxNumero);
}
