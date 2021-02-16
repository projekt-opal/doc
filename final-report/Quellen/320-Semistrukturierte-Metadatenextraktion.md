\newpage

### Arbeitspaket 3.2: Semistrukturierte Metadatenextraktion

**Metadatenextraktion aus Portalen**

Semistrukturierte Metadaten sind in unterschiedlichen Datenrepräsentationen aufzufinden, beispielsweise in HTML-Tabellen. Durch maschinelle Erstellung solcher Tabellen tauchen innerhalb der Datenstrukturen Artefakte auf, die zur Identifizierung und Extraktion von Nutzdaten verwendet werden können. In der Anfangsphase des OPAL-Projekts wurden CSS-Klassenbezeichner genutzt, um den Squirrel-Crawler zu konfigurieren und relevante Daten zu extrahieren. Dieses Vorgehen ist während der Projektlaufzeit obsolet geworden, da sich Aktualisierungen der Portale ergaben. Beispielsweise wurde mit dem mCLOUD Release 1.5.0 eine maschinenlesbare Schnittstelle eingeführt, womit strukturierte Metadaten verfügbar gemacht wurden. Die ursprünglich verwendete Konfiguration des Squirrel Crawlers ist weiterhin in der Code-History auffindbar.


**Metadatenextraktion von Lizenzen**

Für den Bericht zur ersten Metadatenextraktionskomponente (Deliverable 3.3) wurden zudem eine Softwarekomponente geringen Umfangs zur Extraktion von Lizenz-URIs erstellt. Für das Abgabedokument wurden Lizenzen von rund 2.800 Metadatensätzen und 61.000 Distributionen (Versionen) aus mCLOUD und dem European Data Portal extrahiert. Die meistverwendete Lizenz dieser Statistik ist die Open Government Licence v2.0.

Im weiteren Projektverlauf wurden Lizenz-Identifikatoren (URIs) zur Referenzierung von Lizenzen genutzt und mit der ReCoDa-Komponente eine Lösung zur Berechnung von Kompatibilitäten umgesetzt (siehe Arbeitspaket 5.4).


**Weiterführende Inhalte**

* D3.3 Erste Metadatenextraktionskomponente (Adrian Wilke, Michael Röder): [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D3.3_Metadaten-Extraktion.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D3.3_Metadaten-Extraktion.pdf)
* Squirrel-Konfiguration für mCLOUD: [https://github.com/projekt-opal/squirrel-portals-config/commits/master/mcloud.yaml](https://github.com/projekt-opal/squirrel-portals-config/commits/master/mcloud.yaml)
* mCLOUD Release 1.5.0: [https://mcloud.de/web/guest/blog/-/blogs/mcloud-release-1-5-0](https://mcloud.de/web/guest/blog/-/blogs/mcloud-release-1-5-0)
* Software Daten-Statistiken: [https://github.com/projekt-opal/statistics](https://github.com/projekt-opal/statistics)
