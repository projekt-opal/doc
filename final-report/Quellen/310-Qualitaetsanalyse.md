\newpage

### Arbeitspaket 3.1: Qualitätsanalyse


**Spezifikation von Qualitätskriterien**

In der wissenschaftlichen Literatur wurden bereits unterschiedliche Aspekte zu offenen Daten und Metadaten untersucht. Die hier durchgeführte Literaturrecherche wurde hinsichtlich eines Systems zur automatischen Generierung von Qualitätsmerkmalen von Metadaten zu offenen Datensätzen im Bereich von Mobilitätsdaten durchgeführt. Das Ergebnis der Literaturrecherche ist der folgende Katalog, bestehend aus 13 Qualitätsdimensionen und 48 zugehörigen Qualitätskriterien und -metriken zur konkreten Implementierung.

**Ausdruckskraft**

![](../Medien/Tabelle-310.pdf)

**Zeitlich**

![](../Medien/Tabelle-310b.pdf)

\newpage

**Verständlichkeit**

![](../Medien/Tabelle-310c.pdf)

\newpage

**Rechte**

![](../Medien/Tabelle-310d.pdf)

\newpage

**Vertrauen**

![](../Medien/Tabelle-310e.pdf)

\newpage

**Community**

![](../Medien/Tabelle-310f.pdf)

**Vielseitigkeit**

![](../Medien/Tabelle-310g.pdf)

\newpage

**Repräsentation**

![](../Medien/Tabelle-310h.pdf)

\newpage

**Verknüpfung**

![](../Medien/Tabelle-310i.pdf)

**Erreichbarkeit**

![](../Medien/Tabelle-310j.pdf)

**Zugriff**

![](../Medien/Tabelle-310k.pdf)

\newpage

**Versionierung**

![](../Medien/Tabelle-310l.pdf)

**Daten**

![](../Medien/Tabelle-310m.pdf)



\newpage

**Qualitätsanalyse-Komponente**

Mit der Qualitätsanalyse-Komponente erfolgte eine Implementierung von Qualitätsmetriken. Die Komponente nimmt als Eingabe einen RDF-Graphen entgegen, der Tripel eines Metadateneintrages im DCAT Format enthalten muss. Vor Ausführung der Komponente besteht die Möglichkeit, folgende Einstellungen vorzunehmen:

* setIncludeLongRunning: Entscheidung, ob Metriken berechnet werden sollen, die voraussichtlich eine Lange Laufzeit benötigen. Dies ist z.B. die RetrievabilityMetric, bei deren Ausführung getestet wird, ob URIs im Web zugreifbar sind. In der Ausgangskonfiguration ist diese Option nicht gesetzt.
* setLogIfNotComputed: Entscheidung, ob in einer Datei festgehalten werden soll, falls eine Metrik für einen Datensatz z.B. wegen eines Ausnahmefehlers nicht berechnet werden kann. Diese Option ist in der Ausgangskonfiguration gesetzt.
* setRemoveMeasurements: Entscheidung, ob etwaige bereits bestehende Ergebnisse entfernt werden sollen. Dieser Fall trifft z.B. ein, wenn die Komponente mehrfach für denselben Datensatz ausgeführt wird. In der Ausgangskonfiguration ist diese Option gesetzt.

Als Ausgabe werden Ganzzahlen im Intervall [0..5] geschrieben, wobei 0 das schlechteste und 5 das beste Ergebnis darstellt. Als Vokabular wird das Data Quality Vocabulary (DQV) verwendet. Die folgende Abbildung zeigt ein Minimalbeispiel der Daten einer Ausführung:

![](../Medien/AP3-1-Civet.pdf)

Im Beispiel wurde als Eingabe (oberer Teil) eine Ressource genutzt, für die Angaben zur Lizenz, Stichwörtern, Herausgeber und einer Datenversion bestehen. Als Resultat wurden Werte für 5 Metriken berechnet. Die Komponente ist unter dem Namen *Civet* als Open Source veröffentlicht.




**Weiterführende Inhalte**

* D3.1 Spezifikation von Qualitätskriterien (Adrian Wilke, Ivan Ermilov, Matthias Wauer): [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D3.1_Specification_of_ quality_criteria.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables)
* D3.2 Qualitätsanalyse-Komponente (Adrian Wilke, Matthias Wauer): [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D3.2_Quality-analysis-component.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D3.2_Quality-analysis-component.pdf)
* Software Qualitätsanalyse: [https://github.com/projekt-opal/civet](https://github.com/projekt-opal/civet)
