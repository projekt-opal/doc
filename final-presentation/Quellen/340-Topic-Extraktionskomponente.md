## D3.4 Topic-Extraktionskomponente

### Ansatz 1: Topic-Extraction

- Extrahiert Entitäten aus **englischsprachigen Texten**  
  (z.B. **Topics**: **Ort**, **Datum**)
- Ergebnis:
    - date precision: 1.0
    - date recall: 0.087
    - date f1-score: 0.16
    - place precision: 1.0
    - place recall: 0.324
    - place f1-score: 0.489
- Problem: Viele Herausgeber → **heterogene Texte**
- Deliverable (Code): [Topic-Extraction](https://github.com/projekt-opal/Topic-Extraction)

## D3.4 Ansatz 2: Klassifizierung Kategorien

- Klassifizierung von **DCAT Kategorien** (themes)
- Nutzung von **Entscheidungsbäumen** und **TF-IDF**

![](../Medien/AP3.4-Klassifikation.png)

Deliverable (Code): [Classification](https://github.com/projekt-opal/classification) ✓

