# RobotWar

###Installation du projet
>######Attention
Le projet est en Java8

Pour cloner le projet : 
```
git clone https://github.com/PhilyT/RobotWar.git
```



>Pour installer et tout lancer :

######Sous linux : 
```
build.sh
```
######Sous Mac OS : 
```
sh build.sh
```
######Sous Windows : 
Si CigWin d'installé :  
```
sh build.sh
```
Sinon :  
```
mvn clean
```
```
mvn package
```
  
### Documents  
  
La documentation se trouve dans le repertoire doc à la racine.  
  
###Release  
  
>######Version 1.0  
Rendu du projet  
  
###Contributeurs  
Nicolas Kircun  
Tom Phily   
Mohammed Tanouti  
  
###Dirigé par :  
Fabrice Huet  
  
## Sujet 
  
Le but de ce projet est de construire un jeu de combat virtuel de type RobotWar  
  
Dans une arêne de combat en 2D, vue de dessus, des robots s'affrontent, gérés par une IA relativement basique. Le comportement ainsi que le graphisme des robots est décidé par des plugins. Un robot est actif tant que sa vie n'a pas atteint 0 et le gagnant est le dernier robot actif. À chaque robot est associé une quantité d'énergie et chaque action consomme une partie de celle-ci. L'énergie remonte régulièrement tant qu'elle n'a pas atteint la valeur maximale.   

### Plugins graphisme

Ces plugins servent à la représentation graphique des robots et de leurs armes. Le jeu devra contenir de base un plugin qui représente les robots par un carré de couleur alératoire. D'autres plugins possibles sont par exemple une animation, la visualisation des barres de vie et d'énergie...

### Plugins de déplacement

Ces plugins servent à décider du déplacement du robot. Le plugin le plus simple consiste en un déplacement aléatoire mais d'autres plus compliqués peuvent être implémentés. Par exemple dans le cas d'un robot avec une arme de courte portée, un déplacement vers un autre robot sera utile. On peut aussi avoir un déplacement dont la vitesse dépend de la barre de vie ou de la quantité d'énergie restante. 

###Plugins d'attaque

Ces plugins servent à décider attaquer les autres robots et à diminuer leur barre de vie. Chaque attaque sera définie par une portée et un graphisme. De base un plugin implémentant une attaque de courte portée sera proposé.  

###Remarques

Ne perdez pas de vue que l'objectif est de faire une architecture à plugin, donc ne passez pas trop de temps à rendre votre jeu intéressant/amusant, ce n'est pas le but. 
 
###Scénario pour l'évaluation

Afin d'évaluer vos projets, voici un ensemble d'étapes effectuées par le correcteur. Vous devez vous assurer que ce scénario marche sur n'importe quelle machine. Le projet sera testé sur un Linux ou un Mac avec un Java 8.  
  
    Compilation du projet avec maven  
        Génération d'un jar exécutable avec maven  
        Création d'une arborescence contenant des plugins de base chargés dés le lancement de l'application  
        Création d'une arborescence séparée contenant des plugins que l'utilisateur pourra ajouter à l'application (i.e. pas dans le classpath initial)  
    Démarrage de l'application avec java -jar ... ou maven  
    Déplacement dans l'arborescence, ajout/suppression de plugins...  
  
Le but de cette évaluation est d'avoir un aperçu rapide de votre programme afin de préparer la présentation orale.  
  
Source : http://miage.unice.fr/User:FredericMallet/Programmation_Avanc%c3%a9e_-_2012%2f%2f2013/Projet_2016-2017