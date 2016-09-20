package hw2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class GameTest4 {

	@Test
	public void testInitialConstructor1() {
		Game game = new Game("Hello, World!", 5);
		String msg = "The default max guesses should be 5";
		assertEquals(msg, 5, game.getMaxGuesses());
	}

	@Test
	public void testEdgeMaxGuess1() {
		Game game = new Game("Hello, World!", 5);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		guessChar(1, 'D', game);
		guessChar(1, 'A', game);
		String msg = "After guessing H, E, L, O, W, R, D, and A, with Hello, World! as secret phrase, the number of wrong guesses should be 0 ";
		assertEquals(msg, 0, game.numWrongGuesses());
	}

	@Test
	public void testEdgeMaxGuess2() {
		Game game = new Game("Hello, World!", 0);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		guessChar(1, 'D', game);
		// guessChar(1, 'A', game);
		String msg = "After guessing H, E, L, O, W, R, and D, with Hello, World! as secret phrase, the won should return false ";
		assertEquals(msg, false, game.won());
	}

	@Test
	public void testEdgeMaxGuess3() {
		Game game = new Game("Hello, World!", -1);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		guessChar(1, 'D', game);
		// guessChar(1, 'A', game);
		String msg = "After guessing H, E, L, O, W, R, and D, with Hello, World! as secret phrase, the won should return false ";
		assertEquals(msg, false, game.won());
	}

	@Test
	public void testInitialMaxGuesses1() {
		Game game = new Game("Hello, World!");
		String msg = "The default max guesses should be 7";
		assertEquals(msg, 7, game.getMaxGuesses());
	}

	@Test
	public void testInitialMaxGuesses2() {
		Game game = new Game("Hello, World!", 5);
		String msg = "The default max guesses should be 7";
		assertEquals(msg, 5, game.getMaxGuesses());
	}

	@Test
	public void testInitialMaxGuesses3() {
		Game game = new Game("Hello, World!", 0);
		String msg = "The default max guesses should be 0";
		assertEquals(msg, 0, game.getMaxGuesses());
	}

	@Test
	public void testInitialDisplayedWord1() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		String msg = "The letters should be hidden and non letters should not be hidden";
		HideableChar[] testChar = stringToHideableChar(testWord);
		assertEquals(msg, true,
				equalsHideableChar(game.getDisplayedWord(), testChar));

	}

	@Test
	public void testInitialSecretWord1() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		String msg = "The secret word should be HELLO, WORLD!";
		assertEquals(msg, testWord.toUpperCase(), game.getSecretWord());
	}

	@Test
	public void testWrongGuessCount1() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		game.guessLetter('a');
		String msg = "After guessing a, with Hello, World! as secret phrase, the number of wrong guesses should be 1 ";
		assertEquals(msg, 1, game.numWrongGuesses());
	}

	@Test
	public void testWrongGuessCount2() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(2, 'a', game);
		String msg = "After guessing a twice, with Hello, World! as secret phrase, the number of wrong guesses should be 2 ";
		assertEquals(msg, 2, game.numWrongGuesses());
	}

	@Test
	public void testWrongGuessCount3() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(8, 'a', game);
		String msg = "After guessing a eight times, with Hello, World! as secret phrase, the number of wrong guesses should be 7 ";
		assertEquals(msg, 7, game.numWrongGuesses());
	}

	@Test
	public void testWrongGuessCount4() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(1, ' ', game);
		String msg = "After guessing space once, with Hello, World! as secret phrase, the number of wrong guesses should be 7 ";
		assertEquals(msg, 1, game.numWrongGuesses());
	}

	@Test
	public void testWrongGuessCount5() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		guessChar(1, 'D', game);
		guessChar(1, 'A', game);
		String msg = "After guessing H, E, L, O, W, R, D, and A, with Hello, World! as secret phrase, the number of wrong guesses should be 0 ";
		assertEquals(msg, 0, game.numWrongGuesses());
	}

	@Test
	public void testLettersGuessed1() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(3, 'a', game);
		String msg = "After guessing a 3 times, with Hello, World! as secret phrase, the letter guessed should be A";
		assertEquals(msg, "A", game.lettersGuessed());
	}

	@Test
	public void testLettersGuessed2() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		game.guessLetter('a');
		String msg = "After guessing a once, with Hello, World! as secret phrase, the letter guessed should be A";
		assertEquals(msg, "A", game.lettersGuessed());
	}

	@Test
	public void testLettersGuessed3() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(3, 'a', game);
		guessChar(3, 'b', game);
		String msg = "After guessing a and b 3 times, with Hello, World! as secret phrase, the letter guessed should be AB";
		assertEquals(msg, "AB", game.lettersGuessed());
	}

	@Test
	public void testLettersGuessed4() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		guessChar(1, 'D', game);
		guessChar(1, 'A', game);
		String msg = "After guessing H, E, L, O, W, R, D, and A, with Hello, World! as secret phrase, the letter guessed should be HELOWRD";
		assertEquals(msg, "HELOWRD", game.lettersGuessed());
	}

	@Test
	public void testWon1() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		guessChar(1, 'D', game);
		String msg = "After guessing H, E, L, O, W, R, D, with Hello, World! as secret phrase, won status should be true";
		assertEquals(msg, true, game.won());
	}

	@Test
	public void testWon2() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(6, 'a', game);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		guessChar(1, 'D', game);
		String msg = "After guessing a for 6 times and guessing H, E, L, O, W, R, and D each once, with Hello, World! as secret phrase, won status should be true";
		assertEquals(msg, true, game.won());
	}

	@Test
	public void testWon3() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(8, 'a', game);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		guessChar(1, 'D', game);
		String msg = "After guessing a for 8 times and guessing H, E, L, O, W, R, and D each once, with Hello, World! as secret phrase, won status should be false";
		assertEquals(msg, false, game.won());
	}

	@Test
	public void testGameOver1() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(5, 'a', game);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		guessChar(1, 'D', game);
		String msg = "After guessing a for 5 times and guessing H, E, L, O, W, R, and D each once, with Hello, World! as secret phrase, game should be over";
		assertEquals(msg, true, game.gameOver());
	}

	@Test
	public void testGameOver2() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(8, 'a', game);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		guessChar(1, 'D', game);
		String msg = "After guessing a for 8 times and guessing H, E, L, O, W, R, and D each once, with Hello, World! as secret phrase, game should be over";
		assertEquals(msg, true, game.gameOver());
	}

	@Test
	public void testGameOver3() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		guessChar(5, 'a', game);
		guessChar(1, 'H', game);
		guessChar(1, 'E', game);
		guessChar(1, 'L', game);
		guessChar(1, 'O', game);
		guessChar(1, 'W', game);
		guessChar(1, 'R', game);
		// guessChar(1, 'D', game);
		String msg = "After guessing a for 5 times and guessing H, E, L, O, W, and R each once, with Hello, World! as secret phrase, game should not be over";
		assertEquals(msg, false, game.gameOver());
	}

	@Test
	public void testGuessLetter1() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		String msg = "After guessing a once, with Hello, World! as secret phrase, guessLetter should return false";
		assertEquals(msg, false, game.guessLetter('a'));
	}

	@Test
	public void testGuessLetter2() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		String msg = "After guessing h once, with Hello, World! as secret phrase, guessLetter should return true";
		assertEquals(msg, true, game.guessLetter('h'));
	}

	@Test
	public void testGuessLetter3() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		String msg = "After guessing ! once, with Hello, World! as secret phrase, guessLetter should return false";
		assertEquals(msg, false, game.guessLetter('!'));
	}

	@Test
	public void testGuessLetter4() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		String msg = "After guessing space once, with Hello, World! as secret phrase, guessLetter should return false";
		assertEquals(msg, false, game.guessLetter(' '));
	}

	@Test
	public void testDisplayedWordAfterGuess1() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		game.guessLetter('H');
		String msg = "After guessing H once, with Hello, World! as secret phrase, the letters except H should be hidden and non letters should not be hidden";
		HideableChar[] testChars = stringToHideableChar(testWord);
		unHideChar(testChars, 'H');
		assertEquals(msg, true,
				equalsHideableChar(game.getDisplayedWord(), testChars));
	}

	@Test
	public void testDisplayedWordAfterGuess2() {
		String testWord = "Hello, World!";
		Game game = new Game(testWord);
		game.guessLetter('A');
		String msg = "After guessing A once, with Hello, World! as secret phrase, the letters should be hidden and non letters should not be hidden";
		HideableChar[] testChars = stringToHideableChar(testWord);
		// unHideChar(testChars, 'A');
		assertEquals(msg, true,
				equalsHideableChar(game.getDisplayedWord(), testChars));
	}

	private void unHideChar(HideableChar[] hideableChars, char ch) {
		for (int i = 0; i < hideableChars.length; i++) {
			if (hideableChars[i].getHiddenChar().equals(ch + "")) {
				hideableChars[i].unHide();
			}
		}
	}

	private boolean equalsHideableChar(HideableChar[] chars1,
			HideableChar[] chars2) {
		boolean allEqual = false;
		for (int i = 0; i < chars1.length; i++) {
			boolean euqalHiddenStatus = (chars1[i].isHidden() == chars2[i]
					.isHidden());
			boolean equalChars = (chars1[i].getHiddenChar().equals(chars2[i]
					.getHiddenChar()));

			if (euqalHiddenStatus && equalChars) {
				return true;
			} else {
				return false;
			}
		}

		return allEqual;
	}

	private HideableChar[] stringToHideableChar(String s) {

		HideableChar[] testChar = new HideableChar[s.length()];

		for (int i = 0; i < testChar.length; ++i) {
			testChar[i] = new HideableChar(s.charAt(i));
		}

		return testChar;
	}

	private void guessChar(int times, char ch, Game game) {
		for (int i = 0; i < times; ++i) {
			game.guessLetter(ch);
		}
	}

}