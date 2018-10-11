package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;
import java.util.*;

public class CollectionTestSuite {
    OddNumbersExterminator exterminator = new OddNumbersExterminator();

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
        List<Integer> listWithoutOdd = Arrays.asList(2,4,6,8,10);
        //When
        List<Integer> result = exterminator.exterminate(startList);
        System.out.print(" input list has various elements \r\n");
        //Then
        Assert.assertEquals(listWithoutOdd, result);
    }

}
