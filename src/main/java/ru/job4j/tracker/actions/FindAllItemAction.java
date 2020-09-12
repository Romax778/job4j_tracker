package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;
import ru.job4j.tracker.console.Output;

public class FindAllItemAction implements UserAction {
    private final Output out;

    public FindAllItemAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "FIND ALL";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();


        for (int i = 0; i < items.length; i++) {
            out.println(items[i]);
        }

        return true;
    }
}

