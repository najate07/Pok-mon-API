package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Combat;
import fr.efrei.pokemon.repositories.CombatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombatService {

    private final CombatRepository repository;

    @Autowired
    public CombatService(CombatRepository repository) {
        this.repository = repository;
    }

    public List<Combat> findAll() {
        return repository.findAll();
    }

    public Combat findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Combat combat) {
        repository.save(combat);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Combat combatBody) {
        Combat combat = findById(id);
        if (combat != null) {
            combat.setPokemon1(combatBody.getPokemon1());
            combat.setPokemon2(combatBody.getPokemon2());
            combat.setGagnant(combatBody.getGagnant());
            combat.setDate(combatBody.getDate());
            repository.save(combat);
        }
    }
}
