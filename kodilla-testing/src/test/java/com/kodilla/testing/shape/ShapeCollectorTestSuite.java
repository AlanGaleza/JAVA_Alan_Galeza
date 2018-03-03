package com.kodilla.testing.shape;

import org.junit.*;
import static org.junit.Assert.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This is the beginning of tests.");
    }

    @Before
    public void before() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @After
    public void after() {
        System.out.println("Test #" + testCounter + " has ended");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("All tests are finished.");
    }

    @Test
    public void addShapeToArrayListTest(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Square(20);
        //When
        shapeCollector.addShapeToArrayList(shape);
        //Then
        assertEquals("Square", shape.getShapeName());
        assertEquals(400, shape.getField(), 1);
        assertEquals(1, shapeCollector.getListSize());
    }

    @Test
    public void removeShapeFromArrayListTest() {
        //Given
        Shape shape = new Circle(30);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addShapeToArrayList(shape);
        int positionNumber = 0;
        //When
        Shape result1 = shapeCollector.getShapeFromArrayList(positionNumber);
        boolean result = shapeCollector.removeShapeFromArrayList(shape);
        //Then
        assertEquals(shape, result1);
        assertTrue(result);
        assertEquals(0, shapeCollector.getListSize());
    }

    @Test
    public void removeNonExistingShapeFromArrayListTest(){
        //Given
        Shape shape = new Triangle(40, 20);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addShapeToArrayList(new Circle(50));
        //When
        boolean result = shapeCollector.removeShapeFromArrayList(shape);
        //Then
        assertFalse(result);
    }

    @Test
    public void getShapeFromArrayListTest() {
        //Given
        Shape shape = new Triangle(40, 20);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addShapeToArrayList(shape);
        //When
        Shape result = shapeCollector.getShapeFromArrayList(0);
        //Then
        assertEquals("Triangle", shape.getShapeName());
        assertEquals(400, shape.getField(), 1);
        assertEquals(shape, result);
    }
}
