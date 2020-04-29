Robin DANDEL
[![Build Status](https://travis-ci.com/RobinDandel/DataAnalysisLibrary.svg?token=e4mRizEpTxFhvvM9ZN4Z&branch=master)](https://travis-ci.com/RobinDandel/DataAnalysisLibrary)

Projet seul


-Dans mon projet j'utilise Maven qui permet d'avoir plusieurs plugins tel que Jacoco.
-J'utilise JUnit 4 pour réaliser les tests qui se trouve dans 'src/test/java/DataframeTest.java' .
-Jacoco va permetre évaluer la qualité des tests en mesurant la couveruture du code, ce plugin permet notament de de
 générer une page web qui va donner des informations tel que la couverture de code. Il va permetre aussi de donner un
 rapport du pourcentage de couverture du code. On peut aussi voir la couverture ligne par ligne. Pour accéder au site,
 il faut allait dans 'target/site/jacoco'. Voir l'image 'Jacoco_rapport.png'.
-Travis CI est un service d'integration continue il va permet de vérifier que touts les tests sont valide lors d'un push.
 Il va aussi fournir un badge à github qui va montrer si le dernier push est valide.


Dans les fichiers .csv j'ai mis le type les colonnes en haut pour symplifier. Il y a 3 types : String/Integer/Float.

Fonctionnalités implémenté :
Grace à cet bibliothèque, nous allons pouvoir creer des Dataframe grace à des fichier .csv(avec les Types en haut du
 fichier) ou avec des tableaux de donner. Le code se trouve dans 'src/main/java/Dataframe.java'
-Nous pouvons afficher la première ligne et la dernier ligne de le Dataframe.
-Nous pouvons afficher entièrement le Dataframe.
-Nous pouvons sélectioner dans le Dataframe un sous ensemble en renseigant les lignes et les colonnes que nous souaitons garder.
Cela va permetre de créer un autre Dataframe qui ne comportera que les lignes et colonnes selectioné.






Source svg:
    Title: Car Evaluation Database
    Createur: Marko Bohanec

    Title: Forest Fires
    Createur: Paulo Cortez and Aníbal Morais

