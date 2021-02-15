\newpage

### Arbeitspaket 2.3: Metadatenbasierte Crawlingstrategien: 

Squirrel setzt sich aus zwei Hauptkomponenten zusammen: Dem Frontier und Workern. Um eine vollständig erweiterbare Architektur zu erreichen, setzen beide Komponenten auf das Dependency Injektionsmuster, d.h. sie bestehen aus mehreren Modulen, die die einzelnen Funktionalitäten der Komponenten implementieren. Diese Module können in die Komponenten injiziert werden, was das Hinzufügen von weiteren Funktionalitäten ermöglicht. Zur Unterstützung der Injektion von Abhängigkeiten wurde Squirrel auf Basis des Spring-Frameworks implementiert. Die folgende Abbildung veranschaulicht die Architektur:

![](../Medien/AP2-2-Squirrel-Architektur.pdf)

Bei der Ausführung verfügt der Crawler über genau ein Frontier und eine Anzahl von Workern, die parallel arbeiten können. Das Frontier wird mit einer Liste von Seed-URIs initialisiert. Es normalisiert und filtert die URIs. Die beinhaltet die Prüfung beinhaltet, ob die URIs schon einmal durchlaufen wurden. Anschließend werden die URIs in die interne Warteschlange hinzugefügt. Sobald der Frontier eine Anforderung von einem Worker erhält, gibt er einen Satz von URIs an den Worker. Für jede gegebene URI holt der Worker den Inhalt des URIs ab, analysiert die empfangenen Daten, sammelt neue URIs und leitet die Daten an seine Senke weiter. Ist der Worker mit dem gegebenen Satz von URIs fertig, sendet er ihn zusammen mit den neu identifizierten URIs zurück an den Frontier Der Crawler implementiert eine periodische Neubewertung von URIs, von denen bekannt ist, dass sie in vergangenen Iterationen gecrawlt wurden.

Die Squirrel Worker dokumentieren den Crawling-Prozess indem sie Metadaten in einen Metadatengraphen schreiben. Diese Metadaten stützen sich hauptsächlich auf der PROV-Ontologie und wurden bei Bedarf erweitert. Die folgende Abbildung gibt einen Überblick über die generierten Metadaten:

![](../Medien/AP2-2-Squirrel-Aktivitaet.pdf)

Das Crawlen eines einzelnen URIs wird als eine Aktivität modelliert. Zu einer solchen Aktivität gehören Daten wie die Start- und Endzeit, die ungefähre Anzahl der empfangenen Triples und eine Statuszeile, die anzeigt, ob das Crawling erfolgreich war. Der Ergebnisgraph (oder die Ergebnisdatei im Falle einer dateibasierten Senke) ist eine Entität, die durch die Aktivität erzeugt wird. Sowohl der Ergebnisgraph als auch die Aktivität sind mit dem URI verbunden, der gecrawlt wurde.

Zu den metadatenbasierten wurde ein Artikel und das OPAL Projekt auf der International Semantic Web Conference 2020 vorgestellt und anschließend veröffentlicht.


**Weiterführende Inhalte**

* Squirrel – Crawling RDF Knowledge Graphs on the Web (Artikel von Michael Röder, Geraldo de Souza Jr, Axel-Cyrille Ngonga Ngomo): [https://link.springer.com/chapter/10.1007/978-3-030-62466-8_3](https://link.springer.com/chapter/10.1007/978-3-030-62466-8_3)
* Squirrel – Crawling RDF Knowledge Graphs on the Web (PDF): [https://papers.dice-research.org/2020/ISWC_Squirrel/public.pdf](https://papers.dice-research.org/2020/ISWC_Squirrel/public.pdf)
