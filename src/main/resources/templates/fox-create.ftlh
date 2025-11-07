<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Create Fox</title></head>
<body>
  <h1>Create New Fox</h1>

  <form method="post" action="/api/foxes/new">
    <label>Name: <input name="name" required></label><br>
    <label>Species: <input name="species"></label><br>
    <label>Age: <input name="age" type="number" min="0"></label><br>
    <label>Description: <input name="description"></label><br>
    <label>Active Date: <input name="activeDate" type="date"></label><br>
    <button type="submit">Save</button>
  </form>

  <p><a href="/api/foxes">Back to list</a></p>
</body>
</html>
