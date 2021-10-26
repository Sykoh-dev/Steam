package Sykodev.Steam.controllers;

import Sykodev.Steam.models.dto.ClientDTO;
import Sykodev.Steam.models.form.ClientForm;
import Sykodev.Steam.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping(path = {"","/","/all"})
    public ResponseEntity<List<ClientDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getOne(@PathVariable Long id){
        return ResponseEntity
                .ok( service.getOne(id));
    }

    @PostMapping(path = {"", "/", "/add"})
    public ClientDTO insert(@Valid @RequestBody ClientForm form){



        return service.insert(form);
    }

    @DeleteMapping("/{id}")
    public ClientDTO delete(@PathVariable(name = "id") long id){
        return service.delete(id);
    }

    @PutMapping(params= "id")
    public ClientDTO update(@RequestParam long id,@Valid @RequestBody ClientForm form){
        return service.update(id);

    }

}
