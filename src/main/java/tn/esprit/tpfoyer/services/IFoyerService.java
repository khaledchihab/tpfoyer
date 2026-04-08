package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addFoyer(Foyer f);

    Foyer updateFoyer(Foyer f);

    void deleteFoyer(Long id);

    List<Foyer> getFoyers();

    List<Foyer> findByNomFoyerContains(String nomFoyer);

    List<Foyer> findByUniversiteNomUniversiteContains(String nomUniversite);

    List<Foyer> findByBlocsIdBloc(Long idBloc);
}
