package com.profilemanagement.profilemanagementsystem.dao;
import com.profilemanagement.profilemanagementsystem.model.User;
import com.profilemanagement.profilemanagementsystem.utils.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public boolean insertUser(String name, String email, String password) throws SQLException {

        String sql = "INSERT INTO profile (name, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int rows = preparedStatement.executeUpdate();

            return rows > 0;
        }
    }


    public List<User> getAllUsers() throws SQLException {

        String sql = "SELECT * FROM profile";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement()) {

            List<User> users = new ArrayList<>();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);

                User user = new User(id, name, email, password);

                users.add(user);
            }

            return users;
        }
    }


    public User getUserById(int id) throws SQLException {

        String sql = "SELECT * FROM profile WHERE id=?";

        try (Connection conn = DBConnection.getConnection()) {

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                int uid = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);

                return new User(uid, name, email, password);
            }
        }

        return null;
    }
}