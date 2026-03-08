package tn.esprit.tpfoyer.mapper;

import tn.esprit.tpfoyer.dto.FoyerDTO;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Foyer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manual mapper for Foyer entity to DTO conversion
 */
public class FoyerMapper {

    public static FoyerDTO toDTO(Foyer foyer) {
        if (foyer == null) {
            return null;
        }
        
        FoyerDTO dto = new FoyerDTO();
        dto.setIdFoyer(foyer.getIdFoyer());
        dto.setNomFoyer(foyer.getNomFoyer());
        dto.setCapaciteFoyer(foyer.getCapaciteFoyer());
        
        if (foyer.getUniversite() != null) {
            dto.setUniversiteId(foyer.getUniversite().getIdUniversite());
            dto.setUniversiteNom(foyer.getUniversite().getNomUniversite());
        }
        
        if (foyer.getBlocs() != null) {
            dto.setBlocIds(foyer.getBlocs().stream()
                    .map(Bloc::getIdBloc)
                    .collect(Collectors.toList()));
        }
        
        return dto;
    }

    public static Foyer toEntity(FoyerDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Foyer foyer = new Foyer();
        foyer.setIdFoyer(dto.getIdFoyer());
        foyer.setNomFoyer(dto.getNomFoyer());
        foyer.setCapaciteFoyer(dto.getCapaciteFoyer());
        // Relationships should be set via service layer
        
        return foyer;
    }

    public static List<FoyerDTO> toDTOList(List<Foyer> foyers) {
        if (foyers == null) {
            return new ArrayList<>();
        }
        return foyers.stream()
                .map(FoyerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
