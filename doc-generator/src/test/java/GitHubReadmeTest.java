import static org.junit.jupiter.api.Assertions.assertFalse;

import org.dice_research.opal.doc.Cfg;
import org.dice_research.opal.doc.github.GithubReadme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link GithubReadme}.
 *
 * @author Adrian Wilke
 */
class GitHubReadmeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetData() {
		assertFalse(GithubReadme.load(Cfg.getGithubUser(), "catfish").getData().isEmpty());
		assertFalse(GithubReadme.load(Cfg.getGithubUser(), "AGDISTIS", "opal").getData().isEmpty());
		assertFalse(GithubReadme.load(Cfg.getGithubUser(), "civet", "master", "README.md").getData().isEmpty());
	}

	@Test
	void testGetMarkdown() {
		String catfishMarkdown = GithubReadme.load(Cfg.getGithubUser(), "catfish").getMarkdown();
		assertFalse(catfishMarkdown.isEmpty());
		assertFalse(catfishMarkdown.contains("## Credits"));
	}

}