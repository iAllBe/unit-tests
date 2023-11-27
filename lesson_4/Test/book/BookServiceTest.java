package book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {

    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testFindBookById() {
        String expectedId = "123";
        Book expectedBook = new Book(expectedId);
        when(bookRepository.findById(expectedId)).thenReturn(expectedBook);

        Book actualBook = bookService.findBookById(expectedId);

        // Проверяем, что метод findById был вызван с ожидаемым аргументом
        verify(bookRepository).findById(expectedId);

        // Проверяем, что возвращенная книга соответствует ожидаемой книге
        assertEquals(expectedBook, actualBook);
    }

    @Test
    void testFindAllBooks() {
        List<Book> expectedBooks = Arrays.asList(
                new Book("1", "Book 1", "Name 1"),
                new Book("2", "Book 2", "Name 2")
        );
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Вызываем метод, который должен использовать bookRepository
        List<Book> actualBooks = bookService.findAllBooks();

        // Проверяем, что метод findAll был вызван
        verify(bookRepository).findAll();

        // Проверяем, что возвращенный список соответствует ожидаемому списку
        assertEquals(expectedBooks, actualBooks);
    }

}


