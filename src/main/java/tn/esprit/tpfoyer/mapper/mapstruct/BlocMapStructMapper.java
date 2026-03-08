package tn.esprit.tpfoyer.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import tn.esprit.tpfoyer.dto.BlocDTO;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Chambre;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * MapStruct mapper for Bloc entity <-> DTO conversion
 */
@Mapper(componentModel = "spring")
public interface BlocMapStructMapper {

    @Mapping(source = "foyer.idFoyer", target = "foyerId")
    @Mapping(source = "foyer.nomFoyer", target = "foyerNom")
    @Mapping(source = "chambres", target = "chambreIds", qualifiedByName = "chambresToIds")
    BlocDTO toDTO(Bloc bloc);

    @Mapping(target = "foyer", ignore = true)
    @Mapping(target = "chambres", ignore = true)
    Bloc toEntity(BlocDTO dto);

    List<BlocDTO> toDTOList(List<Bloc> blocs);

    @Named("chambresToIds")
    default List<Long> chambresToIds(Set<Chambre> chambres) {
        if (chambres == null) {
            return null;
        }
        return chambres.stream()
                .map(Chambre::getIdChambre)
                .collect(Collectors.toList());
    }
}
