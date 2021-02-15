- Kopieren der Original-Zeilen. Als Quelle nicht PDF verwenden, dort sind Zeilenumbrüche enthalten.
- Übersetzung https://www.deepl.com/
- Sprache berichtigen
- Kommas mit ;; ersetzen
- Zeilenumbrüche entfernen (Copy-Paste)
- Import/Export https://www.tablesgenerator.com/markdown_tables
- Spaltenbreite über Anzahl Minus-Zeichen
- ;; ersetzen




CF1

Fokussiertes Crawling von HTTP-Seiten

Der fokussierte Crawler verwendet vordefinierte Seed-Listen, um auf Web-Ressourcen zuzugreifen und diese zu durchlaufen, und bietet Filtermöglichkeiten für die Verfolgung von Links zu anderen Web-Ressourcen.

Manueller Abgleich von Meta-Informationen bei Datenportalen mit den gecrawlten Daten.

AK11


CF2

Zugriff über verschiedene Protokolle

Der Crawler kann auf Daten über verschiedene Standardprotokolle zugreifen, z. B. HTTPS und FTP

Testfälle für Crawler-Konnektoren; Verfügbarkeit von gecrawlten Daten von Sites, die diese Protokolle verwenden.

AK11



CF3

Periodisches Crawling

Eine Funktion zum Starten von periodischen und iterativen Crawling-Prozessen, die vom Crawling-Framework unterstützt wird, ist in der OPAL-Administration verfügbar.

Verfügbarkeit dieser Funktion mit Unit-/Integrationstest.

AK4


CF4

Abruf von

Relevante Rohdaten, die vom Crawler gefunden wurden, werden extrahiert und gespeichert.

Präzisions-/Recall-Evaluierung mit manuell annotierten Goldstandard-Stichproben von Quellen.

AK11



CF5

Analyse

Halbstrukturierte, abgeholte Daten werden analysiert, um nur auf relevante Teile zuzugreifen.

Präzisions-/Recall-Auswertung mit manuell annotierten Stichproben

AK12


CF6

Extraktion

Rohdatenstrings werden aus umgebenden Strukturdaten (z. B. HTML-Tags) extrahiert.

Die extrahierten Daten enthalten keine Strukturinformationen.

AK12


CF7

Semantische, maschinenlesbare Datenspeicherung

Gefundene Daten sollten in einem Datenformat gespeichert werden, das geeignet ist, die Semantik der extrahierten Informationen zu handhaben, um sie in einem nachfolgenden Integrationsschritt zu verknüpfen. (z.B. Turtle, Terse RDF Triple Language)

Validierung der gecrawlten Daten.

AK7, AK9



CF8

Speicherung von zeitbezogenen Daten

Die Crawler-Komponente reichert extrahierte Daten (siehe CF7) mit einem Zeitstempel an und speichert sie.

Unit-Test.

AK17, AK4


CF9

CKAN-API-Unterstützung

Der Crawler kann die CKAN-API für CKAN-Quellen für einen effizienteren Datenzugriff nutzen.

Integrationstestfall.










Schlüssel

Titel

Beschreibung

Bewertungskriterien

Referenz (D1.1)


CN1

Konfiguration

Eine Konfiguration von Daten-Seeds (z. B. Katalogübersichten) ist über eine Benutzeroberfläche für Menschen und auf programmatische Weise (über eine API) möglich.

Verfügbarkeit der Konfigurations-UI und API, Testfälle.


CN2

Überwachung des Crawling-Prozesses

Die Crawler-Komponente bietet einen geeigneten Überblick über die laufenden Crawling-Prozesse.

Umfrage unter den OPAL-Mitgliedern.


CN3

Steuerung des Crawling-Prozesses

Es gibt eine Möglichkeit, die Crawling-Komponente für die OPAL-Administration benutzerfreundlich manuell zu steuern (starten, stoppen).

Umfrage unter OPAL-Mitgliedern.

AK6


CN4

Dokumentation der Komponente

Die Entwickler stellen eine Dokumentation für die Konfiguration des Crawlers zur Verfügung.

Dokumentation.



CN5

Dokumentation des Datenflusses

Eine Beschreibung der Speicherung von Daten ist vorhanden.

Dokumentation.


CN6

Zeiteffizientes Crawling

Mehrere Instanzen oder Sub-Komponenten ermöglichen das parallele Crawlen einzelner oder mehrerer Ressourcen.

Test von sequentiellen und parallelen Crawling-Jobs.


CN7

Ordentliches Crawling

Der Crawler sollte robots.txt respektieren und angemessene Pausen zwischen den Zugriffen einfügen.

Integrationstest mit Server-Mock, der das Verhalten des Crawlers verfolgt.












