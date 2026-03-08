package tn.esprit.tpfoyer.mapper;

import tn.esprit.tpfoyer.dto.BlocDTO;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.entities.Chambre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manual mapper for Bloc entity to DTO conversion
 */
public class BlocMapper {

    public static BlocDTO toDTO(Bloc bloc) {
        if (bloc == null) {
            return null;
        }
        
        BlocDTO dto = new BlocDTO();
        dto.setIdBloc(bloc.getIdBloc());
        dto.setNomBloc(bloc.getNomBloc());
        dto.setCapaciteBloc(bloc.getCapaciteBloc());
        
        if (bloc.getFoyer() != null) {
            dto.setFoyerId(bloc.getFoyer().getIdFoyer());
            dto.setFoyerNom(bloc.getFoyer().getNomFoyer());
        }
        
        if (bloc.getChambres() != null) {
            dto.setChambreIds(bloc.getChambres().stream()
                    .map(Chambre::getIdChambre)
                    .collect(Collectors.toList()));
        }
        
        return dto;
    }

    public static Bloc toEntity(BlocDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Bloc bloc = new Bloc();
        bloc.setIdBloc(dto.getIdBloc());
        bloc.setNomBloc(dto.getNomBloc());
        bloc.setCapaciteBloc(dto.getCapaciteBloc());
        // Relationships should be set via service layer
        
        return bloc;
    }

    public static List<BlocDTO> toDTOList(List<Bloc> blocs) {
        if (blocs == null) {
            return new ArrayList<>();
        }
        return blocs.stream()
                .map(BlocMapper::toDTO)
                .collect(Collectors.toList());
    }
}
