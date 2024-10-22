package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.dto.CreateTrainer;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

	private final TrainerService trainerService;

	@Autowired
	public TrainerController(TrainerService trainerService) {
		this.trainerService = trainerService;
	}

	@GetMapping
	public ResponseEntity<List<Trainer>> findAll() {
		return new ResponseEntity<>(trainerService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Trainer> findById(@PathVariable String id) {
		Trainer trainer = trainerService.findById(id);
		if (trainer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(trainer, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody CreateTrainer trainer) {
		trainerService.save(trainer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
