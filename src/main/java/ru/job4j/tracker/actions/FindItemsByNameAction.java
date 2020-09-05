package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;

public class FindItemsByNameAction implements UserAction{
    @Override
    public String name() {
        return "=== FIND ITEMS BY NAME ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String taskName = input.askStr("Enter name: ");

        Item[] items = tracker.findByName(taskName);

        if (items.length == 0) {
            System.out.println("Task with name :" + taskName + " not found");
        } else {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        }
        return true;
    }
}
