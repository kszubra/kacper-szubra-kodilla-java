package com.kodilla.exception.test2;

public class ExceptionHandling {
    public static void main(String[] args) {

        SecondChallenge sc = new SecondChallenge();

        try{

            String test = sc.probablyIWillThrowException(2.0, 3.0);
            System.out.println(test);

        }catch(Exception e){
            System.out.println("Exception: variables satisfied the condition (x >= 2 || x < 1 || y == 1.5) ");
        }finally{

            System.out.println("Finally");
        }

    }
}
