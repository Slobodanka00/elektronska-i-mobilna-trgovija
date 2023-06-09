package mk.ukim.finki.emt.eshop.web.rest;

import mk.ukim.finki.emt.eshop.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryRestController {
    @GetMapping("/list")
    public List<Category> getAllCategories() {
        return Arrays.asList(Category.values());
    }
}