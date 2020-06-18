package org.dice_research.opal.doc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.dice_research.opal.doc.deliverables.Deliverable;
import org.dice_research.opal.doc.deliverables.DeliverablesParser;
import org.dice_research.opal.doc.github.GitHubRepositories;
import org.dice_research.opal.doc.github.GithubReadme;
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

		// Clear cache

		if (Cfg.getModes().contains("clearCache")) {
			Cache.clear();
		}

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

		// Generate data from README files

		if (Cfg.getModes().contains("documentation")) {
			StringBuilder stringBuilder = new StringBuilder();
			for (Entry<Repository, GithubReadme> entry : main.getReadmes().entrySet()) {
				String markdown = entry.getValue().getMarkdown();
				if (markdown != null) {
					stringBuilder.append(markdown);
				}
			}
			File file = new File(Cfg.getOutputDirectory(), "OPAL-Dokumentation.md");
			try {
				FileUtils.write(file, stringBuilder, StandardCharsets.UTF_8);
				System.out.println("To generate tex, use: " + "pandoc -s " + file.getAbsolutePath() + " -o "
						+ file.getAbsolutePath().replace(".md", ".tex"));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public GitHubRepositories gitHubRepositories;

	public List<Deliverable> getDeliverables() {
		return new DeliverablesParser().parse();
	}

	public List<Repository> getRepositories() {
		gitHubRepositories = new GitHubRepositories();
		return gitHubRepositories.getRepositories(Cfg.getGithubUser());
	}

	public Map<Repository, GithubReadme> getReadmes() {
		Map<Repository, GithubReadme> readmes = new HashMap<>();
		for (Repository repository : getRepositories()) {
			readmes.put(repository, GithubReadme.load(Cfg.getGithubUser(), repository.getName()));
		}
		return readmes;
	}

	private StringBuilder createRepositoriesMarkdown() {

		StringBuilder stringBuilder = new StringBuilder();

		// Get all repositories

		List<Repository> allRepositories = getRepositories();

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