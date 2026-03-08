package tn.esprit.tpfoyer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlocDTO {
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;
    private Long foyerId;
    private String foyerNom; // Useful denormalized field
    private List<Long> chambreIds;
}
