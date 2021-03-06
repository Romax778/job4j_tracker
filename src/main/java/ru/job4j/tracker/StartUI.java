package ru.job4j.tracker;


import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.console.ConsoleOutput;
import ru.job4j.tracker.console.Input;
import ru.job4j.tracker.console.Output;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }


    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;

        while (run) {
            this.showMenu(actions);

            int select = input.askInt("Select: ");


            UserAction action = null;
            if(select < 0 || select >= actions.size()) {
                System.out.println("Choose existing option");
                continue;
            }
                action = actions.get(select);



            run = action.execute(input, tracker);
        }
    }


    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }


    public static void main(String[] args) {
        Output output = new ConsoleOutput();

        Input input = new ru.job4j.tracker.ValidateInput();

        Tracker tracker = new Tracker();

        List<UserAction>actions = new ArrayList<>() ;
                actions.add(new CreateAction(output));
                actions.add(new ShowItemsAction(output));
                actions.add(new ReplaceItemAction(output));
        actions.add(new DeleteItemAction(output));
        actions.add( new FindItemByIdAction(output));
        actions.add( new FindItemsByNameAction(output));
        actions.add( new FindAllItemAction(output));
        actions.add(new ExitAction(output));

        new StartUI(output).init(input, tracker, actions);

    }
}
