package com.wings.models;

import java.util.UUID;

public class Bird {
    private UUID birdId;
    private String name;
    private String habitat;
    private double rarity;

    public Bird(UUID birdId, String name, String habitat, double rarity) {
        this.birdId = birdId;
        this.name = name;
        this.habitat = habitat;
        this.rarity = rarity;
    }

    public UUID getBirdId() { return this.birdId; };
    public String getName() { return this.name; };
    public String getHabitat() { return this.habitat; };
    public double getRarity() { return this.rarity; };

    //Todo
    //ToString and equals
}
