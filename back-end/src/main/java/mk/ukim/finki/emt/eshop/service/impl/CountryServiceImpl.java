package mk.ukim.finki.emt.eshop.service.impl;

import mk.ukim.finki.emt.eshop.model.Country;
import mk.ukim.finki.emt.eshop.model.dto.CountryDto;
import mk.ukim.finki.emt.eshop.repository.CountryRepository;
import mk.ukim.finki.emt.eshop.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> getAllCountries() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long country) {
        return this.countryRepository.findById(country)
                .orElse(null);
    }

    @Override
    public Country addCountry(CountryDto country) {
        Country country1 = new Country();

        country1.setName(country.getName());
        country1.setContinent(country.getContinent());

        return countryRepository.save(country1);
    }

    @Override
    public Country editCountry(Long id, CountryDto country) {

        Country country1 = countryRepository.findById(id)
                .orElse(null);

        assert country1 != null;
        country1.setName(country.getName());
        country1.setContinent(country.getContinent());

        return countryRepository.save(country1);
    }

    @Override
    public void deleteCountry(Long id) {
        this.countryRepository.deleteById(id);

    }
}
