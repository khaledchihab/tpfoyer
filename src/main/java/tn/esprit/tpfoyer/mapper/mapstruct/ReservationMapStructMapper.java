package tn.esprit.tpfoyer.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import tn.esprit.tpfoyer.dto.ReservationDTO;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.entities.Reservation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * MapStruct mapper for Reservation entity <-> DTO conversion
 */
@Mapper(componentModel = "spring")
public interface ReservationMapStructMapper {

    @Mapping(source = "estValide", target = "valide")
    @Mapping(source = "etudiants", target = "etudiantIds", qualifiedByName = "etudiantsToIds")
    ReservationDTO toDTO(Reservation reservation);

    @Mapping(source = "valide", target = "estValide")
    @Mapping(target = "etudiants", ignore = true)
    Reservation toEntity(ReservationDTO dto);

    List<ReservationDTO> toDTOList(List<Reservation> reservations);

    @Named("etudiantsToIds")
    default List<Long> etudiantsToIds(Set<Etudiant> etudiants) {
        if (etudiants == null) {
            return null;
        }
        return etudiants.stream()
                .map(Etudiant::getIdEtudiant)
                .collect(Collectors.toList());
    }
}
