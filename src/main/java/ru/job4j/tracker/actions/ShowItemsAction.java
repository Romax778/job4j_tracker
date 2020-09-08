package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;
import ru.job4j.tracker.console.Output;

public class ShowItemsAction implements UserAction {
    private final Output out;

    public ShowItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "ITEMS";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== ITEMS LIST ====");
        Item[] items = tracker.findAll();
        for (Item item : items) out.println(item);
        return true;
    }
}
