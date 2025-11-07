<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Fox</title>
</head>
<body>
<h1>Create New Fox</h1>

<form action="/api/foxes/new" method="post">
    <p>
        <label>Name:
            <input type="text" name="name" required>
        </label>
    </p>

    <p>
        <label>Species:
            <input type="text" name="species" required>
        </label>
    </p>

    <p>
        <label>Age:
            <input type="number" step="0.1" name="age" required>
        </label>
    </p>

    <p>
        <label>Description:
            <textarea name="description" rows="3" cols="30"></textarea>
        </label>
    </p>

    <p>
        <label>Active Date:
            <input type="date" name="activeDate">
        </label>
    </p>

    <button type="submit">Save</button>
</form>

<p><a href="/api/foxes">Back to list</a></p>
</body>
</html>
