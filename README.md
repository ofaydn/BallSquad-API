Prerequisites:
  First you need to setup a MySql server on your device.
  Then start your server on 3306 port.
  Create a database named "ballsquad". Username and 
  password should be both "root".

How to run application?
  Open project file named BallsquadApi on IntellijIDEA.
  Run the applicaton with Shift + F10 combination.
  Liquibase will handle creation of tables.

What does application do?
  Applicaton offers 2 different endpoints.Both are POST requests.

  1)localhost:8080/authors?name=(author name)
  This endpoint allows you to make queries for authors in database.
  If database doesn't contain queried author, it will fetch from 
  OpenLibrary website and save it to the database for later searches.

  2)localhost:8080/works/(author id)
  This endpoint brings you works of the author you've queried.
  Same as first endpoint if author works are not in  the database, 
  they are saved to database.
  
