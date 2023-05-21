package mk.ukim.finki.emt.eshop.service;

import mk.ukim.finki.emt.eshop.model.Book;
import mk.ukim.finki.emt.eshop.model.dto.BookDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addBook(BookDto book);

    Book editBook(Long id, BookDto book);

    void deleteBook(Long id);

    void markBookAsTaken(Long id);

    List<Book> getAllBooksByPage(Pageable withPage);
}

