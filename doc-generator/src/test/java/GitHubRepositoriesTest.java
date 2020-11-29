import java.util.List;

import org.dice_research.opal.doc.Cfg;
import org.dice_research.opal.doc.github.GitHubRepositories;
import org.eclipse.egit.github.core.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Tests {@link GitHubRepositories}.
 *
 * @author Adrian Wilke
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GitHubRepositoriesTest {

	GitHubRepositories gitHubRepositories;

	@BeforeEach
	void setUp() throws Exception {
		gitHubRepositories = new GitHubRepositories();
	}

	@Test
	@Order(1)
	void testGetRepositories() {
		List<Repository> repositories = getRepositories();
		Assertions.assertTrue(repositories.size() > 40);
	}

	@Test
	@Order(2)
	void testGetTopics() {
		List<Repository> repositories = getRepositories();
		List<String> topics = GitHubRepositories.getTopics(repositories.get(0));
		Assertions.assertFalse(topics.isEmpty());
	}

	private List<Repository> getRepositories() {
		return gitHubRepositories.getRepositories(Cfg.getGithubUser());
	}
}