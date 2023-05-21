package mk.ukim.finki.emt.eshop.web.rest;


import mk.ukim.finki.emt.eshop.model.Author;
import mk.ukim.finki.emt.eshop.model.dto.AuthorDto;
import mk.ukim.finki.emt.eshop.service.AuthorService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;


    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public List<Author> listAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author1 = authorService.getAuthorById(id);

        if (author1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(author1);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody AuthorDto author) {
        Author author1 = authorService.addAuthor(author);

        if (author1 == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(author1);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> editAuthor(@PathVariable Long id, @RequestBody AuthorDto author) {
        Author author1 = authorService.editAuthor(id, author);

        if (author1 == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(author1);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
        Author author1 = authorService.getAuthorById(id);

        if (author1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            authorService.deleteAuthor(id);
            return ResponseEntity.ok(author1);
        }
    }
}
