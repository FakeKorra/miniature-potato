# NetGenius Backend

## Student Management API

### Эндпоинты:
- `POST /api/students` — добавление студента (требуется токен).
- `GET /api/students` — получение списка студентов с фильтрацией.
- `GET /api/students/{id}` — получение студента по ID.
- `PUT /api/students/{id}` — обновление данных студента.
- `DELETE /api/students/{id}` — удаление студента.

### Фильтрация (query-параметры для GET /api/students):
- `id` — поиск по ID.
- `fullName` — частичный поиск по ФИО.
- `groupName` — поиск по группе.
- `enrollmentDate` — поиск по дате зачисления.

### Аутентификация:
- `POST /auth/sign-in` — получение JWT-токена.
- `POST /auth/sign-up` — регистрация пользователя.