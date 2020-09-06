package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.console.Input;
import ru.job4j.tracker.console.StubInput;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("Replaced item"));

        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0" ,"1", replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceItemAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("Deleted item"));

        Input in = new StubInput(
                new String[] {"0" , "1", "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

}

