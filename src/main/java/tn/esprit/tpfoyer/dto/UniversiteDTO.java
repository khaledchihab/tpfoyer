package tn.esprit.tpfoyer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversiteDTO {
    private Long idUniversite;
    private String nomUniversite;
    private String adresse;
    private Long foyerId;
}
