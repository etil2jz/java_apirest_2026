# Introduction à Java J2EE
Ce projet a pour but de lancer un projet bootstrap en Java Spring Boot.
L'objectif est de découvrir plein de technologies et permettre aux utilisateurs de laisser un avis sur un produit.

Nous nous retrouvons avec une API REST qui permet la gestion d'utilisateurs, de produits, de commandes et d'avis clients.

## Pré-requis
Pour lancer ce projet, Docker Compose est requis.

#### Utilisateur Windows
Ouvrez un terminal et exécutez la commande : 
```shell
wsl --install
```

Pour le sous-système Ubuntu : 
```shell
wsl --install -d Ubuntu
```

Pour le sous-système Debian (vous avez du goût) : 
```shell
wsl --install -d Debian
```

Vous pouvez ensuite entrer dans le sous-système choisi :

Ubuntu : 
```shell
wsl -d Ubuntu
```

Debian : 
```shell
wsl -d Debian
```

Suivez maintenant la partie **Utilisateur Linux**.

#### Utilisateur macOS (bientôt moi)
Installez l'utilitaire Brew : https://brew.sh

Puis installez l'outil Colima : https://formulae.brew.sh/formula/colima

Enfin, démarrez Colima en exécutant la commande : 
```shell
colima start
```

Suivez maintenant la partie **Utilisateur Linux**.

#### Utilisateur Linux
Installez Docker : https://docs.docker.com/engine/install/

Si vous souhaitez éviter d'utiliser `sudo` pour chaque commande Docker : https://docs.docker.com/engine/install/linux-postinstall/

### Démarrer la base de données MySQL
Déployez un conteneur MySQL en exécutant la commande suivante dans le répertoire `database` du projet : 
```shell
docker compose up -d
```
___
## Documentation de l'API (Swagger)
Une fois l'application lancée, la documentation interactive est disponible ici : http://127.0.0.1:8080/swagger-ui/index.html

Certains endpoints sont publics, d'autres nécessitent une authentification (Basic Auth) :

| **Méthode** 	 | **Endpoint** 	 | **Description**                      	 | **Accès**      	  |
|---------------|----------------|----------------------------------------|-------------------|
| `POST`      	 | /accounts    	 | Créer un compte (avec vérif adresse) 	 | 🌍 Public       	 |
| `GET`       	 | /products    	 | Voir le catalogue produit            	 | 🌍 Public       	 |
| `GET`       	 | /notices     	 | Voir les avis                        	 | 🌍 Public       	 |
| `POST`      	 | /products    	 | Ajouter un produit                   	 | 🔒 Auth Requise 	 |
| `POST`      	 | /orders      	 | Passer une commande                  	 | 🔒 Auth Requise 	 |
| `GET`       	 | /orders      	 | Voir ses commandes                   	 | 🔒 Auth Requise 	 |
| `POST`      	 | /notices     	 | Laisser un avis (achat requis)       	 | 🔒 Auth Requise 	 |

## Exemples de JSON
### Créer un compte (POST /accounts)
L'adresse sera automatiquement corrigée par l'API Géoplateforme.
```json
{
  "username": "jean_dupont",
  "password": "password123",
  "description": "Client fidèle",
  "address": "3 rue des potiers toulouse"
}
```

### Ajouter un produit (POST /products)
```json
{
  "name": "Apple MacBook Air M5",
  "price": 1099.99
}
```

### Passer commande (POST /orders)
```json
{
  "accountId": 1,
  "productIds": [1]
}
```

### Laisser un avis (POST /notices)
Fonctionne uniquement si l'utilisateur 1 a acheté le produit 1.
```json
{
  "accountId": 1,
  "productId": 1,
  "userReview": "Ça fait du bien de coder sur un Mac !"
}
```

## Explication technique de l'API
### Le flux de données général
Chaque requête suit ce cheminement :
1. **Controller** : Reçoit le DTO (Data Transfer Object), valide les entrées (`@Valid`) et délègue au Service.
2. **Mapper** : Convertit les DTOs en Entités (DAO) pour isoler.
3. **Service** : Applique la logique métier (vérifications, appels externes) et appelle le Repository.
4. **Repository** : Interface JPA qui communique avec la BDD MySQL.

### Les controllers
1. **Account (Utilisateurs)** : Créer un compte, récupérer la liste de tous les comptes, récupérer un compte spécifique via l'ID.
2. **Notice (Avis)** : Laisser un avis, récupérer la liste de tous les avis, récupérer un avis spécifique via l'ID.
3. **Orders (Commandes)** : Passer une commande, récupérer la liste de toutes les commandes, récupérer une commande spécifique via l'ID.
4. **Product (Produits)** : Ajouter un produit, récupérer la liste de tous les produits, récupérer un produit spécifique via l'ID.

### Sécurité
L'API est sécurisée par Spring Security :
- **Authentification** : Basic Auth.
- **Autorisations** :
- * `PUBLIC` : Inscription (`POST /accounts`), Consultation du catalogue et des avis (`GET`).
- * `PROTECTED` : Passer une commande, ajouter un produit, laisser un avis.
