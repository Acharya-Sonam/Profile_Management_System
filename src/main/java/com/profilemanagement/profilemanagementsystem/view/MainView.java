package com.profilemanagement.profilemanagementsystem.view;
import com.profilemanagement.profilemanagementsystem.controller.UserController;
import com.profilemanagement.profilemanagementsystem.model.User;

import java.util.List;
import java.util.Scanner;

public class MainView {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserController userController = new UserController();

        while (true) {

            System.out.println("1. Add User Profile");
            System.out.println("2. View All Users");
            System.out.println("3. View My Profile (by ID)");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    if (userController.addUser(name, email, password)) {
                        System.out.println("User added successfully!");
                    } else {
                        System.out.println("Failed to add user.");
                    }

                    break;

                case 2:

                    List<User> users = userController.getAllUsers();

                    if (users == null || users.isEmpty()) {
                        System.out.println("No users found.");
                    } else {

                        for (User user : users) {

                            System.out.println("ID: " + user.getId());
                            System.out.println("Name: " + user.getName());
                            System.out.println("Email: " + user.getEmail());
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    User user = userController.getUserById(id);

                    if (user != null) {

                        System.out.println("ID: " + user.getId());
                        System.out.println("Name: " + user.getName());
                        System.out.println("Email: " + user.getEmail());

                    } else {

                        System.out.println("User not found.");
                    }

                    break;

                case 4:

                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;

                default:

                    System.out.println("Please choose a correct option.");
            }
        }
    }
}