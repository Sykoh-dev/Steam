package Sykodev.Steam.controllers;

import Sykodev.Steam.models.dto.RemboursementDTO;
import Sykodev.Steam.models.form.RemboursementForm;
import Sykodev.Steam.service.RemboursementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/remboursement")
public class RemboursementController {

    private final RemboursementService service;

    public RemboursementController(RemboursementService service) {
        this.service = service;
    }


    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<RemboursementDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemboursementDTO> getOne(@PathVariable Long id){
        return ResponseEntity
                .ok( service.getOne(id));
    }

    @PostMapping(path = {"", "/", "/add"})
    public RemboursementDTO insert(@Valid @RequestBody RemboursementForm form){

        return service.insert(form);
    }

    @DeleteMapping("/{id}")
    public RemboursementDTO delete(@PathVariable(name = "id") long id){
        return service.delete(id);
    }

    @PutMapping(params= "id")
    public RemboursementDTO update(@RequestParam long id,@Valid @RequestBody RemboursementForm form){
        return service.update(id);

    }
}
