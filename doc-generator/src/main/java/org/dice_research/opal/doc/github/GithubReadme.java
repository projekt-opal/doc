package org.dice_research.opal.doc.github;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dice_research.opal.doc.Cache;

/**
 * README.md files on GitHub.
 * 
 * Use load methods to create instances.
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

	public static GithubReadme load(String user, String repository) {
		return load(user, repository, "master");
	}

	public static GithubReadme load(String user, String repository, String branch) {
		return load(user, repository, branch, "README.md");
	}

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

	public URL getUrl() {
		try {
			return new URL("https://raw.githubusercontent.com/" + githubUser + "/" + githubRepository + "/"
					+ githubBranch + "/" + githubPath);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public String getData() {
		return data;
	}

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
}