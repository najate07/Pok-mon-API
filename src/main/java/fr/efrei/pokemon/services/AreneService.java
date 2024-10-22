package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Arene;
import fr.efrei.pokemon.repositories.AreneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreneService {

    private final AreneRepository repository;

    @Autowired
    public AreneService(AreneRepository repository) {
        this.repository = repository;
    }

    public List<Arene> findAll() {
        return repository.findAll();
    }

    public Arene findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Arene arene) {
        repository.save(arene);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Arene areneBody) {
        Arene arene = findById(id);
        if (arene != null) {
            arene.setNom(areneBody.getNom());
            arene.setChampion(areneBody.getChampion());
            repository.save(arene);
        }
    }
}
