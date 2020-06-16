package org.dice_research.opal.doc;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

/**
 * Parses deliverables at OPAL website.
 *
 * @author Adrian Wilke
 */
public class DeliverablesParser {

	public static final String DELIVERBLES_URL = "http://projekt-opal.de/en/results/deliverables/";

	/**
	 * Main entry point.
	 */
	public static void main(String[] args) {
		List<Deliverable> deliverables = new DeliverablesParser().parse();
		// TODO extract links
		for (Deliverable deliverable : deliverables) {
			System.out.println(deliverable);
		}
	}

	/**
	 * Parses deliverables table at {@link #DELIVERBLES_URL} and returns list of
	 * {@link Deliverable}s.
	 */
	private List<Deliverable> parse() {
		List<Deliverable> deliverables = new LinkedList<>();
		CleanerProperties cleanerProperties = new CleanerProperties();
		TagNode rootTagNode = null;
		try {
			rootTagNode = new HtmlCleaner(cleanerProperties).clean(new URL(DELIVERBLES_URL));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		TagNode tableTagNode = rootTagNode.getElementListByAttValue("id", "tablepress-1", true, false).get(0);
		List<? extends TagNode> trTagNodes = tableTagNode.getElementListByName("tr", true);
		for (TagNode trTagNode : trTagNodes) {
			List<? extends TagNode> tdTagNodes = trTagNode.getElementListByName("td", true);
			if (!tdTagNodes.isEmpty()) {
				Deliverable deliverable = new Deliverable();
				deliverable.id = tdTagNodes.get(0).getText().toString().trim();
				deliverable.title = tdTagNodes.get(1).getText().toString().trim();
				deliverable.due = tdTagNodes.get(2).getText().toString().trim();
				deliverable.milestone = tdTagNodes.get(3).getText().toString().trim();
				deliverables.add(deliverable);
			}
		}
		return deliverables;
	}
}