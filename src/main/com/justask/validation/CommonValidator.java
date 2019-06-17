package com.justask.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * 
 * For input validation and filtering
 *
 */
public class CommonValidator {
	final private static String[] SET_VALUES = new String[] {"fuck", "fucker", "shit", "bitch", "fucking"};
	// HashSet is faster than List in searching. 
	final private static Set<String> curseWords = new HashSet<String>(Arrays.asList(SET_VALUES));
	/**
	 * Filter out curse words
	 * @param s
	 * @return
	 */
	public static String filter(String s) {
		s = s.trim();
		String[] words= s.split(" ");
		List<String> l = Arrays
				.asList(words)
				.stream()
				.filter(word->!curseWords.contains(word))
				.collect(Collectors.toList());
		return String.join(" ", l);
	}
}
