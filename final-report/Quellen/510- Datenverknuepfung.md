\newpage

### Arbeitspaket 5.1: Datenverknüpfung

## D5.1 Erste Version der Verknüpfungskomponente

![](../Medien/AP5.1-Limes.png)

- Deliverable (Code): [LIMES 1.5.0](https://github.com/dice-group/LIMES/releases/tag/1.5.0)
- Im Folgenden verwendet

LIMES (1/3)

- **LIMES**: Link Discovery Framework for Metric Spaces
- **Überschneidungen** in versch. Wissensgraphen **finden**
    - z.B. **Erstellung Verknüpfungen** zwischen gleichen
Ressourcen in verschiedenen Wissensgraphen
    - z.B. **geografische Ähnlichkeiten** finden
- Verwendung von **Metriken**, die Inhalte vergleichen
- Verwendet Dreiecksungleichung (aus der Geometrie / Mathematik).
- Verringert Anzahl benötigter
Vergleiche.
- LIMES-Framework: Grundlage maschinellen Lernens

WOMBAT (2/3)

- **WOMBAT**: A Generalization Approach for Automatic Link Discovery
- Ansatz des Maschinellen Lernens (ML) zur Link Discovery
- **Supervised Learning**, benötigt ausschließlich positive Lernbeispielen
- **Unsupervised Learning**, ohne Lernbeispiele
- Algorithmus : Zwei aufeinander aufbauende Teile
    - Einzelner (atomic) Vergleich von Bestandteilen zweier Graphen
    - Kombinierung (generalization)

DRAGON (3/3)

- **DRAGON**: Decision Tree Learning for Link Discovery
- Verwendet **Entscheidungsbäume** zum Erlernen von Link Spezifikationen
- Beim rekursiven Erstellen von Entscheidungsbäumen kann
dabei
    - entweder die Trefferquote (recall) unter Verwendung des lokalen Gini Index, oder
    - die Genauigkeit (precision) unter Verwendung des globalen F-Maß fokussiert werden
- Im Rahmen von **OPAL** entwickelt ([Springer](https://link.springer.com/chapter/10.1007%2F978-3-030-19274-7_31))  
 u.a. auch: [LimesWebUI](http://ceur-ws.org/Vol-2456/paper53.pdf)



![](../Medien/AP5.1-Limes.png)

- RDF Dataset Enrichment Framework: [DEER](https://github.com/dice-group/deer)
- Deliverable (Code): [LIMES 1.7.4](https://github.com/dice-group/LIMES/releases/tag/1.7.4)


**Weiterführende Inhalte**

* D1.3 Architektur: [https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D1.3_Architecture.pdf](https://github.com/projekt-opal/doc/blob/master/deliverables/OPAL_D1.3_Architecture.pdf)

