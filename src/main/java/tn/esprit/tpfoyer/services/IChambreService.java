package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);

    void deleteChambre(Long id);

    List<Chambre> getChambres();

    List<Chambre> findByNumeroChambreGreaterThan(Long numero);

    List<Chambre> findByNumeroChambreLessThan(Long numero);

    List<Chambre> findByNumeroChambreBetween(Long minNumero, Long maxNumero);

    List<Chambre> findByTypeC(TypeChambre typeChambre);

    List<Chambre> findByBlocNomBlocContains(String nomBloc);

    List<Chambre> findByBlocFoyerNomFoyerContains(String nomFoyer);

    List<Chambre> retrieveChambresByTypeJPQL(TypeChambre typeC);

    List<Chambre> retrieveChambresByNomBlocJPQL(String nomBloc);

    List<Chambre> retrieveChambresByTypeNative(String typeC);

    int updateTypeById(Long idChambre, TypeChambre typeC);

    int deleteChambresByNumeroLessThan(Long maxNumero);
}
