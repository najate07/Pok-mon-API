package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Combat;
import fr.efrei.pokemon.services.CombatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combats")
public class CombatController {

    private final CombatService service;

    @Autowired
    public CombatController(CombatService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Combat>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combat> findById(@PathVariable String id) {
        Combat combat = service.findById(id);
        if (combat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(combat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Combat combat) {
        service.save(combat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Combat combat = service.findById(id);
        if (combat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
