package org.dice_research.opal.doc.github;

import java.util.Comparator;

import org.eclipse.egit.github.core.Repository;

/**
 * Compares repositories by name.
 *
 * @author Adrian Wilke
 */
public class RepositoryComparator implements Comparator<Repository> {

	@Override
	public int compare(Repository o1, Repository o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}