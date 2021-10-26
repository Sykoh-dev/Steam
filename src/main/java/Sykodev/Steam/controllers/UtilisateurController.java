package Sykodev.Steam.controllers;

import Sykodev.Steam.models.dto.UtilisateurDTO;
import Sykodev.Steam.models.form.UtilisateurForm;
import Sykodev.Steam.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UtilisateurController {

    public final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UtilisateurDTO> insert(@Valid @RequestBody UtilisateurForm form){
        return ResponseEntity.ok( service.insert(form) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> update(@PathVariable long id, @Valid @RequestBody UtilisateurForm form){
        return ResponseEntity.ok( service.update(id, form) );
    }

    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getAll(){
        return ResponseEntity.ok( service.getAll() );
    }

    }