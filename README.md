# JAVA_Todo_app_exercise_01

>## HTML pages

- registration.html
- login.html
- profile.html
- todos.html
- modifyTodo.html

>## HTML navbar
<pre>
USERNAME                                                     Add todo | My todos | Profile
</pre>
>## Entities

- User + DTO

name (form), email (form), password (form), gender (form), bio (editable on profile page), todos

---
- Todo + DTO

title (form), body (form), status, deadline (form), priority (form), createdAt, modifiedAt, user

---
- Priority (enum)

CASUAL, IMPORTANT, URGENT

>## Endpoints

- GET / > /login
- GET /login
- GET /registration
- GET /users/{userId}
- GET /users/{userId}/my-todos
- GET /users/{userId}/todo/{todoId}
- POST /login
- POST /users/add
- POST /users/delete
- POST /todos/add
- POST /todos/delete/{id}

>## REST

- GET /api/todos

>## Tasks

- Use DB

- Hash the user password

- Todo row: priority, title, status, edit

- Indicate priority with a circle (green-casual, yellow-important, red-urgent) at the beginning of each todo's row
