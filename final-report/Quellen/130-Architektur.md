\newpage

### Arbeitspaket 1.3: Architektur

Eine High-Level Ansicht der OPAL-Architektur ist in der folgenden Abbildung dargestellt. Sie ist unterteilt in die folgenden Schichten:

1. Die Extraktionsschicht enthält die Funktionalität zum gezielten Crawlen von Open-Data-Seiten.
2. Die Datenanalyseschicht enthält ein erweiterbares Framework mit Komponenten zum Extrahieren bestimmter Metadatenelemente, die Verarbeitung von Qualitätsmetriken und die Extraktion von Schemainformationen Informationen für Datensätze.
3. Die Transformationsschicht überträgt die verschiedenen Metadaten-Repräsentationen in ein gemeinsames Vokabular.
4. Die Integrationsschicht verknüpft und vereinheitlicht verschiedene Metadatenbeschreibungen aus unterschiedlichen Portalen für einzelne Datensätze und berechnet Beziehungen zwischen einzelnen Datensätzen.
5. Die Zugriffsschicht bietet eine API für den programmatischen Zugriff auf die Portalfunktionalität.
6. Die Anwendungsschicht enthält die Endbenutzeranwendungen

![](../Medien/AP1-3-ArchitekturUrspruenglich.png)

Während des Projektverlaufs hat sich die Verwendung der Datenhaltungsschicht als Flaschenhals herausgestellt. Daher wurde die ursprüngliche Architektur so umgestellt, dass für das Web-Frontend Elasticsearch zum Einsatz kommt und zur Aufbereitung von eine sequenzielle Behandlung erfolgt (siehe Arbeitspaket 4.2: Konvertierungskomponente).

**Weiterführende Inhalte**

* D1.3 Architektur (Matthias Wauer, Ivan Ermilov): [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D1.3_Architecture.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D1.3_Architecture.pdf)

