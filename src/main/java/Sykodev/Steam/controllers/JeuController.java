package Sykodev.Steam.controllers;

import Sykodev.Steam.models.dto.JeuDTO;
import Sykodev.Steam.models.form.JeuForm;
import Sykodev.Steam.service.JeuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jeu")
public class JeuController {

    private final JeuService service;

    public JeuController(JeuService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<JeuDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JeuDTO> getOne(@PathVariable Long id){
        return ResponseEntity
                .ok( service.getOne(id));
    }

    @PostMapping(path = {"", "/", "/add"})
    public JeuDTO insert(@Valid @RequestBody JeuForm form){

        return service.insert(form);
    }

    @DeleteMapping("/{id}")
    public JeuDTO delete(@PathVariable(name = "id") long id){
        return service.delete(id);
    }

    @PutMapping(params= "id")
    public JeuDTO update(@RequestParam long id,@Valid @RequestBody JeuForm form){
        return service.update(id);

    }
}
