package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> findByAnneeUniversitaireGreaterThan(LocalDate date) {
        return reservationRepository.findByAnneeUniversitaireGreaterThan(date);
    }

    @Override
    public List<Reservation> findByAnneeUniversitaireLessThan(LocalDate date) {
        return reservationRepository.findByAnneeUniversitaireLessThan(date);
    }

    @Override
    public List<Reservation> findByAnneeUniversitaireBetween(LocalDate startDate, LocalDate endDate) {
        return reservationRepository.findByAnneeUniversitaireBetween(startDate, endDate);
    }

    @Override
    public List<Reservation> findByEtudiantsIsNotNull() {
        return reservationRepository.findByEtudiantsIsNotNull();
    }

    @Override
    public List<Reservation> findByEstValideTrue() {
        return reservationRepository.findByEstValideTrue();
    }
}
