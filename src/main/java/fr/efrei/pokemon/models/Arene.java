package fr.efrei.pokemon.models;

import jakarta.persistence.*;

@Entity
public class Arene {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nom;

    @OneToOne
    private Trainer champion;

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Trainer getChampion() {
        return champion;
    }

    public void setChampion(Trainer champion) {
        this.champion = champion;
    }
}
