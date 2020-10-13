package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.console.Input;
import ru.job4j.tracker.console.Output;
import ru.job4j.tracker.console.StubInput;
import ru.job4j.tracker.console.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
//    @Test
//    public void whenCreateItem() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[] {"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(out),
//                new ExitAction(out)
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }
//    @Test
//    public void whenReplaceItem() {
//        Output out = new StubOutput();
//
//        Tracker tracker = new Tracker();
//
//        Item item = tracker.add(new Item("Replaced item"));
//
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[] {"0" ,"1", replacedName, "1"}
//        );
//        UserAction[] actions = {
//                new ReplaceItemAction(out),
//                new ExitAction(out)
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Output out = new StubOutput();
//        Tracker tracker = new Tracker();
//
//        Item item = tracker.add(new Item("Deleted item"));
//
//        Input in = new StubInput(
//                new String[] {"0" , "1", "1"}
//        );
//        UserAction[] actions = {
//                new DeleteItemAction(out),
//                new ExitAction(out)
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new ru.job4j.tracker.ValidateInput();
                

        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }

    @Test
    public void findAllTest() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();

        tracker.add(new Item("first"));
        tracker.add(new Item("second"));


        UserAction[] actions = {
                new FindAllItemAction(out),
                new ExitAction(out)
        };

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. FIND ALL" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "1 first" + System.lineSeparator() +
                        "2 second" + System.lineSeparator() +

                        "Menu." + System.lineSeparator() +
                        "0. FIND ALL" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void findByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "first", "1"}
        );
        Tracker tracker = new Tracker();

        tracker.add(new Item("first"));
        tracker.add(new Item("second"));


        UserAction[] actions = {
                new FindItemsByNameAction(out),
                new ExitAction(out)
        };

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. FIND BY NAME" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "1 first" + System.lineSeparator() +


                        "Menu." + System.lineSeparator() +
                        "0. FIND BY NAME" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()

        ));
    }

    @Test
    public void findByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "2", "1"}
        );
        Tracker tracker = new Tracker();

        tracker.add(new Item("first"));
        tracker.add(new Item("second"));


        UserAction[] actions = {
                new FindItemByIdAction(out),
                new ExitAction(out)
        };

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. FIND BY ID" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "Task found :" + System.lineSeparator() +
                        "2 second" + System.lineSeparator() +

                        "Menu." + System.lineSeparator() +
                        "0. FIND BY ID" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()

        ));
    }


}

