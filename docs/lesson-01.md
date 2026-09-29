# 1. gyakorlat: szövegmező kitöltése

## 1. Teszteset: WF-001

Előfeltétel: a Selenium Web Form oldal elérhető, a Text input szerkeszthető.
Lépések: megnyitás, mező kiürítése, Selenium gyakorlas beírása.
Elvárt eredmény: a mező aktuális értéke pontosan Selenium gyakorlas.
Ez nem az űrlap beküldését vagy az adatok szerveroldali mentését vizsgálja.

## 2. Az oldal és az elem megismerése

Oldal: https://www.selenium.dev/selenium/web/web-form.html
A mező keresése: By.name("my-text").
A locator az elem megkeresésének szabálya.
A Selenium hivatalos első példája ugyanezt a name attribútumot használja:
https://www.selenium.dev/documentation/webdriver/getting_started/first_script/

## 3. Kód olvasása

- @BeforeEach: minden teszt előtt új böngésző.
- driver: a böngészőt vezérlő objektum referenciája.
- @Test: ezt a metódust tesztként futtatja a JUnit.
- driver.get: megnyitja az URL-t.
- WebDriverWait: legfeljebb 10 másodpercig vár a feltétel teljesülésére.
- elementToBeClickable: látható és engedélyezett elemet vár.
- clear: kiüríti a mezőt.
- sendKeys: begépeli a szöveget.
- getDomProperty("value"): kiolvassa a mező aktuális értékét.
- assertEquals: összehasonlítja az elvárt és tényleges értéket.
- @AfterEach: teszthiba esetén is lefut, és bezárja a böngészőt.

Az Arrange előkészít, az Act végrehajt, az Assert ellenőriz.
Input mezőnél a beírt értéket nem a getText() metódussal olvassuk ki.

## 4. AI-kód review

- A megfelelő, my-text nevű mezőt kezeli?
- A böngészőből visszaolvasott értéket hasonlítja az elvárthoz?
- Nincs véletlenül assertEquals(expectedText, expectedText)?
- Minden teszt tiszta böngészőből indul?
- Hibánál is bezárul a böngésző?
- Feltételre vár a kód, nem fix ideig alszik?

## 5. Futtatás és értelmezés

    mvn test "-Dtest=WebFormTest#shouldAcceptText"

PASS: a beírt és visszaolvasott érték egyezik.
Assertion failure: a két érték eltér.
Timeout / driver / hálózati hiba: a futási körülményeket is vizsgálni kell;
nem szabad automatikusan termékhibának tekinteni.

## 6. Saját feladat

Először cseréld az expectedText értékét erre: Árvíztűrő tükörfúrógép 123.
Futtasd újra, és gondold végig, miért várunk továbbra is PASS eredményt.

Utána kizárólag az assertEquals első argumentumát cseréld "Mas szoveg"-re.
A beírást hagyd változatlanul. Most assertion failure az elvárt eredmény.
Ez megmutatja, hogy az ellenőrzés valóban észleli az eltérést.
A gyakorlat után állítsd vissza az expectedText argumentumot.
