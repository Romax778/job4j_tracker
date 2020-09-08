package ru.job4j.tracker;


import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.console.ConsoleInput;
import ru.job4j.tracker.console.ConsoleOutput;
import ru.job4j.tracker.console.Input;
import ru.job4j.tracker.console.Output;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }


    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;

        while (run) {
            this.showMenu(actions);

            int select = input.askInt("Select: ");
            UserAction action = actions[select];

            run = action.execute(input, tracker);
        }
    }


    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }


    public static void main(String[] args) {
        Output output = new ConsoleOutput();

        Input input = new ConsoleInput();

        Tracker tracker = new Tracker();

        UserAction[] actions = {
                new CreateAction(output), new ShowItemsAction(output), new ReplaceItemAction(output),
                new DeleteItemAction(output), new FindItemByIdAction(output), new FindItemsByNameAction(output)
        };
        new StartUI(output).init(input, tracker, actions);

    }
}
