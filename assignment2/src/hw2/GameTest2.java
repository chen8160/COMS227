package hw2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest2 {

	private String secretWord1;
	private String secretWord2;
	private Game game1;
	private Game game2;
	private final int maxGuessesGame2 = 75;

	@Before
	public void setUp() throws Exception {
		secretWord1 = "Scooby Doo";
		game1 = new Game(secretWord1);
		secretWord2 = "Scrappy Doo";
		game2 = new Game(secretWord2, maxGuessesGame2);
	}

	@Test
	public final void testGetMaxGuesses1() {
		assertEquals("Default max guesses is wrong", 7, game1.getMaxGuesses());
	}

	@Test
	public final void testGetMaxGuesses2() {
		assertEquals("Max guesses is wrong.", 7, game1.getMaxGuesses());
	}

	@Test
	public final void testGetSecretWord1() {
		assertTrue(game1.getSecretWord().equals(secretWord1));
	}

	@Test
	public final void testGetSecretWord2() {
		assertTrue(game2.getSecretWord().equals(secretWord2));
	}

	/**
	 * Tests a sequence fo inputs for the class Game.
	 * <ol>
	 * <li>Test a sequence of wrong input and then check game1 properties</li>
	 * <li>Test the sequence of wrong input again. Then check the game1
	 * properties again.</li>
	 * <li>Test a sequence of correct guesses that will allow winning of the
	 * game. Check game1 properties again.</li>
	 * </ol>
	 */
	@Test
	public final void testGame1() {
		String correctGuesses = "SCobyD";
		String wrongGuesses = "agf";
		String redundantWrongGuesses = wrongGuesses; // String immutability
														// makes this safe

		// iterate through wrong guesses
		for (int iWrongGuess = 0; iWrongGuess < wrongGuesses.length(); iWrongGuess++) {
			assertFalse("Found letter that should not be found",
					game1.guessLetter(wrongGuesses.charAt(iWrongGuess)));
		}
		// check properties of game1
		assertEquals(
				"Number of wrong guesses should be " + wrongGuesses.length(),
				wrongGuesses.length(), game1.numWrongGuesses());
		assertTrue("Letters guessed is incorrect. It should be \""
				+ wrongGuesses + "\".",
				wrongGuesses.equals(game1.lettersGuessed()));
		assertFalse("Game is over when it should not be over.",
				game1.gameOver());
		assertFalse("Game is won when it should not be won.", game1.won());

		// S c o o b y space D o o
		boolean[] isHidden1 = { true, true, true, true, true, true, false,
				true, true, true };
		testDisplayWord(game1, isHidden1);

		// iterate through redundant wrong guesses
		for (int iRedundantWrongGuess = 0; iRedundantWrongGuess < redundantWrongGuesses
				.length(); iRedundantWrongGuess++) {
			assertFalse("Found letter that should not be found",
					game1.guessLetter(redundantWrongGuesses
							.charAt(iRedundantWrongGuess)));
		}

		// check properties of game1
		assertEquals(
				"After redundant guesses, number of wrong guesses should be "
						+ (wrongGuesses.length() + redundantWrongGuesses
								.length()),
				wrongGuesses.length() + redundantWrongGuesses.length(), game1
						.numWrongGuesses());
		assertTrue(
				"After redundant guesses, letters guessed is incorrect. It should be \""
						+ wrongGuesses + "\".",
				wrongGuesses.equals(game1.lettersGuessed()));
		assertFalse("Game is over when it should not be over.",
				game1.gameOver());
		assertFalse("Game is won when it should not be won.", game1.won());
		// S c o o b y space D o o
		boolean[] isHidden2 = { true, true, true, true, true, true, false,
				true, true, true };
		testDisplayWord(game1, isHidden2);

		// iterate through right guesses
		for (int iCorrectGuess = 0; iCorrectGuess < correctGuesses.length(); iCorrectGuess++) {
			assertTrue("Did not find a letter that should have been found.",
					game1.guessLetter(correctGuesses.charAt(iCorrectGuess)));
		}

		// check properties of game1 again
		assertEquals(
				"After correct guesses, numbers of wrong guesses should be "
						+ (wrongGuesses.length() + redundantWrongGuesses
								.length()),
				wrongGuesses.length() + redundantWrongGuesses.length(), game1
						.numWrongGuesses());
		assertTrue(
				"After correct guesses, letters guessed is incorrect. It should be \""
						+ wrongGuesses + correctGuesses + "\".",
				(wrongGuesses + correctGuesses).equals(game1.lettersGuessed()));
		assertTrue("Game should be over.", game1.gameOver());
		assertTrue("Game should be won.", game1.won());
		// S c o o b y space D o o
		boolean[] isHidden3 = { false, false, false, false, false, false,
				false, false, false, false };
		testDisplayWord(game1, isHidden3);
	}

	/**
	 * Tests a sequence for inputs for the class Game.
	 * <ol>
	 * <li>Test game2 over the maximum allowed guesses. check the properties of
	 * game2.</li>
	 * </ol>
	 */
	@Test
	public final void testGame2() {
		char wrongGuess1 = 'h';

		int numberOfGuesses = maxGuessesGame2 + 10;

		for (int iGuess = 0; iGuess < numberOfGuesses; iGuess++) {
			game2.guessLetter(wrongGuess1);
		}
		assertEquals("Number of guesses is incorrect", maxGuessesGame2,
				game2.numWrongGuesses());
		assertTrue("Guessed letters is wrong.",
				game2.lettersGuessed().equals("" + wrongGuess1));
		assertFalse("Game should not be won.", game2.won());
		assertTrue("Game should be over.", game2.gameOver());
		// S c r a p p y space D o o
		boolean[] isHidden = { true, true, true, true, true, true, true, false,
				true, true, true };
		testDisplayWord(game2, isHidden);

	}

	@Test
	public final void testGameOver1() {
		assertFalse("Game should not be over.", game1.gameOver());
	}

	@Test
	public final void testGameOver2() {
		assertFalse("Game should not be over.", game2.gameOver());
	}

	@Test
	public final void testWon1() {
		assertFalse("Game should not be won.", game1.won());
	}

	@Test
	public final void testWon2() {
		assertFalse("Game should not be won.", game2.won());
	}

	/**
	 * Used to check getDisplayWord while running a sequence of inputs to a Game
	 * object
	 * 
	 * @param g
	 *            game object to use to check getDisplayWord
	 * @param isHidden
	 *            boolean array of what characters should be hidden and what
	 *            characters should not
	 */
	public final void testDisplayWord(Game g, boolean[] isHidden) {
		HideableChar[] h = g.getDisplayedWord();

		if (h.length == isHidden.length) {
			for (int iChar = 0; iChar < h.length; iChar++) {
				assertTrue("Character incorrect displayed.",
						h[iChar].isHidden() == isHidden[iChar]);
			}

		} else {
			fail("Hidden characters and correctAnswer are not the same length.");
		}
	}

}
