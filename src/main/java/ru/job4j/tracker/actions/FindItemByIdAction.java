package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== FIND ITEM BY ID ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        int taskId = input.askInt("Enter task id: ");
        Item item = tracker.findById(taskId);

        if (item != null) {
            System.out.println("Task found :");
            System.out.println(item);
        } else {
            System.out.println("Task with id: " + taskId + " not  found!!!");
        }
        return true;
    }
}
