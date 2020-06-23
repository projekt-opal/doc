package org.dice_research.opal.doc.github;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dice_research.opal.doc.Cache;

/**
 * README.md files on GitHub.
 * 
 * Usage: Use the load methods to create GithubReadme instances.
 *
 * @author Adrian Wilke
 */
public class GithubReadme {

	private static final Logger LOGGER = LogManager.getLogger();

	private String githubUser;
	private String githubRepository;
	private String githubBranch;
	private String githubPath;

	private String data;

	/**
	 * Loads a README file. Uses the master branch and "README.md" as path.
	 */
	public static GithubReadme load(String user, String repository) {
		return load(user, repository, "master");
	}

	/**
	 * Loads a README file. Uses "README.md" as path.
	 */
	public static GithubReadme load(String user, String repository, String branch) {
		return load(user, repository, branch, "README.md");
	}

	/**
	 * Loads a README file.
	 */
	public static GithubReadme load(String user, String repository, String branch, String path) {
		GithubReadme githubReadme = new GithubReadme();
		githubReadme.githubUser = user;
		githubReadme.githubRepository = repository;
		githubReadme.githubBranch = branch;
		githubReadme.githubPath = path;
		try {
			githubReadme.data = Cache.get(githubReadme.getUrl());
		} catch (Exception e) {
			LOGGER.error("Could not access " + githubReadme.getUrl().toString());
		}
		return githubReadme;
	}

	/**
	 * Gets the URL of the README file.
	 */
	public URL getUrl() {
		try {
			return new URL("https://raw.githubusercontent.com/" + githubUser + "/" + githubRepository + "/"
					+ githubBranch + "/" + githubPath);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Gets plain data of the README file.
	 */
	public String getData() {
		return data;
	}

	/**
	 * Removes credits from the README file data.
	 */
	public String getMarkdown() {
		String markdown = getData();

		// Do not process null

		if (markdown == null) {
			return markdown;
		}

		// Remove credits

		int creditsIndex = markdown.indexOf("## Credits");
		if (creditsIndex != -1) {
			markdown = markdown.substring(0, creditsIndex);
		}

		return markdown;
	}

	/**
	 * Removes credits and image-lines from the README file data.
	 */
	public String getMarkdownWithoutImages() {
		String markdown = getMarkdown();

		// Do not process null

		if (markdown == null) {
			return markdown;
		}

		// Go through lines and skip images

		String[] lines = markdown.split("\n");
		StringBuilder stringBuilder = new StringBuilder();
		for (String line : lines) {
			if (line.startsWith("![") || line.startsWith("[![")) {
				LOGGER.warn("Skipping " + githubBranch + " " + line);
			} else {
				stringBuilder.append(line);
				stringBuilder.append(System.lineSeparator());
			}
		}

		return stringBuilder.toString();
	}
}