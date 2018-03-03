package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalBeautifier;
import com.kodilla.stream.reference.FunctionalCalculator;
import jdk.nashorn.internal.objects.NativeString;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.YEARS;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Tekst", (text) -> toUpperCase(text));
        poemBeautifier.beautify("Tekst 2", (text) -> text + " ASD");
        poemBeautifier.beautify("UPPER", (text) -> toLowerCase(text) + " asf");


        poemBeautifier.beautify("Alan", FunctionalBeautifier::prefix);
        poemBeautifier.beautify("Iwona", FunctionalBeautifier::suffix);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        People.getList().stream()
                //.map(s -> s.toUpperCase())//lambda to samo co nizej
                //.map(String::toUpperCase)//wskazanie refernecji
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);

/*      BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                    .filter(book -> book.getYearOfPublication() > 2005)
                    .forEach(System.out::println);*/
        //List collector
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());
        System.out.println(("# elements: " + theResultListOfBooks.size()));
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        //Map collectors.toMap()
        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        //Collectors.joinin()
        BookDirectory theBookDirecory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<", ">>"));

        System.out.println(theResultStringOfBooks);

        //ZADANIE 7.3
        Forum forum = new Forum();
        forum.getUserList().stream()
                .filter(user -> user.getGender().equals(ForumUser.Gender.M))
                .filter(user -> LocalDate.now().getYear() - user.getBirthDate().getYear() > 20)
                .filter(user -> user.getNumberOfPosts() > 1)
                .forEach(System.out::println);

        Forum forumMap = new Forum();
        Map<Integer, ForumUser> theResultMapOfUsers = forumMap.getUserList().stream()
                .collect(Collectors.toMap(user -> user.getUniqueId(), user -> user));

        System.out.println("# elements: " + theResultMapOfUsers.size());
        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);


    }
}