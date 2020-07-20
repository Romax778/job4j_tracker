package ru.job4j.tracker;



public class StartUI {

    public void init(Input input, Tracker tracker) {
        String msg = "Enter id";
        boolean run = true;
        while (run) {
            this.showMenu();

            System.out.print("\nSelect: ");
            int select = Integer.valueOf(input.askStr(msg));
            System.out.println("======================================");
            if (select == 0) {
                System.out.print("Enter name: ");
                String name = input.askStr(msg);
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i].toString());
                }
            } else if (select == 2) {
                System.out.print("Enter task name: ");
                String taskName = input.askStr(msg);
                Item[] items = tracker.findByName(taskName);

                if (items.length != 1) {
                    System.out.println("Task with name :" + taskName + " not found");
                } else {
                    System.out.print("Enter new task name: ");
                    String newTaskName = input.askStr(msg);
                    if (tracker.replace(items[0].getId(), new Item(newTaskName))) {
                        System.out.println("Task " + items[0].toString() + " was edited!!!");
                    } else {
                        System.out.println("Problem with task " + items[0].toString() + " editing!!!");
                    }

                }
            } else if (select == 3) {
                System.out.print("Enter task name: ");
                String taskName = input.askStr(msg);
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
                System.out.print("Enter task id: ");
                int taskId = Integer.valueOf(input.askStr(msg));
                Item item = tracker.findById(taskId);
                if (item != null) {
                    System.out.println("Task found :");
                    System.out.println(item.toString());
                } else {
                    System.out.println("Task with id: " + taskId + " not  found!!!");
                }
            } else if (select == 5) {
                System.out.print("Enter task name: ");
                String taskName = input.askStr(msg);
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
        new StartUI().init(input, tracker);

    }
}
