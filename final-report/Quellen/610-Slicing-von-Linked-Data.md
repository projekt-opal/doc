\newpage

### Arbeitspaket 6.1: Slicing von Linked Data

Zum Slicing von großen Linked Data Graphen wurden die zwei folgenden Ansätze entwickelt.


**Ansatz 1: ElasticTriples**

Dieser Ansatz verwendet die Suchmaschine Elasticsearch. Dabei werden die Tripel-Bestandteile Subjekt, Prädikat und Objekt serialisiert, separiert und in drei entsprechende Felder geschrieben. Durch iterative Anfragen können Graphen einzelner Datensätze anschließend gebildet werden.

Ein Import von 90 Millionen Triple (16.3 GB im N-Triples Format) benötigt 77 Minuten. Für das anschließende Splitting sind je Datensatzgraphgröße 2 bis 3 Sekunden notwendig. Bei einer exemplarischen Extraktion wurden 206 zugehörige Triple mit 2.281 Einzelanfragen iterativ gesplittet.


**Ansatz 2: OPAL Slicer**

Dieser Ansatz nutzt Muster im SPARQL Format um Untermengen von Wissensgraphen zu extrahieren. Für diese Lösung wurde das RDFSlice Projekt verwendet. Dabei kommt das Extract-Transform-Load (ETL) Paradigma zum Einsatz. Es werden Graphmuster verwendet, die maximal eine Variable oder einen Identifizierer in den Join-Bedingungen des Musters verwendet. Durch diese Einschränkung entsteht ein Geschwindigkeitsvorteil gegenüber konventionellen Triplestores.


**Weiterführende Inhalte**

- Software ElasticTriples: [https://github.com/projekt-opal/ElasticTriples](https://github.com/projekt-opal/ElasticTriples)
- Software Slicer: [https://github.com/projekt-opal/slicer](https://github.com/projekt-opal/slicer)