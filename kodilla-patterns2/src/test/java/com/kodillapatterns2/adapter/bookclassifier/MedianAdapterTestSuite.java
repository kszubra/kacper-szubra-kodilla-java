package com.kodillapatterns2.adapter.bookclassifier;

import com.kodillapatterns2.adapter.bookclasifier.MedianAdapter;
import com.kodillapatterns2.adapter.bookclasifier.libraryA.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void testMedianAdapterPublicationYearOddAmount() {
        //Given
        MedianAdapter adapter = new MedianAdapter();
        Book bookA1 = new Book("abc", "title", 1990, "blabla");
        Book bookA2 = new Book("abc", "title", 2010, "blabla");
        Book bookA3 = new Book("abc", "title", 1957, "blabla");
        Book bookA4 = new Book("abc", "title", 2012, "blabla");
        Book bookA5 = new Book("abc", "title", 1987, "blabla");

        Set<Book> bookASet = new HashSet<>();
        bookASet.add(bookA1);
        bookASet.add(bookA2);
        bookASet.add(bookA3);
        bookASet.add(bookA4);
        bookASet.add(bookA5);

        //When
        int result = adapter.publicationYearMedian(bookASet);

        //Then
        Assert.assertEquals(1990, result);
    }

    @Test
    public void testMedianAdapterPublicationYearEvenAmount() {
        //Given
        MedianAdapter adapter = new MedianAdapter();
        Book bookA1 = new Book("abc", "title", 1990, "blabla");
        Book bookA2 = new Book("abc", "title", 2010, "blabla");
        Book bookA3 = new Book("abc", "title", 1957, "blabla");
        Book bookA4 = new Book("abc", "title", 2012, "blabla");

        Set<Book> bookASet = new HashSet<>();
        bookASet.add(bookA1);
        bookASet.add(bookA2);
        bookASet.add(bookA3);
        bookASet.add(bookA4);

        //When
        int result = adapter.publicationYearMedian(bookASet);

        //Then
        Assert.assertEquals(2000, result);
    }
}
