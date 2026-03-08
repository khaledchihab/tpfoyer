package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.FoyerDTO;
import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.mapper.mapstruct.FoyerMapStructMapper;
import tn.esprit.tpfoyer.services.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {

    IFoyerService foyerService;
    FoyerMapStructMapper foyerMapper;

    @PostMapping("/addFoyer")
    public FoyerDTO addFoyer(@RequestBody FoyerDTO foyerDTO) {
        Foyer foyer = foyerMapper.toEntity(foyerDTO);
        Foyer savedFoyer = foyerService.addFoyer(foyer);
        return foyerMapper.toDTO(savedFoyer);
    }

    @PutMapping("/updateFoyer")
    public FoyerDTO updateFoyer(@RequestBody FoyerDTO foyerDTO) {
        Foyer foyer = foyerMapper.toEntity(foyerDTO);
        Foyer updatedFoyer = foyerService.updateFoyer(foyer);
        return foyerMapper.toDTO(updatedFoyer);
    }

    @DeleteMapping("/deleteFoyer/{idFoyer}")
    public void deleteFoyer(@PathVariable Long idFoyer) {
        foyerService.deleteFoyer(idFoyer);
    }

    @GetMapping("/retrieveAllFoyers")
    public List<FoyerDTO> retrieveAllFoyers() {
        List<Foyer> foyers = foyerService.getFoyers();
        return foyerMapper.toDTOList(foyers);
    }
}
