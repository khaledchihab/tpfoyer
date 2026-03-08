package tn.esprit.tpfoyer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDTO {
    private Long idChambre;
    private Long numeroChambre;
    private TypeChambre type; // Renamed from typeC for better API naming
    private Long blocId;
    private String blocNom; // Useful denormalized field
    private List<Long> reservationIds;
}
