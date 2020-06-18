package org.dice_research.opal.doc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
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

		// Create README contents for the OPAL documentation repository

		if (Cfg.getModes().contains("readme")) {
			System.out.println(new ReadmeGenerator().generate(Cfg.getGithubUser(), Cfg.getGithubTopic()).toString());
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

}