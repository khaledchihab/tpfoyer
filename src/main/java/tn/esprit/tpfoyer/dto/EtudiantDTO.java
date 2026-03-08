package tn.esprit.tpfoyer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDTO {
    private Long idEtudiant;
    private String nom; // Renamed from nomEt for cleaner API
    private String prenom; // Renamed from prenomEt for cleaner API
    // CIN is hidden - sensitive information not exposed in public API
    private String ecole;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance;
    
    private List<Long> reservationIds;
}
