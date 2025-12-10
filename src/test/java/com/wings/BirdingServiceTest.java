package com.wings;

import com.wings.models.Bird;
import com.wings.models.SpottedBird;
import com.wings.models.User;
import com.wings.repository.BirdRepository;
import com.wings.repository.SpottedBirdRepository;
import com.wings.repository.UserRepository;
import com.wings.service.BirdingService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

public class BirdingServiceTest {
    private BirdingService birdingService;
    private SpottedBirdRepository mockSpottedBirdRepo;
    private BirdRepository mockBirdRepo;
    private UserRepository mockUserRepo;

    @BeforeEach
    public void setUp() {
        mockSpottedBirdRepo = mock(SpottedBirdRepository.class);
        mockBirdRepo = mock(BirdRepository.class);
        mockUserRepo = mock(UserRepository.class);
        birdingService = new BirdingService(mockUserRepo, mockBirdRepo, mockSpottedBirdRepo, null);
    }

    @Test
    @DisplayName("Should create user successfully with valid username")
    public void testCreateUserSuccess() throws SQLException {
        String username = "username";
        when(mockUserRepo.getUserByUsername(username)).thenReturn(null);
        
        User createdUser = birdingService.createUser(username);

        assertNotNull(createdUser);
        assertEquals(username, createdUser.getUsername());
        assertEquals(0, createdUser.getCurrentStreak());
        assertEquals(0, createdUser.getBirdsSpotted());

        verify(mockUserRepo).saveUser(any(User.class));
    }

    @Test
    @DisplayName("Should fail to create user with duplicate username")
    public void testCreateUserDuplicateUsernameFail() throws SQLException {
        String username = "username";
        User existingUser = new User(UUID.randomUUID(), 0, 0, username);
        when(mockUserRepo.getUserByUsername(username)).thenReturn(existingUser);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> birdingService.createUser(username)
        );

        assertEquals("Username already exists", exception.getMessage());
        verify(mockUserRepo, never()).saveUser(any(User.class));
    }

    @Test
    @DisplayName("Should fail to create user with null username")
    public void testCreateUserNullUsernameFail() throws SQLException {
        String username = null;
        when(mockUserRepo.getUserByUsername(username)).thenReturn(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> birdingService.createUser(username));

        assertEquals("Username cannot be empty", exception.getMessage());
        verify(mockUserRepo, never()).saveUser(any(User.class));
    }

    @Test
    @DisplayName("Should fail to create user with empty username")
    public void testCreateUserEmptyUsernameFail() throws SQLException {
        String username = "";
        when(mockUserRepo.getUserByUsername(username)).thenReturn(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> birdingService.createUser(username));

        assertEquals("Username cannot be empty", exception.getMessage());
        verify(mockUserRepo, never()).saveUser(any(User.class));
    }

    //SPOT BIRD
    //Spot bird success
    @Test
    @DisplayName("Should create bird spotting with correct user and bird")
    public void testSpotBirdSuccess() throws SQLException {
        UUID birdId = UUID.randomUUID();
        User user = new User(UUID.randomUUID(), 0, 0, "username");

        birdingService.spotBird(user, birdId);

        ArgumentCaptor<SpottedBird> captor = ArgumentCaptor.forClass(SpottedBird.class);
        verify(mockSpottedBirdRepo).saveSpottedBird(captor.capture());

        SpottedBird saved = captor.getValue();

        assertEquals(birdId, saved.getBirdId());
        assertEquals(user.getUserId(), user.getUserId());
    }

    @Test
    @DisplayName("Should fail to create bird with null user")
    public void testSpotBirdNullUserFail() throws SQLException {
        UUID birdId = UUID.randomUUID();

        assertThrows(IllegalArgumentException.class, () -> birdingService.spotBird(null, birdId));

        verify(mockSpottedBirdRepo, never()).saveSpottedBird(any());
    }

    @Test
    @DisplayName("Should fail to create bird with null bird ID")
    public void testSpotBirdNullBirdIdFail() throws SQLException {
        User user = new User(UUID.randomUUID(), 0, 0, "username");

        assertThrows(IllegalArgumentException.class, () -> birdingService.spotBird(user, null));

        verify(mockSpottedBirdRepo, never()).saveSpottedBird(any());
    }

    //BIRD
    //Get My Birds Success
    //TODO
    /*
    @Test
    @DisplayName("Should return spotted birds for user")
    public void testGetSpottedBirdsSuccess() throws SQLException {
        User user = new User(UUID.randomUUID(), 0, 0, "username");
        UUID spottedBirdUUID = UUID.randomUUID()
        SpottedBird spottedBird = new SpottedBird(UUID.randomUUID(), user.getUserId(), spottedBirdUUID, LocalDateTime.now());

        ArgumentCaptor<SpottedBird> 
    }
    */
    //Get My Birds invalid user
    
    //FRIEND
    //Add friend success
    //Add friend username empty
    //Add friend username null
    //Add friend username is own username

}
