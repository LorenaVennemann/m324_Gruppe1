# Continuous Integration

## 1 & 2

tbd

## 3. Was ist Continuous Testing, und wie wird es umgesetzt?

**Definition und Umsetzung**  
Continuous Testing (CT) ist ein Ansatz im Softwaretesting, bei dem automatisierte Tests kontinuierlich während des gesamten Softwareentwicklungslebenszyklus (SDLC) ausgeführt werden, um frühzeitig Feedback zur Qualität zu geben und die Bereitstellung hochwertiger Software zu beschleunigen. Im Gegensatz zu sporadischen Tests wird CT in CI/CD-Pipelines integriert, sodass Tests bei jedem Code-Commit, Build oder Deployment laufen. Die Umsetzung erfolgt durch Automatisierung von Testfällen mit Tools wie Selenium, JUnit oder TestSigma, die in DevOps-Umgebungen wie Jenkins oder GitHub Actions eingebunden werden. Dies ermöglicht eine *Shift-Left-Testing*-Strategie, bei der Tests früh im Zyklus platziert werden, um Fehler schnell zu erkennen.

**Unterschied zu traditionellen Testmethoden**  
Traditionelle Testmethoden, wie im Wasserfall-Modell, führen Tests phasenweise durch z.B. nur am Ende der Entwicklung oder in separaten QA-Phasen, was zu Verzögerungen und höheren Kosten bei Fehlern führt. CT hingegen ist proaktiv und kontinuierlich, integriert Tests in den Entwicklungsprozess und nutzt Automatisierung für schnelles Feedback. Während traditionelle Tests oft manuell oder batch-basiert sind, läuft CT automatisiert und parallel zur Entwicklung, was den Fokus von "Testen am Ende" zu "Testen von Anfang an" verlagert. Dies reduziert Wartezeiten und verbessert die Agilität, birgt aber die Herausforderung, Tests skalierbar zu halten.  

**Rolle im Entwicklungszyklus**  
CT spielt eine zentrale Rolle, indem es Qualitätssicherung in jeden Schritt des Entwicklungszyklus einbettet. Es unterstützt DevOps-Prinzipien, indem es automatisierte Feedback-Loops schafft, die Entwickler ermächtigen, Codeänderungen sofort zu validieren. Dadurch wird die Time-to-Market verkürzt und Risiken minimiert, da Defekte früh erkannt werden. In agilen Teams fördert CT die Zusammenarbeit zwischen Entwicklern, Testern und Ops-Teams.  

**Automatisierte Tests und Effektivität**  
Typischerweise werden folgende Tests automatisiert:  
- **Unit-Tests**: Für einzelne Komponenten.  
- **Integrationstests**: Für Systeminteraktionen.  
- **UI-Tests**: Z. B. mit Selenium für Benutzeroberflächen.  
- **Performance-Tests** und **Sicherheits-Tests**.  
Effektivität wird durch Metriken wie Testabdeckung, Fehlerrate und Ausführungszeit sichergestellt, oft mit Tools wie SonarQube für Code-Qualität oder durch Flaky-Test-Management. Regelmäßige Reviews und AI-gestützte Testoptimierung helfen, False Positives zu reduzieren.  

**Zusätzliche Ausführungen**  
- *Vertiefung*: In der Praxis wird CT oft mit Containerisierung (z. B. Docker) kombiniert, um Testumgebungen reproduzierbar zu machen. Beispiel: Bei einem Commit triggert Jenkins Unit-Tests, und bei Erfolg folgen Integrationstests.  
- *Gegenüberstellung*: Im Vergleich zu traditionellem Testing (z. B. manuelle Regressionstests) spart CT Zeit (bis zu 50% kürzere Zyklen), erfordert aber höhere Initialinvestitionen in Automatisierung.  
- *Anwendungsbeispiele*: Bei Netflix wird CT verwendet, um Microservices kontinuierlich zu testen, was zu schnelleren Releases führt. Herausforderung: Skalierung bei großen Test-Suiten kann Ressourcen belasten, gelöst durch Cloud-Testing (z. B. AWS).

*Quellen*: 
[TestSigma](https://testsigma.com)
[PubNub](https://www.pubnub.com)
[TestRail](https://www.testrail.com)
[Global App Testing](https://www.globalapptesting.com) 
[LaunchDarkly](https://launchdarkly.com)

## 4. Was ist eine Branching-Strategie, und welches sind die bekanntesten Ansätze?

**Definition und Bedeutung**  
Eine Branching-Strategie definiert, wie Branches in einem Versionskontrollsystem wie Git erstellt, verwaltet und gemerged werden, um parallele Entwicklung zu ermöglichen und Konflikte zu minimieren. Sie ist essenziell für die Organisation von Codeänderungen und die Koordination in Teams, da sie die Versionskontrolle strukturiert, Konflikte reduziert und die Nachverfolgbarkeit von Änderungen gewährleistet. Ohne Strategie kann Chaos durch unkontrollierte Merges entstehen, was die Code-Stabilität gefährdet.  

**Einfluss auf Code-Organisation und Arbeitsfluss**  
Verschiedene Strategien beeinflussen die Code-Organisation: Langlaufende Branches (z. B. in GitFlow) ermöglichen isolierte Features, können aber Merg-Konflikte verursachen. Kurze Branches (z. B. Trunk-Based) fördern schnelle Integration und verbessern den Workflow durch häufige Merges, was Agilität steigert, aber Disziplin erfordert.  

**Bekannte Branching-Strategien**  
- **GitFlow**: Nutzt Hauptbranches wie `master`/`develop`, Feature-, Release- und Hotfix-Branches. Ideal für versionierte Releases; komplex und anfällig für Merge-Konflikte.  
- **GitHub Flow**: Einfacher, mit `main`-Branch und kurzen Feature-Branches; fokussiert auf Pull Requests für schnelle Integration.  
- **Trunk-Based Development (TBD)**: Alle Änderungen gehen direkt in den Trunk (`main`); kurze Branches für schnelle Merges, minimiert Konflikte.  
*Unterschiede*: GitFlow ist strukturiert für große Projekte, TBD agil für CI/CD, GitHub Flow balanciert.  

| Strategie       | Vorteile                          | Nachteile                     | Geeignet für                     |
|-----------------|-----------------------------------|-------------------------------|----------------------------------|
| GitFlow         | Hohe Struktur, Versionskontrolle  | Komplex, Merge-Konflikte      | Release-basierte Projekte        |
| GitHub Flow     | Einfach, schnell                  | Weniger für komplexe Releases  | Agile Teams mit CI               |
| Trunk-Based     | Minimale Konflikte, CI-Fokus      | Erfordert Disziplin           | Hochskalierbare DevOps           |

**Zusätzliche Ausführungen**  
- *Vertiefung*: In mobiler Entwicklung (z. B. iOS/Android) eignet sich TBD für schnelle Iterationen, da App-Stores Releases verzögern.  
- *Gegenüberstellung*: GitFlow vs. TBD: Ersteres schützt Stabilität durch Isolation, Letzteres priorisiert Geschwindigkeit, was in CI/CD-Umgebungen (z. B. bei Google) überwiegt.  
- *Anwendungsbeispiele*: Bei Atlassian wird GitFlow für Jira verwendet, um Features isoliert zu entwickeln. Herausforderung: In großen Teams kann TBD zu "Branch Hell" führen, wenn nicht mit Feature Flags kombiniert.

*Quellen*: 
[LaunchDarkly](https://launchdarkly.com)
[GitProtect](https://gitprotect.io)
[Statsig](https://statsig.com)
[AB Tasty](https://www.abtasty.com)
[Martin Fowler](https://martinfowler.com)

## 5. Wie kann man Commits und Branches mit User Stories verknüpfen?

**Sinn der Verknüpfung**  
Commits und Branches können mit User Stories (z. B. aus Agile-Methoden) verknüpft werden, indem Issue-IDs (z. B. JIRA-Tickets) in Commit-Messages oder Branch-Namen eingebettet werden, um Traceability zu schaffen. Dies ist sinnvoll, da es Transparenz schafft, Änderungen nachverfolgbar macht und Teams hilft, Fortschritt zu tracken. Es verbessert die Zusammenarbeit und erleichtert Audits.  

**Praktiken und Namenskonventionen**  
- **Praktiken**: Issue-ID in Commits (z. B. "Fix bug [JIRA-123]") und Branches (z. B. `feature/JIRA-123-new-login`).  
- **Konventionen**: "type/scope/issue-id-description" (z. B. `feat/ui/JIRA-456-add-button`). Smart Commits in Tools automatisieren Status-Updates.  

**Tool-Unterstützung**  
Tools wie Jira integrieren mit GitHub/Bitbucket via Apps, die Commits/PRs automatisch mit Issues linken. Z. B. GitHub for Jira syncs Branches und triggert Workflows.  

**Zusätzliche Ausführungen**  
- *Vertiefung*: In Scrum-Teams hilft dies, Sprint-Ziele zu tracken; z. B. ein Commit "closes JIRA-789" schließt das Ticket automatisch.  
- *Gegenüberstellung*: Manuelle vs. automatisierte Linking: Letzteres spart Zeit, reduziert Fehler.  
- *Anwendungsbeispiele*: Bei SAP-Projekten linkt GitHub Commits zu Jira, um Dashboards zu aktualisieren. Herausforderung: Inkonsistente Naming kann zu Fehllinks führen, gelöst durch Hooks.

*Quellen*: 
[Medium](https://medium.com)
[Atlassian](https://www.atlassian.com)
[Idalko](https://www.idalko.com)
[SAP Community](https://community.sap.com)
[Stack Overflow](https://stackoverflow.com)

## 6. Welche Merge-Strategien gibt es, und wann werden sie verwendet?

**Ansätze zur Integration**  
Merge-Strategien in Git definieren, wie Änderungen aus einem Branch in einen anderen integriert werden, z. B. via `git merge` mit Optionen:  
- **Fast-Forward**: Einfache Vorlauf-Merge.  
- **Recursive**: Für Konflikte.  
- **Squash**: Zusammenfassen zu einem Commit.  
- **Rebase**: Lineare Historie.  
- **Ours/Subtree**: Spezialisiert.  

**Einfluss auf Historie und Nachvollziehbarkeit**  
- Fast-Forward: Behält lineare Historie (hohe Nachverfolgbarkeit).  
- Squash: Vereinfacht Historie (weniger Details).  
- Rebase: Rewrite Historie (sauber, aber verliert Kontext).  
- Recursive: Erstellt Merge-Commits (erhöht Traceability).  

**Wann welche Strategie?**  
- Fast-Forward: Bei linearen Changes ohne Divergenz.  
- Recursive: Bei Konflikten.  
- Squash: Für saubere Historie in Features.  
- Rebase: Für lineare Logs in agilen Teams.  
- Ours: Ignoriert Changes bei Konflikten.  

**Zusätzliche Ausführungen**  
- *Vertiefung*: In PRs auf GitHub wählt man Squash für kleine Features, um Noise zu reduzieren.  
- *Gegenüberstellung*: Rebase vs. Merge: Rebase sauberer, aber gefährlich bei shared Branches (kann Historie umschreiben).  
- *Anwendungsbeispiele*: Bei DNSimple wird Squash für 2 Jahre verwendet, um Historie zu vereinfachen. Herausforderung: Rebase kann zu Konflikten führen, gelöst durch interaktives Rebase.

**Quellen**: 
[GeeksforGeeks](https://www.geeksforgeeks.org)
[Graphite](https://graphite.dev)
[DEV Community](https://dev.to)
[Stack Overflow](https://stackoverflow.com)
[Atlassian](https://www.atlassian.com)

## 7. Was ist Semantic Versioning, und wie wird es eingesetzt?

Semantic Versioning ist ein einfaches und weit akzeptiertes Schema zur Versionierung von Software, das aus drei Teilen besteht: MAJOR.MINOR.PATCH. Jede Komponente hat eine spezielle Bedeutung:

- **MAJOR**: Erhöht sich bei inkompatiblen Änderungen (Breaking Changes)
- **MINOR**: Erhöht sich bei abwärtskompatiblen neuen Funktionen
- **PATCH**: Erhöht sich bei abwärtskompatiblen Fehlerbehebungen 

*Einsatz*
SemVer wird genutzt, um Entwicklern und Nutzern die Art und Auswirkung von Software-Updates klar zu kommunizieren. Es erleichtert Abhängigkeitsmanagement und Risikominimierung in Projekten.  

*Beispiele*:  
- 1.0.0: Erste stabile Version.  
- 1.1.0: Neue abwärtskompatible Funktion.  
- 1.1.1: Bugfix.  
- 2.0.0: Breaking Change, z. B. API-Änderung.  

**Wie hilft Semantic Versioning bei der Verwaltung von Software-Versionen?**

Schnelle Orientierung: Entwickler und Nutzer können sofort erkennen, ob ein Update kritisch ist oder nur kleinere Verbesserungen enthält.
 
Abhängigkeitsmanagement: Bei Projekten mit Bibliotheken (z. B. NPM-Paketen) kann man zuverlässig prüfen, ob Updates kompatibel sind.
 
Risikominimierung: Durch klare Trennung von Breaking Changes, neuen Funktionen und Bugfixes wird das Risiko, dass Software nach Updates kaputtgeht, reduziert.
 
Automatisierung: Versionsnummern können in CI/CD-Pipelines automatisch gesetzt werden, z. B. mit Tools wie Semantic Release.

**Welche Konventionen werden bei Semantic Versioning angewendet?**

- **Drei-Zahlen-Schema**: MAJOR.MINOR.PATCH (z. B. 1.2.3)
- **MAJOR-Version**: Erhöht bei Breaking Changes (z. B. 1.2.3 → 2.0.0)
- **MINOR-Version**: Erhöht bei neuen, abwärtskompatiblen Funktionen (z. B. 1.2.3 → 1.3.0)  
- **PATCH-Version**: Erhöht bei abwärtskompatiblen Bugfixes (z. B. 1.2.3 → 1.2.4)
- **Prä-Releases**: Optional mit Suffix wie `-beta` (z. B. 1.3.0-beta.1).  
- **Build-Metadaten**: Optional mit `+` (z. B. 1.3.0+build2025)

**Warum ist Semantic Versioning wichtig für die Kompatibilität und Kommunikation von Änderungen?**

- **Kompatibilität**: SemVer zeigt, ob ein Update abwärtskompatibel ist oder bestehende Implementierungen bricht.  
- **Kommunikation**: Klare Versionsnummern fördern die Abstimmung zwischen Entwicklern, Testern und Nutzern.  
- **Planung**: Nutzer können Updates priorisieren (z. B. PATCH sofort, MAJOR nach Tests).  
- **Integration**: In großen Projekten (z. B. Microservices) hilft SemVer, Abhängigkeiten zu koordinieren.  

**Zusätzliche Ausführungen**  
- *Vertiefung*: In Open-Source-Projekten ermöglicht SemVer Nutzern, Updates gezielt einzusetzen, ohne Implementierungen zu gefährden.  
- *Gegenüberstellung*: Ohne SemVer fehlt die Transparenz, was zu unerwarteten Fehlern führt.  
- *Anwendungsbeispiele*: Bei Frameworks wie React zeigt SemVer (z. B. 16.0.0 → 17.0.0), ob eine Migration erforderlich ist. Herausforderung: Teams müssen SemVer diszipliniert anwenden, um Vertrauen zu schaffen.  

**Vertiefung**:
 
*Anwendungsbeispiele*:
 
- Bibliotheken / Frameworks: Entwickler erkennen sofort, ob ein Update riskant ist oder direkt genutzt werden kann.
- Open-Source-Projekte: Nutzer können Updates gezielt einsetzen, ohne dass bestehende Implementierungen kaputtgehen.
- CI/CD-Pipelines: Automatisierte Releases können die SemVer-Konventionen einhalten, z. B. durch Tools wie Semantic Release.

**Quellen**:  
[Compuart](https://www.compuart.com/blog/2023/semantic-versioning-warum-es-entwickler-nutzen-und-anwender-kennen-sollten)
[Mindtwo](https://www.mindtwo.ch/blog/semantic-versioning-semver)
[Dev.to](https://dev.to/disane/semantic-versioning-ein-leitfaden-fur-entwickler-3ibj)  

## 8 & 9

tbd