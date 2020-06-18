package org.dice_research.opal.doc;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Simple cache.
 *
 * @author Adrian Wilke
 */
public abstract class Cache {

	private static final Logger LOGGER = LogManager.getLogger();

	public static String get(URL url) {
		File cacheFile = getCacheFile(url);
		try {
			if (cacheFile.exists()) {
				LOGGER.info("Reading " + url + " from cache " + cacheFile.getAbsolutePath());
				return IOUtils.toString(cacheFile.toURI(), StandardCharsets.UTF_8);
			} else {
				String data;
				try (InputStream inputStream = url.openStream()) {
					LOGGER.info("Writing " + url + " to cache " + cacheFile.getAbsolutePath());
					data = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
				}
				FileUtils.write(cacheFile, data, StandardCharsets.UTF_8);
				return data;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void set(URL url, String data) {
		File cacheFile = getCacheFile(url);
		try {
			FileUtils.write(cacheFile, data, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean has(URL url) {
		return getCacheFile(url).exists();
	}

	private static File getCacheFile(URL url) {
		return new File(new File(System.getProperty("java.io.tmpdir"), Cache.class.getPackageName()),
				md5(url.toString()));
	}

	private static String md5(String string) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(string.getBytes());
			byte[] bytes = messageDigest.digest();
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < bytes.length; ++i) {
				stringBuffer.append(Integer.toHexString((bytes[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return stringBuffer.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}