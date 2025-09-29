# Dokumentation

## Arbeitsprozesse

### Wöchentliches Meeting

- Kurze Vorbereitung vor dem Meeting 
  - Probleme bei Aufgaben
  - Stand der Arbeit
  - Evtl. Aufgabenstellung von den nächsten stories im Backlog lesen
- Jeden Montag 08:30

***Ablauf***:
- Kurze Runde zum Stand der Laufenden Stories / Max. 5min
- Besprechen und Zeitschätzung von Stories im Backlog (Umfang: Sicherstellen, dass es genung zu tun gibt für den Tag) / Max. 20min anderenfalls folge Termin

### Kanban

Unser Kanban Board hat folgende Stati:
- Backlog
- ToDo
- In progress
- In review
- Done
- Always Do

***Backlog***
Im Backlog sind alle unsere Stories die wir zu beginn des Moduls erstellt haben. Diese sind noch nicht geschätzt oder in Sub-Stories aufgeteilt worden

***ToDo***
In der ToDo Spalte sind alle Stories die wir an diesem Tag erledigen wollen. Die Stories sind geschätzt und wurden falls nötig in Sub-Stories aufgeteilt

***In Progress***
Hier befinden sich alle Aufträge die wir gerade am erarbeiten sind.

***In Review***
Nach der Umsetzung kommen Aufträge in Review und werden nochmals von anderen Teammitgliedern angeschaut. Die Abnahme von Code Aufträgen soll über Github PRs stattfinden. Bei Theorie Aufträgen soll sich in den Kommmentaren der Task im Kanban ausgetauscht werden.

***Done***
Der Auftrag ist erledigt.

Definition of Done:
- mindestens 2. Teammitglieder haben das Endresultät angeschaut und das ok gegeben.

***Always Do***
Hier sind hauptsächlich Dokumentations Aufträge die wir über die gesamte Projektdauer ausführen müssen.


## Infrastruktur
Für die Verwaltung unseres Projekts haben wir uns für Github entschieden. Ebenfalls verwenden wir das Kanban-Board sowie CI/CD features (Github Actions) von Github.

## Technologie auswahl
Wir haben uns entschieden die beiden Microservices mit Java Spring-Boot zu entwickeln, da sich alle in unserem Team mit Java auskennen.

## Branching Strategie / Semantic Versioning

### Branches
- Main
- Feature Branches
- Bug Branches
  
![alt text](Images/Branching.png)
Legend:
- main = Blau
- feature = Gelb
- bugfix = Rot
---

***Main Branch***

Der Main Branch ist die sogenannte "Single source of truth" und soll zu jeden Zeitpunkt fehlerfrei laufen. 

Vom Main Branch aus werden Pipelines gestartet.

***Feature Branches***

Für jedes neue Feature / Funktionalität wird ein Feature Branch erstellt. Diese Branches sind kurzlebig und dienen nur zur entwicklung dieses Features. Nach implementierung des Features wird der Branch wieder gelöscht.

Naming:

- Feature Branches kommmen in einen Feature Ordner. 
- Die Feature Branches sollen aus der Nummer und Titel des Auftrags bestehen. 

Schema:
```
feature/{Auftrag Nr.}-{Auftrag Titel}
```

Beispiel: 
```
feature/P2-Micro-Service-Entwickeln
```

***Bug Branches***

Für Fehlverhalten von Code oder anderes werden Bug Branches erstellt. Wie die Feature Branches sind die Bug Branches ebenfalls kurzlebig und dienen nur als Hilfmittel für die Entwicklung. Nach Behebung eines Bugs soll der Branch wieder gelöscht werden.

Naming:

- Bug Branches kommmen in einen Bug Ordner. 
- Der Name eines Bug Branch soll den Bug beschreiben.

Schema:
```
bug/{Name-des-Bugs}
```

Beispiel: 
```
bug/micro-service-not-responding
```

### Merge Requests

Um auf den Main Branch pushen zu könnnen muss ein Merge Request erstellt werden. Dieser muss von einem anderen Teammitglied angeschaut und bestätigt werden.

### Versioning
Wir verwenden MAJOR.MINOR.PATCH in Verbindung mit GitHub Flow.


| Versionsteil | Bedeutung | Beispiel |
|--------------|-----------|----------|
| MAJOR |	Breaking Changes |	2.0.0 |
| MINOR |	Neue Features, abwärtskompatibel |	1.1.0 |
| PATCH |	Kleine Bugfixes |	1.0.1 |
 
 
***Beispiel Workflow***
 
- Feature Branch: feature/P2_1_readAirport → MR → Merge in Main → Version 1.1.0
 
- Bug im Login entdeckt → bugfix/readAirport-error → MR → Merge → Version 1.1.1
 
- Grosse Änderung am Backend → Breaking Change → Merge → Version 2.0.0

# 1. CI Technologien evaluieren

## Untersuchte Werkzeuge

### 1. GitHub Actions
**Vorteile:**
- Voll in GitHub integriert, keine extra Installation nötig
- Einfache Einrichtung von Workflows
- Kostenlose Minuten für öffentliche Repositories
- Viele fertige Actions für Build, Test und Deployment

**Nachteile:**
- Begrenzte kostenlose Minuten für private Repositories
- Weniger flexibel bei sehr komplexen Infrastrukturen
- Dokumentation teilweise unübersichtlich

### 2. GitLab CI
**Vorteile:**
- Voll integriert in GitLab
- Sehr flexibel mit eigenen Runnern
- Gute Unterstützung für komplexe Pipelines
- Alle Tools für CI und Repository Management in einem System

**Nachteile:**
- Einrichtung eigener Runner kann komplex sein
- Weniger bekannt, weniger fertige Templates im Vergleich zu GitHub Actions

### 3. Jenkins
**Vorteile:**
- Extrem flexibel und anpassbar
- Riesige Community und viele Plugins
- Funktioniert mit allen SCM Systemen

**Nachteile:**
- Komplexe Installation und Wartung
- UI wirkt veraltet und teilweise unübersichtlich
- Eigenes Hosting notwendig

## Entscheidung für das Projekt
Für dieses Projekt werden **GitHub Actions** verwendet. Der Grund ist, dass das Projekt-Repository bereits auf GitHub liegt. GitHub Actions lässt sich einfach einrichten, erlaubt automatische Builds und Tests bei jedem Commit oder Pull Request und benötigt keine eigene Infrastruktur. Die kostenlose Nutzung reicht für das Projekt vollkommen aus.

# Pipeline-Vergleich: Alle Tasks in einem Job vs. Aufteilung in Build & Test

| Kriterium        | Variante A: Alles in einem Job | Variante B: Getrennte Jobs (Build & Test) |
|------------------|-------------------------------|-------------------------------------------|
| **Laufzeit**     | Additiv (Build + Tests nacheinander) | Effizienter, da Tests parallel laufen können |
| **Übersicht**    | Weniger, alle Logs in einem Job | Klar getrennt, pro Job eigenes Log |
| **Fehlererkennung** | Unklarer – Build-/Testfehler im selben Log | Sehr klar – Build- oder Testfehler sofort sichtbar |
| **Komplexität**  | Einfach, wenig Setup nötig | Etwas komplexer (Artefakte, Dependencies) |
| **Eignung**      | Kleine Projekte, PoCs | Mittlere/grosse Projekte, Teamarbeit |

---

### Fazit
- **Variante A**: Schnell eingerichtet, gut für kleine Projekte.  
- **Variante B**: Langfristig die bessere Wahl → mehr Übersicht, parallele Tests, bessere Fehlerdiagnose.  

## Umsetzung der CI-Pipeline

Basierend auf unserer Evaluation haben wir uns für eine Pipeline mit getrennten Jobs für Tests und Builds entschieden (Variante B). Die Pipeline ist so konfiguriert, dass sie für unsere beiden Microservices (`airport-service` und `flight-service`) parallel ausgeführt wird, um Effizienz und Übersichtlichkeit zu gewährleisten.

### Zweck und Trigger

Die Pipeline verfolgt zwei Hauptziele:
1.  **Qualitätssicherung**: Bei jedem Push wird sichergestellt, dass alle Unit Tests erfolgreich sind.
2.  **Automatisierung**: Das manuelle Bauen der Applikation entfällt. Nach erfolgreichen Tests wird automatisch ein lauffähiges Artefakt (JAR-Datei) erstellt.

Die Pipeline wird automatisch unter folgenden Bedingungen gestartet:
* Bei einem **Push** auf den `main`-Branch oder einen `feature/*`-Branch.
* Bei einem **Pull Request**, der auf den `main`-Branch abzielt.
* **Wichtig**: Der Start erfolgt nur, wenn Änderungen in einem der Service-Verzeichnisse (`Code/airport-service/**` oder `Code/flight-service/**`) vorliegen. Änderungen an der Dokumentation lösen keinen Build aus.

### Aufbau und Jobs

Unsere Pipeline besteht aus zwei sequenziellen Phasen, die jeweils parallel für beide Services laufen:

#### 1. Job: `test` (Unit Tests)
Dieser Job ist für die Validierung des Codes zuständig.
-   **Name:** `Unit Tests (<service-name>)`
-   **Aufgaben:**
    -   Checkt den Code aus dem Repository aus.
    -   Richtet die korrekte Java-Version (JDK 21) ein.
    -   Führt den Gradle-Task `test` aus, um alle Unit Tests des jeweiligen Services zu starten.
    -   Erstellt einen **Test Report**, der direkt im Pull Request sichtbar ist, um Fehler schnell zu identifizieren.
    -   Lädt die detaillierten Test-Coverage-Reports als **Artefakt** hoch, damit sie bei Bedarf analysiert werden können.

#### 2. Job: `build` (Build Application)
Dieser Job wird erst ausgeführt, nachdem der `test`-Job für den entsprechenden Service erfolgreich war (`needs: test`).
-   **Name:** `Build Application (<service-name>)`
-   **Aufgaben:**
    -   Führt den Gradle-Task `build` aus, überspringt dabei aber die Tests (`-x test`), da diese bereits im vorherigen Job validiert wurden.
    -   Nutzt den **Gradle-Cache**, um wiederholte Builds deutlich zu beschleunigen.
    -   Benennt die erstellte JAR-Datei dynamisch um, sodass sie den Service-Namen und den kurzen Commit-Hash enthält (z.B. `airport-service-a1b2c3d.jar`).
    -   Speichert die fertige JAR-Datei als **Artefakt** (`application-jar-<service-name>`), damit sie für manuelle Tests oder zukünftige Deployment-Schritte heruntergeladen werden kann.
    -   Gibt eine Zusammenfassung der Build-Informationen (JAR-Grösse, Commit, Build-Zeit) im GitHub-Workflow-Log aus.

### Wichtige Merkmale

| Merkmal                  | Umsetzung und Begründung                                                                                                                                                       |
| :----------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Multi-Service-Handling** | Wir verwenden eine **Matrix-Strategie** (`strategy: matrix`). Dadurch werden die `test`- und `build`-Jobs für jeden Service in der Liste (`airport-service`, `flight-service`) parallel gestartet. Das ist skalierbar und schnell. |
| **Effizienz** | Durch die Nutzung des integrierten **Gradle-Cachings** (`cache: 'gradle'`) werden Abhängigkeiten zwischen den Pipeline-Läufen zwischengespeichert, was die Build-Zeiten erheblich verkürzt.       |
| **Transparenz** | Die Test-Reports von `dorny/test-reporter` werden direkt in Pull Requests angezeigt. Fehlerhafte Tests sind so sofort ersichtlich, ohne die Logs durchsuchen zu müssen.           |
| **Nachvollziehbarkeit** | Alle erstellten Artefakte (Test-Reports, JAR-Dateien) werden für eine bestimmte Zeit gespeichert und können bei Bedarf heruntergeladen und inspiziert werden.                        |


## Systemtests – Airport & Flight APIs

### Tool
- **Postman**: Erstellung und Ausführung der Tests

### Getestete Endpunkte & Tests

#### Airport API
- **POST /airports**
  - Statuscode 200 prüfen
  - Response enthält ID
  - Airport-Code korrekt grossgeschrieben (3 Grossbuchstaben)
- **GET /airports**
  - Statuscode 200 prüfen
  - Response ist ein Array
  - Jedes Objekt hat ID und Code
  - Name und Capacity vorhanden und gültig

#### Flight API
- **POST /flights**
  - Statuscode 200 prüfen
  - Response enthält ID
  - Departure- und Arrival-Airport korrekt gesetzt
  - Abflug- und Ankunftszeit korrekt gesetzt
  - AircraftType korrekt gesetzt
  - Optional: ID für weitere Tests speichern
- **GET /flights**
  - Statuscode 200 prüfen
  - Response ist ein Array
  - Jede Flug-Entität hat eine ID
  - Departure- und Arrival-Airport-Code korrekt formatiert (3 Grossbuchstaben)

### Pipeline-Integration
- Postman-Collection kann mit **Newman** in CI/CD eingebunden werden
- Dynamische IDs werden über Environment-Variablen gehandhabt
- End-to-End-Szenarien werden nach jedem Build automatisch geprüft


Für unsere Flight- und Airport-APIs wurden folgende Systemtests eingebunden:

### Tools
- **Postman**: zur Erstellung und Ausführung der API-Tests

### Endpunkte getestet
- **POST /airports**: Neuen Flughafen erstellen
- **GET /airports**: Alle Flughäfen abrufen
- **POST /flights**: Neuen Flug erstellen
- **GET /flights**: Alle Flüge abrufen

### Testinhalte
- Statuscodes prüfen (200 OK, 400 Bad Request)
- Response-Felder prüfen:
  - IDs vorhanden
  - Codes korrekt formatiert (z. B. 3 Grossbuchstaben)
  - Zeiten gültig (Abflug vor Ankunft, in der Zukunft)
  - Name und Kapazität korrekt gesetzt
- Fehlerfälle prüfen:
  - Ungültige Daten → BadRequest
  - Identische Abflugs- und Ankunftsflughäfen → BadRequest

### Pipeline-Integration
- Postman-Collection kann mit **Newman** in CI/CD-Pipeline eingebunden werden
- Tests prüfen End-to-End-Szenarien automatisch nach jedem Build
- Dynamische IDs werden über Environment-Variablen gehandhabt, um Abhängigkeiten zwischen Tests zu vermeiden

# CI-Integration und Event-Strategie

## Übersicht

Die CI-Pipeline ist eng mit unserer Branching-Strategie verzahnt. Dieser Abschnitt beschreibt detailliert, welche Events und Branches die automatisierten Prozesse auslösen und warum diese Entscheidungen getroffen wurden.

## Event-Trigger und Branch-Konfiguration

### Trigger-Übersicht

| Event | Branches | Zweck |
|-------|----------|-------|
| **Push** | `main`, `feature/*`, `bug/*` | Sofortige Validierung bei Code-Änderungen |
| **Pull Request** | Target: `main` | Qualitätssicherung vor dem Merge |

### Push Events

**Ausgelöste Branches:**
- `main`: Der produktive Branch muss immer getestet werden
- `feature/*`: Entwickler erhalten sofortiges Feedback während der Feature-Entwicklung
- `bug/*`: Bugfixes werden validiert, bevor sie in den Main-Branch gelangen

**Begründung:**
- Entwickler sollen **während** der Entwicklung Feedback bekommen, nicht erst beim Pull Request
- Frühes Erkennen von Fehlern spart Zeit und verhindert fehlerhafte Merges
- Der Main-Branch wird zusätzlich abgesichert

**Path-Filter:**
Die Pipeline läuft nur bei Änderungen in:
- `Code/airport-service/**`
- `Code/flight-service/**`

**Begründung:**
- Dokumentationsänderungen (z.B. README, docs/) sollen keinen Build auslösen
- Spart CI-Minuten und beschleunigt den Workflow
- Entwickler werden nicht durch unnötige Builds gestört

### Pull Request Events

**Target Branch:** `main`

**Begründung:**
- Letzte Qualitätskontrolle vor dem Merge
- Test-Reports werden direkt im Pull Request angezeigt
- Reviewer sehen sofort, ob alle Tests erfolgreich sind
- Verhindert, dass fehlerhafter Code in den Main-Branch gelangt

**Warum nur `main` als Target?**
- Feature-zu-Feature Merges sind selten in unserem Workflow
- Alle wichtigen Merges gehen in den Main-Branch
- Reduziert die Komplexität der Pipeline

## Branch-spezifisches Verhalten

### Main Branch

**Status:** Protected Branch

**CI-Verhalten:**
- ✅ Pipeline läuft bei jedem Push
- ✅ Pipeline läuft bei jedem eingehenden Pull Request
- ✅ Build-Artefakte werden gespeichert (30 Tage Retention)

**Besonderheiten:**
- Direktes Pushen ist **nicht** erlaubt (Branch Protection Rules)
- Nur über genehmigte Pull Requests möglich
- CI muss erfolgreich sein, bevor Merge möglich ist

### Feature Branches

**Lebenszyklus:** Kurzlebig

**CI-Verhalten:**
- ✅ Pipeline läuft bei jedem Push
- ✅ Entwickler erhält sofortiges Feedback
- ✅ Test-Reports werden als Artefakte gespeichert (7 Tage)
- ✅ JAR-Dateien werden gebaut, falls Tests erfolgreich sind

**Workflow:**
1. Branch wird von `main` erstellt: `feature/P2-Micro-Service-Entwickeln`
2. Entwickler macht Commits → Pipeline läuft automatisch
3. Bei Fehlern: Entwickler kann sofort reagieren
4. Pull Request nach `main` → Finale Validierung
5. Nach Merge: Branch wird gelöscht

### Bug Branches

**Lebenszyklus:** Sehr kurzlebig

**CI-Verhalten:**
- ✅ Pipeline läuft bei jedem Push
- ✅ Schnelle Validierung, ob Bug behoben ist
- ✅ Gleiche Tests wie bei Feature Branches

**Workflow:**
1. Bug wird entdeckt
2. Branch wird erstellt: `bug/micro-service-not-responding`
3. Bugfix wird implementiert
4. CI validiert, dass Tests wieder erfolgreich sind
5. Pull Request → Merge → Branch löschen

## Pipeline-Phasen und deren Zweck

### Phase 1: Unit Tests (`test` Job)

**Wann:** Immer als erstes

**Zweck:**
- Sicherstellen, dass der Code funktional korrekt ist
- Frühes Feedback bei Fehlern
- Verhindert unnötige Build-Prozesse bei fehlerhaften Tests

**Parallel-Strategie:**
- Beide Services (`airport-service`, `flight-service`) werden **gleichzeitig** getestet
- Spart Zeit (5 Min. statt 10 Min.)
- `fail-fast: false` sorgt dafür, dass beide Services getestet werden, auch wenn einer fehlschlägt

### Phase 2: Build Application (`build` Job)

**Wann:** Nur wenn Tests erfolgreich waren (`needs: test`)

**Zweck:**
- Erstellt lauffähige Artefakte (JAR-Dateien)
- Validiert, dass der Build-Prozess funktioniert
- Stellt deploybare Artefakte bereit

**Dependency:**
- `needs: test` verhindert unnötige Builds bei fehlerhaften Tests
- Spart CI-Minuten und gibt klares Feedback

## Optimierungen und Best Practices

### Caching-Strategie

**Gradle Cache:**
```yaml
cache: 'gradle'
```

**Effekt:**
- Dependencies werden zwischen Builds wiederverwendet
- Erste Build: ~5-7 Min
- Nachfolgende Builds: ~2-3 Min
- Spart ~50% der Build-Zeit

### Matrix-Strategie

**Konfiguration:**
```yaml
strategy:
  fail-fast: false
  matrix:
    service: [airport-service, flight-service]
```

**Vorteile:**
- Beide Services werden parallel getestet/gebaut
- Klare Trennung in den Logs
- Skalierbar: Neuer Service? Einfach zur Matrix hinzufügen

**`fail-fast: false`:**
- Beide Services werden immer getestet, auch wenn einer fehlschlägt
- Entwickler sieht alle Fehler auf einmal, nicht nur den ersten

### Timeout-Konfiguration

**Test Job:** 15 Minuten
**Build Job:** 20 Minuten

**Begründung:**
- Verhindert, dass hängende Jobs CI-Minuten verschwenden
- Normale Builds sollten deutlich schneller sein (5-10 Min.)
- Bei Timeout: Hinweis auf Problem im Code oder der Infrastruktur

## Artefakt-Management

### Test Reports

**Retention:** 7 Tage

**Zweck:**
- Detaillierte Analyse von Testfehlern
- Coverage-Reports für Code-Qualität
- Historische Vergleiche möglich

**Zugriff:**
- Download über Actions-Tab
- Automatisch im Pull Request sichtbar (via `dorny/test-reporter`)

### JAR-Dateien

**Retention:** 30 Tage

**Naming:** `<service>-<commit-hash>.jar`
- Beispiel: `airport-service-a1b2c3d.jar`

**Zweck:**
- Manuelle Tests der gebauten Anwendung
- Vorbereitung für zukünftiges Deployment (CD)
- Versionierung über Commit-Hash

## Monitoring und Feedback

### Erfolgreiche Builds

**Feedback-Kanäle:**
1. ✅ Grünes Häkchen im Actions-Tab
2. ✅ GitHub Notification (wenn aktiviert)
3. ✅ Status im Pull Request (wenn applicable)
4. ✅ Build-Summary mit Details (JAR-Grösse, Build-Zeit)

### Fehlerhafte Builds

**Feedback-Kanäle:**
1. ❌ Rotes Kreuz im Actions-Tab
2. ❌ GitHub Notification mit Fehlerdetails
3. ❌ Blockierter Pull Request
4. ❌ Test-Report zeigt fehlgeschlagene Tests

**Workflow bei Fehlern:**
1. Entwickler erhält Notification
2. Öffnet Actions → Klickt auf fehlerhaften Lauf
3. Identifiziert fehlerhaften Job/Service
4. Öffnet Logs und analysiert Fehler
5. Behebt Fehler lokal
6. Pusht Fix → Pipeline läuft erneut

## Branching-Strategie: Integration mit CI

### Flow-Diagramm

```
main (immer grün)
  ↑
  └─ Pull Request (CI muss grün sein)
      ↑
      └─ feature/* oder bug/* (CI läuft bei jedem Push)
```

### Regeln und Konventionen

1. **Main Branch Protection:**
    - Direktes Pushen von Code verboten
    - Pull Request erforderlich
    - CI muss erfolgreich sein
    - Mindestens 1 Approval erforderlich

2. **Feature/Bug Branches:**
    - CI läuft bei jedem Push
    - Entwickler kann selbstständig iterieren
    - Keine Approvals nötig während Entwicklung

3. **Pull Requests:**
    - CI läuft automatisch
    - Test-Reports direkt sichtbar
    - Merge nur möglich bei grüner CI
