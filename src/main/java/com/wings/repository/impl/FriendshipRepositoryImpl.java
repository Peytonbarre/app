package com.wings.repository.impl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.wings.database.QueryExecuter;
import com.wings.models.Friendship;
import com.wings.repository.FriendshipRepository;
public class FriendshipRepositoryImpl implements FriendshipRepository {

    @Override
    public void addFriendship(Friendship friendship) throws SQLException {
        String sql = "INSERT INTO friendships (userId1, userId2, friendSince) VALUES (?, ?, ?)";
        QueryExecuter.executeUpdate(sql, pstmt -> {
            if(friendship.getUserId1().compareTo(friendship.getUserId2()) < 0){
                pstmt.setObject(1, friendship.getUserId1());
                pstmt.setObject(2, friendship.getUserId2());
            }else{
                pstmt.setObject(1, friendship.getUserId2());
                pstmt.setObject(2, friendship.getUserId1());
            }
            pstmt.setObject(3, friendship.getFriendSince());
        });
    }

    @Override
    public List<Friendship> getFriendshipByUserId(UUID userId) throws SQLException {
        String sql = "SELECT * FROM friendships WHERE userId1 = ? UNION ALL SELECT * FROM frienships WHERE userId2 = ?";
        List<Friendship> frienshipList = new ArrayList<>();
        return QueryExecuter.executeQuery(sql, pstmt -> {
            pstmt.setObject(1, userId);
            pstmt.setObject(2, userId);
        }, rs -> {
            while(rs.next()) {
                Friendship friendship = new Friendship(
                    rs.getObject("userId1", UUID.class),
                    rs.getObject("userId1", UUID.class),
                    rs.getObject("friendSince", LocalDateTime.class)
                );
                frienshipList.add(friendship);
            }
            return frienshipList;
        });
    }

    @Override
    public void removeFriendship(UUID userId1, UUID userId2) throws SQLException {
        String sql = "DELETE FROM friendships WHERE (userId1 = ? AND userId2 = ?) OR (userId1 = ? AND userId2 = ?)";
        QueryExecuter.executeUpdate(sql, pstmt -> {
            pstmt.setObject(1, userId1);
            pstmt.setObject(2, userId2);
            pstmt.setObject(3, userId2);
            pstmt.setObject(4, userId1);
        });
    }
    
}
