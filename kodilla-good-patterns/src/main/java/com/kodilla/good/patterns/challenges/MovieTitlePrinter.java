package com.kodilla.good.patterns.challenges;

public class MovieTitlePrinter {

    public static void main(String args[]) {

        MovieStore movieStore = new MovieStore();

        movieStore.getMovies().values().stream()
                .flatMap(n -> n.stream())
                .map(n -> n + " ! ")
                .forEach(System.out::print);
    }
}
