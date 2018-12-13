package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    private Library primalLibrary;
    private Book book1 = new Book("Wiedźmin", "Andrzej Sapkowski", LocalDate.of(1992, 3, 12));
    private Book book2 = new Book("Władca Pierścieni", "J.R.R. Tolkien", LocalDate.of(1987, 1, 21));
    private Book book3 = new Book("Eragon", "Christopher Paolini", LocalDate.of(2002, 7, 14));
    private Book book4 = new Book("Narodziny Hordy", "Christie Golden", LocalDate.of(2017, 8, 5));

    @Before
    public void prepareLibraryForTest() {
        primalLibrary = new Library("Pierwotna");
        primalLibrary.getBooks().add(book1);
        primalLibrary.getBooks().add(book2);
        primalLibrary.getBooks().add(book3);
        primalLibrary.getBooks().add(book4);
    }

    @Test
    public void testGetBooksByShallowCopy() {
        //Given
        Library shallowCopiedLibrary = null;
        try {
            shallowCopiedLibrary = primalLibrary.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        shallowCopiedLibrary.setName("Płytko skopiowana");

        //When
        primalLibrary.getBooks().remove(book1);
        int bookNumberInPrimal = primalLibrary.getBooks().size();
        int bookNumberInCopied = shallowCopiedLibrary.getBooks().size();

        //Then
        System.out.println(primalLibrary.toString());
        System.out.println(shallowCopiedLibrary.toString());
        Assert.assertEquals(3, bookNumberInPrimal);
        Assert.assertEquals(3, bookNumberInCopied);
    }

    @Test
    public void testGetBooksByDeepCopy() {
        //Given
        Library deepCopiedLibrary = null;
        try {
            deepCopiedLibrary = primalLibrary.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        deepCopiedLibrary.setName("Głęboko skopiowana");

        //When
        primalLibrary.getBooks().remove(book1);
        int bookNumberInPrimal = primalLibrary.getBooks().size();
        int bookNumberInCopied = deepCopiedLibrary.getBooks().size();

        //Then
        System.out.println(primalLibrary.toString());
        System.out.println(deepCopiedLibrary.toString());
        Assert.assertEquals(3, bookNumberInPrimal);
        Assert.assertEquals(4, bookNumberInCopied);
    }





}
