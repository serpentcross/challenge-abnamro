# Task Description
Create a standalone java application which allows users to manage their favourite recipes. It should
allow adding, updating, removing and fetching recipes. Additionally users should be able to filter
available recipes based on one or more of the following criteria:

1. Whether or not the dish is vegetarian
2. The number of servings
3. Specific ingredients (either include or exclude)
4. Text search within the instructions.


   For example, the API should be able to handle the following search requests:

    • All vegetarian recipes
    • Recipes that can serve 4 persons and have “potatoes” as an ingredient
    • Recipes without “salmon” as an ingredient that has “oven” in the instructions.

   Requirements: Please ensure that we have some documentation about the architectural choices and also how to
   run the application. The project is expected to be delivered as a GitHub (or any other public git
   hosting) repository URL.


   All these requirements needs to be satisfied:

      • It must be a REST application implemented using Java (use a framework of your choice)

      • Your code should be production-ready. 

      • REST API must be documented.

      • Data must be persisted in a database.

      • Unit tests must be present.

      • Integration tests must be present.

### Requirements

```
Git        : v2.18.0 or higher
Java       : JDK 11 or higher
Gradle     : v7.4 or higher

OS         : Linux, MacOS or Windows
```

### Not necessary, but just in case

```
Docker     : 19.03.1 or higher
```

### Getting Started

```
git clone https://serpentcross@bitbucket.org/serpentcross/challenge-abnamro.git
cd ./challenge-abnamro/
```

### Preparing database

```
No actions required. The project uses H2 in-memory database.
```

### Installing main application

To install the program just run command (recommended)

(for Linux or MacOS)
```
./gradlew build
```

(for Windows)
```
gradlew.bat build
```

Or you may also just run(without the wrapper):

```
gradle build
```

### Docker build (If Docker is installed)

```
./gradlew jibDockerBuild
```

### Starting application

Run next command

```
./gradlew bootRun
```

### Starting application via Docker

Run next command

```
docker run cooking/cooking-api:0.0.1
```


### Running and testing

The REST-api runs on address

```
http://localhost:8080/api
```

Possible test call

```
curl -X 'GET' \
  'http://localhost:8080/api/recipes?vegetarian=true&servings=4' \
  -H 'accept: application/json
```

Should return a response in JSON format:

```
[
  {
    "id": "e57c70c4-9457-47c1-ac4a-84c64f7a200d",
    "name": "Boiled potato",
    "instruction": "Potato, Carrot, Cabbage",
    "servingAmount": 4,
    "vegetarian": true,
    "ingredients": [
      {
        "id": "1249113c-29f0-4271-96a0-0de4f3a66ed7",
        "name": "Potato",
        "vegetable": true
      },
      {
        "id": "6a34cdec-9380-43e3-915a-09c67d0e03f6",
        "name": "Carrot",
        "vegetable": true
      },
      {
        "id": "31862764-bde4-4e84-9f42-51914f64e3f1",
        "name": "Cabbage",
        "vegetable": true
      }
    ]
  }
]
```

### Documentaion

A detailed documentation, which contains full API description is located there:
```
http://localhost:8080/api/swagger-ui/index.html
```

A contract file is located by address:

```
http://localhost:8080/api/v3/api-docs
```

### Possible upgrades

- using API-versioning;
- implementing audit feature (via AuditableEntity);