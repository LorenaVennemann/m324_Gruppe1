# DevOps Prozesse

## 1. Was ist SDLC (Software Development Life Cycle), und wie gliedert sich dieser Prozess?

SDLC heisst Software Development Life Cycle. Es ist ein Ablauf, wie Software geplant, gebaut, getestet und betrieben wird. Ziel ist es, gute und sichere Software in klaren Schritten zu entwickeln.

![Agile vs Waterfall](./Bilder/agile-waterfall.png)

 
***Welche Schritte umfasst der SDLC, und wie tragen diese zur Entwicklung und Bereitstellung von Software bei?***
 
Die Phasen des SDLC:
 
Planung → Ziel und Umfang vom Projekt werden festgelegt.
 
Analyse → Anforderungen der Nutzer werden gesammelt.
 
Design → Entwurf für die Software entsteht.
 
Entwicklung → Programmierer schreiben den Code.
 
Test → Die Software wird auf Fehler und Qualität geprüft.
 
Bereitstellung → Software wird bei den Nutzern eingeführt.
 
Betrieb und Wartung → Die Software läuft und wird gepflegt.
 
 
***Wie wird der SDLC typischerweise in einem Projekt angewendet und gesteuert?***
 
Im Projekt wird der SDLC als Leitfaden genutzt. Er hilft, dass alle im Team wissen, was wann gemacht wird. Die Steuerung passiert oft durch Projektleiter oder mit Methoden wie Agile oder DevOps. Dabei wird darauf geachtet, dass Termine, Kosten und Qualität eingehalten werden. In moderner Entwicklung wird Sicherheit in jeden Schritt eingebaut, damit Probleme früh erkannt werden.

### Vertiefung

- Tests können unterschiedliche Formen haben: Unit Tests, Integrationstests, Systemtests oder User Acceptance Tests (UAT).
- Planung und Analyse sind entscheidend für Budgetkontrolle und Zeitmanagement.
- Wartung umfasst Bugfixes, Performance-Optimierungen und Sicherheitsupdates – oft der längste Teil des SDLC.
  
***Anwendungsbeispiele***

1. Bankensoftware:
- Hoher Sicherheitsbedarf → strikte SDLC-Phasen mit Reviews und Penetrationstests
- Jede Phase dokumentiert → regulatorische Anforderungen erfüllt

2. Webanwendungen (z. B. E-Commerce):
- Agile SDLC-Version → kurze Iterationen, schnelle Releases
- Testphase wird oft automatisiert (z. B. CI/CD-Pipelines)

3. Mobile Apps:
- MVP wird erstellt, Feedback gesammelt → nächste Entwicklungsphase angepasst
- Schnelle Bereitstellung über App Stores möglich

***Typische Anwendung und Steuerung im Projekt***

- Leitfaden: SDLC gibt dem Team Orientierung: Wer macht was und wann?
- Projektmanagement: Projektleiter überwachen Termine, Kosten und Qualität.
- Methoden:
  - Agile SDLC: Iterative Entwicklung, flexible Anpassungen
  - DevOps-Integration: Automatisierung von Tests, Deployment und Monitoring
- Sicherheitsaspekte: Security-by-Design wird in allen Phasen berücksichtigt → frühe Fehlererkennung, - geringere Kosten bei Bugfixes

### Quellen

- <https://www.redhat.com/de/topics/security/software-development-lifecycle-security>
- <https://aws.amazon.com/de/what-is/sdlc/>
- <https://www.rapid7.com/de/cybersecurity-grundlagen/software-development-life-cycle-sdlc/>
- <https://www.linkedin.com/pulse/software-development-life-cycle-sdlc-tutorial-richard-harris/>

## 2. Was ist der DevOps Lifecycle, und wie ist er strukturiert?

Der DevOps Lifecycle ist ein kontinuierlicher Prozess, der Entwicklung (Dev) und Betrieb (Ops) integriert, um die Softwareentwicklung zu optimieren und eine nahtlose Zusammenarbeit zu ermöglichen. Er ist in einem zyklischen Modell strukturiert, das Phasen wie Planung, Codierung, Integration, Testen, Deployment, Betrieb und Monitoring umfasst, die iterativ ablaufen, um kontinuierliche Verbesserungen zu gewährleisten.
 

![DevSecOps](./Bilder/dev-sec-ops.png)
 
***Wie ist der DevOps Lifecycle definiert, und welche Kernphasen beinhaltet er?***
 
Der DevOps Lifecycle wird als ein kollaborativer Ansatz definiert, der die Lücke zwischen Softwareentwicklung und IT-Betrieb schliesst, um eine kontinuierliche und automatisierte Bereitstellung zu erreichen. Zu den Kernphasen gehören Continuous Development, Continuous Integration, Continuous Testing, Continuous Deployment, Continuous Monitoring und Continuous Feedback, die in einem endlosen Loop organisiert sind.
 
 
***Welche Ziele verfolgt der DevOps Lifecycle im Vergleich zu traditionellen Entwicklungsansätzen?***
 
Der DevOps Lifecycle zielt darauf ab, die Entwicklungszeit zu verkürzen, die Qualität zu steigern und eine engere Zusammenarbeit zwischen Teams zu fördern, im Gegensatz zu traditionellen Ansätzen wie dem Wasserfall-Modell, die sequentiell und silobasiert sind. Im Vergleich zu klassischen Methoden reduziert er Risiken durch Automatisierung und kontinuierliches Feedback, was schnellere Releases und bessere Anpassungsfähigkeit an Veränderungen ermöglicht.


### Quellen

- <https://www.browserstack.com/guide/devops-lifecycle>
- <https://www.geeksforgeeks.org/devops/devops-lifecycle/>
- <https://roadmap.sh/devops/lifecycle>
- <https://unity.com/de/topics/devops-lifecycle>
- <https://www.cloudzero.com/blog/devops-lifecycle/>
- <https://www.harness.io/blog/devops-lifecycle>
- <https://octopus.com/blog/devops-versus-sdlc>
- <https://www.piazzablu.com/devops>
- <https://kruschecompany.com/de/devops-guide/>

## 3. Welche Unterschiede gibt es zwischen dem SDLC und dem DevOps Lifecycle?

***Wie unterscheiden sich die Ansätze, Prozesse und Ziele dieser beiden Modelle?***

***Welche Auswirkungen haben diese Unterschiede auf die Entwicklung, Bereitstellung und den Betrieb von Software?***

| Aspekt                    | SDLC                                        | DevOps Lifecycle                                  |
| ------------------------- | ------------------------------------------- | ------------------------------------------------- |
| **Ansatz**                | Linear, Phasenbasiert (oft Wasserfall)      | Iterativ, kontinuierlicher Zyklus                 |
| **Fokus**                 | Strukturierte Planung und Dokumentation     | Automatisierung, Zusammenarbeit, Feedback         |
| **Ziel**                  | Qualitätssicherung durch Phasen und Reviews | Schnelle, häufige Releases mit hoher Qualität     |
| **Entwicklung & Betrieb** | Oft getrennt                                | Integration von Entwicklung und Betrieb           |
| **Feedback**              | Nach Abschluss der Phasen                   | Kontinuierliches Feedback in allen Phasen         |
| **Bereitstellung**        | Nach Abschluss der Entwicklung              | Automatisierte und kontinuierliche Bereitstellung |

Auswirkungen auf Entwicklung, Bereitstellung und Betrieb:

- SDLC fördert Stabilität und Planbarkeit, eignet sich für klar definierte Projekte.
- DevOps ermöglicht schnellere Anpassungen, kontinuierliche Updates und bessere Reaktion auf Nutzerfeedback.
- DevOps reduziert Silos, verbessert Kommunikation und automatisiert viele manuelle Schritte.

### Quellen

- <https://www.computertechreviews.com/sdlc-vs-devops-which-is-better/>

## 4. Was ist ein MVP (Minimum Viable Product), und welche Bedeutung hat es im DevOps Lifecycle?

Ein MVP ist die kleinste funktionsfähige Version eines Produkts, die mit minimalem Aufwand auf den Markt gebracht wird, um Feedback echter Nutzer zu sammeln.
 
Ziel: Risiken reduzieren, schneller lernen, unnötige Kosten vermeiden

![MVP](./Bilder/mvp.png)
 
 
***Wie wird ein MVP definiert, und welche Kernmerkmale zeichnen es aus?***
 
Ein MVP ist eine Version eines Produkts mit nur den wichtigsten Funktionen, die den Nutzern trotzdem einen klaren Nutzen bietet. Es ist kein reiner Prototyp, sondern schon ein Produkt, das auf den Markt kann. Wichtige Merkmale sind: einfach zu benutzen, funktioniert zuverlässig, zeigt das wichtigste besondere Merkmal des Produkts und kann durch Feedback und Erweiterungen weiter verbessert werden.

***Welche Rolle spielt das MVP in den verschiedenen Phasen des DevOps Lifecycles, insbesondere im Hinblick auf schnelles Feedback und iterative Verbesserung?***

Ein MVP spielt im DevOps-Lifecycle eine zentrale Rolle, indem es in den Phasen Planung, Entwicklung und Bereitstellung schnelles Feedback von Kunden ermöglicht, um Hypothesen zu validieren und Risiken zu minimieren. Durch iterative Verbesserungen basierend auf diesem Feedback, insbesondere in den Phasen Testen und Überwachen, wird das Produkt kontinuierlich an Kundenbedürfnisse angepasst, was die Effizienz und Marktakzeptanz steigert.

### Quellen

- <https://asana.com/de/resources/minimum-viable-product>
- <https://monday.com/blog/de/projektmanagement/minimum-viable-product/>
- <https://www.fme.de/blog/warum-und-wie-definiert-man-eigentlich-ein-minimum-viable-product-mvp/>
- <https://www.awork.com/de/glossary/mvp-minimum-viable-product>
- <https://www.pureconsultant.de/de/scrum/minimum-viable-product-mvp-scrum/>
- <https://www.cobbleweb.co.uk/ultimate-guide-to-minimum-viable-product-mvp/>
