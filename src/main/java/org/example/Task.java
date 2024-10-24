package org.example;

public class Task {
    public String description;
    public boolean done;

    //constructor
    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public boolean isDone() {
        return done;
    }



    //Mark as done
    public void markDone() {
        this.done = true;
        System.out.println("The task " + this.description + " has been marked as done");
    }

    @Override
    public String toString() {
        return ("Task: " + this.description + " Completed: " + this.done);
    }
}
