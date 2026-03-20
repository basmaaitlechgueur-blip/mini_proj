# Ecole de Musique 🎵

Mini projet Spring Boot pour gérer une école de musique (professeurs, instruments, cours).

---

## Technologies utilisées

- Java 17
- Spring Boot 3.2.4
- Spring Data JPA
- Thymeleaf
- H2 (base de données en mémoire)
- Lombok
- Maven

---

## Lancer le projet

1. Cloner le projet
2. Ouvrir dans IntelliJ IDEA
3. Lancer `Application.java`
4. Ouvrir le navigateur sur `http://localhost:8080`

---

## Fonctionnalités

- Ajouter, modifier, supprimer des professeurs
- Ajouter, modifier, supprimer des instruments
- Ajouter, modifier, supprimer des cours
- Filtrer les cours par niveau et par jour
- Filtrer les instruments par famille et disponibilité
- Tableau de bord avec statistiques sur la page d'accueil

---

## Pages disponibles

| URL | Description |
|---|---|
| http://localhost:8080/ | Page d'accueil |
| http://localhost:8080/profs | Liste des professeurs |
| http://localhost:8080/instruments | Liste des instruments |
| http://localhost:8080/cours | Liste des cours |
| http://localhost:8080/h2-console | Console base de données H2 |

---

## Structure du projet

```
src/
└── main/
    ├── java/com/ecolemusique/
    │   ├── Application.java
    │   ├── controller/
    │   │   ├── HomeController.java
    │   │   ├── ProfController.java
    │   │   ├── InstrumentController.java
    │   │   └── CoursController.java
    │   ├── model/
    │   │   ├── Prof.java
    │   │   ├── Instrument.java
    │   │   └── Cours.java
    │   └── repository/
    │       ├── ProfRepository.java
    │       ├── InstrumentRepository.java
    │       └── CoursRepository.java
    └── resources/
        ├── templates/
        ├── static/
        └── application.properties
```

---

## Configuration base de données

La base de données H2 est en mémoire, les données sont réinitialisées à chaque redémarrage.

Pour accéder à la console H2 :
- URL : http://localhost:8080/h2-console
- JDBC URL : `jdbc:h2:mem:ecolemusique`
- Username : `sa`
- Password : *(laisser vide)*

  ---

  ## Capture d'ecran
  ---
<img width="1920" height="1080" alt="Screenshot (1108)" src="https://github.com/user-attachments/assets/6747baac-371f-40db-aa74-3de4c2d14417" />
<img width="1920" height="1080" alt="Screenshot (1109)" src="https://github.com/user-attachments/assets/9c4abdb5-e062-47df-a5a9-fece4633a5ba" />
<img width="1920" height="1080" alt="Screenshot (1110)" src="https://github.com/user-attachments/assets/19db578a-c7f5-47de-86d2-04c59bd95882" />
<img width="1920" height="1080" alt="Screenshot (1111)" src="https://github.com/user-attachments/assets/74f4e065-297f-4d99-a610-f82947140983" />
<img width="1920" height="1080" alt="Screenshot (1112)" src="https://github.com/user-attachments/assets/9d46705c-76ba-405b-be56-dc23a7540c75" />

  ---
## Auterur
---
AIT LECHGUEUR BASMA
  



  
