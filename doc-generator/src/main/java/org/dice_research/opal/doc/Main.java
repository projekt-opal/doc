package org.dice_research.opal.doc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.dice_research.opal.doc.deliverables.DeliverablesParser;
import org.dice_research.opal.doc.github.GitHubRepositories;
import org.dice_research.opal.doc.github.GithubReadme;
import org.dice_research.opal.doc.github.RepositoryComparator;
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

		// Create README contents for the OPAL documentation repository

		if (Cfg.getModes().contains("readme")) {
			File readmeFile = new File("../README.md");
			Utils.write(readmeFile,
					new ReadmeGenerator().generate(Cfg.getGithubUser(), Cfg.getGithubTopic()).toString());
			System.out.println("Created README: " + readmeFile.getAbsolutePath());
		}

		// Create backup of deliverables data

		if (Cfg.getModes().contains("deliverables")) {
			File backupFile = new File("src/main/resources/deliverables-backup.txt");
			Utils.write(backupFile, new DeliverablesParser().getDeliverableLines());
			System.out.println("Created deliverables backup: " + backupFile.getAbsolutePath());
		}

		// Generate documentation from README files

		if (Cfg.getModes().contains("documentation")) {
			StringBuilder stringBuilder = new StringBuilder();
			for (Entry<Repository, GithubReadme> entry : main.getReadmes(Cfg.getGithubTopic()).entrySet()) {
				String markdown = entry.getValue().getMarkdownWithoutImages();
				if (markdown != null) {
					stringBuilder.append(System.lineSeparator());
					stringBuilder.append("\\newpage");
					stringBuilder.append(System.lineSeparator());
					stringBuilder.append(markdown);
				}
			}
			File file = new File(Cfg.getOutputDirectory(), "OPAL-Dokumentation.md");
			try {
				FileUtils.write(file, stringBuilder, StandardCharsets.UTF_8);
				System.out.println("Generated " + file.getAbsolutePath());
				System.out.println("To generate tex, use: " + new File("../doc-latex/pandoc.sh").getCanonicalPath());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private Map<Repository, GithubReadme> getReadmes(String mainRepoTopic) {

		// Get all repos
		GitHubRepositories gitHubRepositories = new GitHubRepositories();
		List<Repository> repositories = gitHubRepositories.getRepositories(Cfg.getGithubUser());

		// Filter main repos
		List<Repository> mainRepos = GitHubRepositories.filterRepositoriesByTopic(repositories, mainRepoTopic);

		// Filter active repositories
		filterFinalRepos(mainRepos);

		// Get readme files
		Map<Repository, GithubReadme> readmes = new TreeMap<>(new RepositoryComparator());
		for (Repository repository : mainRepos) {
			if (repository.getName().equals("AGDISTIS")) {
				readmes.put(repository, GithubReadme.load(Cfg.getGithubUser(), repository.getName(), "opal"));
			} else {
				readmes.put(repository, GithubReadme.load(Cfg.getGithubUser(), repository.getName()));
			}
		}
		return readmes;
	}

	private void filterFinalRepos(List<Repository> repositories) {
		List<String> reposInDev = new LinkedList<>();

		// Do not include doc infos twice
		reposInDev.add("doc");

		// SocialBot is in dev
		reposInDev.add("dcat-qa");

		// Should finally become own repos, if important
		reposInDev.add("misc");

		// No contents
		reposInDev.add("squirrel-portals-config");

		for (int i = repositories.size() - 1; i >= 0; i--) {
			if (reposInDev.contains(repositories.get(i).getName())) {
				repositories.remove(i);
			}
		}

	}

}