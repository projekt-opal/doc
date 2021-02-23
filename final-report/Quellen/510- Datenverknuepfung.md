\newpage

### Arbeitspaket 5.1: Datenverknüpfung

Als Komponente zur Datenverknüpfung wurde LIMES (Link Discovery Framework for Metric Spaces) ausgewählt und im Verlauf des Projekts erweitert. LIMES kann dazu verwendet werden, Überschneidungen in verschiedenen Wissensgraphen zu finden und wurde in OPAL primär eingesetzt, um Verknüpfungen zwischen gleichen Ressourcen in verschiedenen Wissengraphen zu erstellen. Der Fokus liegt dabei auf geografischen Ähnlichkeiten, die durch Einsatz unterschiedlicher Metriken gefunden werden. Der ursprüngliche LIMES-Ansatz verwendet die Dreiecksungleichung um die Anzahl benötigter Vergleiche zwischen Wissensgraphen zu verringern.

Die Erweiterung WOMBAT, ein Ansatz des Maschinellen Lernens (ML) zur Link Discovery, wurde ebenso eingesetzt. Der Ansatz besteht aus zwei aufeinander aufbauenden Teilen: Ein einzelner (atomic) Vergleich von Bestandteilen zweier Graphen und eine anschließende Kombinierung (generalization). Hierbei bestehen die Möglichkeiten, das Supervised Learning, das ausschließlich positive Lernbeispiele benötigt, einzusetzen oder das Unsupervised Learning, das ohne Lernbeispiele auskommt.

Im Rahmen von OPAL wurde auch DRAGON (Decision Tree Learning for Link Discovery) entwickelt, dass Entscheidungsbäume zum Erlernen von Linkspezifikationen verwendet und beim rekursiven Erstellen von Entscheidungsbäumen entweder die Trefferquote (recall) unter Verwendung des lokalen Gini Index oder die Genauigkeit (precision) unter Verwendung des globalen F-Maß fokussiert.

LIMES wurde im Projektrahmen zu einem Framework erweitert, so auch die LIMES Benutzeroberfläche. Weiterhin kann das RDF Dataset Enrichment Framework DEER verwendet werden. Experimente sind in AP 5.2: Lernalgorithmen für Linkspezifikationen aufgeführt.


**Weiterführende Inhalte**

- Software LIMES - Link Discovery Framework for Metric Spaces: [https://github.com/dice-group/LIMES/](https://github.com/dice-group/LIMES/)
- Software DEER - RDF Dataset Enrichment Framework: [https://github.com/dice-group/deer](https://github.com/dice-group/deer)
- LIMES - A Framework for Link Discovery on the Semantic Web (Artikel von Axel-Cyrille Ngonga Ngomo, Mohamed Ahmed Sherif, Kleanthi Georgala, Mofeed Hassan, Kevin Dreßler, Klaus Lyko, Daniel Obraczka, Tommaso Soru): [https://papers.dice-research.org/2021/KI_LIMES/public.pdf](https://papers.dice-research.org/2021/KI_LIMES/public.pdf)
- Limes Web UI (Artikel von Mohamed Ahmed Sherif, Pestryakova Svetlana, Kevin Dreßler, Axel-Cyrille Ngonga Ngomo): [http://ceur-ws.org/Vol-2456/paper53.pdf](http://ceur-ws.org/Vol-2456/paper53.pdf)
- Dragon: Decision Tree Learning for Link Discovery (Artikel von Daniel Obraczka, Axel-Cyrille Ngonga Ngomo)[https://doi.org/10.1007/978-3-030-19274-7_51](https://doi.org/10.1007/978-3-030-19274-7_51)
