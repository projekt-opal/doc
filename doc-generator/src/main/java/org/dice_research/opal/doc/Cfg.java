package org.dice_research.opal.doc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Simple file and properties based configuration.
 * 
 * @author Adrian Wilke
 */
public class Cfg {

	public static final String FILE = "config.properties";

	public static final String KEY_GITHUB_TOKEN = "github.token";

	private static String get(String key) {
		File file = getFile();
		if (!file.canRead()) {
			throw new RuntimeException("Could not read configuration file: " + file.getAbsolutePath());
		}

		Properties properties = new Properties();
		try {
			properties.load(new FileReader(file));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Object value = properties.get(key);
		if (value == null) {
			throw new RuntimeException("Could not find configuration key: " + key);
		} else {
			return value.toString();
		}
	}

	public static File getFile() {
		return new File(FILE);
	}

	public static String getGithubToken() {
		return get(KEY_GITHUB_TOKEN);
	}

}