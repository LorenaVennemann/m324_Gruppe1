# DevOps Prozesse

## Hinweis

Der Inhalt dieses Dokuments wurde mithilfe von ChatGpt erstellt. Die Prompts wurden unten aufgelistet. Zusätzlich hatte ChatGpt die Bewertungskriterien als Kontext:

```
- Inhaltliche Vollständigkeit und Korrektheit
- Quellen: Mehrere Quellenangaben pro Thema. Quellen müssen angegeben werden
- Formatierung des Dokuments und Bildunterstützung
- Zusätzliche Ausführungen pro Thema (Vertiefung, Gegenüberstellung, Anwendungsbeispiele, etc)
```

## 1. Was ist SDLC (Software Development Life Cycle), und wie gliedert sich dieser Prozess?

Der **Software Development Life Cycle (SDLC)** beschreibt den Prozess, wie Software geplant, entwickelt, getestet und betrieben wird. Ziel ist es, durch strukturierte Phasen hochwertige und sichere Software zu erstellen.

![Agile vs Waterfall](agile-waterfall.png)

### Welche Schritte umfasst der SDLC, und wie tragen diese zur Entwicklung und Bereitstellung von Software bei?

Die typischen Phasen im SDLC sind:

- **Planung:** Festlegung von Zielen und Umfang des Projekts.
- **Analyse:** Sammlung der Anforderungen von Nutzern und Stakeholdern.
- **Design:** Entwurf der Softwarearchitektur und Benutzeroberfläche.
- **Entwicklung:** Programmierung und Implementierung.
- **Test:** Überprüfung der Softwarequalität und Fehlersuche.
- **Bereitstellung:** Einführung der Software beim Anwender.
- **Betrieb und Wartung:** Laufender Betrieb, Pflege und Fehlerbehebung.

Jede Phase trägt dazu bei, dass die Software systematisch und kontrolliert entsteht, getestet wird und stabil betrieben werden kann.

### Wie wird der SDLC typischerweise in einem Projekt angewendet und gesteuert?

Der SDLC dient als Leitfaden im Projektmanagement und sorgt für klare Aufgabenverteilung und Termintreue. Steuerung erfolgt meist durch Projektleiter, unterstützt durch Methoden wie Agile oder DevOps. Dabei werden Kosten, Termine und Qualität überwacht. Sicherheitsaspekte (Security-by-Design) werden zunehmend in alle Phasen integriert, um Risiken frühzeitig zu minimieren.

### Vertiefung

- Testarten: Unit-, Integrations-, System- und User Acceptance Tests (UAT).
- Wartung umfasst Bugfixes, Performance-Optimierungen und Sicherheitsupdates.
- Planung und Analyse beeinflussen Budgetkontrolle und Zeitmanagement massgeblich.

### Anwendungsbeispiele

- **Bankensoftware:** Strikte SDLC-Phasen mit Reviews und Penetrationstests für hohe Sicherheit.
- **Webanwendungen:** Agile SDLC mit kurzen Iterationen und automatisierten Tests.
- **Mobile Apps:** Nutzung von MVPs, schnelles Nutzerfeedback und schnelle Updates.

### Prompt
```
Was ist SDLC (Software Development Life Cycle), und wie gliedert sich dieser Prozess?

- Welche Schritte umfasst der SDLC, und wie tragen diese zur Entwicklung und Bereitstellung von Software bei?
- Wie wird der SDLC typischerweise in einem Projekt angewendet und gesteuert
```

### Quellen

- <https://www.redhat.com/de/topics/security/software-development-lifecycle-security>  
- <https://aws.amazon.com/de/what-is/sdlc/>  
- <https://www.rapid7.com/de/cybersecurity-grundlagen/software-development-life-cycle-sdlc/>  

---

## 2. Was ist der DevOps Lifecycle, und wie ist er strukturiert?

Der **DevOps Lifecycle** ist ein kontinuierlicher Prozess, der Entwicklung (Dev) und Betrieb (Ops) integriert, um Software schneller, effizienter und stabiler bereitzustellen. Er ist zyklisch mit Phasen wie Planung, Codierung, Integration, Testen, Deployment, Betrieb und Monitoring organisiert.

![DevSecOps](dev-sec-ops.png)

### Wie ist der DevOps Lifecycle definiert, und welche Kernphasen beinhaltet er?

DevOps schliesst die Lücke zwischen Entwicklung und Betrieb durch:

- **Continuous Development:** Planung und Entwicklung kleiner Features.
- **Continuous Integration:** Tägliche automatisierte Codeintegration und Tests.
- **Continuous Testing:** Automatisiertes und kontinuierliches Testen.
- **Continuous Deployment:** Automatisierte Auslieferung in Produktion.
- **Continuous Monitoring:** Echtzeitüberwachung der Systeme.
- **Continuous Feedback:** Nutzer- und Systemfeedback fliesst direkt zurück.

### Welche Ziele verfolgt der DevOps Lifecycle im Vergleich zu traditionellen Entwicklungsansätzen?

Ziel ist die Beschleunigung der Entwicklungszyklen, höhere Qualität, engere Team-Zusammenarbeit und Flexibilität. Durch Automatisierung und schnelle Feedbackschleifen werden Risiken minimiert, häufigere Releases ermöglicht und die Software besser an Nutzerbedürfnisse angepasst.

### Vertiefung

- Nutzung von Tools wie Jenkins (CI), Kubernetes (Deployment) und Prometheus (Monitoring).
- DevSecOps integriert Sicherheitschecks in jeden Schritt.
- KPIs wie Deployment-Frequenz und Fehlerquote ermöglichen datenbasierte Entscheidungen.

### Anwendungsbeispiele

- **FinTech:** Schnelle Feature-Releases und schnelles Nutzerfeedback.
- **Gaming:** Kontinuierliche Updates basierend auf Nutzerverhalten.
- **Logistik:** Canary-Releases für risikoarme Funktionsausrollungen.

### Gegenüberstellung: DevOps vs. Waterfall

| Aspekt               | DevOps                               | Waterfall                             |
|----------------------|------------------------------------|-------------------------------------|
| Prozessstruktur      | Iterativ, kontinuierlich, zyklisch  | Linear, sequentiell, phasenbasiert  |
| Ziel                 | Schnelle Releases, Feedback, Anpassung | Definierte Projektziele, Stabilität  |
| Risiko               | Gering durch kleine automatisierte Releases | Höher durch späte Tests und Integration |
| Zeit bis Markteinführung | Kurz (täglich/wöchentlich)         | Lang (Monate/Jahre)                  |
| Flexibilität         | Hoch, Änderungen jederzeit möglich  | Niedrig, Änderungen kostenintensiv  |

### Prompt
```
Was ist der DevOps Lifecycle, und wie ist er strukturiert?

- Wie ist der DevOps Lifecycle definiert, und welche Kernphasen beinhaltet er?
- Welche Ziele verfolgt der DevOps Lifecycle im Vergleich zu traditionellen Entwicklungsansätzen?
```

### Quellen

- <https://www.browserstack.com/guide/devops-lifecycle>  
- <https://www.geeksforgeeks.org/devops/devops-lifecycle/>  
- <https://roadmap.sh/devops/lifecycle>  

---

## 3. Unterschiede zwischen SDLC und DevOps Lifecycle

### Wie unterscheiden sich die Ansätze, Prozesse und Ziele dieser beiden Modelle?

- **SDLC** ist phasenbasiert und oft sequenziell organisiert. Entwicklung und Betrieb sind meist getrennt, mit Fokus auf Planbarkeit und Kontrolle.
- **DevOps Lifecycle** ist kontinuierlich und integriert Entwicklung mit Betrieb. Er setzt auf Automatisierung und schnelle Feedbackzyklen, um schnellere Releases und kontinuierliche Verbesserung zu ermöglichen.

### Welche Auswirkungen haben diese Unterschiede auf die Entwicklung, Bereitstellung und den Betrieb von Software?

- SDLC führt zu längeren Entwicklungszyklen, verzögertem Feedback und geringerer Flexibilität bei Änderungen. Die Bereitstellung erfolgt meist als grosser Meilenstein.
- DevOps ermöglicht durch Automatisierung und Zusammenarbeit schnellere, häufigere Releases, schnellere Fehlerbehebung und bessere Anpassung an Kundenbedürfnisse, was zu höherer Agilität und Stabilität führt.

### Zusammenfassung

| Aspekt           | SDLC                               | DevOps Lifecycle                     |
|------------------|-----------------------------------|------------------------------------|
| Ansatz           | Phasenorientiert, sequenziell      | Kontinuierlich, integriert          |
| Zusammenarbeit   | Entwicklung und Betrieb getrennt   | Entwicklung und Betrieb vereint     |
| Ziel             | Planungssicherheit, stabiles Produkt | Schnelle Auslieferung, kontinuierliche Verbesserung |
| Feedbackzyklus   | Langsam, nach Phasenabschluss      | Schnell, kontinuierlich              |
| Automatisierung  | Gering bis mittel                  | Hoch, CI/CD-Pipelines               |

### Prompt
```
Welche Unterschiede gibt es zwischen dem SDLC und dem DevOps Lifecycle?

- Wie unterscheiden sich die Ansätze, Prozesse und Ziele dieser beiden Modelle?
- Welche Auswirkungen haben diese Unterschiede auf die Entwicklung, Bereitstellung und den Betrieb von Software?
```

### Quellen

- <https://jfrog.com/de/learn/sdlc/>  
- <https://www.ovhcloud.com/de/learn/what-is-sdlc/>  
- <https://www.redhat.com/de/topics/security/software-development-lifecycle-security>  
- <https://www.browserstack.com/guide/devops-lifecycle>  
- <https://www.geeksforgeeks.org/devops/devops-lifecycle/>  

---

## 4. Was ist ein MVP (Minimum Viable Product), und welche Bedeutung hat es im DevOps Lifecycle?

Ein **MVP** ist die kleinste funktionsfähige Produktversion, die mit minimalem Aufwand auf den Markt gebracht wird, um schnelles Nutzerfeedback einzuholen und Risiken zu reduzieren.

![MVP](mvp.png)

### Wie wird ein MVP definiert, und welche Kernmerkmale zeichnen es aus?

- Enthält nur die Kernfunktionen, die dem Nutzer einen klaren Nutzen bieten.
- Kein reiner Prototyp, sondern ein marktfähiges Produkt.
- Einfach zu bedienen, zuverlässig und erweiterbar.

### Welche Rolle spielt das MVP im DevOps Lifecycle?

Das MVP ermöglicht im DevOps Prozess schnelles Feedback in frühen Phasen, um Hypothesen zu validieren und Risiken zu minimieren. Durch iterative Verbesserungen und kurze Release-Zyklen wird das Produkt kontinuierlich optimiert und an Kundenbedürfnisse angepasst.

### Vertiefung

- MVPs werden häufig in Continuous Deployment Pipelines integriert.
- Kontinuierliches Feedback steuert die Weiterentwicklung.
- Frühzeitige Markttests minimieren Fehlentwicklungen.
- KPIs (Nutzerinteraktion, Conversion) werden früh analysiert.

### Gegenüberstellung: MVP vs. fertiges Produkt

| Aspekt               | MVP                          | Fertiges Produkt                    |
|----------------------|------------------------------|-----------------------------------|
| Funktionsumfang      | Minimal, Kernfunktionen       | Vollständig, alle Features         |
| Ziel                 | Feedback und Lernprozess      | Markt- oder Geschäftsziel          |
| Risiko               | Gering, weniger Ressourcen    | Höher, vollständige Entwicklungskosten |
| Zeit bis Markteinführung | Kurz                        | Länger                            |
| Flexibilität         | Hoch, einfache Anpassungen    | Niedriger, Änderungen kostenintensiver |

### Prompt
```
Was ist ein MVP (Minimum Viable Product), und welche Bedeutung hat es im DevOps Lifecycle?

- Wie wird ein MVP definiert, und welche Kernmerkmale zeichnen es aus?
- Welche Rolle spielt das MVP in den verschiedenen Phasen des DevOps Lifecycles, insbesondere im Hinblick auf schnelles Feedback und iterative Verbesserung?
```

### Quellen

- <https://asana.com/de/resources/minimum-viable-product>  
- <https://monday.com/blog/de/projektmanagement/minimum-viable-product/>  
- <https://www.fme.de/blog/warum-und-wie-definiert-man-eigentlich-ein-minimum-viable-product-mvp/>  
- <https://www.awork.com/de/glossary/mvp-minimum-viable-product>  
