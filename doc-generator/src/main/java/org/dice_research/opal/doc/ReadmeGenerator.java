package org.dice_research.opal.doc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.dice_research.opal.doc.deliverables.Deliverable;
import org.dice_research.opal.doc.deliverables.DeliverablesParser;
import org.dice_research.opal.doc.github.GitHubRepositories;
import org.dice_research.opal.doc.github.RepositoryComparator;
import org.eclipse.egit.github.core.Repository;

/**
 * Generates README.md for https://github.com/projekt-opal/doc.
 *
 * @author Adrian Wilke
 */
public class ReadmeGenerator {

	private List<Repository> mainRepositories;
	private List<Repository> minorRepositories;
	private List<Repository> diceRepositories;

	private boolean addDeliverables = false;

	public ReadmeGenerator(boolean addDeliverables) {
		this.addDeliverables = addDeliverables;
	}

	public StringBuilder generate(String githubUser, String mainRepoTopic) {

		createRepositoryLists(githubUser, mainRepoTopic);

		StringBuilder stringBuilder = new StringBuilder();
		addResource(stringBuilder, "readmeHeader.md");
		addRepositories(stringBuilder, "Main OPAL repositories", mainRepositories);
		addRepositories(stringBuilder, "Related DICE repositories", diceRepositories);
		addRepositories(stringBuilder, "Additional OPAL repositories", minorRepositories);
		if (addDeliverables) {
			addDeliverables(stringBuilder);
		}
		addResource(stringBuilder, "readmeFooter.md");

		return stringBuilder;
	}

	private void createRepositoryLists(String githubUser, String mainRepoTopic) {
		GitHubRepositories gitHubRepositories = new GitHubRepositories();

		List<Repository> allRepositories = gitHubRepositories.getRepositories(githubUser);
		allRepositories.sort(new RepositoryComparator());

		mainRepositories = GitHubRepositories.filterRepositoriesByTopic(allRepositories, mainRepoTopic);

		minorRepositories = new LinkedList<Repository>(allRepositories);
		minorRepositories.removeAll(mainRepositories);

		diceRepositories = new LinkedList<Repository>();
		diceRepositories.add(new Repository().setName("DEER").setHtmlUrl("https://github.com/dice-group/deer")
				.setDescription("RDF Dataset Enrichment Framework (D5.5)"));
		diceRepositories.add(new Repository().setName("FOX").setHtmlUrl("https://github.com/dice-group/FOX")
				.setDescription("Federated Knowledge Extraction Framework (D3.3)"));
		diceRepositories.add(new Repository().setName("LIMES").setHtmlUrl("https://github.com/dice-group/LIMES")
				.setDescription("Link Discovery Framework for Metric Spaces (D5.*)"));
		diceRepositories.add(new Repository().setName("Squirrel").setHtmlUrl("https://github.com/dice-group/Squirrel")
				.setDescription("Squirrel searches and collects Linked Data (D2.*)"));
		diceRepositories
				.add(new Repository().setName("TeBaQA").setHtmlUrl("https://github.com/dice-group/TeBaQA/tree/opal")
						.setDescription("Template-Based Question Answering (D7.4)"));
	}

	private void addResource(StringBuilder stringBuilder, String resourceName) {
		try {
			stringBuilder.append(
					IOUtils.resourceToString(resourceName, StandardCharsets.UTF_8, this.getClass().getClassLoader()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void addRepositories(StringBuilder stringBuilder, String title, List<Repository> repositories) {
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("### ");
		stringBuilder.append(title);
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(System.lineSeparator());
		addMarkdownRepositoryTable(stringBuilder, repositories);
	}

	private void addMarkdownRepositoryTable(StringBuilder stringBuilder, List<Repository> repositories) {
		stringBuilder.append("| Repository | Description |");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("| ---------- | ----------- |");
		stringBuilder.append(System.lineSeparator());
		for (Repository repo : repositories) {
			stringBuilder.append("| [");
			stringBuilder.append(repo.getName());
			stringBuilder.append("](");
			stringBuilder.append(repo.getHtmlUrl());
			stringBuilder.append(") | ");
			stringBuilder.append(repo.getDescription() == null ? "" : repo.getDescription().trim());
			stringBuilder.append(" |");
			stringBuilder.append(System.lineSeparator());
		}
	}

	private void addDeliverables(StringBuilder stringBuilder) {
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("## Deliverables");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("| ID | Titel | Meilenstein |");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("| -- | ----- | ----------- |");
		stringBuilder.append(System.lineSeparator());

		for (Deliverable deliverable : new DeliverablesParser().get()) {
			stringBuilder.append("| ");
			stringBuilder.append(deliverable.id);

			stringBuilder.append(" | ");
			if (deliverable.linkUrls.isEmpty()) {
				stringBuilder.append(deliverable.title);
			} else {
				for (int i = 0; i < deliverable.linkUrls.size(); i++) {
					stringBuilder.append("[");
					stringBuilder.append(deliverable.linkTitles.get(i));
					stringBuilder.append("](");
					stringBuilder.append(deliverable.linkUrls.get(i));
					stringBuilder.append(") ");
				}
			}

			stringBuilder.append("| ");
			stringBuilder.append(deliverable.milestone);
			stringBuilder.append(" |");
			stringBuilder.append(System.lineSeparator());
		}
	}
}