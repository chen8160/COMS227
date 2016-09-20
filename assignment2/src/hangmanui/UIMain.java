package hangmanui;

import hw2.PhraseSelector;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Sample main class for starting an instance of HangmanUI.
 */
public class UIMain {
	/**
	 * 15:45 2014/3/18
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) throws FileNotFoundException {
		PhraseSelector selector = new PhraseSelector("words.txt");
		Random rand = new Random();
		HangmanUI.start(selector, rand);
	}

}
