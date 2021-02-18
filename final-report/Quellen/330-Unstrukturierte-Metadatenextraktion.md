\newpage

### Arbeitspaket 3.3: Unstrukturierte Metadatenextraktion

**Spracherkennung**

In RDF besteht die technische Möglichkeit, Literale mit einer Sprachauszeichnung zu versehen. Für Literale, zu denen keine Sprache spezifiziert ist, wird eine Spracherkennung auf Basis von Apache OpenNLP durchgeführt. Als Eingabe werden hier Titel- und Beschreibungstext von Metadatensätzen verwendet. Im Fall dass Apache OpenNLP für eine Sprache eine Wahrscheinlichkeit überhalb eines Schwellenwertes zurück gibt, werden die entsprechendent Sprach-Tags von Titel- und Beschreibungsliteralen aktualisiert.


**Geografische Daten**

Zur Anreicherung der Metadatensätze mit geografischen Angaben wurden die Geodatenbanken Nomenclature of Territorial Units for Statistics (NUTS) und Local Administrative Units (LAU) verwendet. Mit diesen steht eine hierarchische Datenbank mit Geopolygonen und entsprechenden Eigennamen von Orten zur Verfügung. Für die Datenextraktion wurde zunächst die Komponente LauNuts verwendet. Auf dieser Basis können 8.495 Orte in Deutschland in Volltexten dedektiert werden. Die angereicherten Daten werden im Projektverlauf für eine Geo-Suche verwendet.


**Eigennamenerkennung und Disambiguierung von Entitäten**

Zur Named Entity Recognition wurde FOX (Federated knOwledge eXtraction framework) eingesetzt. Die eingebettete Komponente kam für die Eigennamenerkennung von Orten zum Einsatz. Hierzu wurden folgenden Webservices implementiert:

- metadata/fox: Gibt die extrahierten Ergebnisse aus FOX im Turtle-Format zurück.
- metadata/fox/location/names: Gibt erkannte Ortsnamen im JSON-Format zurück.
- metadata/fox/location/uris: Gibt Identifikatoren (URIs) erkannter Ortsnamen im JSON-Format zurück.

Während das FOX-Framework selbst die Eigennamenerkennung übernimmt, nutzt das Framework AGDISTIS/MAG zur Disambiguierung der Entitäten. Siehe hierzu AP 4.4: Indizierungskomponente.


**Weiterführende Inhalte**

* D3.3 Erste Metadatenextraktionskomponente (Adrian Wilke, Michael Röder): [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D3.3_Metadaten-Extraktion.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D3.3_Metadaten-Extraktion.pdf)
* Software Metadatenextraktion: [https://github.com/projekt-opal/metadata-refinement](https://github.com/projekt-opal/metadata-refinement)
* Software Metadatenextraktion (mit Named Entity Recognition): [https://github.com/projekt-opal/metadata-refinement/tree/metadata-alpha](https://github.com/projekt-opal/metadata-refinement/tree/metadata-alpha)
* Software LauNuts: [https://github.com/projekt-opal/LauNuts](https://github.com/projekt-opal/LauNuts)
* Software FOX - Federated Knowledge Extraction Framework: [https://github.com/dice-group/FOX](https://github.com/dice-group/FOX)

