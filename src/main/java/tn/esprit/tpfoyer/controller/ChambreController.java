package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.ChambreDTO;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.mapper.mapstruct.ChambreMapStructMapper;
import tn.esprit.tpfoyer.services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {

    IChambreService chambreService;
    ChambreMapStructMapper chambreMapper;

    @PostMapping("/addChambre")
    public ChambreDTO addChambre(@RequestBody ChambreDTO chambreDTO) {
        Chambre chambre = chambreMapper.toEntity(chambreDTO);
        Chambre savedChambre = chambreService.addChambre(chambre);
        return chambreMapper.toDTO(savedChambre);
    }

    @PutMapping("/updateChambre")
    public ChambreDTO updateChambre(@RequestBody ChambreDTO chambreDTO) {
        Chambre chambre = chambreMapper.toEntity(chambreDTO);
        Chambre updatedChambre = chambreService.updateChambre(chambre);
        return chambreMapper.toDTO(updatedChambre);
    }

    @DeleteMapping("/deleteChambre/{idChambre}")
    public void deleteChambre(@PathVariable Long idChambre) {
        chambreService.deleteChambre(idChambre);
    }

    @GetMapping("/retrieveAllChambres")
    public List<ChambreDTO> retrieveAllChambres() {
        List<Chambre> chambres = chambreService.getChambres();
        return chambreMapper.toDTOList(chambres);
    }
}
