# Invest fund calculator

- Aplikacja do wyliczania kwot dla funduszy inwestycyjnych

## Technologie

- spring-boot (DI, IOC)
- spring-boot-starter-web (tomcat, restowe endpoint)
- spring-boot-starter-data-jpa (repozytoria JPA do przechowywania danych o sposobie inwestowania i funduszach)
- h2 database (baza na potrzeby uruchomienia)
- java 8 
- swagger (do automatycznego generowania UI na potrzeby uruchomienia)

## Opis działania

- Endpoint POST /fund służy do dodawania funduszy
- Endpoint GET /fund służy do pobrania listy zdefinowanych funduszy
- Endpoint GET /investStyle służy do pobrania listy zdefinowanych sposobów inwestowania
- Endpoint POST /invest służy do wyliczenia kwot dla poszczególnych funduszy, wymaga podania kwoty, id funduszy, 
i stylu inwestowania. Fundusze i style inwestowania muszą znajdować się wśród wcześniej zdefinowanych.
W odpowiedzi zwraca: kwote inwestycji rozdzielona pomiędzy wybrane fundusze oraz kwota nieprzydzielona.

## Uruchomienie 

- uruchomić main w klasie InvestApplication
- użyć polecenia maven spring-boot:run

pod adresem http://localhost:2829/swagger-ui.html będzie znajdować sie UI do wołania ww endpointów (UI wygenerowany przy pomocy swagger)
