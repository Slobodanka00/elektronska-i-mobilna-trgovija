package mk.ukim.finki.emt.eshop.service;

import mk.ukim.finki.emt.eshop.model.Country;
import mk.ukim.finki.emt.eshop.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> getAllCountries();

    Country getCountryById(Long country);

    Country addCountry(CountryDto country);

    Country editCountry(Long id, CountryDto country);

    void deleteCountry(Long id);
}
