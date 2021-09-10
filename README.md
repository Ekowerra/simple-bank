# simple-bank

Ce projet a pour but de présenter, via des modifications successives de la signature d'une fonction, la gestion d'erreurs systématique dans une application.
Sur une simple méthode createAccount nous allons, étape par étape, complexifier la signature de la méthode pour apporter une gestion d'erreur nous permettant d'exposer proprement les erreurs, et de les gérer de façon systématique.

En parallèle, une application est en place pour permettre de constater à chaque étape l'amélioration fournie.

Cette application est construite avec la stack technique suivant :
 - H2 (base de données)
 - Doobie (librairie de requête de base de données)
 - Flyway (librairie de migration de base de données)
 - Cats Effect (librairie de gestion des effets de bord)
 - Tapir (librairie de routage HTTP et génération de documentation OpenAPI)
 - Circe (librairie de gestion encodage/decodage en JSON)
 - PureConfig (librairie de gestion de configuration)

L'application peut être lancée sur le port 8080 via la commande sbt run.
La documentation est accessible sur l'url localhost:8080/swagger

//TODO
- installation de poste
    - télécharger l'IDE IntelliJ Community
    - nouveau projet
        - from version control
        - coller le ssh du projet dedans
        - installer les plugins scala et sbt
        - utiliser scalafmt
        - en haut à droite, onglet sbt?
            - si non, fermer le projet. Supprimer le dossier .idea. Réouvrir avec IJ en tant que projet le fichier build.sbt
            - si oui, en bas à gauche, lancer 'run' dans le sbt shell,  ou bien 'sbt run' dans le terminal (à la racine du projet)
                - si ok, c'est bon
                - si non, investiguez (démerdez-vous)
- Déroulé des exos