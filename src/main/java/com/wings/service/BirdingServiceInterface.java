// package com.wings.service;


// import java.io.IOException;
// import java.sql.SQLException;
// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.UUID;

// import com.wings.models.*;
// import com.wings.repository.*;

// public class BirdingServiceInterface {
//     UserRepository userRepo;
//     BirdRepository birdRepo;
//     SpottedBirdRepository spottedBirdRepo;
//     FriendshipRepository friendshipRepo;

//     BirdingService(UserRepository userRepo, BirdRepository birdRepo, SpottedBirdRepository spottedBirdRepo, FriendshipRepository friendshipRepo) {}
//     User createUser(String username) throws SQLException {}
//     User loginUser(String username) throws SQLException {}
//     void spotBird(User currentUser, UUID birdId) throws SQLException {}
//     List<Bird> getAllBirds() throws SQLException {}
//     List<SpottedBird> getMyBirds(User currentUser) throws SQLException {}
//     Bird getBirdById(UUID birdId) throws SQLException{}
//     void addFriend(User currentUser, String username) throws SQLException{}
// }
