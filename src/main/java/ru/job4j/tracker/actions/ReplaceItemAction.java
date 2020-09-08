package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;
import ru.job4j.tracker.console.Output;

public class ReplaceItemAction implements UserAction {
    private final Output out;

    public ReplaceItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "REPLACE";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== REPLACE ITEM ====");
        int taskId = input.askInt("Enter task id: ");
        String taskName = input.askStr("Enter new task name: ");

        Item some = new Item(taskName);

        if (tracker.replace(taskId, some)) {
            out.println("Task was edited!!");
        } else {
            out.println("Task with id " + taskId + " not found!!");
        }

        return true;
    }
}
