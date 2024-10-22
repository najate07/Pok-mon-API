package fr.efrei.pokemon.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Combat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    private Pokemon pokemon1;

    @ManyToOne
    private Pokemon pokemon2;

    @ManyToOne
    private Pokemon gagnant;

    private Date date;

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public Pokemon getGagnant() {
        return gagnant;
    }

    public void setGagnant(Pokemon gagnant) {
        this.gagnant = gagnant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
