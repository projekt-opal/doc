package org.dice_research.opal.doc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Creates slide templates in markdown format.
 * 
 * Executed only one time.
 * 
 * Input: TSV (CSV) file copied from spreadsheed.
 * 
 * @author Adrian Wilke
 */
public class PresentationSlideGenerator {

	// Do not overwrite existing contents
	boolean execute = false;

	// Copied data from spreadsheet
	String inRes = "deliverables.tsv";

	// Slides directory
	File outDir = new File("../final-presentation/Quellen");

	public static void main(String[] args) {
		new PresentationSlideGenerator().generateSlides();
	}

	private PresentationSlideGenerator generateSlides() {

		// Do not overwrite existing contents
		if (!execute) {
			return this;
		}

		// Read data
		URL url = ClassLoader.getSystemResource(inRes);
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(new File(url.toURI()), StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// Parse and write
		String lastWorkpackage = null;
		StringBuilder wpBuilder = new StringBuilder();
		for (String line : lines) {

			// Parse
			String[] parts = line.split("\t");
			String workpackage = parts[0].trim();
			String deliverable = parts[1].trim();
			String title = parts[2].trim();
			String trimTitle = title.replace(" ", "");

			// Write Deliverable
			File file = new File(outDir, workpackage + deliverable + "0-" + trimTitle + ".md");
			String content = "## D" + workpackage + "." + deliverable + " " + title + "\n\nTODO\n\n";
			try {
				FileUtils.write(file, content, StandardCharsets.UTF_8);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			// Write WorkPackage
			// (after all D. parsed)
			if (lastWorkpackage != null && !lastWorkpackage.equals(workpackage)) {
				generateWp(lastWorkpackage, wpBuilder);
				wpBuilder = new StringBuilder();
			}

			// Update
			lastWorkpackage = workpackage;

			wpBuilder.append("- ");
			wpBuilder.append("D" + workpackage + "." + deliverable + " " + title);
			wpBuilder.append("\n");
		}

		// Finally write last existing WP
		generateWp(lastWorkpackage, wpBuilder);

		return this;
	}

	private void generateWp(String lastWorkpackage, StringBuilder wpBuilder) {
		File file = new File(outDir, lastWorkpackage + "00-" + "AP" + lastWorkpackage + ".md");
		StringBuilder sb = new StringBuilder();
		sb.append("# Arbeitspaket " + lastWorkpackage + "\n\n");
		sb.append("## Arbeitspaket " + lastWorkpackage + "\n\n");
		sb.append(wpBuilder);
		sb.append("\n");
		String content = sb.toString();

		try {
			FileUtils.write(file, content, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}