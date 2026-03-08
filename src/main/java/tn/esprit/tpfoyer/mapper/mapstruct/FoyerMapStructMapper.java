package tn.esprit.tpfoyer.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import tn.esprit.tpfoyer.dto.FoyerDTO;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.entities.Universite;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * MapStruct mapper for Foyer entity <-> DTO conversion
 */
@Mapper(componentModel = "spring")
public interface FoyerMapStructMapper {

    @Mapping(source = "universite.idUniversite", target = "universiteId")
    @Mapping(source = "universite.nomUniversite", target = "universiteNom")
    @Mapping(source = "blocs", target = "blocIds", qualifiedByName = "blocsToIds")
    FoyerDTO toDTO(Foyer foyer);

    @Mapping(target = "universite", ignore = true)
    @Mapping(target = "blocs", ignore = true)
    Foyer toEntity(FoyerDTO dto);

    List<FoyerDTO> toDTOList(List<Foyer> foyers);

    @Named("blocsToIds")
    default List<Long> blocsToIds(Set<Bloc> blocs) {
        if (blocs == null) {
            return null;
        }
        return blocs.stream()
                .map(Bloc::getIdBloc)
                .collect(Collectors.toList());
    }
}
