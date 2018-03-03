package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;
import com.kodilla.exception.test.ExceptionHandling;
import com.kodilla.exception.test.SecondChallenge;

public class ExceptionModuleRunner {

    public static void main(String args[]) {

/*        FileReader fileReader = new FileReader();
        fileReader.readFile();*/

        /*FileReaderWithoutHandling fileReader1 = new FileReaderWithoutHandling();
        fileReader.readFile1();*/

        FileReader fileReader = new FileReader();

        ExceptionHandling eh = new ExceptionHandling();

        try {
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.println("Problem while reading a file");
        }
    }
}
