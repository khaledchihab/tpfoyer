package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.ChambreDTO;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;
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

    @GetMapping("/search/by-numero-gt")
    public List<ChambreDTO> findByNumeroChambreGreaterThan(@RequestParam Long numero) {
        return chambreMapper.toDTOList(chambreService.findByNumeroChambreGreaterThan(numero));
    }

    @GetMapping("/search/by-numero-lt")
    public List<ChambreDTO> findByNumeroChambreLessThan(@RequestParam Long numero) {
        return chambreMapper.toDTOList(chambreService.findByNumeroChambreLessThan(numero));
    }

    @GetMapping("/search/by-numero-between")
    public List<ChambreDTO> findByNumeroChambreBetween(@RequestParam Long minNumero, @RequestParam Long maxNumero) {
        return chambreMapper.toDTOList(chambreService.findByNumeroChambreBetween(minNumero, maxNumero));
    }

    @GetMapping("/search/by-type")
    public List<ChambreDTO> findByTypeC(@RequestParam TypeChambre typeChambre) {
        return chambreMapper.toDTOList(chambreService.findByTypeC(typeChambre));
    }

    @GetMapping("/search/by-bloc")
    public List<ChambreDTO> findByBlocNomBlocContains(@RequestParam String nomBloc) {
        return chambreMapper.toDTOList(chambreService.findByBlocNomBlocContains(nomBloc));
    }

    @GetMapping("/search/by-foyer")
    public List<ChambreDTO> findByBlocFoyerNomFoyerContains(@RequestParam String nomFoyer) {
        return chambreMapper.toDTOList(chambreService.findByBlocFoyerNomFoyerContains(nomFoyer));
    }

    @GetMapping("/jpql/by-type")
    public List<ChambreDTO> retrieveChambresByTypeJPQL(@RequestParam TypeChambre typeC) {
        return chambreMapper.toDTOList(chambreService.retrieveChambresByTypeJPQL(typeC));
    }

    @GetMapping("/jpql/by-nom-bloc")
    public List<ChambreDTO> retrieveChambresByNomBlocJPQL(@RequestParam String nomBloc) {
        return chambreMapper.toDTOList(chambreService.retrieveChambresByNomBlocJPQL(nomBloc));
    }

    @GetMapping("/native/by-type")
    public List<ChambreDTO> retrieveChambresByTypeNative(@RequestParam String typeC) {
        return chambreMapper.toDTOList(chambreService.retrieveChambresByTypeNative(typeC));
    }

    @PutMapping("/jpql/update-type")
    public int updateTypeById(@RequestParam Long idChambre, @RequestParam TypeChambre typeC) {
        return chambreService.updateTypeById(idChambre, typeC);
    }

    @DeleteMapping("/jpql/delete-by-numero-lt")
    public int deleteChambresByNumeroLessThan(@RequestParam Long maxNumero) {
        return chambreService.deleteChambresByNumeroLessThan(maxNumero);
    }
}
