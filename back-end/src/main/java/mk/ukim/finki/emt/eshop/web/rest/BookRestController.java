package mk.ukim.finki.emt.eshop.web.rest;


import mk.ukim.finki.emt.eshop.model.Book;
import mk.ukim.finki.emt.eshop.model.dto.BookDto;
import mk.ukim.finki.emt.eshop.service.BookService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/list/page/{page}")
    public List<Book> getAllBooksByPage(@PathVariable int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return bookService.getAllBooksByPage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book1 = bookService.getBookById(id);

        if (book1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(book1);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody BookDto book) {
        Book book1 = bookService.addBook(book);

        if (book1 == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(book1);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto book) {
        Book book1 = bookService.editBook(id, book);

        if (book1 == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(book1);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.deleteBook(id);
            return ResponseEntity.ok(book);
        }
    }

    @PutMapping("/mark/{id}")
    public ResponseEntity<Book> markBookAsTaken(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            bookService.markBookAsTaken(id);
            return ResponseEntity.ok(book);
        }
    }



}
