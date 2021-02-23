\newpage

### Arbeitspaket 5.2: Lernalgorithmen für Linkspezifikationen

In diesem Teil wurden die Softwarekomponenten aus AP 5.1 in 5 Experimenten zur Deduplizierung angewendet. Aufbauend auf Linkspezifikationen für OPAL/DCAT Datensätzen stand für jedes Experiment jeweils 30 GB Arbeitsspeicher zur Verfügung. Die Experimente sind im Folgenden aufsteigend sortiert nach der Güte ihrer Ergebnisse beschrieben.

- In Experiment 1: WOMBAT als unsupervised complete wurden als Linkspezifikation dcat:Dataset und 23 optionale weitere Eigenschaften festgelegt. Sowohl bei Schwellenwerten von 0,95 und 0,9 wurden keine Duplikate erkannt, da die Ausführung aufgrund der Größe der Eingabedaten bei der trotz 30 GB Arbeitsspeicher mit einem OutOfMemoryError (GC overhead limit exceeded) vorzeitig beendet wurde.
- In Experiment 2: WOMBAT unsupervised simple II wurden ebenfalls dcat:Datasets und 23 optionale weitere Eigenschaften spezifiziert. Hier ergab ein Schwellenwert von 0,9 keine Duplikate und ein Schwellenwert von 0,8 rund 24 Millionen Duplikate. Entsprechend der Ergebniszahlen (keine Ergebnisse und zu viele Duplikate) lieferte dieses Experiment keine verwertbaren Ergebnisse.
- In Experimant 3: WOMBAT unsupervised simple I wurden sowohl dcat:Dataset als auch entsprechende Distributionen dcat:downloadURL und deren 10 optionale weitere Eigenschaften spezifiziert. Ein Schwellenwert von 0,5 ergab rund 18.000 Duplikate, ein Schwellenwert von 0,9 ergab 888 duplizierte Datensätze. Die erkannten 888 Datensätze konnten später bestätigt werden, so dass über Download-URls der jeweiligen Distributionen eine Deduplizierung möglich ist.
- In Experiment 4: LIMES (Dataset) wurde dieselbe Linkspezifikation verwendet; hier wurde LIMES core anstelle von WOMBAT verwendet. Erneut wurden 888 duplizierte Datensätze gefunden.
- In Experiment 5: LIMES (Distribution) wurde die Spezifizierung der Datensätze entfernt und ein Fokus auf Distributionen gesetzt. Es wurden 1.833 Duplikate von Distributionen gefunden.

Abschließend empfehlen wir zum Finden von Duplikaten die Verwendung von Download-URLs, um mehrfach auftretende Datensätze zu dedektieren. Dies ist für Anwendungsfälle relevant, in denen Daten aus mehreren Portalen zur Verfügung stehen und gleiche Datensätze erkannt werden müssen.


**Weiterführende Inhalte**

- D5.2 Lernalgorithmen für Linkspezifikationen auf Metadaten (Adrian Wilke, Mohamed Sherif): [OPAL Datenintegration](https://github.com/projekt-opal/linking)
- Software zur Datenextraktion: [OPAL Datenintegration](https://github.com/projekt-opal/linking)
