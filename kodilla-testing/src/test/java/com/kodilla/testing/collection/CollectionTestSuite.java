package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    private static int test = 1;

    public static ArrayList<Integer> normalArrayListCreator(){
        ArrayList<Integer> normalArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            normalArrayList.add(i);
        }
        return normalArrayList;
    }

    @Before
    public void before() {
        switch (test) {
            case 1:
                System.out.println("Empty ArrayList Test in progress.");
                break;
            case 2:
                System.out.println("Normal ArrayList Test in progress.");
                break;
        }
    }

    @After
    public void after() {
        System.out.println("Test has ended.\n");
    }

    @Test
    //(sprawdzi czy klasa zachowuje się poprawnie gdy lista jest pusta)
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumberExterminator odds = new OddNumberExterminator();
        ArrayList<Integer> emptyArrayList = new ArrayList<>();
        //When
        ArrayList<Integer> result = odds.exterminate(emptyArrayList);
        //Then
        Assert.assertEquals(0, result.size());
        test = 2;
    }

    @Test
    //(sprawdzi czy klasa zachowuje się poprawnie gdy lista zawiera liczby parzyste i nieparzyste)
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumberExterminator odds = new OddNumberExterminator();
        ArrayList<Integer> list = normalArrayListCreator();
        //When
        ArrayList<Integer> result = odds.exterminate(list);
        //Then
        Assert.assertEquals(4, result.size());
    }
}