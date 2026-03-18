package com.profilemanagement.profilemanagementsystem.controller;
import com.profilemanagement.profilemanagementsystem.dao.UserDAO;
import com.profilemanagement.profilemanagementsystem.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserController {

    private UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
    }

    public boolean addUser(String name, String email, String password) {

        try {
            return userDAO.insertUser(name, email, password);
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
            return false;
        }
    }

    public List<User> getAllUsers() {

        try {
            return userDAO.getAllUsers();
        } catch (SQLException e) {
            System.out.println("Error retrieving users: " + e.getMessage());
            return null;
        }
    }

    public User getUserById(int id) {

        try {
            return userDAO.getUserById(id);
        } catch (SQLException e) {
            System.out.println("Error retrieving user: " + e.getMessage());
            return null;
        }
    }
}