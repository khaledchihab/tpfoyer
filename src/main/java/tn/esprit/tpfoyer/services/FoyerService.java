package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.repositories.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService {

    FoyerRepository foyerRepository;

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public List<Foyer> getFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public List<Foyer> findByNomFoyerContains(String nomFoyer) {
        return foyerRepository.findByNomFoyerContains(nomFoyer);
    }

    @Override
    public List<Foyer> findByUniversiteNomUniversiteContains(String nomUniversite) {
        return foyerRepository.findByUniversiteNomUniversiteContains(nomUniversite);
    }

    @Override
    public List<Foyer> findByBlocsIdBloc(Long idBloc) {
        return foyerRepository.findByBlocsIdBloc(idBloc);
    }

    @Override
    public List<Foyer> retrieveFoyersByNomUniversiteJPQL(String nomUniversite) {
        return foyerRepository.retrieveFoyersByNomUniversiteJPQL(nomUniversite);
    }

    @Override
    public List<Foyer> retrieveFoyersByCapaciteMinJPQL(Long capacite) {
        return foyerRepository.retrieveFoyersByCapaciteMinJPQL(capacite);
    }

    @Override
    public List<Foyer> retrieveFoyersByNomNative(String nomFoyer) {
        return foyerRepository.retrieveFoyersByNomNative(nomFoyer);
    }

    @Override
    public int updateCapaciteById(Long idFoyer, Long capacite) {
        return foyerRepository.updateCapaciteById(idFoyer, capacite);
    }

    @Override
    public int deleteFoyersByCapaciteLessThan(Long capacite) {
        return foyerRepository.deleteFoyersByCapaciteLessThan(capacite);
    }
}
