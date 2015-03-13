import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author annashi
 * This class has functionality to jumble the characters
 * in a string and returns
 * an array of words contained in the dictionary
 */
public class Jumble {
	
	/**
	 * Jumbles the characters in <word> and checks
	 * if the resulting word is located in the 
	 * <dictionary>
	 * @param word
	 * @param dictionary
	 * @return
	 */
	public ArrayList<String> jumble(String word, HashMap<String, Boolean> dictionary) {
		Set<String> set = helper(word);
		ArrayList<String> wordsOnlyArr = new ArrayList<String>();
		for (String s : set) {
			if (s != null && s.length() > 0 && dictionary.containsKey(s)) {
				wordsOnlyArr.add(s);
			}
		}
		return wordsOnlyArr;
	}
	
	/**
	 * Generates the possible combinations of character jumbles
	 * for <word>
	 * @param word
	 * @return
	 */
	public Set<String> helper(String word) {
		if (word.length() == 0) {
			Set<String> arr = new HashSet<String>();
			arr.add("");
			return arr;
		}
		char first = word.charAt(0);
		String rest = word.substring(1);
		Set<String> combo = helper(rest);
		Set<String> newCombo = (Set<String>) ((HashSet<String>) combo).clone();
		for (String s : combo) {
			if (s.length() == 0) {
				newCombo.add(first + s);
			}
			for (int j = 0; j < s.length(); j++) {
				String prefix = s.substring(0, j);
				String end = s.substring(j);
				// jumbling in different orders
				newCombo.add(prefix + first + end);
				newCombo.add(first + prefix + end);
				newCombo.add(first + end + prefix);
				newCombo.add(end + first + prefix);
				newCombo.add(end + prefix + first);
				newCombo.add(prefix + end + first);
			}
		}
		return newCombo;
	}
}
