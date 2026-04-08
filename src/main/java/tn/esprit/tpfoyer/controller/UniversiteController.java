package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.UniversiteDTO;
import tn.esprit.tpfoyer.entities.Universite;
import tn.esprit.tpfoyer.mapper.mapstruct.UniversiteMapStructMapper;
import tn.esprit.tpfoyer.services.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {

    IUniversiteService universiteService;
    UniversiteMapStructMapper universiteMapper;

    @PostMapping("/addUniversite")
    public UniversiteDTO addUniversite(@RequestBody UniversiteDTO universiteDTO) {
        Universite universite = universiteMapper.toEntity(universiteDTO);
        Universite savedUniversite = universiteService.addUniversite(universite);
        return universiteMapper.toDTO(savedUniversite);
    }

    @PutMapping("/updateUniversite")
    public UniversiteDTO updateUniversite(@RequestBody UniversiteDTO universiteDTO) {
        Universite universite = universiteMapper.toEntity(universiteDTO);
        Universite updatedUniversite = universiteService.updateUniversite(universite);
        return universiteMapper.toDTO(updatedUniversite);
    }

    @DeleteMapping("/deleteUniversite/{idUniversite}")
    public void deleteUniversite(@PathVariable Long idUniversite) {
        universiteService.deleteUniversite(idUniversite);
    }

    @GetMapping("/retrieveAllUniversites")
    public List<UniversiteDTO> retrieveAllUniversites() {
        List<Universite> universites = universiteService.getUniversites();
        return universiteMapper.toDTOList(universites);
    }

    @GetMapping("/search/by-nom")
    public List<UniversiteDTO> findByNomUniversiteContains(@RequestParam String nomUniversite) {
        return universiteMapper.toDTOList(universiteService.findByNomUniversiteContains(nomUniversite));
    }

    @GetMapping("/search/by-adresse-like")
    public List<UniversiteDTO> findByAdresseLike(@RequestParam String adresse) {
        return universiteMapper.toDTOList(universiteService.findByAdresseLike(adresse));
    }

    @GetMapping("/search/adresse-not-null")
    public List<UniversiteDTO> findByAdresseIsNotNull() {
        return universiteMapper.toDTOList(universiteService.findByAdresseIsNotNull());
    }

    @GetMapping("/search/without-foyer")
    public List<UniversiteDTO> findByFoyerIsNull() {
        return universiteMapper.toDTOList(universiteService.findByFoyerIsNull());
    }
}
