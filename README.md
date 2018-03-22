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

## Opis 

Na podstawie podanej kwoty inwestycji, podanych funduszy i stylu inwestowania aplikacja automawycznie dzieli podaną kwotę na podane wundusze zgodnie ze zdefiniowanym stylem inwestowania.

Przykład 1

Kwota inwestycji: 10 001 PLN<br />
Styl inwestowania: bezpieczny (bezpieczny - 20% Polskie, 75% Zagraniczne, 5% Pieniężne)<br />

Wybrane fundusze:<br />
1 Polskie, Fundusz Polski 1<br />
2 Polskie, Fundusz Polski 2<br />
3 Zagraniczne, Fundusz Zagraniczny 1<br />
4 Zagraniczne, Fundusz Zagraniczny 2<br />
5 Zagraniczne, Fundusz Zagraniczny 3<br />
6 Pieniężn,e Fundusz Pieniężny 1<br />

Wynik:<br />
1 Polskie, Fundusz Polski 1, 1000 PLN, 10%<br />
2 Polskie, Fundusz Polski 2, 1000 PLN, 10%<br />
3 Zagraniczne, Fundusz Zagraniczny 1, 2500 PLN, 25%<br />
4 Zagraniczne, Fundusz Zagraniczny 2, 2500 PLN, 25%<br />
5 Zagraniczne, Fundusz Zagraniczny 3, 2500 PLN, 25%<br />
6 Pieniężne, Fundusz Pieniężny 1, 500 PLN, 5%<br />
<br />
Kwota nieprzydzielona 1.<br />
