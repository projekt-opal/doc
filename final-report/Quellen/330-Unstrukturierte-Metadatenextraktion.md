\newpage

### Arbeitspaket 3.3: Unstrukturierte Metadatenextraktion

**Spracherkennung**

In RDF besteht die technische Möglichkeit, Literale mit einer Sprachauszeichnung zu versehen. Für Literale, zu denen keine Sprache spezifiziert ist, wird eine Spracherkennung auf Basis von Apache OpenNLP durchgeführt. Als Eingabe werden hier Titel- und Beschreibungstext von Metadatensätzen verwendet. Im Fall dass Apache OpenNLP für eine Sprache eine Wahrscheinlichkeit überhalb eines Schwellenwertes zurück gibt, werden die entsprechendent Sprach-Tags von Titel- und Beschreibungsliteralen aktualisiert.


**Geografische Daten**

Zur Anreicherung der Metadatensätze mit geografischen Angaben wurden die Geodatenbanken Nomenclature of Territorial Units for Statistics (NUTS) und Local Administrative Units (LAU) verwendet. Mit diesen steht eine hierarchische Datenbank mit Geopolygonen und entsprechenden Eigennamen von Orten zur Verfügung. Für die Datenextraktion wurde zunächst die Komponente LauNuts verwendet. Auf dieser Basis können 8.495 Orte in Deutschland in Volltexten dedektiert werden. Die angereicherten Daten werden im Projektverlauf für eine Geo-Suche verwendet.


**Eigennamenerkennung und Disambiguierung von Entitäten**

Zur Named Entity Recognition wurde FOX verwendet. FOX nutzt AGDISTIS/MAG zur Disambiguierung. Die genannten Komponenten wurden im Rahmen von OPAL weiterentwickelt und wurden u.a. auf den Konferenzen European Semantic Web Conference (ESWC 2018) und Knowledge Capture Conference (K-CAP 2017) vorgestellt.




**Weiterführende Inhalte**

* D3.3 Erste Metadatenextraktionskomponente (Adrian Wilke, Michael Röder): [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D3.3_Metadaten-Extraktion.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D3.3_Metadaten-Extraktion.pdf)
* Software Metadatenextraktion: [https://github.com/projekt-opal/metadata-refinement](https://github.com/projekt-opal/metadata-refinement)
* Software Metadatenextraktion (mit Named Entity Recognition): [https://github.com/projekt-opal/metadata-refinement/tree/metadata-alpha](https://github.com/projekt-opal/metadata-refinement/tree/metadata-alpha)
* Software LauNuts: [https://github.com/projekt-opal/LauNuts](https://github.com/projekt-opal/LauNuts)
* Software FOX - Federated Knowledge Extraction Framework: [https://github.com/dice-group/FOX](https://github.com/dice-group/FOX)
* Entity Linking in 40 Languages using MAG (Artikel von Diego Moussallem, Ricardo Usbeck, Michael Röder, Axel-Cyrille Ngonga Ngomo): [https://arxiv.org/abs/1805.11467](https://arxiv.org/abs/1805.11467)
* MAG: A Multilingual, Knowledge-base Agnostic and Deterministic Entity Linking Approach (Artikel von Diego Moussallem, Ricardo Usbeck, Michael Röder, Axel-Cyrille Ngonga Ngomo): [https://svn.aksw.org/papers/2017/KCAP_MAG/public.pdf](https://svn.aksw.org/papers/2017/KCAP_MAG/public.pdf)
