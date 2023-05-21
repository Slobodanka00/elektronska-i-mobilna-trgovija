package mk.ukim.finki.emt.eshop.web.rest;

import mk.ukim.finki.emt.eshop.model.Country;
import mk.ukim.finki.emt.eshop.model.dto.CountryDto;
import mk.ukim.finki.emt.eshop.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/list")
    public List<Country> getAllCountries() {
        return this.countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Country country1 = countryService.getCountryById(id);

        if (country1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(country1);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody CountryDto country) {
        Country country1 = countryService.addCountry(country);

        if (country1 == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(country1);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable Long id, @RequestBody CountryDto country) {
        Country country1 = countryService.editCountry(id, country);

        if (country1 == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(country1);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id) {
        Country country1 = countryService.getCountryById(id);

        if (country1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            countryService.deleteCountry(id);
            return ResponseEntity.ok().build();
        }
    }


}
