package com.kodilla.testing.shape;

import org.junit.*;
import com.kodilla.testing.shape.Shape;
import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.ShapeCollector;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;


    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector testShapeCollector = new ShapeCollector();
        Triangle triangle1 = new Triangle(5,6);
        //When
        testShapeCollector.addFigure(triangle1);
        //Then
        Assert.assertEquals(1, testShapeCollector.getShapesAmount());

    }

    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector testShapeCollector = new ShapeCollector();
        Circle circle1 = new Circle(4);
        testShapeCollector.addFigure(circle1);
        //When
        testShapeCollector.removeFigure(circle1);
        //Then
        Assert.assertEquals(0, testShapeCollector.getShapesAmount());

    }

    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector testShapeCollector = new ShapeCollector();
        Square square1 = new Square(5);
        testShapeCollector.addFigure(square1);
        //When
        //Then
        Assert.assertEquals(square1, testShapeCollector.getFigure(0));

    }
}
