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
}
