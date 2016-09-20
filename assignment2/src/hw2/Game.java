package hw2;

/**
 * Class representing a game of hangman. This class encapsulates all aspects of
 * the game state, including the secret word or phrase, the letters guessed so
 * far, and the number of wrong guesses. A hangman game can be constructed with
 * a specified maximum number of wrong guesses which defaults to
 * DEFAULT_MAX_WRONG_GUESSES. The secret word or phrase is represented as an
 * array of HideableChar and may contain whitespace and arbitrary punctuation
 * characters. Clients of this code decide how to represent the "hidden"
 * characters to the user. Non-alphabetic characters are normally not hidden.
 * 
 * @author Yuxiang Chen
 * 
 */
public class Game {

	/**
	 * Default value for the maximum number of wrong guesses.
	 */
	public static final int DEFAULT_MAX_WRONG_GUESSES = 7;
	/**
	 * The secret word.
	 */
	private String secretWord;
	/**
	 * The maximum times of wrong guesses.
	 */
	private int maxWrongGuesses;
	/**
	 * The number of wrong guesses which have been performed by the player.
	 */
	private int numWrongGuesses;
	/**
	 * A sequence of hideable characters.
	 */
	private HideableChar[] chars;
	/**
	 * The letters which have been guessed by the player.
	 */
	private String lettersHasGuessed;

	/**
	 * Constructs a hangman game using the given word as the secret word and the
	 * default maximum number of wrong guesses.
	 * 
	 * @param word
	 *            the secret word
	 */
	public Game(String word) {
		secretWord = word;
		maxWrongGuesses = DEFAULT_MAX_WRONG_GUESSES;
		numWrongGuesses = 0;
		chars = new HideableChar[word.length()];
		for (int i = 0; i < secretWord.length(); i++) {
			chars[i] = new HideableChar(secretWord.charAt(i));
		}
		lettersHasGuessed = "";
	}

	/**
	 * Constructs a hangman game using the given word as the secret word and the
	 * given value as the maximum number of wrong guesses.
	 * 
	 * @param word
	 *            the secret word
	 * @param maxGuesses
	 *            given value for the maximum number of wrong guesses.
	 */
	public Game(String word, int maxGuesses) {
		secretWord = word;
		maxWrongGuesses = maxGuesses;
		numWrongGuesses = 0;
		chars = new HideableChar[word.length()];
		for (int i = 0; i < secretWord.length(); i++) {
			chars[i] = new HideableChar(secretWord.charAt(i));
		}
		lettersHasGuessed = "";
	}

	/**
	 * Determines whether this game is over.
	 * 
	 * @return true if the player has won or has run out of guesses, false
	 *         otherwise
	 */
	public boolean gameOver() {
		if (numWrongGuesses >= maxWrongGuesses || won()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a sequence of HideableChar representing the secret word or
	 * phrase. Letters that have not been guessed yet are hidden. Non-alphabetic
	 * characters (according to the method Character.isAlphabetic) are never
	 * hidden; the HideableChar constructor will normally help enforce this
	 * condition.
	 * 
	 * @return displayed form of the secret word
	 */
	public HideableChar[] getDisplayedWord() {
		return chars;
	}

	/**
	 * Returns the maximum number of wrong guesses for this game.
	 * 
	 * @return maximum number of wrong guesses
	 */
	public int getMaxGuesses() {
		return maxWrongGuesses;
	}

	/**
	 * Returns the complete secret word or phrase as a string.
	 * 
	 * @return the secret word or phrase
	 */
	public String getSecretWord() {
		return secretWord;
	}

	/**
	 * Invoked by the player to guess a letter. The behavior is as follows: <br/>
	 * If the game is already over, this method does nothing and returns false. <br/>
	 * If the letter has previously been guessed by the player, records it as a
	 * wrong guess and returns false. <br/>
	 * If the letter has not previously been guessed, but does not occur in the
	 * secret word or phrase, records it as a wrong guess and returns false. <br/>
	 * If the letter has not previously been guessed and does occur in the
	 * secret word, changes all occurrences of the letter in the secret word to
	 * "not hidden" and returns true.<br/>
	 * 
	 * @param ch
	 *            the letter to check
	 * @return true if the letter has not been guessed already and occurs in the
	 *         secret word, false otherwise
	 */
	public boolean guessLetter(char ch) {
		if (gameOver()) {
			return false;
		}
		boolean result = false;
		numWrongGuesses++;
		for (int i = 0; i < secretWord.length(); i++) {
			if (("" + ch).equals(chars[i].getHiddenChar())) {
				if (chars[i].isHidden()) {
					chars[i].unHide();
					result = true;
				}
			}
		}
		if(result == true){
			numWrongGuesses--;
		}
		duplicatesExclusion(ch);
		return result;
	}

	/**
	 * Returns a string containing all the letters guessed so far by the player,
	 * without duplicates.
	 * 
	 * @return letters guessed so far by the player
	 */
	public String lettersGuessed() {
		return lettersHasGuessed;
	}

	/**
	 * Returns the number of wrong guesses made so far by the player.
	 * 
	 * @return number of wrong guesses
	 */
	public int numWrongGuesses() {
		return numWrongGuesses;
	}

	/**
	 * Determines whether the player has guessed all the letters in the secret
	 * word.
	 * 
	 * @return true if the player has won, false otherwise
	 */
	public boolean won() {
			for (int i = 0; i < secretWord.length(); i++) {
				if (chars[i].isHidden()) {
					return false;
				}
			}
			return true;
		//wrong here
	}

	/**
	 * Add the letter to the string of characters which the player has guessed
	 * if it is not duplicated with previous letters which have been guessed by
	 * the player.
	 * 
	 * @param ch
	 *            the given letter.
	 * @return letters guessed so far by the player without duplicates.
	 */
	private void duplicatesExclusion(char ch) {
		if (lettersHasGuessed.length() < 1) {
			lettersHasGuessed += ch;
		} else {
			boolean isDuplicated = false;
			for (int i = 0; i < lettersHasGuessed.length(); i++) {
				if (lettersHasGuessed.charAt(i) == ch) {
					isDuplicated = true;
					break;
				}
			}
			if (!isDuplicated) {
				lettersHasGuessed += ch;
			}
		}
	}

}
