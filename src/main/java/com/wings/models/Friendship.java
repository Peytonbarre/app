package com.wings.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Friendship {
    private UUID userId1;
    private UUID userId2;
    private LocalDateTime friendSince;

    public Friendship(UUID userId1, UUID userId2, LocalDateTime friendSince){
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.friendSince = friendSince;
    }

    public UUID getUserId1() { return this.userId1; };
    public UUID getUserId2() { return this.userId2; };
    public LocalDateTime getFriendSince() { return this.friendSince; };
        //Todo
    //ToString and equals
}
