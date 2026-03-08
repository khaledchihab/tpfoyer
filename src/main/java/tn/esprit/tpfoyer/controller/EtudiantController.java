package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.EtudiantDTO;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.mapper.mapstruct.EtudiantMapStructMapper;
import tn.esprit.tpfoyer.services.IEtudiantService;

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
}
