package org.dice_research.opal.doc;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.GistService;
import org.eclipse.egit.github.core.service.RepositoryService;

/**
 * GitHub access via GitHub Java API (org.eclipse.egit.github.core).
 * 
 * @see https://github.com/eclipse/egit-github/tree/master/org.eclipse.egit.github.core
 * 
 * @author Adrian Wilke
 */
public class GitHub {

	public static final String USER = "projekt-opal";

	/**
	 * Main entry point.
	 */
	public static void main(String[] args) throws IOException {
		new GitHub().printRepositoryTable(USER);
	}

	/**
	 * Prints table of repositories in markdown.
	 */
	private void printRepositoryTable(String user) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("| Repository | Description |");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("| ---------- | ----------- |");
		stringBuilder.append(System.lineSeparator());
		for (Repository repo : getRepositories(user)) {
			stringBuilder.append("| [");
			stringBuilder.append(repo.getName());
			stringBuilder.append("](");
			stringBuilder.append(repo.getHtmlUrl());
			stringBuilder.append(") | ");
			stringBuilder.append(repo.getDescription() == null ? "" : repo.getDescription().trim());
			stringBuilder.append(" |");
			stringBuilder.append(System.lineSeparator());
		}
		System.out.println(stringBuilder.toString());
	}

	/**
	 * Returns list of repositories.
	 */
	public List<Repository> getRepositories(String user) throws IOException {
		RepositoryService service = new RepositoryService();
		return service.getRepositories(user);
	}

	/**
	 * Tests GitHubToken and creates Gist (works).
	 * 
	 * @see https://github.com/settings/tokens
	 * @see https://github.com/eclipse/egit-github/tree/master/org.eclipse.egit.github.core#creating-a-gist
	 */
	@SuppressWarnings("unused")
	private void createGist() throws IOException {
		GistFile file = new GistFile();
		file.setContent("System.out.println(\"Hello World\");");
		Gist gist = new Gist();
		gist.setDescription("Prints a string to standard out");
		gist.setFiles(Collections.singletonMap("Hello.java", file));
		GistService service = new GistService();
		service.getClient().setOAuth2Token(Cfg.getGithubToken());
		gist = service.createGist(gist);
		System.out.println(gist.getUrl());
	}

}