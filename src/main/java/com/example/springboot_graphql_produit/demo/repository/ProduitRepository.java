package com.example.springboot_graphql_produit.demo.repository;

import com.example.springboot_graphql_produit.demo.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
