\newpage

### Arbeitspaket 8.1: Portalinfrastruktur und Deployment 

Das Deployment der Komponenten des OPAL Portals geschieht über Docker. Die primäre Datenhaltung für das Portal wurde mit der performanten Suchmaschine Elasticsearch realisiert. Für Datenanalysen werden die Metadaten zusätzlich im Triplestore Fuseki vorgehalten. Beide Datenhaltungskomponenten verfügen über Schnittstellen (API, SPARQL) zum Datenzugriff. Diese werden über Microservices zugegriffen. Die Microservices wurden mit Webservices des Spring Frameworks implementiert und bereiten Daten für die Verwendung in der Benutzeroberfläche (Web UI) auf. Die Benutzeroberfläche baut auf den Bibliotheken React, Next.js und Bootstrap auf. Die folgende Abbildung gibt einen Überblick über die Hauptkomponenten und Repositorien:

![](../Medien/AP8-Demo-Repositories.png)

**Weiterführende Inhalte**

- 8.1 Portalinfrastruktur (Matthias Wauer, Afshin Amini, Adrian Wilke): [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D8.1_Portal_infrastructure.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D8.1_Portal_infrastructure.pdf)
- Software Datenhaltung: [https://github.com/projekt-opal/opaldata](https://github.com/projekt-opal/opaldata)
- Software Microservices: [https://github.com/projekt-opal/web-service](https://github.com/projekt-opal/web-service)
- Software Benutzeroberfläche: [https://github.com/projekt-opal/web-ui](https://github.com/projekt-opal/web-ui)
