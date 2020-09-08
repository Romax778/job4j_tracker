package ru.job4j.tracker.actions;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;
import ru.job4j.tracker.console.Output;

public class DeleteItemAction implements UserAction {
    private final Output out;
    public DeleteItemAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== DELETE ITEM ====");
        int taskId = input.askInt("Enter task id: ");

        if (tracker.delete(taskId)) {
            out.println("Task was deleted!!");
        } else {
           out.println("Task with id " + taskId + " not found!!");
        }
        return true;
    }
}
