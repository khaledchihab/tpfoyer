package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Bloc;
import tn.esprit.tpfoyer.services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {

    IBlocService blocService;

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocService.addBloc(b);
    }

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc b) {
        return blocService.updateBloc(b);
    }

    @DeleteMapping("/deleteBloc/{idBloc}")
    public void deleteBloc(@PathVariable Long idBloc) {
        blocService.deleteBloc(idBloc);
    }

    @GetMapping("/retrieveAllBlocs")
    public List<Bloc> retrieveAllBlocs() {
        return blocService.getBloc();
    }
}
