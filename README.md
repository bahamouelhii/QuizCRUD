# QuizCRUD

## Description
API REST pour la gestion des questions et des quiz.

## Fonctionnalités
- CRUD pour les quiz et les questions.

## Installation
1. Clonez ce dépôt : `git clone https://github.com/bahamouelhii/quizcrud.git`
2. Construisez le projet avec `mvn clean install`.
3. Lancez l'application avec `mvn spring-boot:run`.

## Endpoints disponibles

### 1. Questions

#### Obtenir toutes les questions
- **URL** : `/api/questions`
- **Méthode** : `GET`
- **Description** : Récupère toutes les questions.

#### Ajouter une nouvelle question
- **URL** : `/api/questions`
- **Méthode** : `POST`
- **Body** : Un objet JSON représentant la question à ajouter.

#### Mettre à jour une question
- **URL** : `/api/questions/{id}`
- **Méthode** : `PUT`
- **Paramètres** : `id` (int) : L'ID de la question à mettre à jour.
- **Body** : Un objet JSON représentant la question mise à jour.

#### Supprimer une question
- **URL** : `/api/questions/{id}`
- **Méthode** : `DELETE`
- **Paramètres** : `id` (int) : L'ID de la question à supprimer.

### 2. Quiz

#### Créer un nouveau quiz
- **URL** : `/api/quiz/create`
- **Méthode** : `POST`
- **Paramètres** :
  - `category` : La catégorie du quiz.
  - `numQ` : Le nombre de questions dans le quiz.
  - `title` : Le titre du quiz.

#### Lister les quiz d'une catégorie
- **URL** : `/api/quiz/list/{category}`
- **Méthode** : `GET`
- **Paramètres** : `category` (String) : La catégorie du quiz.

#### Obtenir les détails d'un quiz
- **URL** : `/api/quiz/{id}`
- **Méthode** : `GET`
- **Paramètres** : `id` (int) : L'ID du quiz.

#### Soumettre des réponses et obtenir un score
- **URL** : `/api/quiz/score/{id}`
- **Méthode** : `POST`
- **Paramètres** : `id` (int) : L'ID du quiz.
- **Body** : Liste des réponses sous forme de JSON.

