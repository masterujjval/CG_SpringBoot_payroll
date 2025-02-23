package com.payroll.payrollapp.uc2;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping ResultSet to User object
    private final RowMapper<User> userRowMapper = (rs, rowNum) ->
            new User(rs.getInt("id"), rs.getString("name"));

    // Create User
    public int addUser(User user) {
        String sql = "INSERT INTO users (name) VALUES (?)";
        return jdbcTemplate.update(sql, user.getName());
    }

    // Get All Users
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    // Get User by ID
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, id);
    }

    // Update User
    public int updateUser(int id, String name) {
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, name, id);
    }

    // Delete User
    public int deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
