package com.wings.repository.impl;

import java.sql.SQLException;
import java.util.UUID;

import com.wings.models.User;
import com.wings.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void saveUser(User user) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveUser'");
    }

    @Override
    public User getUserById(UUID id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public User getUserByUsername(String username) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByUsername'");
    }

    @Override
    public User[] getAllUsers() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }
    
}
