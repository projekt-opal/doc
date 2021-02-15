\newpage

###  Arbeitspaket 2.4: Benchmarking der Crawling-Komponente

Mit diesem Arbeitspaket und dem damit entstandenen ORCA-Benchmark wurde der erste Benchmark entwickelt, um die Leistung von Web und Data Web Crawlern fair zu bewerten. Der Benchmark erzeugt ein synthetisches Daten-Web, das vom Original-Web entkoppelt ist und einen fairen und wiederholbaren Vergleich von Data Web Crawlern ermöglicht. Die Auswertungen zeigen, dass der Benchmark verwendet werden kann, um die verschiedenen Vor- und Nachteile bestehender Crawler aufzuzeigen.

Die Hauptidee hinter ORCA ist die Sicherstellung der vergleichbaren Bewertung von Crawlern zu gewährleisten, indem ein lokales, synthetisches Data Web erstellt wird. Der Benchmark-Crawler wird dabei mit einem Satz von Seed-Knoten der synthetischen Wolke initialisiert und gestartet, um die komplette Wolke zu crawlen. Da die Wolke generiert wird, ist der Benchmark-Komponente bekannt, welche Triples gecrawlt werden sollen und kann die Vollständigkeit und die Geschwindigkeit des Crawlers messen. Da die Generierung der Wolke deterministisch ist, kann eine zuvor verwendete Wolke für das Benchmarking eines anderen Crawlers neu erzeugt werden, so dass dass die Auswertungsergebnisse vergleichbar sind, wenn die Experimente auf der gleichen Hardware ausgeführt werden.

Die folgende Abbildung zwigt eine Übersicht der Benchmark-Komponenten und des Datenflusses. (Orange: Benchmark-Komponenten; Grau: Synthetisches Datennetz; Dunkelblau: Benchmark-Crawler; Durchgehende Linien: Fluss der Daten; Gepunktete Linien: Verknüpfungen zwischen RDF-Datensätzen; die Zahlen geben die Ausführungsreihenfolge an.)

![](../Medien/AP2-4-Squirrel-Benchmark.pdf)

Die Ergebnisse des Benchmarks sind in nachfolgener Abbildung dargestellt. Es wurden der OPAL Crawler Squirrel und der LDSpider Crawler miteinander verglichen. Dabei wurden die Crawler mit unterschiedlichen Konfigurationen gestartet, so etwa Squirrel mit 1, 3, 9 bzw. 18 Worker-Komponenten. Insbesondere für das Data Web lieferte der Squirrel Crawler die besten Ergebnisse. Zudem kann Squirrel im Gegensatz zu LDSpider die RDF/JSON Serialisierung und Kompressionsformate behandeln.

![](../Medien/AP2-4-Squirrel-Benchmark-Ergebnisse.pdf)

Die Benchmarks und das OPAL Projekt wurden als Artikel auf der International Conference on Semantic Computing (ICSC 2021) vorgestellt. Eine Veröffentlichung findet im Laufe des Jahres statt. Die exakte technische Vorgehensweise ist im Artikel / Deliverable 2.6 beschrieben. Die entwickelte Software ist als Open Source veröffentlicht.

**Weiterführende Inhalte**

* ORCA – a Benchmark for Data Web Crawlers (Artikel von Michael Röder, Geraldo de Souza Jr., Denis Kuchelev, Abdelmoneim Amer Desouki, Axel-Cyrille Ngonga Ngomo): [https://papers.dice-research.org/2021/ICSC2021_ORCA/ORCA_public.pdf](https://papers.dice-research.org/2021/ICSC2021_ORCA/ORCA_public.pdf)
* Deliverable D2.3: Benchmark-Spezifikation und Ergebnisse des ersten Crawlers (Geraldo de Souza, Adrian Wilke): [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D2.3_Benchmark-specification_and_first_results_Crawler.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D2.3_Benchmark-specification_and_first_results_Crawler.pdf)
* ORCA Software: [https://w3id.org/dice-research/orca](https://w3id.org/dice-research/orca)
