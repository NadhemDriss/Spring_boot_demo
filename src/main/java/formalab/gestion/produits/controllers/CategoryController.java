package formalab.gestion.produits.controllers;

import formalab.gestion.produits.entities.Category;
import formalab.gestion.produits.entities.Product;
import formalab.gestion.produits.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"","/"})
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoriesList = categoryService.findAll();
        return new ResponseEntity<>(categoriesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/{id}/products")
    public List<Product> getCategoryProducts(@PathVariable Long id) {
        List<Product> products = categoryService.findById(id).getProducts();
        return products;
    }

    @PostMapping(value = {"","/"})
    public Category createNewCategory(@RequestBody Category category) {
        categoryService.save(category);
        return category;
    }

    @PutMapping(value = {"","/"})
    public Category updateCategory(@RequestBody Category category) {
        categoryService.update(category);
        return category;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(Long id) {
        categoryService.delete(id);
    }

    @GetMapping("/{name}")
    public void findByName(@PathVariable  String name) {
        categoryService.findByName(name);
    }
}
