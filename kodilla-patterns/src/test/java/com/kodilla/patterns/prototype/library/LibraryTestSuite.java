package com.kodilla.patterns.prototype.library;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Biblioteka 1");
        Book book1 = new Book("Metro2033", "Dmitrij Głuchowski", LocalDate.now());
        Book book2 = new Book("Krzyżacy", "Henryk Sienkiewizc", LocalDate.now());
        Book book3 = new Book("Złodziejka książek", "Markus Zusak ", LocalDate.now());
        library.books.add(book1);
        library.books.add(book2);
        library.books.add(book3);

        System.out.println(library);

        Library shallowLibraryClone = null;

        try {
            shallowLibraryClone = library.shallowCopy();
            shallowLibraryClone.setName("Shallow copy of Library Object.");

        } catch (CloneNotSupportedException e) {

            System.out.println(e);
        }
        System.out.println(shallowLibraryClone);

        Library deepLibraryClone = null;

        try {

            deepLibraryClone = library.deepCopy();
            deepLibraryClone.setName("Deep copy of Library Object.");

        } catch (CloneNotSupportedException e) {

            System.out.println(e);
        }

        System.out.println(deepLibraryClone);

        //When
        library.books.remove(book1);
        library.books.remove(book2);

        //Then
        System.out.println("\nRemoving 2 positions from library Object and sout Object library and its shallowCopy and deepCopy.\n");
        System.out.println(library);
        System.out.println(shallowLibraryClone);
        System.out.println(deepLibraryClone);
        assertThat(library.getBooks().size()).isEqualTo(1);
        assertThat(shallowLibraryClone.getBooks().size()).isEqualTo(1);
        assertThat(deepLibraryClone.getBooks().size()).isEqualTo(3);
    }
}
