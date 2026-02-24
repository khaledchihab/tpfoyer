package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Bloc;
import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc b);

    Bloc updateBloc(Bloc b);

    void deleteBloc(Long id);

    List<Bloc> getBloc();
}
