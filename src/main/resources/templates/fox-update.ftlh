<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Update Fox</title></head>
<body>
  <h1>Update Fox</h1>

  <form method="post" action="/api/foxes/update">
    <label>ID (read-only):
      <input name="id" value="${fox.id!fox.animalId!fox.foxId}" readonly>
    </label><br>
    <label>Name: <input name="name" value="${fox.name}" required></label><br>
    <label>Species: <input name="species" value="${fox.species!""}"></label><br>
    <label>Age: <input name="age" type="number" min="0" value="${fox.age!""}"></label><br>
    <label>Description: <input name="description" value="${fox.description!""}"></label><br>
    <label>Active Date: <input name="activeDate" type="date" value="${fox.activeDate!""}"></label><br>
    <button type="submit">Save</button>
  </form>

  <p><a href="/api/foxes/${fox.id!fox.animalId!fox.foxId}">Cancel</a></p>
</body>
</html>
