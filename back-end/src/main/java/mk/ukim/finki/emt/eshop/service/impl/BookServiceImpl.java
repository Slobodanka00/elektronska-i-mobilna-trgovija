package mk.ukim.finki.emt.eshop.service.impl;

import mk.ukim.finki.emt.eshop.model.Author;
import mk.ukim.finki.emt.eshop.model.Book;
import mk.ukim.finki.emt.eshop.model.dto.BookDto;
import mk.ukim.finki.emt.eshop.repository.BookRepository;
import mk.ukim.finki.emt.eshop.service.AuthorService;
import mk.ukim.finki.emt.eshop.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }


    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return this.bookRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Book addBook(BookDto book) {
        Author author = authorService.getAuthorById(book.getAuthor());
        Book book1 = new Book();

        book1.setName(book.getName());
        book1.setCategory(book.getCategory());
        book1.setAuthor(author);
        book1.setAvailableCopies(book.getAvailableCopies());

        return this.bookRepository.save(book1);
    }

    @Override
    public Book editBook(Long id, BookDto book) {
        Book book1 = bookRepository.findById(id)
                .orElse(null);

        Author author = authorService.getAuthorById(book.getAuthor());
        assert book1 != null;
        book1.setName(book.getName());
        book1.setCategory(book.getCategory());
        book1.setAuthor(author);
        book1.setAvailableCopies(book.getAvailableCopies());

        return this.bookRepository.save(book1);
    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);

    }

    @Override
    public void markBookAsTaken(Long id) {
        Book book1 = bookRepository.findById(id)
                .orElse(null);

        assert book1 != null;
        book1.setAvailableCopies(book1.getAvailableCopies() - 1);

        bookRepository.save(book1);

    }

    @Override
    public List<Book> getAllBooksByPage(Pageable withPage) {
        return this.bookRepository.findAll(withPage).getContent();
    }
}
