package tn.esprit.tpfoyer.mapper;

import tn.esprit.tpfoyer.dto.UniversiteDTO;
import tn.esprit.tpfoyer.entities.Universite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manual mapper for Universite entity to DTO conversion
 */
public class UniversiteMapper {

    public static UniversiteDTO toDTO(Universite universite) {
        if (universite == null) {
            return null;
        }
        
        UniversiteDTO dto = new UniversiteDTO();
        dto.setIdUniversite(universite.getIdUniversite());
        dto.setNomUniversite(universite.getNomUniversite());
        dto.setAdresse(universite.getAdresse());
        
        if (universite.getFoyer() != null) {
            dto.setFoyerId(universite.getFoyer().getIdFoyer());
        }
        
        return dto;
    }

    public static Universite toEntity(UniversiteDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Universite universite = new Universite();
        universite.setIdUniversite(dto.getIdUniversite());
        universite.setNomUniversite(dto.getNomUniversite());
        universite.setAdresse(dto.getAdresse());
        // Foyer relationship should be set via service layer
        
        return universite;
    }

    public static List<UniversiteDTO> toDTOList(List<Universite> universites) {
        if (universites == null) {
            return new ArrayList<>();
        }
        return universites.stream()
                .map(UniversiteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
