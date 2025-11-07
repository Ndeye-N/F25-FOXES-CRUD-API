<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Fox Details</title></head>
<body>
  <h1>${fox.name}</h1>

  <p><b>ID:</b> ${fox.id!fox.animalId!fox.foxId}</p>
  <p><b>Species:</b> ${fox.species!""}</p>
  <p><b>Age:</b> ${fox.age!""}</p>
  <p><b>Description:</b> ${fox.description!""}</p>
  <p><b>Active Date:</b> ${fox.activeDate!""}</p>

  <p>
    <a href="/api/foxes">Back to list</a> |
    <a href="/api/foxes/update/${fox.id!fox.animalId!fox.foxId}">Update</a> |
    <a href="/api/foxes/delete/${fox.id!fox.animalId!fox.foxId}">Delete</a>
  </p>
</body>
</html>
