package org.example;

import java.util.Scanner;

public class Main {
    private static User[] users = new User[10];
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. View Task List");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter user name:");
                    String name = scanner.nextLine();
                    if (userExists(name)) {
                        System.out.println("User already exists.");
                    } else {
                        users[userCount++] = new User(name);
                    }
                    break;

                case 2:
                    System.out.println("Enter user name:");
                    name = scanner.nextLine();
                    User user = findUser(name);
                    if (user != null) {
                        System.out.println("Enter task description:");
                        String taskDescription = scanner.nextLine();
                        user.addTask(taskDescription);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter user name:");
                    name = scanner.nextLine();
                    user = findUser(name);
                    if (user != null) {
                        System.out.println("Enter task description to mark as completed:");
                        String taskDescription = scanner.nextLine();
                        user.markAsDone(taskDescription);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter user name:");
                    name = scanner.nextLine();
                    user = findUser(name);
                    if (user != null) {
                        user.printTasks();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static User findUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }
        return null;
    }

    private static boolean userExists(String name) {
        return findUser(name) != null;
    }
}
