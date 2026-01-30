package utils;

import model.BookBase;

import java.util.List;

public class SortingUtils {

    public static void sortBooksByTitle(List<BookBase> books) {
        books.sort((b1, b2) ->
                b1.getTitle().compareToIgnoreCase(b2.getTitle())
        );
    }
}
