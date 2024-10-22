package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Arene;
import fr.efrei.pokemon.services.AreneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arenes")
public class AreneController {

    private final AreneService service;

    @Autowired
    public AreneController(AreneService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Arene>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arene> findById(@PathVariable String id) {
        Arene arene = service.findById(id);
        if (arene == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(arene, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Arene arene) {
        service.save(arene);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Arene arene = service.findById(id);
        if (arene == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
