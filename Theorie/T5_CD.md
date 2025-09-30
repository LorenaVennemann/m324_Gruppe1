# Continuous Deployment & Deployment-Strategien

## 1. Was ist Continuous Deployment und wie wird es umgesetzt?

**Continuous Deployment (CD)** ist eine Praxis in der Softwareentwicklung, bei der Codeänderungen automatisch in die Produktionsumgebung überführt werden, sobald sie alle automatisierten Tests erfolgreich durchlaufen haben. Dies ermöglicht eine schnelle und kontinuierliche Bereitstellung neuer Funktionen oder Fehlerbehebungen an die Nutzer.

**Umsetzung:**
- **Automatisierte Tests:** Vor der Bereitstellung werden umfangreiche automatisierte Tests durchgeführt, um die Qualität und Stabilität des Codes sicherzustellen.
- **Automatisierte Deployment-Pipeline:** Tools wie Jenkins, GitLab CI/CD oder GitHub Actions werden verwendet, um den gesamten Prozess vom Commit bis zur Produktion zu automatisieren.
- **Monitoring:** Nach der Bereitstellung wird das System kontinuierlich überwacht, um etwaige Probleme frühzeitig zu erkennen und zu beheben.

**Quellen:**
- [IBM: Continuous Deployment](https://www.ibm.com/think/topics/continuous-deployment)
- [Atlassian: Continuous Deployment](https://www.atlassian.com/continuous-delivery/software-testing/continuous-deployment)

---

## 2. Unterschied zwischen Continuous Deployment und Continuous Delivery

- **Continuous Delivery (CD):** Der Code wird automatisch bis zu einer Staging-Umgebung bereitgestellt. Die endgültige Freigabe in die Produktion erfolgt jedoch manuell.
- **Continuous Deployment:** Die Freigabe in die Produktion erfolgt automatisch, sobald alle Tests erfolgreich sind.

**Vergleich:**

| Aspekt                  | Continuous Delivery           | Continuous Deployment           |
|-------------------------|-------------------------------|---------------------------------|
| Automatisierung         | Bis Staging                   | Bis Produktion                  |
| Manuelle Freigabe       | Ja                            | Nein                            |
| Risiko bei Fehlern      | Gering (manuelle Kontrolle)   | Höher (automatische Freigabe)   |

**Quellen:**
- [Puppet: Continuous Delivery vs. Deployment](https://www.puppet.com/blog/continuous-delivery-vs-deployment)
- [AWS: Continuous Delivery vs. Continuous Deployment](https://aws.amazon.com/devops/continuous-delivery/)

---

## 3. Vor- und Nachteile von Continuous Delivery und Continuous Deployment

**Continuous Delivery:**
- **Vorteile:**  
  - Höhere Kontrolle über den Produktionscode  
  - Möglichkeit, Releases zu planen und zu koordinieren  
  - Geringeres Risiko bei der Einführung neuer Funktionen  

- **Nachteile:**  
  - Verzögerungen bei der Bereitstellung neuer Funktionen  
  - Zusätzlicher manueller Aufwand für die Freigabe  

**Continuous Deployment:**
- **Vorteile:**  
  - Schnellere Bereitstellung neuer Funktionen  
  - Reduzierung manueller Eingriffe  
  - Schnelle Rückmeldung von Nutzern  

- **Nachteile:**  
  - Höheres Risiko bei Fehlern in der Produktion  
  - Erfordert umfangreiche Tests und Monitoring  

---

## 4. Deployment-Strategien

### Blue/Green Deployment
- Zwei identische Produktionsumgebungen: „Blue“ (aktuell) und „Green“ (neu)  
- Verkehr wird auf Green umgeschaltet nach erfolgreichem Test  
- **Vorteile:** Minimierung von Ausfallzeiten, schnelle Rückkehr zur vorherigen Version

**Quellen:**
- [Octopus Deploy: Blue/Green Deployments](https://octopus.com/devops/software-deployments/blue-green-deployment/)
- [AWS: Blue/Green Deployments](https://docs.aws.amazon.com/whitepapers/latest/blue-green-deployments/introduction.html)

### Canary Deployment
- Neue Version wird schrittweise an kleine Benutzergruppe ausgerollt  
- Bei Erfolg wird Ausrollung auf grössere Benutzergruppe erweitert  
- **Vorteile:** Frühe Fehlererkennung, geringeres Risiko

**Quellen:**
- [Google Cloud: Canary Deployment](https://cloud.google.com/deploy/docs/deployment-strategies/canary)
- [Codefresh: Canary Deployments](https://codefresh.io/learn/software-deployment/what-are-canary-deployments/)

---

## 5. A/B Testing
- Vergleich zweier Versionen eines Produkts, um die bessere Variante zu ermitteln  
- Anwendungen: UI-Optimierung, Conversion-Rate-Steigerung, Hypothesenvalidierung  

**Quellen:**
- [VWO: A/B Testing](https://vwo.com/ab-testing/)
- [Optimizely: A/B Testing](https://www.optimizely.com/optimization-glossary/ab-testing/)

---

## 6. Feature Toggles
- Funktionen können im Code aktiviert/deaktiviert werden, ohne Deployment  
- Anwendungen: A/B-Tests, gezielte Nutzergruppen, schnelles Deaktivieren fehlerhafter Funktionen  

**Quellen:**
- [Martin Fowler: Feature Toggles](https://martinfowler.com/articles/feature-toggles.html)
- [Optimizely: Feature Toggles](https://www.optimizely.com/optimization-glossary/feature-toggle/)

---

## 7. Rollback-Strategien
- **Automatisiert:** Rückkehr zur vorherigen Version bei Fehlern  
- **Manuell:** Entwickler führen Rückkehr zur vorherigen Version durch  

**Quellen:**
- [Octopus Deploy: Modern Rollback Strategies](https://octopus.com/blog/modern-rollback-strategies)
- [AWS: Rollback Strategies](https://aws.amazon.com/builders-library/ensuring-rollback-safety-during-deployments/)

---

## 8. Continuous Monitoring
- Kontinuierliche Überwachung von Systemmetriken, Logs und Benutzeraktivitäten  
- Tools: Prometheus, Grafana, Splunk  
- Alarme und Benachrichtigungen bei Anomalien  

**Quellen:**
- [Splunk: Continuous Monitoring](https://www.splunk.com/en_us/blog/learn/continuous-monitoring.html)
- [NIST: Continuous Monitoring](https://csrc.nist.gov/glossary/term/continuous_monitoring)

---

## 9. Sichere Passwortspeicherung
- **Hashing:** bcrypt, Argon2  
- **Salting:** Zufallswert hinzufügen, um Rainbow-Table-Angriffe zu verhindern  
- **Verschlüsselung:** Speicherung verschlüsselt, sicherer Schlüsselmanagement  

**Quellen:**
- [OWASP: Password Storage Cheat Sheet](https://cheatsheetseries.owasp.org/cheatsheets/Password_Storage_Cheat_Sheet.html)
- [Bitwarden: Password Manager](https://www.wired.com/review/bitwarden-password-manager)

---

## 10. Arten von Deployments
- Direkt auf Server kompilieren und bereitstellen  
- Containerisierung mit Docker  
- Orchestrierung mit Docker Swarm oder Kubernetes  
- Serverless Deployment (z. B. AWS Lambda)

**Quellen:**
- [AWS: Deployment Methods](https://aws.amazon.com/devops/continuous-delivery/)
- [Docker: Deployment with Docker](https://www.docker.com/resources/what-container)

---

## Fazit
Die Implementierung von Continuous Deployment und den entsprechenden Strategien ermöglicht schnelle, effiziente und sichere Softwarebereitstellung. Methoden wie Blue/Green-Deployments, Canary-Deployments, A/B-Tests, Feature Toggles und Continuous Monitoring minimieren Risiken und sichern die Softwarequalität. Passwörter sollten immer sicher gespeichert und geeignete Deployment-Methoden je nach Infrastruktur ausgewählt werden.
