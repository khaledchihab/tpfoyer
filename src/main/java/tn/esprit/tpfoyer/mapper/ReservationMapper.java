package tn.esprit.tpfoyer.mapper;

import tn.esprit.tpfoyer.dto.ReservationDTO;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.entities.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manual mapper for Reservation entity to DTO conversion
 */
public class ReservationMapper {

    public static ReservationDTO toDTO(Reservation reservation) {
        if (reservation == null) {
            return null;
        }
        
        ReservationDTO dto = new ReservationDTO();
        dto.setIdReservation(reservation.getIdReservation());
        dto.setAnneeUniversitaire(reservation.getAnneeUniversitaire());
        dto.setValide(reservation.isEstValide()); // Renamed field
        
        if (reservation.getEtudiants() != null) {
            dto.setEtudiantIds(reservation.getEtudiants().stream()
                    .map(Etudiant::getIdEtudiant)
                    .collect(Collectors.toList()));
        }
        
        return dto;
    }

    public static Reservation toEntity(ReservationDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Reservation reservation = new Reservation();
        reservation.setIdReservation(dto.getIdReservation());
        reservation.setAnneeUniversitaire(dto.getAnneeUniversitaire());
        reservation.setEstValide(dto.getValide() != null ? dto.getValide() : false);
        // Relationships should be set via service layer
        
        return reservation;
    }

    public static List<ReservationDTO> toDTOList(List<Reservation> reservations) {
        if (reservations == null) {
            return new ArrayList<>();
        }
        return reservations.stream()
                .map(ReservationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
