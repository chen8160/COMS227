package hw2;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

/**
 * Generator for secret words or phrases for word-guessing games. A
 * PhraseSelector chooses a line randomly from a file specified in the
 * constructor.
 * 
 * @author Yuxiang Chen
 * 
 */
public class PhraseSelector {
	/**
	 * This is a file instance variable.
	 */
	private File file;

	/**
	 * Constructs a PhraseSelector that will select words from the given file.
	 * This constructor may throw a FileNotFoundException if the file cannot be
	 * opened.
	 * 
	 * @param givenFilename
	 *            the name of the file
	 * @throws java.io.FileNotFoundException
	 */
	public PhraseSelector(String givenFilename)
			throws java.io.FileNotFoundException {
		file = new File(givenFilename);
	}

	/**
	 * Returns a word or phrase selected at random from this PhraseSelector's
	 * file, using the given source of randomness. Specifically, this method
	 * returns the nth line of the file, where n = rand.nextInt(size) and size
	 * is the number of lines in the file. This method may throw
	 * FileNotFoundException if the file cannot be opened.
	 * 
	 * @param rand
	 *            the given source of randomness.
	 * @return a randomly selected line of the file
	 * @throws java.io.FileNotFoundException
	 */
	public String selectWord(Random rand) throws java.io.FileNotFoundException {
		Scanner numLines = new Scanner(file);
		int size = 0;
		while (numLines.hasNextLine()) {
			numLines.nextLine();
			size++;
		}
		numLines.close();
		Scanner lines = new Scanner(file);
		for (int i = 0; i < rand.nextInt(size); i++) {
			lines.nextLine();
		}
		String result = lines.nextLine();
		lines.close();
		return result;
	}
}
