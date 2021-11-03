package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.LibrarianService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianServiceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Lends book by first come first serve")
    void lendBookByPriority() throws IOException {
        LibrarianService librarianService = new LibrarianService("john", "012");
        assertEquals("book available", librarianService.lendBookFirstComeFirstServe());
    }
    @Test
    @DisplayName("Lends book by priority")
    void lendBookFirstComeFirstServe() throws IOException {
        LibrarianService librarianService = new LibrarianService("peter","042");
        assertEquals("the hobbit", librarianService.lendBookByPriority());
    }
}