package tn.esprit.tpfoyer.mapper;

import tn.esprit.tpfoyer.dto.ChambreDTO;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manual mapper for Chambre entity to DTO conversion
 */
public class ChambreMapper {

    public static ChambreDTO toDTO(Chambre chambre) {
        if (chambre == null) {
            return null;
        }
        
        ChambreDTO dto = new ChambreDTO();
        dto.setIdChambre(chambre.getIdChambre());
        dto.setNumeroChambre(chambre.getNumeroChambre());
        dto.setType(chambre.getTypeC()); // Mapping typeC to type
        
        if (chambre.getBloc() != null) {
            dto.setBlocId(chambre.getBloc().getIdBloc());
            dto.setBlocNom(chambre.getBloc().getNomBloc());
        }
        
        if (chambre.getReservations() != null) {
            dto.setReservationIds(chambre.getReservations().stream()
                    .map(Reservation::getIdReservation)
                    .collect(Collectors.toList()));
        }
        
        return dto;
    }

    public static Chambre toEntity(ChambreDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Chambre chambre = new Chambre();
        chambre.setIdChambre(dto.getIdChambre());
        chambre.setNumeroChambre(dto.getNumeroChambre());
        chambre.setTypeC(dto.getType()); // Mapping type to typeC
        // Relationships should be set via service layer
        
        return chambre;
    }

    public static List<ChambreDTO> toDTOList(List<Chambre> chambres) {
        if (chambres == null) {
            return new ArrayList<>();
        }
        return chambres.stream()
                .map(ChambreMapper::toDTO)
                .collect(Collectors.toList());
    }
}
