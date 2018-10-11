package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;
import java.util.*;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Testing new case:");
    }

    @After
    public void after(){
        System.out.println("Test finished");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        ArrayList<Integer> startList = new ArrayList<Integer>();
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //When
        List<Integer> result = exterminator.exterminate(startList);
        System.out.print(" input list is empty \r\n");
        //Then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer> startList = new ArrayList<Integer>();
        for (int i = 1; i<11; i++){
            startList.add(i);
        }
        List<Integer> listWithoutOdd = new ArrayList<Integer>();
        listWithoutOdd.add(2);
        listWithoutOdd.add(4);
        listWithoutOdd.add(6);
        listWithoutOdd.add(8);
        listWithoutOdd.add(10);
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //When
        List<Integer> result = exterminator.exterminate(startList);
        System.out.print(" input list is has various elements \r\n");
        //Then
        Assert.assertEquals(listWithoutOdd, result);
    }

}
