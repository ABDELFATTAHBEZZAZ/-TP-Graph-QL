package com.example.springboot_graphql_produit.demo.repository;

import com.example.springboot_graphql_produit.demo.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}

