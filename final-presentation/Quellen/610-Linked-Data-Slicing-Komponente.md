## D6.1 Linked-Data-Slicing-Komponente

### Ansatz 1: ElasticTriples

- Import: **90 Millionen Triple** in **77 Minuten**  
  (16.3 GB im N-Triples Format)
- Splitting: Eine Anfrage dauert **2-3 Sekunden**.  
  Beispiel: 1 aus 1 Millionen **DCAT Datensätzen**  
  mit **206 zugehörigen Triplen**  
  nutzt intern 2.281 Anfragen
- Deliverable (Code): [ElasticTriples - Elasticsearch powered triple storage](https://github.com/projekt-opal/ElasticTriples)

## D6.1 Ansatz 2: OPAL Slicer

- Nutzt **Muster im SPARQL Format**  
  um Untermengen von **Wissensgraphen zu extrahieren**.
- Basiert auf RDFSlice Projekt
- Beispiel:

```
-source input.ttl
-patterns "Select * where {?d a <http://www.w3.org/ns/dcat#Dataset>}"
-out datasets.ttl
```

Deliverable (Code): [OPAL Slicer](https://github.com/projekt-opal/slicer) ✓

