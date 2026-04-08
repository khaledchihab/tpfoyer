package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.ReservationDTO;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.mapper.mapstruct.ReservationMapStructMapper;
import tn.esprit.tpfoyer.services.IReservationService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    IReservationService reservationService;
    ReservationMapStructMapper reservationMapper;

    @PostMapping("/addReservation")
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        Reservation savedReservation = reservationService.addReservation(reservation);
        return reservationMapper.toDTO(savedReservation);
    }

    @PutMapping("/updateReservation")
    public ReservationDTO updateReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        Reservation updatedReservation = reservationService.updateReservation(reservation);
        return reservationMapper.toDTO(updatedReservation);
    }

    @DeleteMapping("/deleteReservation/{idReservation}")
    public void deleteReservation(@PathVariable Long idReservation) {
        reservationService.deleteReservation(idReservation);
    }

    @GetMapping("/retrieveAllReservations")
    public List<ReservationDTO> retrieveAllReservations() {
        List<Reservation> reservations = reservationService.getReservations();
        return reservationMapper.toDTOList(reservations);
    }

    @GetMapping("/search/by-annee-gt")
    public List<ReservationDTO> findByAnneeUniversitaireGreaterThan(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return reservationMapper.toDTOList(reservationService.findByAnneeUniversitaireGreaterThan(date));
    }

    @GetMapping("/search/by-annee-lt")
    public List<ReservationDTO> findByAnneeUniversitaireLessThan(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return reservationMapper.toDTOList(reservationService.findByAnneeUniversitaireLessThan(date));
    }

    @GetMapping("/search/by-annee-between")
    public List<ReservationDTO> findByAnneeUniversitaireBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return reservationMapper.toDTOList(reservationService.findByAnneeUniversitaireBetween(startDate, endDate));
    }

    @GetMapping("/search/with-etudiants")
    public List<ReservationDTO> findByEtudiantsIsNotNull() {
        return reservationMapper.toDTOList(reservationService.findByEtudiantsIsNotNull());
    }

    @GetMapping("/search/valid")
    public List<ReservationDTO> findByEstValideTrue() {
        return reservationMapper.toDTOList(reservationService.findByEstValideTrue());
    }
}
