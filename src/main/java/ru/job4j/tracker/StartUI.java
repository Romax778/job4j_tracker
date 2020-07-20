package ru.job4j.tracker;



public class StartUI {
   /* public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Replace an Item ====");
        String name = input.askStr("choose id: ");
        Item item = new Item(name);
        tracker.replace(,item);
    }
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.delete(item);
    }*/
    public void init(Input input, Tracker tracker) {

        boolean run = true;
        while (run) {
            this.showMenu();

            System.out.print("\nSelect: ");
            int select = Integer.valueOf(input.askStr("Select"));
            System.out.println("======================================");
            if (select == 0) {
                System.out.print("Create new item");
                String name = input.askStr("Enter name");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i].toString());
                }
            } else if (select == 2) {

                String taskName = input.askStr("Enter task name: ");
                Item[] items = tracker.findByName(taskName);

                if (items.length != 1) {
                    System.out.println("Task with name :" + taskName + " not found");
                } else {

                    String newTaskName = input.askStr("Enter new task name: ");
                    if (tracker.replace(items[0].getId(), new Item(newTaskName))) {
                        System.out.println("Task " + items[0].toString() + " was edited!!!");
                    } else {
                        System.out.println("Problem with task " + items[0].toString() + " editing!!!");
                    }

                }
            } else if (select == 3) {

                String taskName = input.askStr("Enter task name: ");
                Item[] items = tracker.findByName(taskName);

                if (items.length != 1) {
                    System.out.println("Task with name :" + taskName + " not found");
                } else {
                    if (tracker.delete(items[0].getId())) {
                        System.out.println("Task " + items[0].toString() + " was deleted!!!");
                    } else {
                        System.out.println("Problem with task " + items[0].toString() + " deleting!!!");
                    }

                }
            } else if (select == 4) {

                int taskId = Integer.valueOf(input.askStr("Enter task id: "));
                Item item = tracker.findById(taskId);
                if (item != null) {
                    System.out.println("Task found :");
                    System.out.println(item.toString());
                } else {
                    System.out.println("Task with id: " + taskId + " not  found!!!");
                }
            } else if (select == 5) {

                String taskName = input.askStr("Enter task name: ");
                Item[] items = tracker.findByName(taskName);

                if (items.length != 1) {
                    System.out.println("Task with name :" + taskName + " not found");
                } else {
                    for (int i = 0; i < items.length; i++) {
                        System.out.println(items[i].toString());
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("\n\nMenu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput() {
            @Override
            public String askStr(String question) {
                return null;
            }

            @Override
            public int askInt(String question) {
                return 0;
            }
        };
        Tracker tracker = new Tracker();
         /*StartUI.createItem(input,tracker);
         StartUI.replaceItem();
*/
    }
}
