# GitHub API Task

## Opis

Aplikacja realizuje zadanie rekrutacyjne polegające na pobraniu informacji o publicznych repozytoriach użytkownika GitHub.
Została stworzona w oparciu o Java 21 oraz Spring Boot 3.5, zgodnie z wymaganiami zadania.

## Funkcjonalności

- Endpoint `GET /repositories/{username}`:
    - Zwraca listę publicznych repozytoriów danego użytkownika GitHub.
    - Dla każdego repozytorium zwracane są:
        - `repositoryName`
        - `ownerLogin`
        - `branches` - lista zwracająca:
            - `branchName`
            - `lastCommitSha`

- Obsługa błędów:
  - `404 Not Found` - jeśli użytkownik nie istnieje.

## Wymagania

- Java 21
- Maven
- Spring Boot 3.5+

 ## Uruchomianie
 1. Sklonuj repozytorium:
    ```bash
    git clone https://github.com/DemoN2k20/githubapi.git
    cd githubapi
3. Zbuduj projekt:
   ```bash
   mvn clean install
5. Uruchom aplikację:
   ```bash
   mvn spring-boot:run
7. Wywołanie przykładowego endpointu:
   ```bash
   GET http://localhost:8080/repositories/octocat

## Testowanie

Aby uruchomić testy integracyjne:
   ```bash
   mvn test

W projekcie znajduje się jeden test integracyjny obejmujący tzw. happy path, napisany bez użycia mocków.

## Założenia
- Nie obsługuję paginacji (ani w API GitHub, ani w endpointzie)
- Nie używam WebFlux
- Nie wprowadzam architektury DDD and hexagonalnej
- Implementuję wyłącznie to, co zawarto w treści zadania
- Brak nadmiarowego kodu - skupienie na minimalnym rozwiązaniu

## Autor
Daria Pavlenko

Zadanie wykonane w ramach rekrutacji
