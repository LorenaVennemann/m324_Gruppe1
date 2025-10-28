# Lernjournal Lorena Jil Vennemann
 
**Datum:** 08.18.2025

**Modul / Thema:** m324

---

## 1. Vorbehalte zum heutigen Thema
Am Anfang dieses Moduls hatte ich Angst, dass es eine Überlastung für mich und das Team sein könnte.  
Diese Befürchtung hat sich jedoch nicht bestätigt, nachdem wir die ersten drei Aufgaben im Team gut geschafft haben.

---

## 2. Bezug zu eigenen Erfahrungen
In meinem Unternehmen arbeiten wir auch mit einem Kanban Board, was mir schon vertraut ist.  
Unser Team hat sich jetzt für GitHub entschieden, in meiner Firma arbeiten wir jedoch mit GitLab.  
Das zeigt, dass verschiedene Tools fuer ähnliche Aufgaben genutzt werden können und man sich flexibel anpassen muss.

---

## 6. Reflektion und Feedback
Heute habe ich gelernt was das CALMS-Modell ist, ebenfalls habe ich etwas über The3Ways

## Feedback YN
Es geht mir vor allem um den Reflektions-Teil. In diesem Fall also um die zwei Themen CALMS und 3 ways. Wie wird das bei euch in der Firma verwendet? Was gefällt dir dort, resp. was würdest du ändern, nachdem du nun die Theorie kennst?

---

**Datum:** 08.25.2025

**Modul / Thema:** m324

---

# 6. Reflektion und Feedback

## Gelerntes
Heute habe ich gelernt, wie man ein Planning Meeting richtig umsetzt.  
Dazu haben wir auch Rückmeldung vom Lehrer erhalten. 

## Themen des Tages
- Semantic Versioning  
- Mono- und Multirepo-Ansätze im Kontext von Microservices  
- Artifact-Repository  
- SDLC (Software Development Life Cycle)  
- MVP (Minimum Viable Product)  

## Einschätzung
Es war viel Inhalt, den ich mir heute aneignen musste.  
Trotzdem habe ich sehr viel Neues dazu gelernt.  

## Fazit
Insgesamt war der Tag recht stressig, jedoch sehr lehrreich.

## Feedback YN
Bitte unbedingt die Reflektion mit den Themen und Betrieb machen

---
---
**Datum:** 01.09.2025  
**Modul / Thema:** m324
---

## Bezug zu eigenen Erfahrungen
Heute haben wir in P2_Applikation entschieden, mit HeidiSQL zu arbeiten. Damit kenne ich mich bereits aus, da wir es auch in meiner Abteilung im Betrieb nutzen. Ausserdem haben wir über Versionierung, Branching und M.M.P (Major.Minor.Patch) für die Visualisierung gesprochen, um Projekte besser planen zu können. In meiner Firma läuft das ähnlich: Wir haben einen Main-Branch und erstellen für jedes Jira-Ticket einen eigenen Branch. 

## Reflektion und Feedback
Mir hat heute besonders gefallen, dass ich die Theorie direkt mit meiner Arbeit vergleichen konnte. Es war interessant zu sehen, wie Branching, Versionierung und Workflows in einem Projekt umgesetzt werden. Dadurch verstehe ich besser, wie man Änderungen sauber nachverfolgt und ein Projekt im Team gut organisiert.

Insgesamt ist es jedoch nicht komplett neu für mich, da ich ähnliche Methoden bereits im Alltag in meiner Firma benutze. Spannend war es jedoch zu sehen, welche weiteren Möglichkeiten es gibt, Projekte noch effizienter zu strukturieren.

## Feedback YN
Du sagst nur, dass du mit Betrieb vergleichen konntest. Dann vergleiche auch hier im Text! Das ist so noch keine Reflektion :(

---
---
**Datum:** 08.09.2025  
**Modul / Thema:** m324
---
## Bezug zu eigenen Erfahrungen
Heute habe ich am Airport-Service Projekt gearbeitet und folgende Aufgaben umgesetzt:
Erstellung der Flughafen-Entity, DTOs (Request/Response) und Controller.
Implementierung der Endpunkte zum Abrufen aller Flughäfen und zum Erstellen neuer Flughäfen.
Hinzufügen von Bean-Validierungen (@NotBlank, @Size, @Positive), damit Eingaben automatisch geprüft werden.
Schreiben eines Unit-Tests für den GET-Endpunkt, um die Funktionalität zu überprüfen.

Im Vergleich zu meinen Erfahrungen in meinem Betrieb:
In meinem Betrieb werden Daten professionell verwaltet und ebenfalls validiert, z. B. in internen Systemen oder Datenbanken, je nach Abteilung.
Dadurch konnte ich die automatisierte Validierung in Spring Boot direkt mit den betrieblichen Prozessen vergleichen.
Ich habe verstanden, dass saubere Datenstrukturen, Validierungen und automatisierte Prüfungen sowohl im Projekt als auch im Betrieb für Datenqualität und Fehlervermeidung sorgen.
## Reflektion und Feedback
Was lief gut:
Umsetzung der Endpunkte und Validierungen hat gut funktioniert.
Die Arbeit mit Postman erleichtert das Testen der API ohne Frontend.

Herausforderungen:
Fehler wie „Ambiguous mapping“ zeigten, wie wichtig eine klare Trennung zwischen Endpunktmethoden und Hilfsmethoden ist.
Vergleich mit dem Betrieb:

Wie in meinem Betrieb ist es entscheidend, dass Daten korrekt validiert und geprüft werden.
Automatisierte Prüfungen im Code erleichtern die Arbeit und verhindern Fehler ähnlich wie im professionellen System.

Verbesserungspotenzial:
Unit-Tests auch für POST-Endpunkte mit Validierung schreiben (zurzeit in Arbeit).
DTOs und Entities noch klarer trennen, um den Code wartbarer zu machen.

## Feedback YN
Beim Programmieren ist der Vergleich schwieriger. Darum heute gut!

---
---
**Datum:** 22.09.2025  
**Modul / Thema:** m324
---
## Bezug zu eigenen Erfahrungen
Das Erstellen der Pipeline für Auftrag P3 und das Dokumentieren hat mir geholfen, mehr über CI/CD und Automatisierung zu lernen. Ich habe gesehen, wie man verschiedene Möglichkeiten in einer Pipeline nutzen kann, zum Beispiel GitHub Actions. In meiner Firma arbeiten wir zwar mit GitLab Pipelines und nicht mit GitHub, aber ich habe dort schon Pipelines umsetzen dürfen. Heute lief es sehr gut, da es ein kleines Projekt war und nur wenige Anforderungen braucht. In meiner Firma habe ich für Pipelines länger gebraucht und mehr Änderungen machen müsssen, um sie zum Laufen zu bringen, da wir dort auch Lombok und andere Libraries verwenden. Das Schreiben der Unit-Tests im Task P2 hat mir gezeigt, wie man die Qualität von Code prüft und Fehler früh erkennt.

## Reflektion und Feedback
Was lief gut:
Die Pipeline konnte schnell erstellt und dokumentiert werden, da es ein kleines Projekt war. Die Unit-Tests haben Fehler früh erkannt. Ich konnte auch Erfahrungen aus meiner Firma einbringen. Wir haben uns regelmässig im Team besprochen.

Herausforderungen:
Es war nicht immer einfach, die Pipeline richtig umzusetzen, besonders wegen der Pfade im Projekt. In meiner Firma sind Pipelines noch komplexer, zum Beispiel mit Lombok und weiteren Libraries

Verbesserungspotenzial:
Die Unit-Tests könnten alle Sonderfälle abdecken. 

## Feedback YN
OK

---
---
**Datum:** 29.09.2025  
**Modul / Thema:** m324
---

## Bezug zu eigenen Erfahrungen

Unit Tests kenne ich bereits aus meiner Arbeit. In jeder Abteilung, in der ich tätig war und die mit Java arbeitet, haben wir stets Unit Tests geschrieben. Dieses Wissen hat mir heute sehr geholfen.

Die verschiedenen Arten von Pipelines waren für mich sehr interessant. Auch bei der Arbeit habe ich bereits mit Pipelines gearbeitet, die aus mehreren Jobs bestehen. Postman kenne ich ebenfalls aus der Arbeit, allerdings nutze ich es dort bisher nur für manuelle Tests und nicht für automatische Systemtests.

## Reflektion und Feedback

**Was lief gut:**
- Unit Tests für Flüge fertig gemacht
- P3 Auftrag "Systemtests einbinden" angefangen
- Pipeline-Varianten Task im P3 abgeschlossen  
- Gute Kommunikation im Team  
- Meine Erfahrung mit Unit Tests hat geholfen

**Herausforderungen:**
- Postman für Systemtests war schwierig
- Lange nicht mehr richtig mit Postman gearbeitet
- Von manuellem Testen zu automatischen Tests umdenken
- Pipeline-Konfiguration verstehen

**Verbesserungspotenzial:**
- Postman besser lernen für automatische Tests
- Mehr Übung mit Test-Frameworks
- Pipeline-Dokumentation verbessern
- Systematischer bei Fehlern in Tests vorgehen

## Feedback YN

Inhaltlich keine Reflektion, wahrscheinlich, weil nichts neues gemacht wurde.
---
---
**Datum:** 20.10.2025  
**Modul / Thema:** m324
---
## Bezug zu eigenen Erfahrungen
Heute habe ich gemeinsam mit Sandro in P4 die Subtask erstellt. Ausserdem habe ich mit dem Z1-Task begonnen und konnte diesen erfolgreich abschliessen. Dabei haben wir GitHub Issues verwendet. In meiner Firma nutzen wir kein GitHub, sondern GitLab in Kombination mit Jira als Ticketsystem. Persönlich bevorzuge ich Jira, da es für mich übersichtlicher ist, allerdings finde ich das UI von GitHub Issues ansprechender. Gegen Ende der Stunde konnte ich mit Task P4 starten. Dort habe ich mit der Einrichtung von VPCs sowie Security Groups in AWS begonnen. Mit AWS hatte ich bisher in meiner Firma keine praktischen Erfahrungen, mein Wissen stammt also hauptsächlich aus der Schule.

## Reflektion und Feedback
Was lief gut:
Der Z1-Task lief sehr gut und ich konnte dabei viel über GitHub Issues lernen. Auch in AWS bin ich gut vorangekommen und konnte mein Wissen aus dem vorherigen Modul direkt anwenden.

Herausforderungen:
Leider konnte ich nicht direkt mit Z4 beginnen, da AWS zeitweise nicht erreichbar war. Deshalb habe ich zunächst mit Z1 gearbeitet und diesen abgeschlossen.

Verbesserungspotenzial:
Ich denke, dass wir im Team sehr gut vorankommen und die Zusammenarbeit effizient gestaltet ist.

## Feedback YN

OK
---
---
**Datum:** 27.10.2025  
**Modul / Thema:** m324
---
## Bezug zu eigenen Erfahrungen
Heute habe ich noch einige kleine Aufgaben im Z2 Task erledigt und bin danach zum P4 Task übergegangen. Dort habe ich an den Themen weitergearbeitet, an denen ich letzte Woche gearbeitet habe. Neu habe ich für DEV die Infrastruktur in AWS erstellt und dieselben Schritte für PROD durchgeführt. Ausserdem habe ich bereits die deploy.yml-Datei mit der Deploy-Stage fertiggestellt, die bei Bedarf noch angepasst werden kann. In meiner Firma arbeiten wir mit OCP (OpenShift). Anfangs fiel es mir schwerer, mich dort zurechtzufinden, als bei AWS, da OpenShift komplexer einzurichten ist. Sobald das Setup jedoch einmal vollständig steht, ist die Nutzung von OCP nicht mehr so schwierig.

Vergleich:
AWS: Einstieg schneller, da die Services einzeln und übersichtlich genutzt werden können.
OCP: Anfangs aufwendiger, da alles in einem Cluster/Setup integriert wird, dafür aber langfristig konsistenter und effizienter im Team.

## Reflektion und Feedback
Was lief gut:
Ich fand das morgendliche Meeting sehr erfolgreich, wir haben gleich zu Beginn Fortschritte erzielt. Ebenfalls positiv war, wie gut die Zusammenarbeit im Team funktioniert hat.

Herausforderungen:
Eine Herausforderung bestand darin herauszufinden, warum die Load Balancer in AWS nicht funktionierten. Schliesslich stellte sich heraus, dass die Availability Zones in zwei Public Subnets nicht identisch sein dürfen, zum Beispiel dürfen beide nicht eu-west-1b sein.

Verbesserungspotenzial:
Da eine Person im Team nur wenig kommuniziert, fehlt uns manchmal der Überblick über den Arbeitsstand. Das erschwert die Zusammenarbeit und verlangsamt unseren Fortschritt.



