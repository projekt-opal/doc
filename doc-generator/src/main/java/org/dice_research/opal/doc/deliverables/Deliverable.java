package org.dice_research.opal.doc.deliverables;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Deliverable parsed by {@link DeliverablesParser}.
 *
 * @author Adrian Wilke
 */
public class Deliverable {

	public static final String PREFIX_GOOGLE_DRIVE = "https://drive.google.com/";
	public static final String PREFIX_GITHUB_DICE = "https://github.com/dice-group/";
	public static final String PREFIX_GITHUB_OPAL = "https://github.com/projekt-opal/";

	String id;
	String title;
	String due;
	String milestone;
	List<String> linkTitles = new LinkedList<>();
	List<String> linkUrls = new LinkedList<>();

	@Override
	public String toString() {
		return id + " " + title + " " + due + " " + milestone + " " + linkUrls + " " + linkTitles;
	}

	public StringBuilder addLines(StringBuilder stringBuilder) {
		stringBuilder.append(id);
		stringBuilder.append(System.lineSeparator());

		stringBuilder.append(title);
		stringBuilder.append(System.lineSeparator());

		stringBuilder.append(due);
		stringBuilder.append(System.lineSeparator());

		stringBuilder.append(milestone);
		stringBuilder.append(System.lineSeparator());

		if (!linkUrls.isEmpty()) {
			for (String string : linkUrls) {
				stringBuilder.append(string);
				stringBuilder.append(System.lineSeparator());
			}
			for (String string : linkTitles) {
				stringBuilder.append(string);
				stringBuilder.append(System.lineSeparator());
			}
		}

		stringBuilder.append(System.lineSeparator());

		return stringBuilder;
	}

	public HashMap<String, String> getLinksGoogleDrive() {
		return getLinks(PREFIX_GOOGLE_DRIVE);
	}

	public HashMap<String, String> getLinksGithubDice() {
		return getLinks(PREFIX_GITHUB_DICE);
	}

	public HashMap<String, String> getLinksGithubOpal() {
		return getLinks(PREFIX_GITHUB_OPAL);
	}

	public HashMap<String, String> getLinksMisc() {
		HashMap<String, String> linksMap = new HashMap<>();
		for (int i = 0; i < linkUrls.size(); i++) {
			String link = linkUrls.get(i);
			if (!link.startsWith(PREFIX_GOOGLE_DRIVE) && !link.startsWith(PREFIX_GITHUB_DICE)
					&& !link.startsWith(PREFIX_GITHUB_OPAL)) {
				linksMap.put(link, linkTitles.get(i));
			}
		}
		return linksMap;
	}

	private HashMap<String, String> getLinks(String prefix) {
		HashMap<String, String> linksMap = new HashMap<>();
		for (int i = 0; i < linkUrls.size(); i++) {
			String link = linkUrls.get(i);
			if (link.startsWith(prefix)) {
				linksMap.put(link, linkTitles.get(i));
			}
		}
		return linksMap;
	}

}