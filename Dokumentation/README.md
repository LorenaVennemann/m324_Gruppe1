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
