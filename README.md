# Java-Klausur: Programmieren 

Lösungen zur Klausur „Programmieren(Java)“ mit sechs Aufgaben zu Datentypen, Kontrollstrukturen, Arrays, Klassen, Vererbung und einer Denkaufgabe.

## Aufgaben und Lösungen

| Paket | Aufgabe | Hauptdatei |
|---|---|---|
| `aufgabe1` | Datentypen und Operatoren | `Main.java` |
| `aufgabe2` | Kontrollstrukturen (FizzBuzz) | `FizzBuzz.java` |
| `aufgabe3` | Arrays und Schleifen (`findMax`) | `ArrayUtils.java`, `Main.java` |
| `aufgabe4` | Klassen und Objekte (`Car`) | `Car.java`, `Main.java` |
| `aufgabe5` | Vererbung und Polymorphie (`ElectricCar`) | `ElectricCar.java`, `Main.java` |
| `aufgabe6` | Die Unlösbare (`Mystery.decode`) | `Mystery.java` |

### Aufgabe 1: Antworten auf die Fragen

**1. Unterschied zwischen `int` und `Integer`**

- `int` ist ein primitiver Datentyp. Er speichert den Wert direkt, kann nie `null` sein und ist schneller und speicherschonender.
- `Integer` ist die zugehörige Wrapper-Klasse. Ein `Integer` ist ein Objekt, kann `null` sein, hat Methoden (z. B. `compareTo`, `equals`) und wird dort gebraucht, wo Objekte verlangt sind, etwa in Collections wie `List<Integer>`.
- Java wandelt beide Typen automatisch ineinander um (Autoboxing und Unboxing).
- Bei `Integer` vergleicht `==` die Referenzen, nicht die Werte. Werte von -128 bis 127 kommen aus einem Cache, größere nicht. Deshalb gilt: Integer-Objekte immer mit `equals` vergleichen.

**2. Ergebnis von `double result = a / b;` mit `a = 5` und `b = 2`**

Das Ergebnis ist `2.0`, nicht `2.5`. Da `a` und `b` beide `int` sind, wird zuerst eine Ganzzahldivision ausgeführt: `5 / 2 = 2` (der Nachkommaanteil entfällt). Erst danach wird das Ergebnis `2` in `double` umgewandelt. Für `2.5` muss vor der Division umgewandelt werden: `(double) a / b`.

### Aufgabe 2: Kontrollstrukturen (FizzBuzz)

## Aufgabenstellung
Schreiben Sie ein Java-Programm, das die Zahlen von 1 bis 100 ausgibt.

- Jede durch 3 teilbare Zahl wird durch `Fizz` ersetzt.
- Jede durch 5 teilbare Zahl wird durch `Buzz` ersetzt.
- Jede durch 3 **und** 5 teilbare Zahl wird durch `FizzBuzz` ersetzt.

## Projektstruktur
```
FizzBuzz/
├── README.md
└── src/
    └── aufgabe2/
        └── FizzBuzz.java
```

## Lösungsidee
Die Klasse `FizzBuzz` besteht aus zwei Methoden:

- `convert(int zahl)` liefert die Ausgabe für eine einzelne Zahl. Mit dem Modulo-Operator (`%`) wird die Teilbarkeit geprüft. Die Prüfung auf 15 (also 3 und 5 zugleich) steht bewusst **zuerst**, da sonst bei 15 nur `Fizz` ausgegeben würde.
- `main(String[] args)` durchläuft mit einer `for`-Schleife die Zahlen 1 bis 100 und gibt das Ergebnis von `convert` jeweils in einer eigenen Zeile aus.

Verwendete Kontrollstrukturen: `for`-Schleife, `if`-Anweisungen.

## Kompilieren und Ausführen
Voraussetzung: JDK 8 oder neuer.

Im Projektordner `FizzBuzz`:
```bash
javac -d out src/aufgabe2/FizzBuzz.java
java -cp out aufgabe2.FizzBuzz
```

## Erwartete Ausgabe (Auszug)
```
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
...
98
Fizz
Buzz
```
Insgesamt werden 100 Zeilen ausgegeben (27 × `Fizz`, 14 × `Buzz`, 6 × `FizzBuzz`, 53 Zahlen).

### Aufgabe 3: Leeres Array

Die Methode `findMax` gibt `int` zurück und kann deshalb keinen „kein Ergebnis“-Wert liefern. Bei einem leeren (oder `null`-)Array wirft sie eine `IllegalArgumentException`.

### Aufgabe 4: Klassen und Objekte (20 Punkte)

## Aufgabenstellung

Erstellen Sie eine Klasse `Car` mit folgenden Eigenschaften:

- Marke (`String`)
- Baujahr (`int`)
- aktueller km-Stand (`int`)

Die Klasse soll:

- einen Konstruktor besitzen,
- eine Methode `void drive(int km)` besitzen, die den km-Stand erhöht,
- eine Methode `String toString()` besitzen, die eine Beschreibung des Autos zurückgibt.

## Projektstruktur

```
aufgabe4/
├── Car.java    # Klasse Car
└── Main.java   # Testprogramm
```

## Lösung

### Klasse `Car`

| Element | Beschreibung |
|---|---|
| `marke` (`private final String`) | Marke des Autos, nach der Erzeugung unveränderlich |
| `baujahr` (`private final int`) | Baujahr des Autos, nach der Erzeugung unveränderlich |
| `kmStand` (`private int`) | Aktueller Kilometerstand, veränderbar über `drive` |
| `Car(String, int, int)` | Konstruktor, setzt alle drei Eigenschaften und prüft die Eingaben |
| `void drive(int km)` | Erhöht den km-Stand um die gefahrenen Kilometer |
| `String toString()` | Liefert eine Beschreibung des Autos |
| `getMarke()`, `getBaujahr()`, `getKmStand()` | Getter für lesenden Zugriff |

### Eingabeprüfung

Ungültige Werte führen zu einer `IllegalArgumentException`:

- Die Marke darf nicht `null` oder leer sein.
- Das Baujahr muss mindestens 1886 sein (Jahr des ersten Automobils).
- Der km-Stand darf nicht negativ sein.
- Die Kilometer bei `drive` dürfen nicht negativ sein.

### Designentscheidungen

- **Kapselung:** Alle Attribute sind `private`, der Zugriff erfolgt über Methoden.
- **Unveränderlichkeit:** `marke` und `baujahr` sind `final`, da sie sich im Laufe des Autolebens nicht ändern. Nur der km-Stand ist veränderbar.
- **Validierung im Konstruktor:** Es können keine Objekte mit ungültigem Zustand entstehen.

## Kompilieren und Ausführen

Im Verzeichnis oberhalb des Ordners `aufgabe4`:

```bash
javac aufgabe4/*.java
java aufgabe4.Main
```

## Beispielausgabe

```
Marke: VW, Baujahr: 2019, km-Stand: 45000 km
Nach 250 km: Marke: VW, Baujahr: 2019, km-Stand: 45250 km
```

## Voraussetzungen

- Java 11 oder höher (wegen `String.isBlank()`)

### Aufgabe 5: Batterie

Die Aufgabe nennt das Attribut `batteryCapacity` (in kWh) und verlangt in `toString()` den „Batteriestand“. Umgesetzt ist die Ausgabe der Batteriekapazität in kWh.

### Aufgabe 6: Die Unlösbare 

## Aufgabenstellung

Gegeben sei der folgende Code-Schnipsel:

```java
public class Mystery {
    public static void main(String[] args) {
        String code = decode("9-1-2-?");
        System.out.println(code);
    }

    public static String decode(String input) {
        // TODO: Implementieren Sie die Methode so,
        // dass das korrekte Wort ausgegeben wird.
    }
}
```

**Hinweis:** Die Methode `decode` soll aus einer geheimen Zahlenfolge ein Wort erzeugen. Wie genau die Umwandlung funktioniert, ist Teil der Aufgabe. Die Zahlenfolge enthält eine unbekannte Stelle (`?`), deren Bedeutung nicht direkt ersichtlich ist. Finden Sie eine sinnvolle Lösung.

## Projektstruktur

```
Mystery.java    # Klasse Mystery mit main und decode
```

## Lösungsidee

Jede Zahl steht für die Position eines Buchstabens im Alphabet:

| Zahl | 1 | 2 | 3 | ... | 9 | ... | 26 |
|---|---|---|---|---|---|---|---|
| Buchstabe | A | B | C | ... | I | ... | Z |

Die Methode `decode` arbeitet in drei Schritten:

1. Der Eingabestring wird an den Trennzeichen `-` zerlegt.
2. Jedes Teilstück wird in einen Buchstaben umgewandelt (`'A' + zahl - 1`).
3. Teilstücke, die keine gültige Zahl von 1 bis 26 sind (z. B. `?`), werden als `?` ins Ergebnis übernommen.

### Behandlung der unbekannten Stelle

Die Stelle `?` kann nicht entschlüsselt werden, weil sie keine Zahl enthält. Sie wird deshalb nicht geraten, sondern im Ergebnis als `?` markiert. Das Programm stürzt dabei nicht ab, da `NumberFormatException` abgefangen wird.

### Eingabeprüfung

- `null` oder ein leerer String ergibt einen leeren String.
- Zahlen außerhalb von 1 bis 26 werden als `?` markiert.
- Leerzeichen um die Zahlen werden mit `trim()` entfernt.

## Ergebnis

Für `"9-1-2-?"` gibt das Programm aus:

```
IAB?
```

### Warum die Aufgabe „unlösbar" ist

Mit der Zuordnung A = 1 ergibt `9-1-2` die Buchstaben `IAB`. Dafür gibt es keinen Buchstaben als vierte Stelle, der ein sinnvolles deutsches oder englisches Wort ergibt. Auch andere Zuordnungen führen zu keinem Wort:

- A = 0 ergibt `JBC?`
- Umgekehrtes Alphabet (A = 26) ergibt `RZY?`

Die Aufgabe lässt sich also nicht eindeutig lösen. Die Lösung zeigt deshalb eine nachvollziehbare Umwandlung und einen robusten Umgang mit der unbekannten Stelle.

## Kompilieren und Ausführen

```bash
javac Mystery.java
java Mystery
```

## Voraussetzungen

- Java 11 oder höher (wegen `String.isBlank()`)

## Ausführen

Voraussetzung: JDK 11 oder neuer.

```
./run.sh
```

Oder einzeln, z. B. Aufgabe 3:

```
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out aufgabe3.Main
```

## Technologien

- Java (JDK 11+)
