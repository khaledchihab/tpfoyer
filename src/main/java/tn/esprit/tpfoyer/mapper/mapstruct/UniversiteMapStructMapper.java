package tn.esprit.tpfoyer.mapper.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import tn.esprit.tpfoyer.dto.UniversiteDTO;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.entities.Universite;

import java.util.List;

/**
 * MapStruct mapper for Universite entity <-> DTO conversion
 */
@Mapper(componentModel = "spring")
public interface UniversiteMapStructMapper {

    @Mapping(source = "foyer.idFoyer", target = "foyerId")
    UniversiteDTO toDTO(Universite universite);

    @Mapping(target = "foyer", ignore = true)
    Universite toEntity(UniversiteDTO dto);

    List<UniversiteDTO> toDTOList(List<Universite> universites);

    @Named("foyerToId")
    default Long foyerToId(Foyer foyer) {
        return foyer != null ? foyer.getIdFoyer() : null;
    }
}
