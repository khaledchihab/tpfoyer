package tn.esprit.tpfoyer.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import tn.esprit.tpfoyer.dto.ChambreDTO;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Reservation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * MapStruct mapper for Chambre entity <-> DTO conversion
 */
@Mapper(componentModel = "spring")
public interface ChambreMapStructMapper {

    @Mapping(source = "typeC", target = "type")
    @Mapping(source = "bloc.idBloc", target = "blocId")
    @Mapping(source = "bloc.nomBloc", target = "blocNom")
    @Mapping(source = "reservations", target = "reservationIds", qualifiedByName = "reservationsToIds")
    ChambreDTO toDTO(Chambre chambre);

    @Mapping(source = "type", target = "typeC")
    @Mapping(target = "bloc", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Chambre toEntity(ChambreDTO dto);

    List<ChambreDTO> toDTOList(List<Chambre> chambres);

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
