package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    public List<Integer> exterminate(ArrayList<Integer> numbers){

        List<Integer> listWithoutOdd = new ArrayList<Integer>();

        for (Integer i : numbers){
            if(i%2 == 0){
                listWithoutOdd.add(i);
            }
        }
        return listWithoutOdd;
    }
}
