spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

        package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Column(nullable = false)
    private String category;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt = LocalDate.now();

    // Getters and Setters
}

package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private String username;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "birth_year", nullable = false)
    private Integer birthYear;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Double balance = 1000.0;

    // Getters and Setters
}

@Query("SELECT p FROM Product p WHERE p.price > :price")
List<Product> findByPriceGreaterThan(@Param("price") double price);

@Query("SELECT p FROM Product p WHERE p.category = :category")
List<Product> findByCategory(@Param("category") String category);

@Query("SELECT p FROM Product p WHERE p.stockQuantity < :quantity")
List<Product> findLowStock(@Param("quantity") int quantity);

@Query("SELECT c FROM Customer c WHERE c.city = :city")
List<Customer> findByCity(@Param("city") String city);

@Query("SELECT c FROM Customer c WHERE c.balance >= :amount")
List<Customer> findByMinBalance(@Param("amount") double amount);

@Query("SELECT c FROM Customer c WHERE c.birthYear < :year")
List<Customer> findOlderThan(@Param("year") int year);