package formalab.gestion.produits.services;

import formalab.gestion.produits.entities.Category;
import formalab.gestion.produits.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public void save(Category category) {
         categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public void update(Category category) {
        categoryRepository.save(category);
    }

    public void findByName(String name) {
        categoryRepository.findByName(name);
    }
}
