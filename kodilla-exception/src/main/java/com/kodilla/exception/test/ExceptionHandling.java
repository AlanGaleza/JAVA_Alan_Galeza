package com.kodilla.exception.test;

public class ExceptionHandling  {

    public static void main(String args[]) throws java.lang.Throwable {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {

            System.out.println(secondChallenge.probablyIWillThrowException(2.0, 1.5));

        } catch (Exception e) {

            System.out.println("Something went wrong. Error: " + e);

        } finally {

            System.out.println("Finally block");

        }
    }


}
