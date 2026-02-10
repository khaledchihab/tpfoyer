package tn.esprit.tpfoyer.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate anneeUniversitaire;
    private boolean estValide;
    @ManyToOne
    private Chambre chambre;
    @ManyToMany
    private Set<Etudiant> etudiants;
    private LocalDate anneeUniversitaire;
}
