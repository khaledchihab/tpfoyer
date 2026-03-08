package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.ReservationDTO;
import tn.esprit.tpfoyer.entities.Reservation;
import tn.esprit.tpfoyer.mapper.mapstruct.ReservationMapStructMapper;
import tn.esprit.tpfoyer.services.IReservationService;

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
}
