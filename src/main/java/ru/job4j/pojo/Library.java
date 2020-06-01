package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Clean  Code", 455);
        Book book2 = new Book("Effective Java", 355);
        Book book3 = new Book("Core Java", 555);
        Book book4 = new Book("Algorithms in  Java", 395);

        Book[] books = new Book[4];

        books[0] = book;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;




        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
        }
        System.out.println();
        System.out.println(" swap book 1 and book 4");
        System.out.println();
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];

            System.out.println(bk.getName() + " - " + bk.getNumberOfPages());
        }
        System.out.println();

        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if (bk == books[3]) {


                System.out.println(bk.getName());


            }
        }
    }
}


