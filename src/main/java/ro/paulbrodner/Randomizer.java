package ro.paulbrodner;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author paul.brodner
 *
 */
public class Randomizer {
	public static String prefix(String prefix) {
		return String.format("%s%s", prefix, RandomStringUtils.randomAlphabetic(5));
	}
}
