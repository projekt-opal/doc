package org.dice_research.opal.doc.deliverables;

import java.util.Comparator;

/**
 * Comparator for {@link Deliverable}s.
 *
 * @author Adrian Wilke
 */
public class DeliverablesComparator implements Comparator<Deliverable> {

	enum Order {
		ID, TITLE
	};

	private Order order;

	public DeliverablesComparator(Order order) {
		this.order = order;
	}

	@Override
	public int compare(Deliverable o1, Deliverable o2) {
		if (order.equals(Order.ID)) {
			return o1.id.compareToIgnoreCase(o2.id);
		} else {
			// Order.TITLE
			return o1.title.compareToIgnoreCase(o2.title);
		}
	}

}