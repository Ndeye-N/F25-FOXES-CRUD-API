<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Foxes</title></head>
<body>
  <h1>All Foxes</h1>

  <#-- foxList is set in the controller: model.addAttribute("foxList", ...) -->
  <#if foxList?? && (foxList?size > 0)>
    <ul>
      <#list foxList as fox>
        <li>
          <strong>${fox.name}</strong>
          (species: ${fox.species!""}, age: ${fox.age!""})
          — <a href="/api/foxes/${fox.id!fox.animalId!fox.foxId}">View</a>
        </li>
      </#list>
    </ul>
  <#else>
    <p>No foxes found.</p>
  </#if>

  <p><a href="/api/foxes/create">Create New Fox</a></p>
</body>
</html>
