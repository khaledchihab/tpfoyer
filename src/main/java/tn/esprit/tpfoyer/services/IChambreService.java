package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Chambre;
import java.util.List;

public interface IChambreService {
    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);

    void deleteChambre(Long id);

    List<Chambre> getChambres();
}
