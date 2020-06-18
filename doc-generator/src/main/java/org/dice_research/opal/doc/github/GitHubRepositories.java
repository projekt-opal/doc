package org.dice_research.opal.doc.github;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.dice_research.opal.doc.Cache;
import org.dice_research.opal.doc.Cfg;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * GitHub access via GitHub Java API (org.eclipse.egit.github.core).
 * 
 * @see https://github.com/eclipse/egit-github/tree/master/org.eclipse.egit.github.core
 * 
 * @author Adrian Wilke
 */
public class GitHubRepositories {

	public static final String GITHUB_API_URL = "https://api.github.com";

	/**
	 * Gets all repositories containing a topic.
	 */
	public List<Repository> filterMainRepositories(List<Repository> repositories, String topicToContain) {
		List<Repository> filteredRepositories = new LinkedList<>();
		for (int i = repositories.size() - 1; i >= 0; i--) {
			Repository repository = repositories.get(i);
			for (String topic : getTopics(repository)) {
				if (topic.equals(topicToContain)) {
					filteredRepositories.add(repository);
					continue;
				}
			}
		}
		return filteredRepositories;
	}

	/**
	 * Prints table of repositories in markdown.
	 */
	public GitHubRepositories addMarkdownRepositoryTable(StringBuilder stringBuilder, List<Repository> repositories) {
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
		return this;
	}

	/**
	 * Gets topics.
	 * 
	 * Uses token to avoid rate limits.
	 * 
	 * GET /repos/:owner/:repo/topics
	 * 
	 * @see https://developer.github.com/v3/repos/#get-all-repository-topics
	 * @see https://developer.github.com/v3/rate_limit/
	 */
	public List<String> getTopics(Repository repository) {

		String json;

		// Cache
		String cacheId = "http://example.org/repositoryTopics/" + repository.getName();
		URL cacheURL = null;
		try {
			cacheURL = new URL(cacheId);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		if (Cache.has(cacheURL)) {
			json = Cache.get(cacheURL);
		} else {

			String url = GITHUB_API_URL + "/repos/" + repository.getOwner().getLogin() + "/" + repository.getName()
					+ "/topics";

			// Dirty, I know ...
			// https://www.codejava.net/java-se/networking/java-urlconnection-and-httpurlconnection-examples
			try {
				URL urlObj = new URL(url);
				URLConnection urlCon = urlObj.openConnection();
				urlCon.setRequestProperty("Accept", "application/vnd.github.mercy-preview+json");
				urlCon.setRequestProperty("Authorization", "token " + Cfg.getGithubToken());
				InputStream inputStream = urlCon.getInputStream();
				BufferedInputStream reader = new BufferedInputStream(inputStream);
				ByteArrayOutputStream writer = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				while ((bytesRead = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, bytesRead);
				}
				writer.close();
				reader.close();
				json = writer.toString();

				// Cache
				Cache.set(cacheURL, json);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		JSONObject jo = new JSONObject(json);
		JSONArray ja = jo.getJSONArray("names");
		List<String> topics = new ArrayList<>(ja.length());
		for (int i = 0; i < ja.length(); i++) {
			topics.add(ja.getString(i));
		}
		return topics;
	}

	/**
	 * Returns list of repositories.
	 */
	public List<Repository> getRepositories(String user) {
		RepositoryService service = new RepositoryService();
		try {
			return service.getRepositories(user);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}