package org.dice_research.opal.doc.archieve;

import java.io.IOException;
import java.util.Collections;

import org.dice_research.opal.doc.Cfg;
import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;
import org.eclipse.egit.github.core.service.GistService;

/**
 * GitHub API tests (not used).
 *
 * @author Adrian Wilke
 */
public class GitHubApiTest {

	/**
	 * Tests GitHubToken and creates Gist (works).
	 * 
	 * @see https://github.com/settings/tokens
	 * @see https://github.com/eclipse/egit-github/tree/master/org.eclipse.egit.github.core#creating-a-gist
	 */
	@SuppressWarnings("unused")
	public static void createGist() throws IOException {
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
