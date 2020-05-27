package org.dice_research.opal.doc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

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
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

			StringBuilder sb = new StringBuilder();
			int cp;
			while ((cp = rd.read()) != -1) {
				sb.append((char) cp);
			}
			return sb.toString();
		} finally {
			is.close();
		}
	}
}
