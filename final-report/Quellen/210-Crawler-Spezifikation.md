\newpage

### Arbeitspaket 2.1: Spezifikation der Crawler-Komponente

Das primäre Ziel von OPAL ist es, Benutzern das einfache Auffinden offener Daten zu ermöglichen, indem verfügbare Metadaten aus verschiedenen Webquellen gesammelt, analysiert und integriert werden. Dieses Arbeitspaket konzentriert sich auf den ersten Schritt in Richtung dieses Ziels: Die Identifizierung und Extraktion von Metadaten von Webseiten, die Datensätze beschreiben.

Dieses Arbeitpaket spezifiziert funktionale und nicht-funktionale Anforderungen für die OPAL Crawler-Komponente. Dabei werden die allgemeinen Anforderungen, die in Deliverable D1.1 gesammelt wurden, referenziert. Außerdem werden 10 existierende Crawling-Komponenten hinsichtlich der Anforderungen verglichen.


**Funktionale Anforderungen**

Im Folgenden sind funktionale Anforderungen, wie Dienste oder Funktionen, die von der Crawler-Implementierung bereitgestellt werden müssen, aufgeführt. Zusätzlich sind die Anforderungen aus AP 1.1 referenziert.

| ID  | Titel                                           | Beschreibung                                                                                                                                                                                                                                               | Bewertungskriterien                                                                                               | Ref. |
|----|-------------------|-------------------------------------------------|-------------------------------------------------|-------|
| CF1 | Fokussiertes Crawling von HTTP-Seiten           | Der fokussierte Crawler verwendet vordefinierte Seed-Listen, um auf Web-Ressourcen zuzugreifen, diese zu durchlaufen und bietet Filtermöglichkeiten für die Verfolgung von Links zu anderen Web-Ressourcen.                                          | Manueller Abgleich von Meta-Informationen bei Datenportalen mit den gecrawlten Daten.                             | AK11            |
| CF2 | Zugriff über verschiedene Protokolle            | Der Crawler kann auf Daten über verschiedene Standardprotokolle zugreifen, z. B. HTTPS und FTP                                                                                                                                                            | Testfälle für Crawler-Konnektoren; Verfügbarkeit von gecrawlten Daten von Seiten, die diese Protokolle verwenden. | AK11            |
| CF3 | Periodisches Crawling                           | Funktion zum Starten von periodischen und iterativen Crawling-Prozessen, die vom Crawling-Framework unterstützt wird, ist in der OPAL-Administration verfügbar.                                                                                     | Verfügbarkeit dieser Funktion mit Unit-/Integrationstest.                                                         | AK4             |
| CF4 | Fetching                                       | Relevante Rohdaten, die vom Crawler gefunden wurden, werden extrahiert und gespeichert.                                                                                                                                                                  | Präzisions-/Recall-Evaluierung mit manuell annotierten Goldstandard-Stichproben von Quellen.                      | AK11            |
| CF5 | Analyse                                         | Halbstrukturierte, geladene Daten werden analysiert, um nur auf relevante Teile zuzugreifen.                                                                                                                                                            | Präzisions-/Recall-Auswertung mit manuell annotierten Stichproben                                                 | AK12            |
| CF6 | Extraktion                                      | Rohdatenstrings werden aus umgebenden Strukturdaten (z. B. HTML-Tags) extrahiert.                                                                                                                                                                          | Extrahierte Daten enthalten keine Strukturinformationen.                                                     | AK12            |
| CF7 | Semantische, maschinenlesbare Daten-speicherung | Gefundene Daten sollten in einem Datenformat gespeichert werden, das geeignet ist, die Semantik der extrahierten Informationen zu handhaben, um sie in einem nachfolgenden Integrationsschritt zu verknüpfen. (z.B. Turtle, Terse RDF Triple Language) | Validierung der gecrawlten Daten.                                                                                 | AK7, AK9       |
| CF8 | Speicherung von zeitbezogenen Daten             | Die Crawler-Komponente reichert extrahierte Daten (siehe CF7) mit einem Zeitstempel an und speichert sie.                                                                                                                                                  | Unit-Test.                                                                                                        | AK17, AK4      |
| CF9 | CKAN-API-Unterstützung                          | Der Crawler kann die CKAN-API für einen effizienteren Datenzugriff nutzen.                                                                                                                                                                | Integrationstestfall.                                                                                             | -                |


**Nicht-funktionale Anforderungen**

Nicht-funktionale Anforderungen beschreiben Qualitätsaspekte, Rahmenbedingungen oder Anforderungen, die auf verschiedene Weise umgesetzt werden können. In der folgenden Tabelle werden diese bzgl. eines fokussierten Crawlers beschrieben, wobei eine Referenzierung auf AP 1.1 erfolgt.

| ID | Titel                              | Beschreibung                                                                                                                                                       | Bewertungskriterien                                                         | Ref. |
|----|-------------------|-------------------------------------------------|-------------------------------------------------|-------|
| CN1       | Konfiguration                      | Eine Konfiguration von Daten-Seeds (z. B. Katalogübersichten) ist über eine Benutzeroberfläche für Menschen und auf programmatische Weise (über eine API) möglich. | Verfügbarkeit der Konfigurations-UI und API, Testfälle.                    | -               |
| CN2       | Überwachung des Crawling-Prozesses | Die Crawler-Komponente bietet einen geeigneten Überblick über die laufenden Crawling-Prozesse.                                                                     | Umfrage unter den OPAL-Mitgliedern.                                         | -               |
| CN3       | Steuerung des Crawling-Prozesses   | Es gibt eine Möglichkeit, die Crawling-Komponente für die OPAL-Administration benutzerfreundlich manuell zu steuern (starten, stoppen).                          | Umfrage unter OPAL-Mitgliedern.                                             | AK6             |
| CN4       | Doku-mentation der Komponente       | Die Entwickler stellen eine Dokumentation für die Konfiguration des Crawlers zur Verfügung.                                                                        | Dokumentation.                                                              | -               |
| CN5       | Doku-mentation des Datenflusses     | Eine Beschreibung der Speicherung von Daten ist vorhanden.                                                                                                         | Dokumentation.                                                              | -               |
| CN6       | Zeiteffizientes Crawling           | Mehrere Instanzen oder Sub-Komponenten ermöglichen das parallele Crawlen einzelner oder mehrerer Ressourcen.                                                       | Test von sequentiellen und parallelen Crawling-Jobs.                        | -               |
| CN7       | Ordentliches Crawling              | Der Crawler sollte robots.txt respektieren und angemessene Pausen zwischen den Zugriffen einfügen.                                                                 | Integrationstest mit Server-Mock, der das Verhalten des Crawlers verfolgt. | -               |


**Vergleich bestehender Crawing-Framworks**

Gemäß der Vorhabensbeschreibung sollte die Implementierung der fokussierten Crawling-Komponente im OPAL-Projekt ein bestehendes Framework wiederverwenden. In der folgenden Tabelle werden bestehende relevante Open-Source-Crawler-Frameworks identifiziert und im Hinblick auf die bestehenden Anforderungen verglichen.

| Software     | CF1               | CF2          | CF3 | CF4 | CF5 | CF6 | CF7 | CF8 | CF9 |
|--------------|-------------------|--------------|-----|-----|-----|-----|-----|-----|-----|
| WebMagic     | X (Nur ein Link) | \checkmark (nur HTTP) | X   | (\checkmark)   | (\checkmark)   | (\checkmark)   | (\checkmark)   | (\checkmark)   | X   |
| StormCrawler | \checkmark                  | \checkmark (nur HTTP) | X   | X   | X   | X   | X   | X   | X   |
| Apache Nutch | \checkmark                  | \checkmark             | X   | \checkmark    | (\checkmark)   | (\checkmark)   | (\checkmark)   | X   | X   |
| REX          | \checkmark                  | \checkmark (nur HTTP) | X   | \checkmark    | \checkmark    | \checkmark    | \checkmark    | X   | X   |
| HTTrack      | \checkmark                  | \checkmark (nur HTTP) | (\checkmark)   | X   | X   | X   | X   | X   | X   |
| ldspider     | \checkmark                  | \checkmark (nur HTTP) | X   | \checkmark    | \checkmark    | \checkmark    | \checkmark    | \checkmark    | X   |
| slug         | \checkmark                  | \checkmark (nur HTTP) | (\checkmark)   | \checkmark    | \checkmark    | \checkmark    | \checkmark    | \checkmark    | X   |
| Apache Any23 | X (Nur ein Link) | \checkmark (nur HTTP) | X   | \checkmark    | \checkmark    | \checkmark    | X   | X   | X   |
| Squirrel     | (\checkmark)                 | \checkmark             | \checkmark    | (\checkmark)   | \checkmark    | \checkmark    | \checkmark    | \checkmark    | \checkmark    |
| TDSP         | X                 | X            | X   | \checkmark    | \checkmark    | \checkmark    | \checkmark    | \checkmark    | X   |

Entsprechend dieser Analyse wurde das Squirrel-Framework für eine nachfolgende Crawler-Implementierung ausgewählt, da die meisten Anforderungen direkt unterstützt werden und für die übrigen eine Erweiterung erfolgen kann.


**Weiterführende Inhalte**

* D2.1 Spezifikation der Crawler-Komponente: [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D2.1_Spezifikation_der_Crawler-Komponente.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D2.1_Spezifikation_der_Crawler-Komponente.pdf)

