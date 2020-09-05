package ru.job4j.tracker.actions;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "=== DELETE ITEM ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int taskId = input.askInt("Enter task id: ");

        if (tracker.delete(taskId)) {
            System.out.println("Task was deleted!!");
        } else {
            System.out.println("Task with id " + taskId + " not found!!");
        }
        return true;
    }
}
