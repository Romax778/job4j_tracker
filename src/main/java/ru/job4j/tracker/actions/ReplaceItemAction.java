package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;

public class ReplaceItemAction implements UserAction {
    @Override
    public String name() {
        return "=== REPLACE ITEM ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int taskId = input.askInt("Enter task id: ");
        String taskName = input.askStr("Enter new task name: ");

        Item some = new Item(taskName);

        if (tracker.replace(taskId, some)) {
            System.out.println("Task was edited!!");
        } else {
            System.out.println("Task with id " + taskId + " not found!!");
        }

        return true;
    }
}
