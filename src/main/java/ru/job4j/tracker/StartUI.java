package ru.job4j.tracker;


import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {

        boolean run = true;

        while (run) {

            this.showMenu();


            System.out.println("Select: ");

            int select = Integer.parseInt(scanner.nextLine());

            System.out.println("======================================");

            if (select == 0) {

                System.out.println("Enter name: ");

                String name = scanner.nextLine();

                Item item = new Item(name);

                tracker.add(item);

            } else if (select == 1) {

                Item[] items = tracker.findAll();

                for (int i = 0; i < items.length; i++) {

                    System.out.println(items[i]);

                }

            } else if (select == 2) {

                System.out.print("Enter task id: ");

                int taskId = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter new task name: ");
                String taskName = scanner.nextLine();

                Item some = new Item(taskName);

                if (tracker.replace(taskId, some)) {
                    System.out.println("Task was edited!!");
                } else {
                    System.out.println("Task with id " + taskId + " not found!!");
                }

            } else if (select == 3) {

                System.out.print("Enter task id: ");

                int taskId = scanner.nextInt();

                if (tracker.delete(taskId)) {
                    System.out.println("Task was deleted!!");
                } else {
                    System.out.println("Task with id " + taskId + " not found!!");
                }


            } else if (select == 4) {

                System.out.print("Enter task id: ");

                int taskId = Integer.parseInt(scanner.nextLine());

                Item item = tracker.findById(taskId);

                if (item != null) {

                    System.out.println("Task found :");

                    System.out.println(item);

                } else {

                    System.out.println("Task with id: " + taskId + " not  found!!!");

                }

            } else if (select == 5) {

                System.out.print("Enter task name: ");

                String taskName = scanner.nextLine();

                Item[] items = tracker.findByName(taskName);


                if (items.length == 0) {

                    System.out.println("Task with name :" + taskName + " not found");

                } else {

                    for (int i = 0; i < items.length; i++) {

                        System.out.println(items[i]);

                    }

                }

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

        Scanner scanner = new Scanner(System.in);

        Tracker tracker = new Tracker();

        new StartUI().init(scanner, tracker);


    }
}
