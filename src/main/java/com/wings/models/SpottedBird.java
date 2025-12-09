package com.wings.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class SpottedBird {
    private UUID spottedBirdId;
    private UUID userId;
    private UUID birdId;
    private LocalDateTime dateSpotted;

    public SpottedBird(UUID spottedBirdId, UUID userId, UUID birdId, LocalDateTime dateSpotted){
        this.spottedBirdId = spottedBirdId;
        this.userId = userId;
        this.birdId = birdId;
        this.dateSpotted = dateSpotted;
    }

    public UUID getSpottedBirdId() { return this.spottedBirdId; };
    public UUID getUserId() { return this.userId; };
    public UUID getBirdId() { return this.birdId; };
    public LocalDateTime getDateSpotted() { return this.dateSpotted; };
}
