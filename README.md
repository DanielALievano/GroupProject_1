# CEN4010 Fall 2023  
Geek Text Project

## Formatting
### Curly Braces
The opening curly brace should be placed on the same line as the
previous statement, separated by a single space

### Package Names
Package names should be lowercase

### Documentation
Document your classes with @author (Your first name)

## Git
### Branch Names
Branch name convention goes here (discuss with team)

### Pushing
Please only commit packages and classes  
Do not push to main without consulting the rest of the team  
Do not commit executables, output, .gitignore, or IDE files  

### Database
Create a new database CREATE DATABASE IF NOT EXISTS mydatabase;

Use the new database USE mydatabase;

Create a table for user profiles CREATE TABLE IF NOT EXISTS UserProfile ( ProfileID INT AUTO_INCREMENT PRIMARY KEY, ProfileName VARCHAR(255), FirstName VARCHAR(255), LastName VARCHAR(255), Email VARCHAR(255), Password VARCHAR(255), CardInformation VARCHAR(255), Age INT );

Insert sample data INSERT INTO UserProfile (ProfileName, FirstName, LastName, Email, Password, CardInformation, Age) VALUES ('User1', 'John', 'Doe', 'john.doe@email.com', 'password123', '1234-5678-9012-3456', 25), ('User2', 'Jane', 'Smith', 'jane.smith@email.com', 'password456', '9876-5432-1098-7654', 30), ('User3', 'Bob', 'Johnson', 'bob.johnson@email.com', 'password789', '5678-9012-3456-7890', 22), ('User4', 'Alice', 'Williams', 'alice.williams@email.com', 'passwordabc', '4321-8765-0987-6543', 28), ('User5', 'Charlie', 'Brown', 'charlie.brown@email.com', 'passwordxyz', '8765-4321-2109-8765', 35), ('User6', 'Eva', 'Jones', 'eva.jones@email.com', 'passwordefg', '3456-7890-1234-5678', 40), ('User7', 'David', 'Lee', 'david.lee@email.com', 'passwordhij', '7890-1234-5678-9012', 26), ('User8', 'Sophie', 'Miller', 'sophie.miller@email.com', 'passwordklm', '2109-8765-4321-0987', 32), ('User9', 'Michael', 'Brown', 'michael.brown@email.com', 'passwordnop', '6543-2109-8765-4321', 27), ('User10', 'Olivia', 'Taylor', 'olivia.taylor@email.com', 'passwordqrs', '9012-3456-7890-1234', 33);