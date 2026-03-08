package tn.esprit.tpfoyer.mapper;

import tn.esprit.tpfoyer.dto.EtudiantDTO;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.entities.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manual mapper for Etudiant entity to DTO conversion
 */
public class EtudiantMapper {

    public static EtudiantDTO toDTO(Etudiant etudiant) {
        if (etudiant == null) {
            return null;
        }
        
        EtudiantDTO dto = new EtudiantDTO();
        dto.setIdEtudiant(etudiant.getIdEtudiant());
        dto.setNom(etudiant.getNomEt()); // Renamed field
        dto.setPrenom(etudiant.getPrenomEt()); // Renamed field
        dto.setEcole(etudiant.getEcole());
        dto.setDateNaissance(etudiant.getDateNaissance());
        // CIN is intentionally hidden - sensitive data
        
        if (etudiant.getReservations() != null) {
            dto.setReservationIds(etudiant.getReservations().stream()
                    .map(Reservation::getIdReservation)
                    .collect(Collectors.toList()));
        }
        
        return dto;
    }

    public static Etudiant toEntity(EtudiantDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Etudiant etudiant = new Etudiant();
        etudiant.setIdEtudiant(dto.getIdEtudiant());
        etudiant.setNomEt(dto.getNom()); // Mapping back to nomEt
        etudiant.setPrenomEt(dto.getPrenom()); // Mapping back to prenomEt
        etudiant.setEcole(dto.getEcole());
        etudiant.setDateNaissance(dto.getDateNaissance());
        // CIN should be set separately if needed
        // Relationships should be set via service layer
        
        return etudiant;
    }

    public static List<EtudiantDTO> toDTOList(List<Etudiant> etudiants) {
        if (etudiants == null) {
            return new ArrayList<>();
        }
        return etudiants.stream()
                .map(EtudiantMapper::toDTO)
                .collect(Collectors.toList());
    }
}
