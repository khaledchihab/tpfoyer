package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;
import tn.esprit.tpfoyer.repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService {

    ChambreRepository chambreRepository;

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public List<Chambre> getChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public List<Chambre> findByNumeroChambreGreaterThan(Long numero) {
        return chambreRepository.findByNumeroChambreGreaterThan(numero);
    }

    @Override
    public List<Chambre> findByNumeroChambreLessThan(Long numero) {
        return chambreRepository.findByNumeroChambreLessThan(numero);
    }

    @Override
    public List<Chambre> findByNumeroChambreBetween(Long minNumero, Long maxNumero) {
        return chambreRepository.findByNumeroChambreBetween(minNumero, maxNumero);
    }

    @Override
    public List<Chambre> findByTypeC(TypeChambre typeChambre) {
        return chambreRepository.findByTypeC(typeChambre);
    }

    @Override
    public List<Chambre> findByBlocNomBlocContains(String nomBloc) {
        return chambreRepository.findByBlocNomBlocContains(nomBloc);
    }

    @Override
    public List<Chambre> findByBlocFoyerNomFoyerContains(String nomFoyer) {
        return chambreRepository.findByBlocFoyerNomFoyerContains(nomFoyer);
    }

    @Override
    public List<Chambre> retrieveChambresByTypeJPQL(TypeChambre typeC) {
        return chambreRepository.retrieveChambresByTypeJPQL(typeC);
    }

    @Override
    public List<Chambre> retrieveChambresByNomBlocJPQL(String nomBloc) {
        return chambreRepository.retrieveChambresByNomBlocJPQL(nomBloc);
    }

    @Override
    public List<Chambre> retrieveChambresByTypeNative(String typeC) {
        return chambreRepository.retrieveChambresByTypeNative(typeC);
    }

    @Override
    public int updateTypeById(Long idChambre, TypeChambre typeC) {
        return chambreRepository.updateTypeById(idChambre, typeC);
    }

    @Override
    public int deleteChambresByNumeroLessThan(Long maxNumero) {
        return chambreRepository.deleteChambresByNumeroLessThan(maxNumero);
    }
}
