# Selenium Basics

Gyakorlóprojekt Java-alapú webes tesztautomatizáláshoz.

A tesztek a [Selenium Web Form](https://www.selenium.dev/selenium/web/web-form.html) oldalán futnak. Jelenleg egy szövegmező kitöltését és értékének ellenőrzését tartalmazza.

## Eszközök

- Java 21
- Maven
- Selenium WebDriver
- JUnit 5
- Google Chrome

## Futtatás

A projekt gyökérmappájából, ahol a `pom.xml` található:

```bash
mvn test
```

Csak az űrlap tesztjeinek futtatása:

```bash
mvn test "-Dtest=WebFormTest"
```

Az első futtatáskor a szükséges függőségek és a böngésződriver letöltése időt vehet igénybe.

## Mappák

- `src/test/java`: tesztek
- `src/main/java`: a projektgeneráláskor létrejött mintaprogram
- `target`: generált fájlok és teszteredmények

A tesztfuttatás riportjai a `target/surefire-reports` mappában találhatók.