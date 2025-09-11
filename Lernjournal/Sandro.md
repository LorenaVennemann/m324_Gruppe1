# Lernjournal von Sandro

## 08.09.2025

TBD
- datenmodell
- pull request / code review
- persistenz db
- api endpoints
- validierung
- merge conflicts
- vergleich mit firma
- IPA Projekt

## 01.09.2025

Heute haben wir das Thema Versionierung und Branching genauer angeschaut, dabei gibt es bei einem Projekt in meiner Firma auch verschiedene Branches, wie z.B. main, dev, feat, fix, refactor & chore.

So ist die produktive Version immer auf dem main-Branch, während auf dem dev-Branch die neusten Features gesammelt werden für einen neuen Release und für jedes Ticket wird jeweils ein neuen z.B. feature-Branche erstellt.

Ich bin aber der Meinung, dass je nachdem wie gross das Team und Projekt ist, dass dann auch weniger Branches ausreichen, so wie wir in diesem Projekt fürs Modul starten werden, mit einem main-Branche und für jedes Feature einen eigenen Branche.

Wichtiger als die Anzahl Branches finde ich die Regelmässigkeit Änderungen zu committen und zu pushen, sowie auch zu pullen, damit nichts verloren geht, alle auf dem neusten Stand sind und es nicht zu grossen Konflikten kommt.

In diesem erwähnten Projekt in meiner Firma, wird auch M.M.P (Major.Minor.Patch) für die Versionierung genutzt, was ich sehr sinnvoll finde, da so auf einen Blick ersichtlich ist, wie gross die Änderungen sind, vorausgesetzt es ist für alle verständlich was z.Bsp. ein "Breaking Change" ist und wie dann die Version aktualisiert werden muss.

Bei der Initialisierung unseres Projektes haben wir unter anderem die Datenbank aufgesetzt, dabei haben wir uns für HeidiSQL entschieden, was ich gut finde zur Auffrischung, da es schon länger her ist seit ich mit einer SQL-Datenbank gearbeitet habe, da wir im Betrieb hauptsächlich mit LDAP arbeiten.

**Feedback YN**: Gut!

## 25.08.2025

Heute fand ich das Feedback zu unserem Meeting besonders gut, also das gesagt wurde was noch nicht so gut ist und beim nächsten Meeting zu verbessern ist, wie z.B. die Vorbereitugn auf das Meeting.

Letzte Woche habe ich ins Lernjournal geschrieben, dass wir GitHub Nutzen, ohne Pipelines und nur für interne Projekte, das ist aber nicht so, hatte den Durchblick einfach nicht mit den 100+ Repositories auf GitHub.

Heute in der Theorie ging es unter anderem um Branching- und Merge-Strategien, da ist es bei uns in der Firma Software-Abhängig, liegt evt. daran das es bei SVN keine PRs im klassischen Sinne gibt, aber es funktioniert und "never change a running system" oder?

**Feedback YN**. Nun koenntest du bereits auf die Teile CALMS und 3 Ways eingehen. Wie werden die umgesetzt bei euch in der Firma. Was fehlt? Was wird gut gemacht, etc. Gehe auf die spezifischen Themen ein. Der Text oben ist mir noch zu allgemein.

## 18.08.2025

In meinem Lehrbetrieb ist das CI/CD nicht so schlimm wie beim Beginn mit TechNova aus der Theorie 1 & 2, aber auch noch nicht so gut wie am Ende das Ergebnis TechNova, mit wöchentlichen Deployments, sondern eher so 1x im Monat.

Es kann sicher noch einiges verbessert werden bei uns in der Firma wie z.B. automatisierte Tests und noch automatisierter es deployment, weil doch noch einige manuelle Schritte nötig sind für das Deployment vom jeweils neuen Release.

Zudem arbeiten wir hauptsächlich mit Subversion, für Eigenentwicklungen/Interne Sachen benutzen wir aber auch GitHub sowie in diesem Modul, aber ohne Pipelines. Es gab schon Migrations-Versuche von SVN zu GitHub, aber diese sind leider gescheitert.

Ich arbeite gerne mit GitHub (finde den default Light mode von GitLab einfach nicht gut 😂), weil es mit Projects und Actions gleich zwei weitere Features hat, welche wir benutzen können und somit kein weiteres Tool benötigen für Kanban und CI/CD. 

**Feedback YN**. Guter Start. In Zukunft werden die Themen klarer und auch deine Reflektionsmoeglichkeiten. 
