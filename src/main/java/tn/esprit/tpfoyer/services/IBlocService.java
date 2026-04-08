package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc b);

    Bloc updateBloc(Bloc b);

    void deleteBloc(Long id);

    List<Bloc> getBloc();

    List<Bloc> findByNomBlocLike(String nomBloc);

    List<Bloc> findByNomBlocContains(String nomBloc);

    List<Bloc> findByCapaciteBlocGreaterThan(Long capacite);

    List<Bloc> findByCapaciteBlocBetween(Long minCapacite, Long maxCapacite);

    List<Bloc> findByFoyerNomFoyerContains(String nomFoyer);

    List<Bloc> retrieveBlocsByNomFoyerJPQL(String nomFoyer);

    List<Bloc> retrieveBlocsByCapaciteMinJPQL(Long capacite);

    List<Bloc> retrieveBlocsByNomNative(String nomBloc);

    int updateCapaciteById(Long idBloc, Long capacite);

    int deleteBlocsByCapaciteLessThan(Long capacite);
}
