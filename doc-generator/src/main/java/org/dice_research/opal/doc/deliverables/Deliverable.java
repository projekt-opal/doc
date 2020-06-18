package org.dice_research.opal.doc.deliverables;

import java.util.LinkedList;
import java.util.List;

/**
 * Deliverable parsed by {@link DeliverablesParser}.
 *
 * @author Adrian Wilke
 */
public class Deliverable {

	String id;
	String title;
	String due;
	String milestone;
	List<String> linkTitles = new LinkedList<>();
	List<String> linkUrls = new LinkedList<>();

	@Override
	public String toString() {
		return id + " " + title + " " + due + " " + milestone + " " + linkUrls + " " + linkTitles;
	}

}