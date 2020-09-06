package ru.job4j.tracker.actions;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.console.Input;

public class ExitAction implements UserAction{
    @Override
    public String name() {
        return "=== EXIT ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
