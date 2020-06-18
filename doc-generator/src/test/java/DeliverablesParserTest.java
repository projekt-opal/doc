
import java.util.List;

import org.dice_research.opal.doc.deliverables.Deliverable;
import org.dice_research.opal.doc.deliverables.DeliverablesParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link DeliverablesParser}.
 *
 * @author Adrian Wilke
 */
class DeliverablesParserTest {

	DeliverablesParser deliverablesParser;

	@BeforeEach
	void setUp() throws Exception {
		deliverablesParser = new DeliverablesParser();
	}

	@Test
	void test() {
		List<Deliverable> deliverables = deliverablesParser.get();
		Assertions.assertTrue(deliverables.size() > 30);
	}

}