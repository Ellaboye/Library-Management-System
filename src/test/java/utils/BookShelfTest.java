package utils;

import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BookShelfTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Queries map for book")
    void getBook() throws IOException {
        BookShelf bookShelf = new BookShelf();
        assertEquals("Sorry book not Available",bookShelf.getBook("Decagon handbook"));
        assertEquals("8 still available",bookShelf.getBook("the great gatsby"));
    }
}