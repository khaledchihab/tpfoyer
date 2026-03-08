package tn.esprit.tpfoyer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoyerDTO {
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;
    private Long universiteId;
    private String universiteNom; // Useful denormalized field
    private List<Long> blocIds;
}
