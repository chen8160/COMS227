package hw2;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class PhraseSelectorTest {

	private PhraseSelector phrases1;
	private PhraseSelector phrases2;

	@Before
	public void setUp() throws Exception {
		phrases1 = new PhraseSelector("words.txt");
	}

	/**
	 * check that an error is thrown when file is not found
	 */
	@Test
	public final void testPhraseSelector() {
		try {
			phrases2 = new PhraseSelector("");
			fail("FileNotFould Exception was not thrown.");
		} catch (Exception e) {
			// Do nothing
		}
	}

	/**
	 * Check that selectWord returns the same string for the same random seed
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public final void testSelectWord() throws FileNotFoundException {

		// Setup random
		Random randy1 = new Random(6131983);
		Random randy2 = new Random(6131983);

		// Setup 2nd phraseSelector
		phrases2 = new PhraseSelector("words.txt");

		// iterate through 5 phrases
		for (int iPhrase = 0; iPhrase < 5; iPhrase++) {
			String singlePhrase1 = phrases1.selectWord(randy1);
			String singlePhrase2 = phrases2.selectWord(randy2);
			assertTrue(
					"The same word is not returned for the same random seed. "
							+ "Are you using your own random inside PhraseSelector? "
							+ "Failed on " + iPhrase + "th phrase. "
							+ "singlePhrase1 was \"" + singlePhrase1
							+ "\". singlePhrase2 was \"" + singlePhrase2
							+ "\".", singlePhrase1.equals(singlePhrase2));
		} // end for, check phrase 5 times
	}

}
