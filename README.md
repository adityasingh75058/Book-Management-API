#  Book Management API

##  Overview
This is a Spring Boot REST API for managing books. It supports CRUD operations (Create, Read, Update, Delete).

## Tech Stack
- Java
- Spring Boot
- MySQL
- Docker
- REST APIs

## Features
- Add new book
- Get all books
- Update book
- Delete book

## API Endpoints

### Create Book
POST /books

### Get All Books
GET /books

### Update Book
PATCH /books/{id}

### Delete Book
DELETE /books/{id}

## Run with Docker
docker-compose up --build
