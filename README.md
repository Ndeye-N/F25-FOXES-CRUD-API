

### Version
1.0.0

---

## Installation
- Get the project
    - clone
        ```
      git clone https://github.com/Ndeye-N/f25-foxes-crud-api.git
        ```
    - OR download zip.
- Open the project in VS Code.
- This project is built to run with **JDK 21**.
- Dependencies include **JPA**, **PostgreSQL**, and **Spring Web**.
  JPA handles persistence, PostgreSQL is the database used.
- `/src/main/resources/application.properties` contains your database configuration.
  - Make sure your Neon database is running before executing the project.
  - Copy your JDBC connection string from Neon (Java tab) and paste it as the value for
    `spring.datasource.url` (no quotation marks).
- Build and run the main class. You should see a new `foxes` table created in your Neon database.

---

## API Endpoints
Base URL: [`http://localhost:8080/api/foxes`](http://localhost:8080/api/foxes)

1. **`GET /api/foxes`**
   Retrieves all foxes in the database.

2. **`GET /api/foxes/{id}`**
   Retrieves a single fox by its ID.

3. **`POST /api/foxes`**
   Adds a new fox entry.
   Example:
   ```json
   {
     "name": "Sahara",
     "description": "Shy arctic wanderer",
     "species": "Arctic",
     "activeDate": "2025-09-20"
   }

4. **`PUT /api/foxes/{id}`**
   Updates an existing fox’s information by its ID.
   Example:
   ```json
   {
     "name": "Sahara",
     "description": "Calm arctic explorer",
     "species": "Arctic",
     "activeDate": "2025-10-01"
   }

5. **`DELETE /api/foxes/{id}`**
   Deletes a fox from the database using its ID.

   Example Request:
   `DELETE http://localhost:8080/api/foxes/3`

   Example Response:
   ```json
   {
     "message": "Fox with ID 3 has been deleted successfully."
   }

6. **`GET /api/foxes/category/{species}`**
   Retrieves foxes by their species.

   Example Request:
   `GET http://localhost:8080/api/foxes/category/Arctic`

   Example Response:
   ```json
   [
     {
       "animalId": 1,
       "name": "Sahara",
       "description": "Shy arctic wanderer",
       "species": "Arctic",
       "activeDate": "2025-09-20"
     },
     {
       "animalId": 2,
       "name": "Puff",
       "description": "Playful arctic fox pup",
       "species": "Arctic",
       "activeDate": "2025-09-28"
     }
   ]

7. **`GET /api/foxes/search?name=substring`**
   Searches foxes by part of their name.

   Example Request:
   `GET http://localhost:8080/api/foxes/search?name=Sa`

   Example Response:
   ```json
   [
     {
       "animalId": 1,
       "name": "Sahara",
       "description": "Shy arctic wanderer",
       "species": "Arctic",
       "activeDate": "2025-09-20"
     }
   ]

   ---

## Demo Video
Link:  https://uncg-my.sharepoint.com/:v:/g/personal/nmndiaye_uncg_edu/EecRzbO-csZEvExlAS0VsZIBj_9F1j0M0e1C5psv1zZixQ?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=6clNml


## MVC WEB APP DEMO
Link: https://uncg-my.sharepoint.com/:v:/g/personal/nmndiaye_uncg_edu/EV5FfCfjmY9AuBFib5FPC4kBO-U62Fx7blclVYhZM9v_3A?e=dR7kbj
