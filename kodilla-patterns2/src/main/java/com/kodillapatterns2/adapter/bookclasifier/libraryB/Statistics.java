package com.kodillapatterns2.adapter.bookclasifier.libraryB;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Statistics implements BookStatistics {
    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        if(books.size() == 0) {return 0;}
        int sum = 0;
        for(Map.Entry<BookSignature, Book> entry : books.entrySet()) {
            sum += entry.getValue().getYearOfPublication();
        }
        return sum/books.size();
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        if(books.size() == 0) {return 0;}

        /** WEDLE POLECENIA
         *
         *         int[]years = new int[books.size()];
         *         int n = 0;
         *         for(Map.Entry<BookSignature, Book> entry : books.entrySet()) {
         *             years[n] = entry.getValue().getYearOfPublication();
         *             n++;
         *         }
         *         Arrays.sort(years);
         *         if(years.length % 2 == 0) {
         *             return years[(int)(years.length / 2 + 0.5)];
         *         } else {
         *             return years[years.length/2];
         *         }
         */

        /** BEZ MODYFIKOWANIA OBIEKTU
         *
         *         int bookCount = books.size();
         *         IntStream sortedYears = books.values().stream()
         *                                         .mapToInt(Book::getYearOfPublication)
         *                                         .sorted();
         *
         *         int median = bookCount%2 == 0?
         *                 (int)sortedYears.skip(bookCount/2-1).limit(2).average().getAsDouble():
         *                 sortedYears.skip(bookCount/2).findFirst().getAsInt();
         *
         *         return median;
         */

        /**
         * MODYFIKUJĄC OBIEKT
         */

        List<Book> bookList = books.values().stream().collect(Collectors.toList());
        bookList.sort(Comparator.comparingInt(Book::getYearOfPublication));
        int median = bookList.get(bookList.size()/2).getYearOfPublication();
        if(bookList.size()%2 == 0) median = (median + bookList.get(bookList.size()/2-1).getYearOfPublication()) / 2;

        return median;





    }
}
