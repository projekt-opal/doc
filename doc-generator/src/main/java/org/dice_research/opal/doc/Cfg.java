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

	public static final String KEY_GITHUB_USER = "github.user";
	public static final String KEY_GITHUB_TOKEN = "github.token";
	public static final String KEY_GITHUB_TOPIC = "github.topic";
	public static final String KEY_MODES = "modes";
	public static final String KEY_OUTPUT_DIRECTORY = "outputDirectory";

	private static String get(String key) {
		File file = getConfigurationFile();
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
			throw new RuntimeException("Could not find configuration key '" + key + "' in " + file.getAbsolutePath());
		} else {
			return value.toString();
		}
	}

	public static File getConfigurationFile() {
		return new File(FILE);
	}

	public static String getGithubToken() {
		return get(KEY_GITHUB_TOKEN);
	}

	public static String getGithubUser() {
		return get(KEY_GITHUB_USER);
	}

	public static String getGithubTopic() {
		return get(KEY_GITHUB_TOPIC);
	}

	public static String getModes() {
		return get(KEY_MODES);
	}

	public static String getOutputDirectory() {
		return get(KEY_OUTPUT_DIRECTORY);
	}

}