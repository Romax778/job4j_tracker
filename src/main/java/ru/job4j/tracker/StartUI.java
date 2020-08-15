package ru.job4j.tracker;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        Item[] items = tracker.findAll();

        for (int i = 0; i < items.length; i++)
            System.out.println(items[i]);
    }

    public static void replaceItem(Input input, Tracker tracker) {


        int taskId = input.askInt("Enter task id: ");
        String taskName = input.askStr("Enter new task name: ");

        Item some = new Item(taskName);

        if (tracker.replace(taskId, some)) {
            System.out.println("Task was edited!!");
        } else {
            System.out.println("Task with id " + taskId + " not found!!");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {


        int taskId = input.askInt("Enter task id: ");

        if (tracker.delete(taskId)) {
            System.out.println("Task was deleted!!");
        } else {
            System.out.println("Task with id " + taskId + " not found!!");
        }

    }

    public static void findItemById(Input input, Tracker tracker) {

        int taskId = input.askInt("Enter task id: ");
        Item item = tracker.findById(taskId);

        if (item != null) {
            System.out.println("Task found :");
            System.out.println(item);
        } else {
            System.out.println("Task with id: " + taskId + " not  found!!!");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {

        System.out.print("Enter task name: ");

        String taskName = input.askStr("Enter name: ");

        Item[] items = tracker.findByName(taskName);


        if (items.length == 0) {

            System.out.println("Task with name :" + taskName + " not found");

        } else {

            for (int i = 0; i < items.length; i++) {

                System.out.println(items[i]);

            }

        }

    }


    public void init(Input input, Tracker tracker) {

        boolean run = true;

        while (run) {
            this.showMenu();
            int select = input.askInt("select");

            System.out.println("======================================");

            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemsByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }


    private void showMenu() {

        System.lineSeparator();
        System.out.println("Menu.");

        System.out.println("0. Add new Item");

        System.out.println("1. Show all items");

        System.out.println("2. Edit item");

        System.out.println("3. Delete item");

        System.out.println("4. Find item by Id");

        System.out.println("5. Find items by name");

        System.out.println("6. Exit Program");

    }


    public static void main(String[] args) {

        Input input = new ConsoleInput();

        Tracker tracker = new Tracker();

        new StartUI().init(input , tracker);


    }
}
