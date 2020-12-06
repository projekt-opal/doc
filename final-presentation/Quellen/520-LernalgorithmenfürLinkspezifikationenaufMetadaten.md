## D5.2 Lernalgorithmen für Linkspezifikationen auf Metadaten

- **5 Experimente** zur **Deduplizierung**
- Linkspezifikationen für **OPAL/DCAT Datensätze**
- jeweils 30 GB Arbeitsspeicher
- Deliverable (Code): [OPAL Datenintegration](https://github.com/projekt-opal/linking)
- Deliverable als [PDF-Datei](https://hobbitdata.informatik.uni-leipzig.de/OPAL/Deliverables/OPAL_D5.2_Lernalgorithmen_fuer_Linkspezifikationen_auf_Metadaten.pdf)

## D5.2: WOMBAT unsupervised complete (1/5)

- Linkspezifikation: dcat:Dataset und  
  **23 optionale** weitere Eigenschaften
- Anzahl erkannter Duplikate:
    - 0 (Schwellenwert: 0,95)
    - 0 (Schwellenwert: 0,9)
- Aufgrund Größe der Eingabedaten bei der
Ausführung mit 30 GB Arbeitsspeicher vorzeitig beendet.  
java.lang.**OutOfMemoryError**: GC overhead limit exceeded

## D5.2: WOMBAT unsupervised simple II (2/5)

- Linkspezifikation: dcat:Dataset und  
  **23 optionale** weitere Eigenschaften
- Anzahl erkannter Duplikate:
    - 0 (Schwellenwert: 0,9)
    - 23.744.536 (Schwellenwert: 0,8)
- keine Ergebnisse und  
  zu viele Ergebnisse

## D5.2: WOMBAT unsupervised simple I (3/5)

- Linkspezifikation: dcat:Dataset,  
  Distributionen dcat:downloadURL und  
  **10 optionale** weitere Eigenschaften von
- Anzahl erkannter Duplikate:
    - 888 (Schwellenwert: 0,9)
    - 18.373 (Schwellenwert: : 0,5)
- **888 Duplikate von Datensätzen**

## D5.2: LIMES (Dataset) (4/5)

- Linkspezifikation: dcat:Dataset,  
  Distributionen dcat:downloadURL und  
  10 weitere optionale Eigenschaften von Distributionen
- **Anzahl erkannter Duplikate: 888 Datensätze**

### D5.2: LIMES (Distribution) (5/5)

- Linkspezifikation: dcat:Distribution  
  und dcat:downloadURL
- **Anzahl erkannter Duplikate: 1.833 Distributionen** ✓

