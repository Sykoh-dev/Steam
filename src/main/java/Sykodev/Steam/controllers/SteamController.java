package Sykodev.Steam.controllers;

import Sykodev.Steam.models.dto.SteamDTO;
import Sykodev.Steam.models.form.SteamForm;
import Sykodev.Steam.service.SteamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/steam")
public class SteamController {

    private final SteamService service;

    public SteamController(SteamService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<SteamDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SteamDTO> getOne(@PathVariable Long id){
        return ResponseEntity
                .ok( service.getOne(id));
    }

    @PostMapping(path = {"", "/", "/add"})
    public SteamDTO insert(@Valid @RequestBody SteamForm form){

        return service.insert(form);
    }

    @DeleteMapping("/{id}")
    public SteamDTO delete(@PathVariable(name = "id") long id){
        return service.delete(id);
    }

    @PutMapping(params= "id")
    public SteamDTO update(@RequestParam long id,@Valid @RequestBody SteamForm form){
        return service.update(id);

    }
}
