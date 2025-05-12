package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        products.add(product);
        return "Product added!";
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        if (id >= 0 && id < products.size()) {
            products.set(id, updatedProduct);
            return "Product updated!";
        }
        return "Product not found!";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        if (id >= 0 && id < products.size()) {
            products.remove(id);
            return "Product deleted!";
        }
        return "Product not found!";
    }
}package com.example.demo.model;

public class Product {
    private String name;
    private double price;
    private String description;

    public Product() {}

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
        package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}