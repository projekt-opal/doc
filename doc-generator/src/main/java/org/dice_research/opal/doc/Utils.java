package org.dice_research.opal.doc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

/**
 * Utilities.
 *
 * @author Adrian Wilke
 */
public class Utils {

	/**
	 * Reads JSON from URL.
	 * 
	 * @see https://stackoverflow.com/a/4308662
	 */
	public static String readJsonFromUrl(String url) throws IOException {
		InputStream is = null;
		BufferedReader rd = null;
		try {
			is = new URL(url).openStream();
			rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

			StringBuilder sb = new StringBuilder();
			int cp;
			while ((cp = rd.read()) != -1) {
				sb.append((char) cp);
			}
			return sb.toString();
		} finally {
			if (is != null)
				is.close();
			if (rd != null)
				rd.close();
		}
	}

	/**
	 * Writes string to file.
	 */
	public static void write(File file, String data) {
		try {
			FileUtils.write(file, data, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}