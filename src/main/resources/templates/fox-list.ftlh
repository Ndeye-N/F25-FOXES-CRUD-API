<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>All Foxes</title>
  </head>
  <body>
    <h1>All Foxes</h1>

    <!-- Extra Credit: Search by name -->
    <form action="/api/foxes/search" method="get">
      <input type="text" name="name" placeholder="Search by name">
      <button type="submit">Search</button>
    </form>

    <!-- Extra Credit: Filter by species -->
    <p>
      Filter by species:
      <a href="/api/foxes/category/arctic">Arctic</a> |
      <a href="/api/foxes/category/red">Red</a> |
      <a href="/api/foxes/category/fennec">Fennec</a> |
      <a href="/api/foxes">Clear filter</a>
    </p>

    <!-- Show which filter is active, if any -->
    <#if filter??>
      <p><em>${filter}</em></p>
    </#if>

    <#if foxList?? && (foxList?size > 0)>
      <ul>
        <#list foxList as fox>
          <li>
            <a href="/api/foxes/${fox.animalId}">
              <strong>${fox.name}</strong>
            </a>
            (species: ${fox.species}, age: ${fox.age})

            — <a href="/api/foxes/${fox.animalId}">View</a>
            — <a href="/api/foxes/update/${fox.animalId}">Edit</a>
            — <a href="/api/foxes/delete/${fox.animalId}">Delete</a>
          </li>
        </#list>
      </ul>
    <#else>
      <p>No foxes found.</p>
    </#if>

    <p><a href="/api/foxes/create">Create New Fox</a></p>
  </body>
</html>
