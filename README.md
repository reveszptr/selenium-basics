# Selenium Basics

Java-alapú tesztautomatizálási gyakorlóprojekt, AI segítségével.
A cél a generált kód megértése, ellenőrzése és hibakeresése.

## Eszközök

- Java 21
- Maven 3.9+
- Selenium WebDriver 4.35.0
- JUnit Jupiter 5.13.4
- Google Chrome

Az első futtatás internetkapcsolatot igényel a Maven-függőségekhez,
a Selenium Manager driverletöltéséhez és a gyakorlóoldal eléréséhez.

## Futtatás

A parancsokat a pom.xml fájlt tartalmazó projektmappában futtasd.

    mvn test

Csak a böngészős teszt:

    mvn test "-Dtest=WebFormTest"

Csak az első teszteset:

    mvn test "-Dtest=WebFormTest#shouldAcceptText"

Böngészőablak nélkül:

    mvn test "-Dheadless=true"

Alapértelmezésben látható Chrome-ablak indul, és a teszt végén bezárul.
A teszteredmények a target/surefire-reports mappában találhatók.

## Felépítés

- pom.xml: verziók, függőségek és Maven-beállítások.
- src/test/java/hu/gyakorlas/tests/WebFormTest.java: az első böngészős teszt.
- src/test/java/hu/gyakorlas/AppTest.java: a generált mintateszt, nem UI-ellenőrzés.
- src/main/java/hu/gyakorlas/App.java: a generált mintaprogram.
- Page Object réteg: egy későbbi gyakorlatban választjuk külön.
- docs/lesson-01.md: teszteset, kódmagyarázat és önálló feladat.
- target/: generált fájlok; nem részei a verziókezelt forrásnak.

## Git-munkafolyamat

1. Egy kisebb feladathoz külön branch, például test/web-form-text-input.
2. Tesztkód és a hozzá tartozó dokumentáció módosítása.
3. Helyi tesztfuttatás és git diff ellenőrzése.
4. Célzott fájlok hozzáadása és rövid, tartalmas commitüzenet.
5. Branch feltöltése, pull request és review.
6. Ellenőrzés után összeolvasztás a main branchbe.

Generált riportot, drivert és helyi jelszót nem commitolunk.
Új, ugyanide tartozó teszteset általában új @Test metódus a WebFormTest osztályban.
A tesztek külön böngészőt kapnak, és nem függnek egymás futási sorrendjétől.

## Ellenőrzött futtatás és Windows hibaelhárítás

2026-09-29: Java 21.0.8, Chrome 153, Windows alatt 2 teszt sikeres
(1 generált mintateszt és 1 valódi böngészős teszt).

Ebben a futtatókörnyezetben az alapfuttatás a böngésző indításakor
"Unable to establish loopback connection" / "Invalid argument: connect"
hibával megállt. Projektbeli ideiglenes socket-mappával sikeresen lefutott.

Ha ugyanezt a hibát kapod, Git Bash terminálban:

    mkdir -p target/socket-tmp
    mvn test "-Dheadless=true" "-Djdk.net.unixdomain.tmpdir=target/socket-tmp"

PowerShellben a mappa létrehozása:

    New-Item -ItemType Directory -Path target/socket-tmp -Force

A Java-beállítás csak erre a futtatásra érvényes. Látható böngészőhöz
hagyd el a headless paramétert. A normál, külön terminálból indított
futtatásnál nem feltétlenül szükséges ez a kerülőmegoldás.

Chrome 153 mellett a rögzített Selenium-verzió CDP-verziófigyelmeztetést
adott. A teszt a standard WebDriver műveleteket használja, és sikeresen
lefutott; DevTools/CDP funkciókat ez a gyakorlat nem használ.
