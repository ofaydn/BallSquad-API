
# BallSquad API
Purpose of developing this API is to prove technical skills for a basic back-end position. Project includes fetching data from external API service using Feign Client, saving those datas to a local MySql server, and returning those datas to the user when needed all of the logic was written in Java language. I've used Liquibase as schema management tool in this project, which made a lot easier managing database tables. 

## Running the project
In order to run this project in your local machine you just need Docker installed on your machine. Then by typing folowing commands you will be able to run the project without worrying about any kind of program setup.

Create a directory and go. 
```bash
mkdir ballsquad_api
cd ballsquad_api
```
Create a docker-compose.yaml file and paste those.
```bash
version: '3'
services:
  db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: ballsquad
    container_name: ballsquad_db_appc
  app:
    image: ofaydn/ballsquad_java_app:latest
    ports:
      - "8081:8080"
    depends_on:
      - db
networks:
  default:
    name: ballsquad_network
    driver: bridge

```

## API Usage
BallSquad API offers 2 different endpoints which both are POST requests.

#### 1) Get authors
This endpoint allows you to make queries for authors in database. If database doesn't contain queried author, it will fetch from OpenLibrary website and save it to the database for later searches.

```http
POST /authors?name=${name}
```

| Parameter | Type     |  Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | **Required**. Author Name |

#### 2) Get author works
This endpoint brings you works of the author you've queried. Same as first endpoint if author works are not in the database, they are saved to database.

```http
POST /works/${authorKey}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `authorKey`      | `string` | **Required**. Author Key |
