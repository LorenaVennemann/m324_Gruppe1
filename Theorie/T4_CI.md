# Continuous Integration

## 1. Was ist Continuous Integration (CI) und wie wird es umgesetzt?

Continuous Integration (CI) ist eine DevOps-Praxis in der Softwareentwicklung, bei der Entwickler ihre Codeänderungen regelmässig in ein zentrales Repository integrieren und diese automatisiert erstellen und testen. Das Ziel ist, Fehler und Konflikte frühzeitig zu erkennen und zu beheben, die Produktqualität zu steigern und den Entwicklungsprozess zu beschleunigen.

![Was ist CI/CD](./Images/Was%20ist%20CI_CD_%20Continuous%20Integration%20und%20Continuous%20Delivery%20erklärt.png)

### Welche Bedeutung hat Continuous Integration im Softwareentwicklungsprozess?

Continuous Integration bedeutet, dass Entwickler Änderungen häufig in ein gemeinsames Repository mergen, jeder Merge startet automatisch Build und Tests. So werden Fehler früh erkannt, Integrationsprobleme reduziert und Releases schneller sowie zuverlässiger.

### Welche technischen Prozesse und Werkzeuge ermöglichen eine erfolgreiche Implementierung von CI?

Erfolgreiche CI braucht klare Prozesse (Versionskontrolle & Branching, automatisierte Builds, automatisierte Tests, statische Analyse/Quality Gates, Artefakt-/Dependency-Management, Caching/Parallelisierung, Benachrichtigungen) und passende Werkzeuge (CI-Dienste, Build-/Test-/Qualitäts- und Container-Tools).

### Welche Rolle spielt CI in der Automatisierung und Zusammenarbeit in Teams?

CI automatisiert Builds, Tests und Code-Checks bei jedem Merge. Das gibt sofortiges Feedback, macht Probleme früh sichtbar, erzwingt gemeinsame Standards (Branching, Quality Gates) und fördert kurze, häufige Änderungen. Ergebnis: weniger Merge-Konflikte, weniger Handarbeit, bessere Team-Abstimmung und schnellere, stabilere Releases.

### Vertiefung

CI wirkt wie ein gemeinsamer, automatisierter Qualitätsfilter: Jede Änderung durchläuft dieselbe Pipeline (Build, Tests, Quality Gates), vereinheitlicht Standards und reduziert Handarbeit. Durch kurze Branches/Trunk-Based Development und transparente Pipeline-Ergebnisse (Status, Logs) sinken Merge-Konflikte und die Abstimmung im Team wird schneller und klarer.

***Anwendungsbeispiele***

- Pull-Request Gates
- Preview-Umgebungen
- Geteilte Pipeline-Vorlagen

***Typische Anwendung und Steuerung im Projekt***

- Feature-Branch mit PR-Gate
- Release-/Promotion-Pipeline

*Quellen*:
- [crowdstrike](https://www.crowdstrike.com/de-de/cybersecurity-101/cloud-security/continuous-integration-continuous-delivery-ci-cd/#:~:text=Was%20ist%20kontinuierliche%20Integration?,mehrerer%20Entwickler%20regelm%C3%A4%C3%9Fig%20zusammengef%C3%BChrt%20wird)
- [martinfowler](https://martinfowler.com/articles/continuousIntegration.html)

## 2 Was sind die Vor- und Nachteile von CI?

### Vorteile von CI

- Neue Änderungen werden sofort geprüft, Fehler werden schnell gefunden und behoben.
- Fehler werden schneller entdeckt und behoben, weil jede Codeänderung automatisch getestet wird.
- Konflikte zwischen Entwicklerinnen und Entwicklern werden reduziert, da alle Änderungen regelmässig zusammengeführt werden.
- Die Anwendung bleibt stabil, da durch automatisierte Tests sichergestellt wird, dass neue Änderungen keine Probleme verursachen.
- Teams arbeiten effizienter, weil man nicht mehr auf einen „Merge Day“ warten muss und die Arbeitsschritte automatisiert sind.
- Updates können schneller bereitgestellt werden, was auch schnelleres Feedback von Nutzern ermöglicht.

### Nachteile / Herausforderungen von CI

- Hoher Aufwand am Anfang, weil automatische Tests und Abläufe eingerichtet werden müssen.
- Organisatorische Disziplin nötig, damit alle Entwicklerinnen und Entwickler regelmässig ihren Code integrieren.
- Abhängigkeit von gut funktionierenden Tests, sonst werden Fehler nicht zuverlässig erkannt.
- Technische Komplexität, besonders wenn viele Entwickler gleichzeitig an verschiedenen Codezweigen arbeiten.
- Kosten und Zeit, da es anfänglich viel Aufwand und Ressourcen erfordert, die CI-Pipeline richtig aufzubauen.

### Einfluss auf Produktqualität und Workflow

- CI verbessert langfristig die Produktqualität, weil Fehler früh erkannt und behoben werden.
- Der Workflow im Team wird effizienter, da Änderungen regelmässig integriert und automatisch getestet werden.

*Quellen*:
- [redhat](https://www.redhat.com/de/topics/devops/what-is-ci-cd)
- [exwe](https://www.exwe.de/de/news/softwareentwicklung/was-ist-continuous-integration-vorteile-herausforderungen-und-tools-im-ueberblick/)
- [mindtwo](https://www.mindtwo.ch/lexicon/continuous-integration-continuous-deployment-cicd)

## 3. Was ist Continuous Testing, und wie wird es umgesetzt?

### Definition und Umsetzung

Continuous Testing (CT) ist ein Ansatz im Software testing, bei dem automatisierte Tests kontinuierlich während des gesamten Softwareentwicklungslebenszyklus (SDLC) ausgeführt werden, um frühzeitig Feedback zur Qualität zu geben und die Bereitstellung hochwertiger Software zu beschleunigen. Im Gegensatz zu sporadischen Tests wird CT in CI/CD-Pipelines integriert, sodass Tests bei jedem Code-Commit, Build oder Deployment laufen. Die Umsetzung erfolgt durch Automatisierung von Testfällen mit Tools wie Selenium, JUnit oder TestSigma, die in DevOps-Umgebungen wie Jenkins oder GitHub Actions eingebunden werden. Dies ermöglicht eine *Shift-Left-Testing*-Strategie, bei der Tests früh im Zyklus platziert werden, um Fehler schnell zu erkennen.

![Continuous%20Testing](./Images/Continuous%20Testing_%20Effizienzsteigerung%20durch%20Automatisierung%20und%20KI%20—%20Finbridge%20GmbH%20&%20Co%20KG.png)

### Unterschied zu traditionellen Testmethoden

Traditionelle Testmethoden, wie im Wasserfall-Modell, führen Tests phasenweise durch z.B. nur am Ende der Entwicklung oder in separaten QA-Phasen, was zu Verzögerungen und höheren Kosten bei Fehlern führt. CT hingegen ist proaktiv und kontinuierlich, integriert Tests in den Entwicklungsprozess und nutzt Automatisierung für schnelles Feedback. Während traditionelle Tests oft manuell oder batch-basiert sind, läuft CT automatisiert und parallel zur Entwicklung, was den Fokus von "Testen am Ende" zu "Testen von Anfang an" verlagert. Dies reduziert Wartezeiten und verbessert die Agilität, birgt aber die Herausforderung, Tests skalierbar zu halten.  

### Rolle im Entwicklungszyklus

CT spielt eine zentrale Rolle, indem es Qualitätssicherung in jeden Schritt des Entwicklungszyklus einbettet. Es unterstützt DevOps-Prinzipien, indem es automatisierte Feedback-Loops schafft, die Entwickler ermächtigen, Codeänderungen sofort zu validieren. Dadurch wird die Time-to-Market verkürzt und Risiken minimiert, da Defekte früh erkannt werden. In agilen Teams fördert CT die Zusammenarbeit zwischen Entwicklern, Testern und Ops-Teams.  

### Automatisierte Tests und Effektivität

Typischerweise werden folgende Tests automatisiert:  

- **Unit-Tests**: Für einzelne Komponenten.  
- **Integrationstests**: Für Systeminteraktionen.  
- **UI-Tests**: Z. B. mit Selenium für Benutzeroberflächen.  
- **Performance-Tests** und **Sicherheit-Tests**.  

Effektivität wird durch Metriken wie Testabdeckung, Fehlerrate und Ausführungszeit sichergestellt, oft mit Tools wie SonarQube für Code-Qualität oder durch Flaky-Test-Management. Regelmässige Reviews und AI-gestützte Testoptimierung helfen, False Positives zu reduzieren.  

### Zusätzliche Ausführungen

- *Vertiefung*: In der Praxis wird CT oft mit Containerisierung (z. B. Docker) kombiniert, um Testumgebungen reproduzierbar zu machen. Beispiel: Bei einem Commit triggert Jenkins Unit-Tests, und bei Erfolg folgen Integrationstests.  
- *Gegenüberstellung*: Im Vergleich zu traditionellem Testing (z. B. manuelle Regressionstests) spart CT Zeit (bis zu 50 % kürzere Zyklen), erfordert aber höhere Initialinvestitionen in Automatisierung.  
- *Anwendungsbeispiele*: Bei Netflix wird CT verwendet, um Microservices kontinuierlich zu testen, was zu schnelleren Releases führt. Herausforderung: Skalierung bei grossen Test-Suiten kann Ressourcen belasten, gelöst durch Cloud-Testing (z. B. AWS).

*Quellen*: 
[TestSigma](https://testsigma.com),
[PubNub](https://www.pubnub.com),
[TestRail](https://www.testrail.com),
[Global App Testing](https://www.globalapptesting.com),
[LaunchDarkly](https://launchdarkly.com)

## 4. Was ist eine Branching-Strategie, und welches sind die bekanntesten Ansätze?

### Definition und Bedeutung

Eine Branching-Strategie definiert, wie Branches in einem Versionskontrollsystem wie Git erstellt, verwaltet und merged werden, um parallele Entwicklung zu ermöglichen und Konflikte zu minimieren. Sie ist essenziell für die Organisation von Codeänderungen und die Koordination in Teams, da sie die Versionskontrolle strukturiert, Konflikte reduziert und die Nachverfolgbarkeit von Änderungen gewährleistet. Ohne Strategie kann Chaos durch unkontrollierte Merges entstehen, was die Code-Stabilität gefährdet.  

![Branching-Strategien](./Images/Branching-Strategien%20im%20praktischen%20Einsatz%20_%20DWX%20Developer%20World.png)

### Einfluss auf Code-Organisation und Arbeitsfluss

Verschiedene Strategien beeinflussen die Code-Organisation: Langlaufende Branches (z. B. in GitFlow) ermöglichen isolierte Features, können aber Merge-Konflikte verursachen. Kurze Branches (z. B. Trunk-Based) fördern schnelle Integration und verbessern den Workflow durch häufige Merges, was Agilität steigert, aber Disziplin erfordert.  

### Bekannte Branching-Strategien

- **GitFlow**: Nutzt Hauptbranche wie `master`/`develop`, Feature-, Release- und Hotfix-Branches. Ideal für versionierte Releases; komplex und anfällig für Merge-Konflikte.  
- **GitHub Flow**: Einfacher, mit `main`-Branch und kurzen Feature-Branches; fokussiert auf Pull Requests für schnelle Integration.  
- **Trunk-Based Development (TBD)**: Alle Änderungen gehen direkt in den Trunk (`main`); kurze Branches für schnelle Merges, minimiert Konflikte.  

*Unterschiede*: GitFlow ist strukturiert für große Projekte, TBD agil für CI/CD, GitHub Flow balanciert.  

| Strategie   | Vorteile                         | Nachteile                     | Geeignet für              |
|-------------|----------------------------------|-------------------------------|---------------------------|
| GitFlow     | Hohe Struktur, Versionskontrolle | Komplex, Merge-Konflikte      | Release-basierte Projekte |
| GitHub Flow | Einfach, schnell                 | Weniger für komplexe Releases | Agile Teams mit CI        |
| Trunk-Based | Minimale Konflikte, CI-Fokus     | Erfordert Disziplin           | Hochskalierbare DevOps    |

### Zusätzliche Ausführungen
- *Vertiefung*: In mobiler Entwicklung (z. B. iOS/Android) eignet sich TBD für schnelle Iterationen, da App-Stores Releases verzögern.  
- *Gegenüberstellung*: GitFlow vs. TBD: Ersteres schützt Stabilität durch Isolation, Letzteres priorisiert Geschwindigkeit, was in CI/CD-Umgebungen (z. B. bei Google) überwiegt.  
- *Anwendungsbeispiele*: Bei Atlassian wird GitFlow für Jira verwendet, um Features isoliert zu entwickeln. Herausforderung: In großen Teams kann TBD zu "Branch Hell" führen, wenn nicht mit Feature Flags kombiniert.

*Quellen*: 
[LaunchDarkly](https://launchdarkly.com),
[GitProtect](https://gitprotect.io),
[Statsig](https://statsig.com),
[AB Tasty](https://www.abtasty.com),
[Martin Fowler](https://martinfowler.com)

## 5. Wie kann man Commits und Branches mit User Storys verknüpfen?

### Sinn der Verknüpfung

Commits und Branches können mit User Storys (z. B. aus Agile-Methoden) verknüpft werden, indem Issue-IDs (z. B. JIRA-Tickets) in Commit-Messages oder Branch-Namen eingebettet werden, um Traceability zu schaffen. Dies ist sinnvoll, da es Transparenz schafft, Änderungen nachverfolgbar macht und Teams hilft, Fortschritt zu tracken. Es verbessert die Zusammenarbeit und erleichtert Audits.  

### Praktiken und Namenskonventionen
- **Praktiken**: Issue-ID in Commits (z. B. "Fix bug [JIRA-123]") und Branches (z. B. `feature/JIRA-123-new-login`).  
- **Konventionen**: "type/scope/issue-id-description" (z. B. `feat/ui/JIRA-456-add-button`). Smart Commits in Tools automatisieren Status-Updates.  

### Tool-Unterstützung
Tools wie Jira integrieren mit GitHub/Bitbucket via Apps, die Commits/PRs automatisch mit Issues linken. Z. B. GitHub for Jira syncs Branches und triggert Workflows.  

### Zusätzliche Ausführungen

- *Vertiefung*: In Scrum-Teams hilft dies, Sprint-Ziele zu tracken; z. B. ein Commit "closes JIRA-789" schließt das Ticket automatisch.  
- *Gegenüberstellung*: Manuelle vs. automatisierte Linking: Letzteres spart Zeit, reduziert Fehler.  
- *Anwendungsbeispiele*: Bei SAP-Projekten linkt GitHub Commits zu Jira, um Dashboards zu aktualisieren. Herausforderung: Inkonsistente Naming kann zu Fehllinks führen, gelöst durch Hooks.

*Quellen*: 
[Medium](https://medium.com),
[Atlassian](https://www.atlassian.com),
[Idalko](https://www.idalko.com),
[SAP Community](https://community.sap.com),
[Stack Overflow](https://stackoverflow.com)

## 6. Welche Merge-Strategien gibt es, und wann werden sie verwendet?

### Ansätze zur Integration

Merge-Strategien in Git definieren, wie Änderungen aus einem Branch in einen anderen integriert werden, z. B. via `git merge` mit Optionen:  

- **Fast-Forward**: Einfache Vorlauf-Merge.  
- **Recursive**: Für Konflikte.  
- **Squash**: Zusammenfassen zu einem Commit.  
- **Rebase**: Lineare Historie.  
- **Ours/Subtree**: Spezialisiert.  

### Einfluss auf Historie und Nachvollziehbarkeit  

- Fast-Forward: Behält lineare Historie (hohe Nachverfolgbarkeit).  
- Squash: Vereinfacht Historie (weniger Details).  
- Rebase: Rewrite Historie (sauber, aber verliert Kontext).  
- Recursive: Erstellt Merge-Commits (erhöht Traceability).  

### Wann welche Strategie?

- Fast-Forward: Bei linearen Changes ohne Divergenz.  
- Recursive: Bei Konflikten.  
- Squash: Für saubere Historie in Features.  
- Rebase: Für lineare Logs in agilen Teams.  
- Ours: Ignoriert Changes bei Konflikten.  

### Zusätzliche Ausführungen

- *Vertiefung*: In PRs auf GitHub wählt man Squash für kleine Features, um Noise zu reduzieren.  
- *Gegenüberstellung*: Rebase vs. Merge: Rebase sauberer, aber gefährlich bei shared Branches (kann Historie umschreiben).  
- *Anwendungsbeispiele*: Bei DNSimple wird Squash für 2 Jahre verwendet, um Historie zu vereinfachen. Herausforderung: Rebase kann zu Konflikten führen, gelöst durch interaktives Rebase.

**Quellen**: 
[GeeksforGeeks](https://www.geeksforgeeks.org),
[Graphite](https://graphite.dev),
[DEV Community](https://dev.to),
[Stack Overflow](https://stackoverflow.com),
[Atlassian](https://www.atlassian.com)

## 7. Was ist Semantic Versioning, und wie wird es eingesetzt?

Semantic Versioning ist ein einfaches und weit akzeptiertes Schema zur Versionierung von Software, das aus drei Teilen besteht: MAJOR.MINOR.PATCH. Jede Komponente hat eine spezielle Bedeutung:

- **MAJOR**: Erhöht sich bei inkompatiblen Änderungen (Breaking Changes)
- **MINOR**: Erhöht sich bei abwärtskompatiblen neuen Funktionen
- **PATCH**: Erhöht sich bei abwärtskompatiblen Fehlerbehebungen 

![Semantic%20Versioning%20(SemVer).png](./Images/Semantic%20Versioning%20(SemVer).png)

### Einsatz

SemVer wird genutzt, um Entwicklern und Nutzern die Art und Auswirkung von Software-Updates klar zu kommunizieren. Es erleichtert Abhängigkeitsmanagement und Risikominimierung in Projekten.  

**Beispiele**:  

- 1.0.0: Erste stabile Version.  
- 1.1.0: Neue abwärtskompatible Funktion.  
- 1.1.1: Bugfix.  
- 2.0.0: Breaking Change, z. B. API-Änderung.  

### Wie hilft Semantic Versioning bei der Verwaltung von Software-Versionen?

*Schnelle Orientierung*: Entwickler und Nutzer können sofort erkennen, ob ein Update kritisch ist oder nur kleinere Verbesserungen enthält.
 
*Abhängigkeitsmanagement*: Bei Projekten mit Bibliotheken (z. B. NPM-Paketen) kann man zuverlässig prüfen, ob Updates kompatibel sind.
 
*Risikominimierung*: Durch klare Trennung von Breaking Changes, neuen Funktionen und Bugfixes wird das Risiko, dass Software nach Updates kaputtgeht, reduziert.
 
*Automatisierung*: Versionsnummern können in CI/CD-Pipelines automatisch gesetzt werden, z. B. mit Tools wie Semantic Release.

### Welche Konventionen werden bei Semantic Versioning angewendet?

- **Drei-Zahlen-Schema**: MAJOR.MINOR.PATCH (z. B. 1.2.3)
- **MAJOR-Version**: Erhöht bei Breaking Changes (z. B. 1.2.3 → 2.0.0)
- **MINOR-Version**: Erhöht bei neuen, abwärtskompatiblen Funktionen (z. B. 1.2.3 → 1.3.0)  
- **PATCH-Version**: Erhöht bei abwärtskompatiblen Bugfixes (z. B. 1.2.3 → 1.2.4)
- **Prä-Releases**: Optional mit Suffix wie `-beta` (z. B. 1.3.0-beta.1).  
- **Build-Metadaten**: Optional mit `+` (z. B. 1.3.0+build2025)

### Warum ist Semantic Versioning wichtig für die Kompatibilität und Kommunikation von Änderungen?

- **Kompatibilität**: SemVer zeigt, ob ein Update abwärtskompatibel ist oder bestehende Implementierungen bricht.  
- **Kommunikation**: Klare Versionsnummern fördern die Abstimmung zwischen Entwicklern, Testern und Nutzern.  
- **Planung**: Nutzer können Updates priorisieren (z. B. PATCH sofort, MAJOR nach Tests).  
- **Integration**: In großen Projekten (z. B. Microservices) hilft SemVer, Abhängigkeiten zu koordinieren.  

### Zusätzliche Ausführungen

- *Vertiefung*: In Open-Source-Projekten ermöglicht SemVer Nutzern, Updates gezielt einzusetzen, ohne Implementierungen zu gefährden.  
- *Gegenüberstellung*: Ohne SemVer fehlt die Transparenz, was zu unerwarteten Fehlern führt.  
- *Anwendungsbeispiele*: Bei Frameworks wie React zeigt SemVer (z. B. 16.0.0 → 17.0.0), ob eine Migration erforderlich ist. Herausforderung: Teams müssen SemVer diszipliniert anwenden, um Vertrauen zu schaffen.  

### Vertiefung
 
**Anwendungsbeispiele:**

- *Bibliotheken / Frameworks*: Entwickler erkennen sofort, ob ein Update riskant ist oder direkt genutzt werden kann.
- *Open-Source-Projekte*: Nutzer können Updates gezielt einsetzen, ohne dass bestehende Implementierungen kaputtgehen.
- *CI/CD-Pipelines*: Automatisierte Releases können die SemVer-Konventionen einhalten, z. B. durch Tools wie Semantic Release.

**Quellen**:  
[Compuart](https://www.compuart.com/blog/2023/semantic-versioning-warum-es-entwickler-nutzen-und-anwender-kennen-sollten),
[Mindtwo](https://www.mindtwo.ch/blog/semantic-versioning-semver),
[Dev.to](https://dev.to/disane/semantic-versioning-ein-leitfaden-fur-entwickler-3ibj)  

## 8. Welchen Unterschied haben Mono- und Multirepo-Ansätze im Kontext von Microservices?
 
### Mono-Repo

Alle Microservices liegen in einem einzigen Repository. Der gesamte Code für alle Services ist also zusammen gespeichert.
 
### Multi-Repo

Jeder Microservice hat sein eigenes Repository. Jeder Service wird separat verwaltet.

![Monorepo%20VS%20Polyrepo%20-%20DEV%20Community.png](./Images/Monorepo%20VS%20Polyrepo%20-%20DEV%20Community.png)
 
### Wie unterscheiden sich Mono- und Multirepo-Ansätze in der Organisation von Code?

*Mono-Repo*: Ein grosser Ordner enthält alle Projekte. Änderungen können leicht übergreifend gemacht werden.
 
*Multi-Repo*: Jeder Service ist unabhängig. Teams arbeiten an ihrem eigenen Repository.
 
### Welche Vor- und Nachteile haben beide Ansätze speziell für die Entwicklung und Wartung von Microservices? 

*Mono-Repo Vorteile*:

- Einfacher Überblick über alle Services
- Gemeinsame Code-Standards und Tests einfacher umzusetzen
 
*Mono-Repo Nachteile*:

- Sehr Gross und Komplex
- Updates oder Builds dauern länger
 
*Multi-Repo Vorteile*:

- Jeder Service ist unabhängig
- Teams können schneller arbeiten ohne Konflikte
 
*Multi-Repo Nachteile*:

- Koordinationen zwischen Services schwieriger
- Gemeinsame Änderungen müssen manuell in allen Repos gemacht werden.
 
### Wie beeinflussen die Ansätze die Skalierbarkeit, Zusammenarbeit und Abhängigkeiten zwischen Teams?

*Mono-Repo*: Gut für große Teams, die eng zusammenarbeiten. Abhängigkeiten zwischen Services sind sichtbar und einfacher zu verwalten.
 
*Multi-Repo*: Gut, wenn Teams unabhängig arbeiten. Skalierung einzelner Services ist leichter, aber Koordination wird aufwendiger.
 
### Vertiefung

*Praxisbeispiel*:
Ein E-Commerce-Unternehmen hat mehrere Microservices: Warenkorb, Zahlung, Versand.
 
*Mono-Repo*: Alle Services liegen zusammen. Entwickler können sofort sehen, wenn eine Änderung im Zahlungsservice den Versandservice beeinflusst.
 
*Multi-Repo*: Jeder Service ist separat. Das Warenkorb-Team kann unabhängig deployen, ohne dass das Zahlungsteam warten muss, aber Änderungen, die mehrere Services betreffen, müssen sorgfältig koordiniert werden.
 
**Quellen**:
[infomaniak](https://news.infomaniak.com/de/multirepo-vs-microservices/),
[kinsta](https://kinsta.com/de/blog/monorepo-vs-multi-repo/),
[dev](https://dev.to/dayal/monorepo-vs-multirepo-managing-codebases-in-modular-architectures-f3b)

## 9. Was ist ein Artifact-Repository, und welche Aufgaben erfüllt es?
 
Ein Software-Artefakt-Repository ist ein zentrales Speichersystem, das in der Softwareentwicklung verwendet wird, um alle softwarebezogenen Artefakte zu verwalten und zu speichern. Dazu gehören kompilierter Code, Bibliotheken, Abhängigkeiten, Konfigurationsdateien, Dokumentation und Build-Ergebnisse. Es stellt sicher, dass diese Artefakte leicht zugänglich, versionskontrolliert und über alle Phasen des Softwareentwicklungszyklus hinweg nachverfolgbar sind.

![Was%20ist%20Artifactory_%20_%20JFrog.png](./Images/Was%20ist%20Artifactory_%20_%20JFrog.png)

### Welche Rolle spielt ein Artifact-Repository in der Softwareentwicklung und im Bereitstellungsprozess?

Artefakte sind die Grundlage der Softwareentwicklung. Sie dienen als Orientierung für Entwickler und helfen, Workflows, Wartung und Fehlerbehebung zu verbessern. Außerdem machen sie es möglich, verschiedene Produktversionen und Eigenschaften nachzuvollziehen.

### Welche Arten von Artefakten werden typischerweise in einem Repository verwaltet?
 
In einem Artefakt-Repository werden typischerweise kompilierte Programme und Bibliotheken, externe Abhängigkeiten, Konfigurationsdateien und Dokumentation gespeichert. Außerdem finden sich dort Build-Ergebnisse wie Installer oder Archive, Container-Images für die Bereitstellung, Skripte zur Automatisierung und Protokolle, die beim Entwickeln oder Überwachen entstehen.
 
### Warum ist ein Artifact-Repository wichtig für CI/CD-Pipelines?
 
Es ist sehr wichtig, da es als zentrale, versionierte Quelle für Builder-Artefakte dient, die für die Bereitstellung in verschiedenen Umgebungen benötigt werden.
 
**Quellen**:  
[JFrog](https://jfrog.com/de/learn/devops/software-artifact-repository/),
[JetBrains](https://www.jetbrains.com/de-de/teamcity/ci-cd-guide/concepts/artifact-repository/),
[TeamHub](https://teamhub.com/blog/understanding-the-role-of-an-artifact-repository-in-software-development/#:~:text=The%20Basics%20of%20Artifact%20Repositories,integration%2C%20and%20continuous%20delivery%20practices.)