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
public class ReservationDTO {
    private Long idReservation;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate anneeUniversitaire;
    
    private Boolean valide; // Renamed from estValide for cleaner API
    private List<Long> etudiantIds;
}
