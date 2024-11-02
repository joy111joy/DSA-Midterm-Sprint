package org.example;

public class TaskList {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskList() {
        head = null;
    }

    // Add a new task to the end of the list
    public void addTask(String description) {
        Task newTask = new Task(description);
        Node newNode = new Node(newTask);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Mark a task as completed by its description
    public void MarkTaskDone(String description) {
        Node current = head;
        while (current != null) {
            if (current.task.description.equals(description)) {
                current.task.markDone();
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found");
    }

    // Print all tasks in the list
    public void printTaskList() {
        Node current = head;
        if (current == null) {
            System.out.println("Task list is empty");
            return;
        }

        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }


    @Override
    public String toString() {
        String result = "";
        Node current = head;

        if (current == null) {
            return "No tasks available";
        }

        while (current != null) {
            result += current.task.toString() + "\n";
            current = current.next;
        }

        return result;
    }
}

