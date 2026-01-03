# GraphQL Demo Project

## Overview

This project is a simple GraphQL API built with **Spring Boot**, **GraphQL**, and **MySQL**.
It manages two entities: `Produit` and `Categorie`, with full CRUD operations.

## Technologies

* Java / Spring Boot
* Spring Data JPA
* GraphQL Java Tools
* MySQL

## Setup

1. Create a MySQL database:

   ```sql
   CREATE DATABASE graphql_db;
   
2. Update `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/graphql_db?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
  
3. Run the project:

   ```bash
   mvn spring-boot:run


## Access GraphiQL

Open [http://localhost:8080/graphiql](http://localhost:8080/graphiql)

## Example Mutation

```graphql
mutation {
  ajouterCategorie(input: { nom: "Informatique" }) {
    id
    nom
  }
}



