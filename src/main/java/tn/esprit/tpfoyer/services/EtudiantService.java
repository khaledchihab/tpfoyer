package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.repositories.EtudiantRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService {

    EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<Etudiant> getEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> findByNomEtLike(String nomEt) {
        return etudiantRepository.findByNomEtLike(nomEt);
    }

    @Override
    public List<Etudiant> findByNomEtContains(String nomEt) {
        return etudiantRepository.findByNomEtContains(nomEt);
    }

    @Override
    public List<Etudiant> findByEcoleIsNull() {
        return etudiantRepository.findByEcoleIsNull();
    }

    @Override
    public List<Etudiant> findByEcoleIsNotNull() {
        return etudiantRepository.findByEcoleIsNotNull();
    }

    @Override
    public List<Etudiant> findByDateNaissanceBetween(LocalDate from, LocalDate to) {
        return etudiantRepository.findByDateNaissanceBetween(from, to);
    }

    @Override
    public List<Etudiant> retrieveEtudiantsByEcoleJPQL(String ecole) {
        return etudiantRepository.retrieveEtudiantsByEcoleJPQL(ecole);
    }

    @Override
    public List<Etudiant> retrieveEtudiantsByReservationValiditeJPQL(boolean valide) {
        return etudiantRepository.retrieveEtudiantsByReservationValiditeJPQL(valide);
    }

    @Override
    public List<Etudiant> retrieveEtudiantsByNomNative(String nom) {
        return etudiantRepository.retrieveEtudiantsByNomNative(nom);
    }

    @Override
    public int updateEcoleById(Long idEtudiant, String ecole) {
        return etudiantRepository.updateEcoleById(idEtudiant, ecole);
    }

    @Override
    public int deleteEtudiantsByEcole(String ecole) {
        return etudiantRepository.deleteEtudiantsByEcole(ecole);
    }
}
