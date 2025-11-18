# Introduction à Java J2EE
Ce projet a pour but de lancer un projet bootstrap en Java Spring Boot.
L'objectif est de découvrir plein de technologies et permettre aux utilisateurs de laisser un avis sur un produit.

## Pré-requis
Pour lancer ce projet, Docker Compose est requis.

### Utilisateur Windows
Ouvrez un terminal et exécutez la commande : `wsl --install`

Pour le sous-système Ubuntu : `wsl --install -d Ubuntu`

Pour le sous-système Debian (vous avez du goût) : `wsl --install -d Debian`

Vous pouvez ensuite entrer dans le sous-système choisi :

Ubuntu : `wsl -d Ubuntu`

Debian : `wsl -d Debian`

Suivez maintenant la partie **Utilisateur Linux**.

### Utilisateur macOS (bientôt moi)
Installez l'utilitaire Brew : https://brew.sh

Puis installez l'outil Colima : https://formulae.brew.sh/formula/colima

Enfin, démarrez Colima en exécutant la commande : `colima start`

Suivez maintenant la partie **Utilisateur Linux**.

### Utilisateur Linux
Installez Docker : https://docs.docker.com/engine/install/

Si vous souhaitez éviter d'utiliser `sudo` pour chaque commande Docker : https://docs.docker.com/engine/install/linux-postinstall/

## Contrat d'interface
Afin de visualiser les routes existantes, un Swagger est à votre disposition.

Swagger est un outil qui génère automatiquement une documentation interactive et visuelle pour une API.

http://127.0.0.1:8080/swagger-ui/index.html

### Explication de l'API
Nous avons créé :

- Un controller Account
- Un Service Account et son interface
- Une interface Repository Account
- Un DAO AccountEntity

AccountEntity représente la structure de données dans la base de données.

Pour pouvoir enregistrer une donnée, nous utilisons l'entrée AccountController.  
Sur le verbe POST, nous allons enregistrer la donnée (attention si vous regardez le swagger, il faudra supprimer account_id (pour mettre cette valeur à 'nulle' via le JSON)).  
Une fois le JSON envoyé via le controller, celui-ci contacte le service qui ne fait aucun traitement particulier, il enregistre directement dans la BDD via AccountRepository.

Maintenant, il y a deux routes pour récupérer la donnée :

- La première : la méthode `findById`, celle-ci grâce au PathParam, nous allons passer l'id de l'account enregistré dans la BDD pour récupérer ces données.
- La seconde : la méthode `findAll`, celle-ci permet de récupérer tous les accounts enregistrés dans la BDD.  
