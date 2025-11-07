<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Fox: ${fox.name}</title>
</head>
<body>
<h1>Update Fox: ${fox.name}</h1>

<form action="/api/foxes/update" method="post">
    <!-- ID: keep, but not editable -->
    <input type="hidden" name="animalId" value="${fox.animalId}" />

    <p>
        <label>Name:
            <input type="text" name="name" value="${fox.name}" required />
        </label>
    </p>

    <p>
        <label>Species:
            <input type="text" name="species" value="${fox.species}" required />
        </label>
    </p>

    <p>
        <label>Age:
            <input type="number" step="0.1" name="age" value="${fox.age}" required />
        </label>
    </p>

    <p>
        <label>Description:<br>
            <textarea name="description" rows="4" cols="40">${fox.description?if_exists}</textarea>
        </label>
    </p>

    <p>
        <label>Active Date:
            <!-- IMPORTANT: no ?string("yyyy-MM-dd") here -->
            <input type="date" name="activeDate"
                   value="${fox.activeDate?if_exists}" />
        </label>
    </p>

    <p>
        <button type="submit">Save</button>
        <a href="/api/foxes">Back to list</a>
    </p>
</form>

</body>
</html>
