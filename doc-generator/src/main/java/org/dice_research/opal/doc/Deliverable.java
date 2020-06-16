package org.dice_research.opal.doc;

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

	@Override
	public String toString() {
		return id + " " + title;
	}
}