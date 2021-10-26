package Sykodev.Steam.controllers;

import Sykodev.Steam.models.dto.AchatDTO;
import Sykodev.Steam.models.form.AchatForm;
import Sykodev.Steam.service.AchatService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/achat")
public class AchatController {

    private final AchatService service;

    public AchatController(AchatService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<AchatDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AchatDTO> getOne(@PathVariable Long id){
        return ResponseEntity
                .ok( service.getOne(id));
    }

    @PostMapping(path = {"", "/", "/add"})
    public AchatDTO insert(@Valid @RequestBody AchatForm form){

        return service.insert(form);
    }

    @DeleteMapping("/{id}")
    public AchatDTO delete(@PathVariable(name = "id") long id){
        return service.delete(id);
    }

    @PutMapping(params= "id")
    public AchatDTO update(@RequestParam long id,@Valid @RequestBody AchatForm form){
        return service.update(id);

}
    }
