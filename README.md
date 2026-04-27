# Conflict Tracker API

## 1. Breu descripció del projecte

**Conflict Tracker API** és una API REST desenvolupada amb **Spring Boot** que permet gestionar informació sobre conflictes internacionals.

L’aplicació permet:

- Crear, consultar, actualitzar i eliminar **conflictes**
- Gestionar **esdeveniments** associats a un conflicte
- Gestionar **faccions** dins d’un conflicte
- Associar conflictes i faccions amb **països**
- Filtrar conflictes per estat o per codi de país

L’API segueix una arquitectura per capes:

- **Controller** → gestiona les peticions HTTP
- **Service** → conté la lògica de negoci
- **Repository** → accés a base de dades
- **DTO + Mapper** → separació entre model intern i resposta externa

---

## 2. Instruccions per compilar i executar l’aplicació

### Requisits previs

- Java 17 o superior
- Maven 3.8+
- Base de dades configurada (segons `application.properties`)

---

### 2.1 Clonar el repositori


    git clone https://github.com/el-teu-usuari/conflict-tracker-api.git
    cd conflict-tracker-api

---

### 2.2 Compilar el projecte

    mvn clean install

---

### 2.3 Executar l’aplicació

Amb Maven:

    mvn spring-boot:run

O bé executant el .jar generat:

    java -jar target/Conflict_Tracker_API-0.0.1-SNAPSHOT.jar

---

### 2.4 URL base de l’API

Per defecte:

    http://localhost:8080/api/v1

---

# 3. Exemples d’ús dels endpoints principals amb Postman

---

## CONFLICTS

### Obtenir tots els conflictes

#### GET

    http://localhost:8080/api/v1/conflicts

#### Filtrar per estat

    GET http://localhost:8080/api/v1/conflicts?status=ACTIVE

---

#### Obtenir conflicte per ID

    GET http://localhost:8080/api/v1/conflicts/1

---

### Crear un conflicte

#### POST

    http://localhost:8080/api/v1/conflicts

Body → raw → JSON:

    {
    "name": "Conflict Example",
    "description": "Description of the conflict",
    "status": "ACTIVE",
    "countryCodes": ["USA", "RUS"]
    }

---

### Actualitzar un conflicte

#### PUT

    http://localhost:8080/api/v1/conflicts/1

    {
    "name": "Conflicto Belico",
    "startDate": "2026-02-12",
    "status": "ENDED",
    "description": "Description of the conflict",
    "countryCodes": [
    "USA"
    ]
    }

---

### Eliminar un conflicte

    DELETE http://localhost:8080/api/v1/conflicts/1

---

### Buscar conflictes per codi de país

    GET http://localhost:8080/api/v1/conflicts/country/USA

---

## EVENTS

### Obtenir tots els esdeveniments

    GET http://localhost:8080/api/v1/events

---

### Crear un esdeveniment

    POST http://localhost:8080/api/v1/events

    {
    "eventDate": "2024-05-10",
    "location": "Kyiv",
    "description": "Major offensive",
    "conflictId": 1
    }

---

### Actualitzar un esdeveniment

    PUT http://localhost:8080/api/v1/events/1

    {
    "location": "Updated location",
    "description": "Updated description"
    }

---

### Eliminar un esdeveniment

    DELETE http://localhost:8080/api/v1/events/1

---

## FACTIONS

### Obtenir totes les faccions

    GET http://localhost:8080/api/v1/factions

---

### Crear una facció

    POST http://localhost:8080/api/v1/factions

    {
    "name": "Rebel Group",
    "conflictId": 1,
    "supportingCountryCodes": ["USA", "FRA"]
    }

---

### Actualitzar una facció

    PUT http://localhost:8080/api/v1/factions/1

    {
    "name": "Updated Faction Name",
    "supportingCountryCodes": ["USA"]
    }

---

### Eliminar una facció

    DELETE http://localhost:8080/api/v1/factions/1



