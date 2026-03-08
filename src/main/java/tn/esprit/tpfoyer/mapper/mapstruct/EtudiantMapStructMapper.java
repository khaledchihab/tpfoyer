package tn.esprit.tpfoyer.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import tn.esprit.tpfoyer.dto.EtudiantDTO;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.entities.Reservation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * MapStruct mapper for Etudiant entity <-> DTO conversion
 * Note: CIN field is intentionally excluded from DTO for security
 */
@Mapper(componentModel = "spring")
public interface EtudiantMapStructMapper {

    @Mapping(source = "nomEt", target = "nom")
    @Mapping(source = "prenomEt", target = "prenom")
    @Mapping(target = "reservationIds", source = "reservations", qualifiedByName = "reservationsToIds")
    EtudiantDTO toDTO(Etudiant etudiant);

    @Mapping(source = "nom", target = "nomEt")
    @Mapping(source = "prenom", target = "prenomEt")
    @Mapping(target = "cin", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Etudiant toEntity(EtudiantDTO dto);

    List<EtudiantDTO> toDTOList(List<Etudiant> etudiants);

    @Named("reservationsToIds")
    default List<Long> reservationsToIds(Set<Reservation> reservations) {
        if (reservations == null) {
            return null;
        }
        return reservations.stream()
                .map(Reservation::getIdReservation)
                .collect(Collectors.toList());
    }
}
