\newpage

### Arbeitspaket 4.1: Vokabularspezifikation

Nach Sichtung von Literatur, Portalen und verfügbaren Schnittstellen wurde 2018 als Hauptvokabular eine Auswahl von Identifizierern aus dem Data Catalog Vocabulary (DCAT) in Version 1 festgelegt. Nachdem im Februar 2010 DCAT Version 2 als W3C Recommendation veröffentlicht wurde, fand eine Erweiterung des OPAL Vokabulars auf dies statt. DCAT spezifiziert Klassen und deren Beziehungen und gibt Empfehlungen für den Einsatz weiterer Vokabulare (z.B. Dublin Core, Friend of a Friend), die in OPAL berücksichtigt und verwendet werden. Für Qualitätsmetriken wird das Data Quality Vocabulary (DQV) eingesetzt (siehe Beispiel in AP 3.1: Qualitätsanalyse). In Fällen in denen es notwendig war eigene Identifizierer zu spezifizieren wurden die entsprechenden Konstanten in der OPAL Common Komponente festgelegt. Die folgende Abbildung zeigt eine Übersicht der wichtigsten Klassen und Beziehungen aus DCAT und DQV, so wie sie in OPAL Verwendung finden. Dabei stellt Dataset eine Spezialisierung von Resource dar, so dass alle Prädikate auch dort verwendet werden. Ein Dataset beschreibt einen Metadateneintrag und Distribution dessen Versionen, die beispielsweise als verschiedene Repräsentationsformen (z.B. CSV und Excel) umgesetzt werden.

![](../Medien/AP4-1-Vokabular.pdf)

**Weiterführende Inhalte**

* D4.1 Vokabularspezifikation (Afshin Amini, Zafar Habeeb Syed): [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D4.1_Vocabulary-specification.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D4.1_Vocabulary-specification.pdf)
* Data Catalog Vocabulary (DCAT): [www.w3.org/TR/vocab-dcat-2](https://www.w3.org/TR/vocab-dcat-2/)
* Data Quality Vocabulary (DQV): [www.w3.org/TR/vocab-dqv](https://www.w3.org/TR/vocab-dqv/)
* OPAL Common Vokabular: [https://github.com/projekt-opal/common/tree/master/src/main/java/org/dice_research/opal/common/vocabulary](https://github.com/projekt-opal/common/tree/master/src/main/java/org/dice_research/opal/common/vocabulary)
