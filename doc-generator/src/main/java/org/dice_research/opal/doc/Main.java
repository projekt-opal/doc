package org.dice_research.opal.doc;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.egit.github.core.Repository;

/**
 * Main entry point.
 *
 * @author Adrian Wilke
 */
public class Main {

	public static final String USER = "projekt-opal";
	public static final String OPAL_TOPIC = "opal";

	/**
	 * Main entry point.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();

		// Get all repositories
		GitHubRepositories gitHubRepositories = new GitHubRepositories();
		List<Repository> allRepositories = gitHubRepositories.getRepositories(USER);

		// Add main repositories
		List<Repository> mainRepositories = gitHubRepositories.filterMainRepositories(allRepositories, OPAL_TOPIC);
		mainRepositories.sort(new Comparator<Repository>() {
			@Override
			public int compare(Repository o1, Repository o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		gitHubRepositories.addMarkdownRepositoryTable(stringBuilder, mainRepositories);

		stringBuilder.append(System.lineSeparator());

		// Add other repositories
		List<Repository> minorRepositories = new LinkedList<Repository>(allRepositories);
		minorRepositories.removeAll(mainRepositories);
		gitHubRepositories.addMarkdownRepositoryTable(stringBuilder, minorRepositories);

		System.out.println(stringBuilder.toString());
	}

}