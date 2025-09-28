# Lernjournal von Sandro

## 22.09.2025

Heute habe ich mich irgendwie nicht so produktiv gefühlt oder jedenfalls nicht so produktiv wie ich gerne gewesen wäre. Auch bei mir in der Firma gibt es Tage, an denen ich nicht so produktiv bin oder auch einfach nicht so produktiv fühle.

Dabei macht es schon ziemlich einen Unterschied, ob man sich nur unproduktiv fühlt oder es auch ist, ich denke dabei wäre es wichtig die Produktivität messen zu können, dafür könnte der Zusatz Z1: Kennzahlen interessant sein, aber auch ohne das Projekt in Kennzahlen zu messen, würde ich schon sagen, dass wir heute weiter kommen hätten müssen, weil wir immer noch nicht fertig sind mit P2 und mit P3 erst gestartet sind.

Ein Task von mir war es heute Tests zu schreiben, dabei hat das Errorhandling bei unseren Endpunkten gefehlt, also anstatt das mir als Client ein 400 Errorcode zurückgegeben wurde, weil ich als User falsche Daten lieferte, erhielt ich jeweils 500 Errorcodes => Internal Server Error, wobei es offensichtlich ein Layer 8 Problem war.

Nicht nur das Errorhandling wies Mängel auf, sondern auch die Validierung der Daten, deshalb wurde aus 1 Testing Task, dann 2 Tasks, weil ich noch Fehler ausbessern musste. So plante ich zu Beginn ca. 2 Lektionen für den Task ein, hatte dann aber fast den ganzen Morgen bis ich meinen eigentlichen Task beenden konnte.

Zur Abwechslung durfte ich bei der Pipeline Erstellung helfen, dabei nutzen wir GitHub Actions, um die Pipeline auszuführen. Das war unter anderem auch ein Grund GitHub zu nutzen, da wir so Tasks, Code und Pipeline an einem Ort haben, dies finde ich praktisch, da so nicht zwischen verschiedenen Tools gewechselt werden muss.

So nutzen wir bei uns in der Firma, wenn wir GitHub nutzen auch GitHub Projects für die Tasks und GitHub Actions für die Pipelines. Wenn wir nicht Git, sondern SVN verwenden, dann nutzen wir verschiedene Tools für die verschiedenen Sachen, was es ein bisschen umständlicher macht.

**Feedback YN**: OK

## 08.09.2025

Meine Tasks heute waren das Datenmodell zu erstellen, sowie sicherzustellen, dass die Daten auch in der DB gespeichert werden und dabei die ID und Erstellungsdatum automatisch generiert werden.

Dabei waren einige Tasks zu Beginn blockiert, bis ich das Datenmodell fertig hatte, da ich aber meistens schon vor 8 Uhr in der Schule war, hatte ich Zeit um vorzuarbeiten, sonst hätten wir Zeit verloren.

Es ist allgemein nicht so einfach die Tasks aufzuteilen, da wir gefühlt zu viele Leute sind für dieses Projekt, aber wäre ja langweilig, wenn alles so einfach wäre. Ich habe nach den Lektionen am Morgen herausgefunden, dass wir eigentlich nicht zu viele Leute für das Projekt sind, sondern uns einfach falsch aufgeteilt haben.

So gibt es nämlich neben P2, was die Version 1.0 vom Projekt ist, noch weitere Tasks, welche parallel gestartet werden können, wie z.B. T5, P3, Z1, Z2 & Z3. Bisher haben wir hauptsächlich alle an einem Task gearbeitet und konnten dies gut aufteilen, aber ich finde jetzt würde es Sinn ergeben uns zu splitten auf die verschiedenen Tasks.

Eigentlich wollte ich jetzt schreiben, dass es doof ist die Tasks aufzuteilen, weil sie verschiedene Anzahl an Punkte geben, dies ist abgesehen von P4 & P3 aber nicht so, denn es geben alle Tasks, die zum aktuellen Stand noch offen sind +/- 0.2 Punkte. Gut schreibe ich dieses Lernjournal, sonst würden mir solche Punkte nicht auffallen.

Es könnte aber auch eng werden, wenn wir zu wenig Ressourcen auf P2 festlegen, weil wir diesen Task am Ende von Woche 6 spätestens abgeben müssen und auch sonst sieht es nicht so aus als hätten wir noch Zeit übrig zum Verschwenden, dies ist aber nicht nur bei diesem Schulprojekt hier so, sondern auch oft bei mir in der Firma, schliesslich ist Zeit = Geld.

Bei der Erstellung der Entities konnte ich bereits bekannte Annotationen wie z.B. NotBlank, NotNull, Size und Pattern verwenden, welche ich auch in der API verwende in der Firma, nur das ich dort keine Entities erstellt habe, sondern nur über die DTO's gehe. Wobei die Projekt/Ordnerstruktur bei der API in der Firma auch anders ist, als wie wir es in diesem Projekt machen.

Das Interessante dabei ist, dass ich bei beiden Projekten entscheiden konnte, wie ich die Struktur vom Projekt haben möchte. Bei der API in meiner Firma bin ich eigentlich alleine dafür verantwortlich und habe mich an einer bereits existierenden API orientiert. Beim aktuellen Projekt in der Schule haben wir das Projekt auf meinem Notebook aufgesetzt und ich habe mich da am MVC Pattern orientiert, welches wir bei der Noser Young ebenfalls verwendet haben (ist aber auch schon über 1 Jahr her).

**Feedback YN**: Gut!

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
