package com.order.restaurant.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restro")
public class Menu {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Category")
    private String category;

    @Column(name = "Subcategory")
    private String subcategory;

    @Column(name = "Rating")
    private float rating;

    @Column(name = "Image")
    private String image;

    @Column(name = "Price")
    private int price;

    @OneToOne(mappedBy = "menuItem",cascade = CascadeType.ALL)
    private OrderItem orderItem;

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
                + ", subcategory=" + subcategory + ", rating=" + rating + ", image=" + image + ", price=" + price + "]";
    }

    public Menu(int id, String name, String description, String category, String subcategory, float rating,
            String image, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.subcategory = subcategory;
        this.rating = rating;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
