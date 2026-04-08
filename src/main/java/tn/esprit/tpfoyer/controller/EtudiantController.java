package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.EtudiantDTO;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.mapper.mapstruct.EtudiantMapStructMapper;
import tn.esprit.tpfoyer.services.IEtudiantService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {

    IEtudiantService etudiantService;
    EtudiantMapStructMapper etudiantMapper;

    @PostMapping("/addEtudiant")
    public EtudiantDTO addEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        Etudiant etudiant = etudiantMapper.toEntity(etudiantDTO);
        Etudiant savedEtudiant = etudiantService.addEtudiant(etudiant);
        return etudiantMapper.toDTO(savedEtudiant);
    }

    @PutMapping("/updateEtudiant")
    public EtudiantDTO updateEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        Etudiant etudiant = etudiantMapper.toEntity(etudiantDTO);
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(etudiant);
        return etudiantMapper.toDTO(updatedEtudiant);
    }

    @DeleteMapping("/deleteEtudiant/{idEtudiant}")
    public void deleteEtudiant(@PathVariable Long idEtudiant) {
        etudiantService.deleteEtudiant(idEtudiant);
    }

    @GetMapping("/retrieveAllEtudiants")
    public List<EtudiantDTO> retrieveAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getEtudiants();
        return etudiantMapper.toDTOList(etudiants);
    }

    @GetMapping("/search/by-nom-like")
    public List<EtudiantDTO> findByNomEtLike(@RequestParam String nomEt) {
        return etudiantMapper.toDTOList(etudiantService.findByNomEtLike(nomEt));
    }

    @GetMapping("/search/by-nom-contains")
    public List<EtudiantDTO> findByNomEtContains(@RequestParam String nomEt) {
        return etudiantMapper.toDTOList(etudiantService.findByNomEtContains(nomEt));
    }

    @GetMapping("/search/ecole-null")
    public List<EtudiantDTO> findByEcoleIsNull() {
        return etudiantMapper.toDTOList(etudiantService.findByEcoleIsNull());
    }

    @GetMapping("/search/ecole-not-null")
    public List<EtudiantDTO> findByEcoleIsNotNull() {
        return etudiantMapper.toDTOList(etudiantService.findByEcoleIsNotNull());
    }

    @GetMapping("/search/by-date-naissance-between")
    public List<EtudiantDTO> findByDateNaissanceBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return etudiantMapper.toDTOList(etudiantService.findByDateNaissanceBetween(from, to));
    }

    @GetMapping("/jpql/by-ecole")
    public List<EtudiantDTO> retrieveEtudiantsByEcoleJPQL(@RequestParam String ecole) {
        return etudiantMapper.toDTOList(etudiantService.retrieveEtudiantsByEcoleJPQL(ecole));
    }

    @GetMapping("/jpql/by-reservation-validite")
    public List<EtudiantDTO> retrieveEtudiantsByReservationValiditeJPQL(@RequestParam boolean valide) {
        return etudiantMapper.toDTOList(etudiantService.retrieveEtudiantsByReservationValiditeJPQL(valide));
    }

    @GetMapping("/native/by-nom")
    public List<EtudiantDTO> retrieveEtudiantsByNomNative(@RequestParam String nom) {
        return etudiantMapper.toDTOList(etudiantService.retrieveEtudiantsByNomNative(nom));
    }

    @PutMapping("/jpql/update-ecole")
    public int updateEcoleById(@RequestParam Long idEtudiant, @RequestParam String ecole) {
        return etudiantService.updateEcoleById(idEtudiant, ecole);
    }

    @DeleteMapping("/jpql/delete-by-ecole")
    public int deleteEtudiantsByEcole(@RequestParam String ecole) {
        return etudiantService.deleteEtudiantsByEcole(ecole);
    }
}
