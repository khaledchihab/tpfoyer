package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    void deleteUniversite(Long id);

    List<Universite> getUniversites();

    List<Universite> findByNomUniversiteContains(String nomUniversite);

    List<Universite> findByAdresseLike(String adresse);

    List<Universite> findByAdresseIsNotNull();

    List<Universite> findByFoyerIsNull();
}
