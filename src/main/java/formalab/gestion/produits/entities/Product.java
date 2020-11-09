package formalab.gestion.produits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {

    // annotation pour ne pas afficher cette attribut dans le resultat json
    // @JsonIgnore
    // @Id : pour dire que cet attribut est le primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // pour changer le nom de la column
    // @Column(name = "name")
    @NotNull(message = "name is required")
    @Size(min = 3, message = "name must be at least 3 characters long")
    private String name;
    @NotNull(message = "description is required")
    private String description;
    @NotNull(message = "price is required")
    private Double price;

    @Column(name = "category_id")
    @JsonProperty("category_id")
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;

    public Category getCategory() {
        return category;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // il faut un constructeur par defaut pour pouvoir envoyer l objet en RequestBody
    public Product() {
    }

    public Product(String name, String description, Double price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
