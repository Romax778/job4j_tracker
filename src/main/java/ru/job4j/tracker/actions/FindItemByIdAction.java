package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;
import ru.job4j.tracker.console.Output;

public class FindItemByIdAction implements UserAction {
    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    private final Output out;

    @Override
    public String name() {
        return  "FIND BY ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {

        int taskId = input.askInt("Enter task id: ");
        Item item = tracker.findById(taskId);

        if (item != null) {
            out.println("Task found :");
            out.println(item);
        } else {
            out.println("Task with id: " + taskId + " not  found!!!");
        }
        return true;
    }
}
