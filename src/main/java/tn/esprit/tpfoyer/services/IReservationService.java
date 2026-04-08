package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation r);

    Reservation updateReservation(Reservation r);

    void deleteReservation(Long id);

    List<Reservation> getReservations();

    List<Reservation> findByAnneeUniversitaireGreaterThan(LocalDate date);

    List<Reservation> findByAnneeUniversitaireLessThan(LocalDate date);

    List<Reservation> findByAnneeUniversitaireBetween(LocalDate startDate, LocalDate endDate);

    List<Reservation> findByEtudiantsIsNotNull();

    List<Reservation> findByEstValideTrue();

    List<Reservation> retrieveReservationsByAnneeUniversitaire(LocalDate annee);

    List<Reservation> retrieveReservationsByEtudiantNom(String nomEt);

    List<Reservation> retrieveReservationsByEstValideNative(boolean valide);

    int updateReservationValidity(Long idReservation, boolean valide);

    int deleteInvalidReservations();

    int insertReservationNative(LocalDate anneeUniversitaire, boolean estValide);
}
