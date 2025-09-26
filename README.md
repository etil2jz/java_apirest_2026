## Introduction
Ce projet a pour but de lancer un projet bootstrap en java spring boot  
Celui-ci est de permettre de découvrir plein de technologies et laisser les utilisateurs faire leur opinion et potentiellement de l'améliorer.

### Pré-requis
Pour lancer ce projet, il faut docker compose. Nous allons les procedures pour la majorité des OS

#### Windows
Il faut WSL

```wsl --install```

##### Pour installer la bonne distribution :
Si vous aimez Ubuntu :  
```wsl --install -d Ubuntu```  
Si vous aimez Debian  :  
```wsl --install -d Debian```

Pour vérifier la version :  
```wsl -l -v```

##### Pour entrer en mode linux
Ubuntu :  
```wsl -d Ubuntu```  
Debian :  
```wsl -d Debian```

Ensuite suivre le tuto Linux

#### MacOs
Je conseille d'installer ```brew```  
via : https://brew.sh

Ensuite selon votre Mac :  
https://formulae.brew.sh/formula/colima

Avec colima démarrer :  
```colima start```

Suivre le tuto Linux

#### Linux
Il faut installer docker voici le lien officiel :  
https://docs.docker.com/compose/install/linux/

Et voici le lien officiel pour mettre docker en sudo :  
https://docs.docker.com/engine/install/linux-postinstall/

### Contrat d'interface
Voici le swagger associé au projet pour tester les routes actuelles.

http://localhost:8080/swagger-ui/index.html

### Explication actuelle de cette branche
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
