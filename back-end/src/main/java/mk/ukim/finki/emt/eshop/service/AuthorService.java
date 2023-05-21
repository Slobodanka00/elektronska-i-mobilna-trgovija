package mk.ukim.finki.emt.eshop.service;

import mk.ukim.finki.emt.eshop.model.Author;
import mk.ukim.finki.emt.eshop.model.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    Author addAuthor(AuthorDto author);

    Author editAuthor(Long id, AuthorDto author);

    void deleteAuthor(Long id);
}
