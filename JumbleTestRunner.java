import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
public class JumbleTestRunner {
	
	private static Jumble j = new Jumble();
	private static HashMap<String, Boolean> dict;

	@Test
	public void testBasicJumbleFunction() {
		ArrayList<String> result = j.jumble("dog", dict);
		assertEquals(result.contains("do"), true);
		assertEquals(result.contains("go"), true);
		assertEquals(result.contains("dog"), true);
		assertEquals(result.contains("god"), true);
		assertEquals(result.size(), 4);		
	}
	
	@Test
	public void oneDuplicateLetterInARow() {
		ArrayList<String> result = j.jumble("dogo", dict);
		assertEquals(result.contains("do"), true);
		assertEquals(result.contains("go"), true);
		assertEquals(result.contains("dog"), true);
		assertEquals(result.contains("god"), true);
		assertEquals(result.contains("good"), true);
		assertEquals(result.size(), 5);
		
	}
	
	@Test
	public void twoDuplicateLettersInARow() {
		ArrayList<String> result = j.jumble("dooog", dict);
		assertEquals(result.contains("do"), true);
		assertEquals(result.contains("go"), true);
		assertEquals(result.contains("dog"), true);
		assertEquals(result.contains("god"), true);
		assertEquals(result.contains("good"), true);
		assertEquals(result.contains("gooo"), true);
		assertEquals(result.contains("ooo"), true);
		assertEquals(result.size(), 7);
	}
	
	@Test
	public void noLettersInDict() {
		ArrayList<String> result = j.jumble("blah", dict);
		assertEquals(result.size(), 0);
	}
	
	
	@Test
	public void duplicateInMiddle() {
		ArrayList<String> result = j.jumble("doogo", dict);
		assertEquals(result.contains("do"), true);
		assertEquals(result.contains("go"), true);
		assertEquals(result.contains("dog"), true);
		assertEquals(result.contains("god"), true);
		assertEquals(result.contains("good"), true);
		assertEquals(result.contains("gooo"), true);
		assertEquals(result.contains("ooo"), true);
		assertEquals(result.size(), 7);
	}
	
	@Test
	public void longerWord() {
		ArrayList<String> result = j.jumble("dqogodcsog", dict);
		assertEquals(result.contains("do"), true);
		assertEquals(result.contains("go"), true);
		assertEquals(result.contains("dog"), true);
		assertEquals(result.contains("god"), true);
		assertEquals(result.contains("good"), true);
		assertEquals(result.contains("gooo"), true);
		assertEquals(result.contains("ooo"), true);
		assertEquals(result.size(), 7);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() {
		dict = new HashMap<String, Boolean>();
		dict.put("dog", true);
		dict.put("do", true);
		dict.put("go", true);
		dict.put("god", true);
		dict.put("good", true);
		dict.put("ooo", true);
		dict.put("gooo", true);
	}
	
	
	public static void main(String[] args) {
	    Result result = JUnitCore.runClasses(JumbleTestRunner.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	  }

}
