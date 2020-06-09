package org.dice_research.opal.doc;

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
	 */
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();

		// Get all repositories

		GitHubRepositories gitHubRepositories = new GitHubRepositories();
		List<Repository> allRepositories = gitHubRepositories.getRepositories(USER);

		// Only print fetched repositories
		if (Boolean.FALSE) {
			System.err.println("Info: Only fetching repositories " + Main.class.getName());
			for (Repository repository : allRepositories) {
				stringBuilder.append(repository.getName());
				stringBuilder.append(System.lineSeparator());
			}
			System.out.println(stringBuilder.toString());
			return;
		}

		// Add main repositories

		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("## Repositories");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("### Main OPAL repositories");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(System.lineSeparator());
		List<Repository> mainRepositories = gitHubRepositories.filterMainRepositories(allRepositories, OPAL_TOPIC);
		mainRepositories.sort(new Comparator<Repository>() {
			@Override
			public int compare(Repository o1, Repository o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
		gitHubRepositories.addMarkdownRepositoryTable(stringBuilder, mainRepositories);

		// Add other repositories

		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("### Additional OPAL repositories");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(System.lineSeparator());
		List<Repository> minorRepositories = new LinkedList<Repository>(allRepositories);
		minorRepositories.removeAll(mainRepositories);
		gitHubRepositories.addMarkdownRepositoryTable(stringBuilder, minorRepositories);

		System.out.println(stringBuilder.toString());
	}

}