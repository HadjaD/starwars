# starwars
## Android Studio Project 4A ESIEA - Starwars Restful API

L'application utilise les données des sept premières saisons d'une API Rest de StarWars https://swapi.co/api/.
Les données manipulées sont les FILMS et les Personnages.

Fonctionnalités: 

**Architecture MVC**
  - Model: Ce package contient les classes java pour stocker les objets de type Films et People
  - Vue: Ce package contient toutes les classes Activity qui sont en charge d'afficher du contenu
  - Controller: Ce package se place entre le Model et la Vue. Le controleur est appelé par la vue et c'est lui qui est en charge de récupérer et stocker les données dans le model demandé en faisant un appel webservice à l'API Rest. Ces données sont ensuite mises à disposition de la vue appelante pour être affichées.
  
**Trois Adapters**:
  - *TabPageAdapter*: Adapteur pour les deux fragments
  - *DataAdapter*: Adapteur du RecyclerView pour l'affichage des Films
  - *DataAdapterPeople*: Adapteur du RecyclerView pour l'affichage des Personnages
  
**Quatre controleurs**:
  - *TitleDisplayHandler*: Controleur en charge de récupérer les données des films depuis l'API
  - *PeopleDisplayHandler*: Controleur en charge de récupérer les données des personnages depuis l'API
  - *FilmByIDCall*: Controleur en charge de récupérer les données sur un Film.
  - *PeopleByIDCall*: Controleur en charge de récupérer les données sur un personnage

**Deux Fragments**: ces fragments sont gérés dans une TabView et contenus dans la _MainActivity_ (Page d'accueil)
  - *FilFragment*: il est en charge de faire appel au controleur pour récupérer les données des 7 films depuis l'API pour ensuite les afficher
  - *PeopleFragment* : il est en charge de faire appel au controleur pour récupérer les données des personnages depuis l'API pour ensuite les afficher à l'aide du _RecyclerView_
  
**Un Menu**: Ce menu se trouve sur la page d'accueil, il contient un item _Content_ qui, lorsque l'utilisateur clique dessus, renvoie à la vue qui contient les deux fragments précédents.

**Quatre activitys**:
  - *MainActivity*: vue principale qui contient un _TextView_, une _ImageView_ et le _Menu_ précédent
  
       <img width="195" alt="welcome_" src="https://user-images.githubusercontent.com/32294639/71321401-fdde2d00-24b8-11ea-81ff-0d6d49610ea6.PNG">
  
  - *OnDataSelectedActivity*: Un clic sur le menu précédent fait appel à cette vue qui contient les fragments. La première table contient les Films par défaut. L'utilisateur peu swapper de gauche à droite pour revenir à l'une des fenêtres.
  
       <img width="193" alt="content_film" src="https://user-images.githubusercontent.com/32294639/71321411-19493800-24b9-11ea-902a-dc7adb813702.PNG">
              <img width="195" alt="content_people" src="https://user-images.githubusercontent.com/32294639/71321414-2403cd00-24b9-11ea-9ba1-6492c729586b.PNG">
          
          
  - *FilmActivity*: cette vue fait appel au controleur pour récupérer les données sur un film. Cette avue permet également de lire les trailers de tous les films en chargeant les vidéos depuis Youtube. Pour cela, je fais appel à l'API **_YoutTubeAndroidPlayerAPI_**
  
       <img width="195" alt="youtube2" src="https://user-images.githubusercontent.com/32294639/71321418-38e06080-24b9-11ea-84f4-15ff10f7fee6.PNG"> <img width="193" alt="film_ray" src="https://user-images.githubusercontent.com/32294639/71322346-f32a9480-24c6-11ea-9638-26ca627c0467.PNG">
  
  - *PeopleActivity*: cette vue fait appel au controleur _PeopleByIDCall_ pour récupérer les données sur un personnage.
  
       <img width="192" alt="people" src="https://user-images.githubusercontent.com/32294639/71321422-4b5a9a00-24b9-11ea-8a0d-1c07379a975c.PNG">
  
  
  




