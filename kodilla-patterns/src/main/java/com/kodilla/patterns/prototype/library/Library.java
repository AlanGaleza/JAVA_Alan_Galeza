package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library>{
    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Library name: '" + name + '\''+
                "\nBooks available: " + books + "\n";
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library libraryClone = super.clone();
        libraryClone.books = new HashSet<>();
        for(Book theBooks: books) {
            Book clonedBook = new Book(theBooks.getTitle(), theBooks.getAuthor(), theBooks.getPublicationDate());
            libraryClone.getBooks().add(clonedBook);
        }
        return libraryClone;
    }
}