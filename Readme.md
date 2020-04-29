Robin DANDEL
[![Build Status](https://travis-ci.com/RobinDandel/DataAnalysisLibrary.svg?token=e4mRizEpTxFhvvM9ZN4Z&branch=master)](https://travis-ci.com/RobinDandel/DataAnalysisLibrary)

Projet seul

Dans mon projet j'utilise Maven qui permet d'avoir plusieurs plugins tel que Jacoco.

J'utilise JUnit 4 pour réaliser les tests qui se trouve dans 'src/test/java/DataframeTest.java'.

Jacoco va permettre évaluer la qualité des tests en mesurant la couverture du code, ce plugin permet notamment de générer une page web qui va donner des informations tel que la couverture de code. Il va permettre aussi de donner un rapport du pourcentage de couverture du code. On peut aussi voir la couverture ligne par ligne. Pour accéder au site, il faut allait dans 'target/site/jacoco'. Sinon voir l'image 'Jacoco_rapport.png'.

Intégration continue est réalisé grace au service Travice il va permet de vérifier que touts les tests sont valide lors d'un push. Il va aussi fournir un badge à github qui va montrer si le dernier push est valide.

Dans les fichiers .csv j'ai mis le type les colonnes en haut pour simplifier. Il y a 3 types : String/Integer/Float.

Fonctionnalités implémentées : Grace à cette bibliothèque, nous allons pouvoir créer des Dataframe grâce à des fichier .csv (avec les Types en haut du fichier) ou avec des tableaux de donner. Le code se trouve dans 'src/main/java/Dataframe.java'.

-Nous pouvons afficher statistique du Dataframe : afficher la première ligne ou la dernière ou entièrement le Dataframe.

-Nous pouvons afficher entièrement le Dataframe.

-Nous pouvons sélectionner dans le Dataframe un sous ensemble en renseignant les lignes et les colonnes que nous souhaitons garder. Cela va permettre de créer un autre Dataframe qui ne comportera que les lignes et colonnes sélectionné.



    
    Source svg:
    
    Title: Car Evaluation Database
    Createur: Marko Bohanec
    
    Title: Forest Fires
    Createur: Paulo Cortez and Aníbal Morais

