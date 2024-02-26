
# BallSquad API
Purpose of developing this API is to prove technical skills for a basic back-end position. Project includes fetching data from external API service using Feign Client, saving those datas to a local MySql server, and returning those datas to the user when needed all of the logic was written in Java language. I've used Liquibase as schema management tool in this project, which made a lot easier managing database tables. 

## Running the project
In order to run this project in your local machine you just need Docker installed on your machine. 

First clone this repository.
```bash
git clone https://github.com/ofaydn/BallSquad-API
```
Then
```bash
docker-compose up
```
And you are good to go!
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
