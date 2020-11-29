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

	private List<Repository> repositories = null;

	/**
	 * Gets all repositories containing a topic.
	 */
	public static List<Repository> filterRepositoriesByTopic(List<Repository> repositories, String topicToContain) {
		List<Repository> filteredRepositories = new LinkedList<>();
		for (Repository repository : repositories) {
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
	 * Returns list of repositories.
	 */
	public List<Repository> getRepositories(String user) {
		if (repositories == null) {
			RepositoryService service = new RepositoryService();
			try {
				repositories = service.getRepositories(user);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		return repositories;
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
	public static List<String> getTopics(Repository repository) {

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
}