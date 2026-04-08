package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.repositories.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {

    BlocRepository blocRepository;

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public List<Bloc> getBloc() {
        return blocRepository.findAll();
    }

    @Override
    public List<Bloc> findByNomBlocLike(String nomBloc) {
        return blocRepository.findByNomBlocLike(nomBloc);
    }

    @Override
    public List<Bloc> findByNomBlocContains(String nomBloc) {
        return blocRepository.findByNomBlocContains(nomBloc);
    }

    @Override
    public List<Bloc> findByCapaciteBlocGreaterThan(Long capacite) {
        return blocRepository.findByCapaciteBlocGreaterThan(capacite);
    }

    @Override
    public List<Bloc> findByCapaciteBlocBetween(Long minCapacite, Long maxCapacite) {
        return blocRepository.findByCapaciteBlocBetween(minCapacite, maxCapacite);
    }

    @Override
    public List<Bloc> findByFoyerNomFoyerContains(String nomFoyer) {
        return blocRepository.findByFoyerNomFoyerContains(nomFoyer);
    }

    @Override
    public List<Bloc> retrieveBlocsByNomFoyerJPQL(String nomFoyer) {
        return blocRepository.retrieveBlocsByNomFoyerJPQL(nomFoyer);
    }

    @Override
    public List<Bloc> retrieveBlocsByCapaciteMinJPQL(Long capacite) {
        return blocRepository.retrieveBlocsByCapaciteMinJPQL(capacite);
    }

    @Override
    public List<Bloc> retrieveBlocsByNomNative(String nomBloc) {
        return blocRepository.retrieveBlocsByNomNative(nomBloc);
    }

    @Override
    public int updateCapaciteById(Long idBloc, Long capacite) {
        return blocRepository.updateCapaciteById(idBloc, capacite);
    }

    @Override
    public int deleteBlocsByCapaciteLessThan(Long capacite) {
        return blocRepository.deleteBlocsByCapaciteLessThan(capacite);
    }
}
