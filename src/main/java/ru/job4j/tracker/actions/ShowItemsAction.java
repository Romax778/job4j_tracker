package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;

public class ShowItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== ITEMS LIST ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item item : items) System.out.println(item);
        return true;
    }
}
