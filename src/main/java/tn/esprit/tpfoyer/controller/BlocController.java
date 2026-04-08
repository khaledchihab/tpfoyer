package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.BlocDTO;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.mapper.mapstruct.BlocMapStructMapper;
import tn.esprit.tpfoyer.services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {

    IBlocService blocService;
    BlocMapStructMapper blocMapper;

    @PostMapping("/addBloc")
    public BlocDTO addBloc(@RequestBody BlocDTO blocDTO) {
        Bloc bloc = blocMapper.toEntity(blocDTO);
        Bloc savedBloc = blocService.addBloc(bloc);
        return blocMapper.toDTO(savedBloc);
    }

    @PutMapping("/updateBloc")
    public BlocDTO updateBloc(@RequestBody BlocDTO blocDTO) {
        Bloc bloc = blocMapper.toEntity(blocDTO);
        Bloc updatedBloc = blocService.updateBloc(bloc);
        return blocMapper.toDTO(updatedBloc);
    }

    @DeleteMapping("/deleteBloc/{idBloc}")
    public void deleteBloc(@PathVariable Long idBloc) {
        blocService.deleteBloc(idBloc);
    }

    @GetMapping("/retrieveAllBlocs")
    public List<BlocDTO> retrieveAllBlocs() {
        List<Bloc> blocs = blocService.getBloc();
        return blocMapper.toDTOList(blocs);
    }

    @GetMapping("/search/by-nom-like")
    public List<BlocDTO> findByNomBlocLike(@RequestParam String nomBloc) {
        return blocMapper.toDTOList(blocService.findByNomBlocLike(nomBloc));
    }

    @GetMapping("/search/by-nom-contains")
    public List<BlocDTO> findByNomBlocContains(@RequestParam String nomBloc) {
        return blocMapper.toDTOList(blocService.findByNomBlocContains(nomBloc));
    }

    @GetMapping("/search/by-capacite-gt")
    public List<BlocDTO> findByCapaciteBlocGreaterThan(@RequestParam Long capacite) {
        return blocMapper.toDTOList(blocService.findByCapaciteBlocGreaterThan(capacite));
    }

    @GetMapping("/search/by-capacite-between")
    public List<BlocDTO> findByCapaciteBlocBetween(@RequestParam Long minCapacite, @RequestParam Long maxCapacite) {
        return blocMapper.toDTOList(blocService.findByCapaciteBlocBetween(minCapacite, maxCapacite));
    }

    @GetMapping("/search/by-foyer")
    public List<BlocDTO> findByFoyerNomFoyerContains(@RequestParam String nomFoyer) {
        return blocMapper.toDTOList(blocService.findByFoyerNomFoyerContains(nomFoyer));
    }
}
