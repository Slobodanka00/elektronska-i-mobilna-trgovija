package mk.ukim.finki.emt.eshop.service.impl;

import mk.ukim.finki.emt.eshop.model.Author;
import mk.ukim.finki.emt.eshop.model.Country;
import mk.ukim.finki.emt.eshop.model.dto.AuthorDto;
import mk.ukim.finki.emt.eshop.repository.AuthorRepository;
import mk.ukim.finki.emt.eshop.repository.CountryRepository;
import mk.ukim.finki.emt.eshop.service.AuthorService;
import mk.ukim.finki.emt.eshop.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return this.authorRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Author addAuthor(AuthorDto author) {
        Author author1 = new Author();
        Country country = countryService.getCountryById(author.getCountry());

        System.out.println("Country ID: " + author.getCountry());
        System.out.println("Fetched country: " + country);

        if (country != null) {
            country = countryRepository.getOne(country.getId()); // fetch the managed instance of the Country
            author1.setCountry(country);

        }

        author1.setName(author.getName());
        author1.setSurname(author.getSurname());
        return this.authorRepository.save(author1);
    }

    @Override
    public Author editAuthor(Long id, AuthorDto author) {

        Author author1 = authorRepository.findById(id).orElse(null);
        Country country = countryService.getCountryById(author.getCountry());

        author1.setName(author.getName());
        author1.setSurname(author.getSurname());
        author1.setCountry(country);
        return this.authorRepository.save(author1);
    }

    @Override
    public void deleteAuthor(Long id) {
        this.authorRepository.deleteById(id);

    }
}
