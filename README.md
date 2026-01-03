# 🚀 Spring Boot GraphQL Demo - Gestion de Produits et Catégories

Une application GraphQL moderne construite avec **Spring Boot 3.5.7** pour la gestion de produits et catégories avec des opérations CRUD complètes.

## 📋 Table des matières

- [Aperçu](#aperçu)
- [Fonctionnalités](#fonctionnalités)
- [Technologies utilisées](#technologies-utilisées)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Configuration](#configuration)
- [Utilisation](#utilisation)
- [Exemples de requêtes GraphQL](#exemples-de-requêtes-graphql)
- [Structure du projet](#structure-du-projet)
- [API Endpoints](#api-endpoints)

## 🎯 Aperçu

Ce projet démontre l'implémentation d'une API GraphQL avec Spring Boot pour gérer un système de produits et catégories. Il utilise GraphQL pour offrir une interface flexible et efficace permettant aux clients de récupérer exactement les données dont ils ont besoin.

### Caractéristiques principales

- ✅ API GraphQL complète avec queries et mutations
- ✅ Gestion des relations entre Produits et Catégories
- ✅ Interface GraphiQL intégrée pour tester l'API
- ✅ Persistance des données avec JPA/Hibernate
- ✅ Base de données MySQL
- ✅ Architecture propre avec séparation des responsabilités

## 🎨 Fonctionnalités

### Entités

- **Produit** : Gestion des produits avec nom, prix et catégorie associée
- **Categorie** : Gestion des catégories avec leurs produits associés

### Opérations disponibles

**Queries (Lecture)**
- Récupérer tous les produits
- Récupérer un produit par ID
- Récupérer toutes les catégories
- Récupérer une catégorie par ID avec ses produits

**Mutations (Écriture)**
- Ajouter un produit
- Modifier un produit
- Supprimer un produit
- Ajouter une catégorie
- Supprimer une catégorie

## 🛠 Technologies utilisées

- **Java 17** - Langage de programmation
- **Spring Boot 3.5.7** - Framework principal
- **Spring GraphQL** - Support GraphQL natif
- **Spring Data JPA** - Abstraction de la couche de données
- **Hibernate** - ORM (Object-Relational Mapping)
- **MySQL** - Base de données relationnelle
- **Maven** - Gestionnaire de dépendances
- **GraphiQL** - Interface interactive pour GraphQL

## 📦 Prérequis

Avant de commencer, assurez-vous d'avoir installé :

- **Java 17** ou supérieur
- **Maven 3.6+**
- **MySQL 8.0+** ou supérieur
- Un IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

## 🔧 Installation

### 1. Cloner le dépôt

```bash
git clone https://github.com/ABDELFATTAHBEZZAZ/-TP-Graph-QL.git
cd -TP-Graph-QL
```

### 2. Créer la base de données MySQL

Connectez-vous à MySQL et exécutez :

```sql
CREATE DATABASE graphql_db;
```

### 3. Configurer la base de données

Modifiez le fichier `src/main/resources/application.properties` avec vos paramètres MySQL :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/graphql_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=votre_username
spring.datasource.password=votre_password
```

### 4. Lancer l'application

```bash
mvn spring-boot:run
```

Ou si vous utilisez un IDE, lancez la classe `DemoApplication.java`.

L'application sera accessible sur : **http://localhost:8080**

## ⚙️ Configuration

### Fichier `application.properties`

```properties
# Application
spring.application.name=demo
server.port=8080

# Base de données MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/graphql_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# GraphQL
spring.graphql.graphiql.enabled=true
```

## 🚀 Utilisation

### Accéder à GraphiQL

Une fois l'application démarrée, ouvrez votre navigateur et accédez à :

**http://localhost:8080/graphiql**

GraphiQL est une interface graphique interactive qui vous permet de :
- Explorer le schéma GraphQL
- Tester vos requêtes et mutations
- Voir la documentation automatique

## 📝 Exemples de requêtes GraphQL

### Queries (Lecture)

#### Récupérer tous les produits

```graphql
query {
  produits {
    id
    nom
    prix
    categorie {
      id
      nom
    }
  }
}
```

#### Récupérer un produit par ID

```graphql
query {
  produit(id: 1) {
    id
    nom
    prix
    categorie {
      id
      nom
    }
  }
}
```

#### Récupérer toutes les catégories avec leurs produits

```graphql
query {
  categories {
    id
    nom
    produits {
      id
      nom
      prix
    }
  }
}
```

#### Récupérer une catégorie par ID

```graphql
query {
  categorie(id: 1) {
    id
    nom
    produits {
      id
      nom
      prix
    }
  }
}
```

### Mutations (Écriture)

#### Ajouter une catégorie

```graphql
mutation {
  ajouterCategorie(input: { nom: "Informatique" }) {
    id
    nom
  }
}
```

#### Ajouter un produit

```graphql
mutation {
  ajouterProduit(input: {
    nom: "Laptop Dell"
    prix: 1299.99
    categorieId: 1
  }) {
    id
    nom
    prix
    categorie {
      id
      nom
    }
  }
}
```

#### Modifier un produit

```graphql
mutation {
  modifierProduit(
    id: 1
    input: {
      nom: "Laptop Dell XPS"
      prix: 1499.99
      categorieId: 1
    }
  ) {
    id
    nom
    prix
  }
}
```

#### Supprimer un produit

```graphql
mutation {
  supprimerProduit(id: 1)
}
```

#### Supprimer une catégorie

```graphql
mutation {
  supprimerCategorie(id: 1)
}
```

## 📁 Structure du projet

```
spring-graphql-demo-main/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/springboot_graphql_produit/demo/
│   │   │       ├── DemoApplication.java          # Point d'entrée
│   │   │       ├── controller/                    # Contrôleurs GraphQL
│   │   │       │   ├── ProduitController.java
│   │   │       │   └── CategorieController.java
│   │   │       ├── model/                         # Entités JPA
│   │   │       │   ├── Produit.java
│   │   │       │   └── Categorie.java
│   │   │       └── repository/                    # Repositories JPA
│   │   │           ├── ProduitRepository.java
│   │   │           └── CategorieRepository.java
│   │   └── resources/
│   │       ├── application.properties             # Configuration
│   │       └── graphql/
│   │           └── schema.graphqls                # Schéma GraphQL
│   └── test/                                      # Tests unitaires
│
├── pom.xml                                        # Dépendances Maven
├── .gitignore
└── README.md
```

## 🔌 API Endpoints

### GraphQL Endpoint

- **URL** : `http://localhost:8080/graphql`
- **Méthode** : POST
- **Content-Type** : `application/json`

### Exemple de requête HTTP

```bash
curl -X POST http://localhost:8080/graphql \
  -H "Content-Type: application/json" \
  -d '{
    "query": "{ produits { id nom prix } }"
  }'
```

### GraphiQL Interface

- **URL** : `http://localhost:8080/graphiql`
- Interface graphique interactive pour tester l'API

## 🎓 Concepts GraphQL utilisés

- **Queries** : Pour récupérer des données (équivalent GET en REST)
- **Mutations** : Pour modifier des données (équivalent POST/PUT/DELETE en REST)
- **Types** : Définition des structures de données
- **Input Types** : Types pour les paramètres d'entrée
- **Relations** : Relations entre Produit et Categorie (Many-to-One)

## 📚 Ressources

- [Documentation Spring GraphQL](https://docs.spring.io/spring-graphql/docs/current/reference/html/)
- [Documentation GraphQL](https://graphql.org/learn/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)

## 👤 Auteur

**ABDELFATTAH BEZZAZ**

- GitHub: [@ABDELFATTAHBEZZAZ](https://github.com/ABDELFATTAHBEZZAZ)

## 📄 Licence

Ce projet est sous licence libre. N'hésitez pas à l'utiliser pour apprendre et améliorer vos compétences en GraphQL et Spring Boot.

---

⭐ Si ce projet vous a aidé, n'hésitez pas à lui donner une étoile !

