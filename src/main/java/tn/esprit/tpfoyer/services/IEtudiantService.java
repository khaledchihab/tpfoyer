package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Etudiant;

import java.time.LocalDate;
import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    void deleteEtudiant(Long id);

    List<Etudiant> getEtudiants();

    List<Etudiant> findByNomEtLike(String nomEt);

    List<Etudiant> findByNomEtContains(String nomEt);

    List<Etudiant> findByEcoleIsNull();

    List<Etudiant> findByEcoleIsNotNull();

    List<Etudiant> findByDateNaissanceBetween(LocalDate from, LocalDate to);

    List<Etudiant> retrieveEtudiantsByEcoleJPQL(String ecole);

    List<Etudiant> retrieveEtudiantsByReservationValiditeJPQL(boolean valide);

    List<Etudiant> retrieveEtudiantsByNomNative(String nom);

    int updateEcoleById(Long idEtudiant, String ecole);

    int deleteEtudiantsByEcole(String ecole);
}
