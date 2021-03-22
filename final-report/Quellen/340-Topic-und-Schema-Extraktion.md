\newpage

### Arbeitspaket 3.4: Topic- und Schema-Extraktion

**Topic-Extraction**

Zur Extraktion von Entitäten aus englischsprachigen Texten wurde in Zusammenarbeit mit dem LIMBO Projekt eine Komponente basierend auf dem Maschinellen Lernen mittels der Bibliothek Rasa NLU (Natural Language Understanding) entwickelt. Basierend auf vorhandenen Beschreibungstexten wurde ein Modell trainiert um Orte, Stichwörter, Daten und Personen zu erkennen. Dadurch dass die Ursprungsdaten von unterschiedlichen Herausgebern und Autoren stammen und die Texte daher einen heterogenen Aufbau mit sich bringen, wurde im weiteren Projektverlauf die Extraktion von Orten mittels LauNuts fokussiert (siehe Arbeitspaket 3.3: Unstrukturierte Metadatenextraktion). Die folgende Tabelle zeigt die Ergebnisse der Topic-Komponente:

|                  | Genauigkeit (Precision) | Sensitivität (Recall) | F-Maß  |
|------------------|-------------------------|-----------------------|--------|
| Datum            | 1.0000                  | 0.0870                | 0.1600 |
| Stichwort        | 0.0000                  | 0.0000                | 0.0000 |
| Person           | 0.0000                  | 0.0000                | 0.0000 |
| Ort              | 1.0000                  | 0.3235                | 0.4889 |
| Keine Entität    | 0.8974                  | 1.0000                | 0.9459 |
| Mittel Micro     | 0.8990                  | 0.8990                | 0.8990 |
| Mittel Makro     | 0.5795                  | 0.2821                | 0.3190 |
| Mittel gewichtet | 0.8626                  | 0.8990                | 0.8602 |


**Klassifizierung von Kategorien**

Für Metadatensätze, die Beschreibungstexte beinhalten, jedoch nicht kategorisiert sind, wurde eine Komponente zur automatischen Klassifizierung von Kategorien entwickelt. Als Kategorien wurden Vorgaben verwendet, die im European Data Portal bestehen. Unter Verwendung der WEKA-Bibliothek wurden TF-IFD Wortvektoren generiert sowie J48-Entscheidungsbäume und ein Naiver Bayes-Klassifikator angewendet. Die Software wurde im Rahmen des OPAL Open Data Hackathon erstellt. Die folgende Tabelle zeigt Ergebnisse einer Kreuzvalidierung eines Durchlaufs mit 160 Instanzen:

| Klassifizierer | 1-Gram  | 2-Gram  | 3-Gram  | 4-Gram  |
|------------|---------|---------|---------|---------|
| J48        | 75,625% | 59,375% | 59,375% | 59,375% |
| NaiveBayes | 47,5%   | 31,875% | 36,875% | 35%     |


\newpage

**Weiterführende Inhalte**

* Software Topic-Extraction: [https://github.com/projekt-opal/Topic-Extraction](https://github.com/projekt-opal/Topic-Extraction)
* Software Classification: [https://github.com/projekt-opal/classification](https://github.com/projekt-opal/classification)
* Rasa NLU: [https://pypi.org/project/rasa-nlu/](https://pypi.org/project/rasa-nlu/)
* WEKA: [https://www.cs.waikato.ac.nz/ml/weka/](https://www.cs.waikato.ac.nz/ml/weka/)
