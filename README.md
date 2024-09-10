# Style Configurator

Style Configurator to serwis do zarządzania ubraniami oraz strojami, umożliwiający wykonywanie operacji CRUD na obu tych encjach. Serwis korzysta z bazy danych PostgreSQL i jest zaimplementowany przy użyciu Spring Boot oraz Javy 21.

### Spis treści
1. [Wymagania](#wymagania)
2. [Instalacja i uruchomienie](#instalacja-i-uruchomienie)
3.  [Dokumentacja API](#dokumentacja-api)
4. [Stack Technologiczny](#stack-technologiczny)

### Wymagania

Aby uruchomić aplikację lokalnie, potrzebujesz:

- Docker
- Plik .env zawierający dane dostępowe do bazy danych:
```text
POSTGRES_USER=<Twoj użytkownik Postgres>
POSTGRES_PASSWORD=<Twoje hasło do Postgres>
```

### Instalacja i uruchomienie

#### Krok 1: Skonfiguruj środowisko

- Przygotuj plik .env na podstawie struktury przedstawionej powyżej.

#### Krok 2: Uruchom aplikację z Docker Compose
```bash
docker-compose up --build
```
Polecenie to uruchomi bazę danych PostgreSQL oraz serwis aplikacji.

#### Krok 3: Dostęp do aplikacji

Aplikacja domyślnie nasłuchuje na porcie 8080. Po uruchomieniu, dokumentacja OpenAPI będzie dostępna pod adresem:
```http://localhost:8080/swagger-ui.html```

### Dokumentacja API

Pełna dokumentacja API wraz z przykładowymi requestami i odpowiedziami znajduje się w interfejsie Swagger dostępnym pod adresem: http://localhost:8080/swagger-ui.html
### Stack Technologiczny

- Java 21 - Język programowania używany do pisania backendu.
-  Spring Boot - Framework do tworzenia aplikacji backendowej.
- PostgreSQL - Relacyjna baza danych używana do przechowywania danych.
- Hibernate - ORM (Object-Relational Mapping) do mapowania obiektów na tabele w bazie danych.
-	OpenAPI - Narzędzie do dokumentowania i testowania API (dokumentacja dostępna w Swagger).
-	Docker - Używany do konteneryzacji aplikacji oraz bazy danych PostgreSQL.
-	Docker Compose - Narzędzie do definiowania i uruchamiania aplikacji wielokontenerowych.
-	MapStruct - Biblioteka do mapowania obiektów między warstwami aplikacji.
- Flyway - Narzędzie do migracji baz danych, używane do zarządzania schematem bazy danych.
- Lombok - Biblioteka do automatycznego generowania kodu (np. getterów i setterów).
- Jakarta Persistence - Specyfikacja JPA do zarządzania trwałością danych w aplikacji.
