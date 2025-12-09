package com.wings.repository.impl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.wings.database.QueryExecuter;
import com.wings.models.SpottedBird;
import com.wings.repository.SpottedBirdRepository;

public class SpottedBirdRepositoryImpl implements SpottedBirdRepository {

    @Override
    public void saveSpottedBird(SpottedBird spottedBird) throws SQLException {
        String sql = "INSERT INTO spotted_birds (spotted_bird_id, user_id, bird_id, date_spotted) VALUES (?, ?, ?, ?)";
        QueryExecuter.executeUpdate(sql, pstmt -> {
            pstmt.setObject(1, spottedBird.getSpottedBirdId());
            pstmt.setObject(2, spottedBird.getUserId());
            pstmt.setObject(3, spottedBird.getBirdId());
            pstmt.setObject(4, spottedBird.getDateSpotted());
        });
    }

    @Override
    public List<SpottedBird> getSpottedBirdsByUserId(UUID userId) throws SQLException {
        String sql = "SELECT * FROM spotted_birds WHERE user_id = ?";
        List<SpottedBird> spottedBirdList = new ArrayList<>();
        return QueryExecuter.executeQuery(sql, pstmt -> {
            pstmt.setObject(1, userId);
        }, rs -> {
            while(rs.next()) {
                SpottedBird spottedBird = new SpottedBird(
                    rs.getObject("spotted_bird_id", UUID.class),
                    rs.getObject("user_id", UUID.class),
                    rs.getObject("bird_id", UUID.class),
                    rs.getObject("date_spotted", LocalDateTime.class)
                );
                spottedBirdList.add(spottedBird);
            }
            return spottedBirdList;
        });
    }

    @Override
    public List<SpottedBird> getAllSpottedBirds() throws SQLException {
        String sql = "SELECT * FROM spotted_birds";
        List<SpottedBird> spottedBirdList = new ArrayList<>();
        return QueryExecuter.executeQuery(sql, pstmt -> {}, rs -> {
            while(rs.next()) {
                SpottedBird spottedBird = new SpottedBird(
                    rs.getObject("spotted_bird_id", UUID.class),
                    rs.getObject("user_id", UUID.class),
                    rs.getObject("bird_id", UUID.class),
                    rs.getObject("date_spotted", LocalDateTime.class)
                );
                spottedBirdList.add(spottedBird);
            }
            return spottedBirdList;
        });
    }
}
