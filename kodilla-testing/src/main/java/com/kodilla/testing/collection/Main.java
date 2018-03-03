package com.kodilla.testing.collection;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class RandomStringGenerator {
    //staic pozwala m.in na RandomStringGenerator.rand();

    public static String rand() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (ThreadLocalRandom.current().nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }
}

class Book {

    private final String author;
    private final String title;

    public Book (String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + title.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Title: " + title + " Author: " + author + " Type: ";
    }

    @Override
    public boolean equals(Object obj) {

        if (! (obj instanceof Book)) return false;
        if (obj == this) return true;

        Book Book = (Book) obj;

        return Book.author.equals(author) && Book.title.equals(title);
    }

    public String getAuthor() { return author; }
    public String getTitle() { return title; }
}

public class Main {

    public enum Type {
        Action, Fiction, Sensation, Fantasy
    }

    public static void main(String[] args) {

        List<Book> lista = new LinkedList<Book>();
        for (int i = 0; i < 8000; i++) {
            lista.add(i, new Book(RandomStringGenerator.rand(), RandomStringGenerator.rand()));
        }
        List<Type> types = new LinkedList<Type>();
        for (int i = 0; i < 8000; i++) {
            if (ThreadLocalRandom.current().nextInt(4) == 0) types.add(i, Type.Action);
            else if (ThreadLocalRandom.current().nextInt(4) == 1) types.add(i, Type.Fantasy);
            else if (ThreadLocalRandom.current().nextInt(4) == 2) types.add(i, Type.Fiction);
            else types.add(i, Type.Sensation);
        }

        System.out.println("Adding element at the 0 place of lista");
        long begin = System.currentTimeMillis();
        lista.add(0, new Book(RandomStringGenerator.rand(), RandomStringGenerator.rand()));
        long end = System.currentTimeMillis();
        System.out.println("Adding element has taken: " + (end - begin) + " ms");

        System.out.println("Adding element at the " + lista.size() + " place of lista");
        begin = System.currentTimeMillis();
        lista.add(lista.size(), new Book(RandomStringGenerator.rand(), RandomStringGenerator.rand()));
        end = System.currentTimeMillis();
        System.out.println("Adding element has taken: " + (end - begin) + " ms\n");

        HashMap<Book, Type> books = new HashMap<>();

        int entrys = 8000;
        System.out.println("Trying to create " + entrys + " entrys");
        begin = System.currentTimeMillis();
        for (int i = 0; i < entrys; i++) {
            books.put(lista.get(i), types.get(i));
        }

        end = System.currentTimeMillis();
        System.out.println("Created: " + books.size() + " unique entrys");
        System.out.println("Creating has taken: " + (end - begin) + " ms\n");

        System.out.println("Adding new entry");
        //dodanie do LinkedList lista
        //lista.add(new Book("Metro 2033", "Dmitrij Głuchowski"));
        begin = System.currentTimeMillis();
        //dodanie do HashMapy books
        books.put(new Book ("Metro 2033", "Dmitrij Gluchowski"), Type.Fiction);
        end = System.currentTimeMillis();
        System.out.println("Adding a new entry has taken: " + (end - begin) + " ms");

        System.out.println("Searching at HashMap");
        String searching = "Metro 2033";
        begin = System.currentTimeMillis();
/*        //to wyszukiwanie po linkedlisc "lista
        for (int i = 0; i < lista.size(); i++) {
            Book buffor = lista.get(i);
            if (lista.get(i).getAuthor().equals(searching)) {
                System.out.println(searching + " is an " + books.get(buffor) + " type book.");
            }
        }
*/
        //Wyszukiwanie autora i tytulu po kluczu. Jezeli nie ma takiego w mapie zwroci wartosc null (Wartosc)
        System.out.println(searching + " is an " + books.get(new Book ("Metro 2033", "Dmitrij Gluchowski")) + " type of book");
        end = System.currentTimeMillis();
        System.out.println("Searching has taken: " + (end - begin) + " ms");
    }
}
