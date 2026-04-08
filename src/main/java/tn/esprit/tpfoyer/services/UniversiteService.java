package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Universite;
import tn.esprit.tpfoyer.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService {

    UniversiteRepository universiteRepository;

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public List<Universite> getUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public List<Universite> findByNomUniversiteContains(String nomUniversite) {
        return universiteRepository.findByNomUniversiteContains(nomUniversite);
    }

    @Override
    public List<Universite> findByAdresseLike(String adresse) {
        return universiteRepository.findByAdresseLike(adresse);
    }

    @Override
    public List<Universite> findByAdresseIsNotNull() {
        return universiteRepository.findByAdresseIsNotNull();
    }

    @Override
    public List<Universite> findByFoyerIsNull() {
        return universiteRepository.findByFoyerIsNull();
    }
}
