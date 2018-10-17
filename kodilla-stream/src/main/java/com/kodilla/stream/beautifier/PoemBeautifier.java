package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void PoemBeautifier(String stringToDecorate, PoemDecorator poemDecorator){
        String stringAfterDecoration;
        stringAfterDecoration = poemDecorator.decorate(stringToDecorate);

        System.out.println("Text after decoration: " + stringAfterDecoration);
    }
}
