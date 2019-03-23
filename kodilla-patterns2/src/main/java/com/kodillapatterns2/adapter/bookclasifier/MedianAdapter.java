package com.kodillapatterns2.adapter.bookclasifier;

import com.kodillapatterns2.adapter.bookclasifier.libraryA.Book;
import com.kodillapatterns2.adapter.bookclasifier.libraryA.Classifier;
import com.kodillapatterns2.adapter.bookclasifier.libraryB.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodillapatterns2.adapter.bookclasifier.libraryB.Book> bookMap = new HashMap<>();

        for(Book book : bookSet) {
            BookSignature signature = new BookSignature(book.getSignature());

            String title = book.getTitle();
            String author = book.getAuthor();
            int yearOfPublication = book.getPublicationYear();
            com.kodillapatterns2.adapter.bookclasifier.libraryB.Book bookB = new com.kodillapatterns2.adapter.bookclasifier.libraryB.Book(author, title, yearOfPublication);

            bookMap.put(signature, bookB);
        }

        return medianPublicationYear(bookMap);

    }
}
