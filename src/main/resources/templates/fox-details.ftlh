<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>${fox.name} Details</title>
</head>
<body>
  <h1>${fox.name}</h1>

  <p><b>ID:</b> ${fox.animalId}</p>
  <p><b>Species:</b> ${fox.species}</p>
  <p><b>Age:</b> ${fox.age}</p>
  <p><b>Description:</b> ${fox.description}</p>

  <hr>
  
  <p>
    <a href="/api/foxes">Back to list</a> |
    <a href="/api/foxes/update/${fox.animalId}">Edit</a> |
    <a href="/api/foxes/delete/${fox.animalId}" style="color:red;">Delete</a>
  </p>
</body>
</html>
