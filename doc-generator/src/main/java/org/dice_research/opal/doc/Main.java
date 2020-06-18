package org.dice_research.opal.doc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
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
			File readmeFile = new File("../README.md");
			Utils.write(readmeFile, new ReadmeGenerator().generate(Cfg.getGithubUser(), Cfg.getGithubTopic()).toString());
			System.out.println("Created README: " + readmeFile.getAbsolutePath());
			
//			System.out.println(new ReadmeGenerator().generate(Cfg.getGithubUser(), Cfg.getGithubTopic()).toString());
		}

		// Create backup of deliverables data

		if (Cfg.getModes().contains("deliverables")) {
			File backupFile = new File("src/main/resources/deliverables-backup.txt");
			Utils.write(backupFile, new DeliverablesParser().getDeliverableLines());
			System.out.println("Created deliverables backup: " + backupFile.getAbsolutePath());
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