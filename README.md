# Persistence
Current version: 0.0.2-2023

## Project Description
The library provides a set of repository interfaces for each entity, as well as a set of entity classes that implement these interfaces. The repository interfaces provide methods for performing common operations on the entities, such as getting, creating, updating, and deleting records. The entity classes represent the data structure of the entities, such as the fields that each entity has.

The library can be used by app clients to connect to any database that supports the JDBC driver. To use the library, an app client would need to create a JDBC connection to the database and then create an instance of each repository interface that they need to use. The app client can then use the repository interfaces to perform operations on the entities.
