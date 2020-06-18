package org.dice_research.opal.doc;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.dice_research.opal.doc.deliverables.Deliverable;
import org.dice_research.opal.doc.deliverables.DeliverablesParser;
import org.dice_research.opal.doc.github.GitHubRepositories;
import org.eclipse.egit.github.core.Repository;

/**
 * OPAL documentation generator.
 * 
 * Use the config.properties file for configuration.
 *
 * @author Adrian Wilke
 */
public class Main {

	/**
	 * Main entry point.
	 */
	public static void main(String[] args) {
		Main main = new Main();

		// Create repository overview in markdown

		if (Cfg.getModes().contains("repositories")) {
			main.gitHubRepositories = new GitHubRepositories();
			System.out.println(main.createRepositoriesMarkdown());
		}

		// Print deliverables

		if (Cfg.getModes().contains("deliverables")) {
			for (Deliverable deliverable : main.getDeliverables()) {
				System.out.println(deliverable);
			}
		}
	}

	public GitHubRepositories gitHubRepositories;

	public List<Deliverable> getDeliverables() {
		return new DeliverablesParser().parse();
	}

	private StringBuilder createRepositoriesMarkdown() {

		StringBuilder stringBuilder = new StringBuilder();

		// Get all repositories

		GitHubRepositories gitHubRepositories = new GitHubRepositories();
		List<Repository> allRepositories = gitHubRepositories.getRepositories(Cfg.getGithubUser());

		// Only print fetched repositories
		if (Boolean.FALSE) {
			System.err.println("Info: Only fetching repositories " + Main.class.getName());
			for (Repository repository : allRepositories) {
				stringBuilder.append(repository.getName());
				stringBuilder.append(System.lineSeparator());
			}
			return stringBuilder;
		}

		// Add main repositories

		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("## Repositories");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("### Main OPAL repositories");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(System.lineSeparator());
		List<Repository> mainRepositories = gitHubRepositories.filterMainRepositories(allRepositories,
				Cfg.getGithubTopic());
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

		return stringBuilder;
	}

}