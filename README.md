# simple-bank

Ce projet a pour but de présenter, via des modifications successives de la signature d'une fonction, la gestion d'erreurs systématique dans une application.
Sur une simple méthode createAccount nous allons, étape par étape, complexifier la signature de la méthode pour apporter une gestion d'erreur nous permettant d'exposer proprement les erreurs, et de les gérer de façon systématique.

En parallèle, une application est en place pour permettre de constater à chaque étape l'amélioration fournie.

Cette application est construite avec la stack technique suivant :
 - [H2](https://h2database.com/html/main.html) (base de données)
 - [Doobie](https://tpolecat.github.io/doobie/) (librairie de requête de base de données)
 - [Flyway](https://flywaydb.org/) (librairie de migration de base de données)
 - [Cats](https://typelevel.org/cats/) Effect (librairie de gestion des effets de bord)
 - [Tapir](https://tapir.softwaremill.com/en/latest/) (librairie de routage HTTP et génération de documentation OpenAPI)
 - [Circe](https://circe.github.io/circe/) (librairie de gestion encodage/decodage en JSON)
 - [PureConfig](https://pureconfig.github.io/) (librairie de gestion de configuration)

L'application peut être lancée sur le port 8080 via la commande sbt run.
La documentation est accessible sur l'url localhost:8080/swagger

## Installation de poste :
- télécharger l'IDE [IntelliJ Community](https://www.jetbrains.com/fr-fr/idea/download)
- cloner le projet
- ouvrir le projet avec IntelliJ
  - télécharger/utiliser la version 11 du JDK
  - installer les plugins scala et sbt
  - en haut à droite, vous devriez trouver un onglet sbt

![onglet sbt](https://github.com/Ekowerra/simple-bank/blob/master/project/images/where_is_sbt.png?raw=true)

   - si non, fermer le projet. Supprimer le dossier .idea situé à la racine du projet. Réouvrir avec IJ le projet
   - si oui, en bas à gauche, lancer 'run' dans le sbt shell

![sbt_shell](https://github.com/Ekowerra/simple-bank/blob/master/project/images/where_is_sbt_shell.png?raw=true)


   - essayer d'accèder au lien suivant http://localhost:8080/swagger
     - si ok, c'est bon (vous pouvez couper la console avec la commande ctrl+C)
     - si non, investiguez (démerdez-vous)
   - git checkout Exercice_1