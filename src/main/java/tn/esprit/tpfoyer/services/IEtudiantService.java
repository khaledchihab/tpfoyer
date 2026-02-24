package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Etudiant;
import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    void deleteEtudiant(Long id);

    List<Etudiant> getEtudiants();
}
