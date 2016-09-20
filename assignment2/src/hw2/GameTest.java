package hw2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class GameTest {
	Game gameNormal;
	Game gameWithPunctuation;

	@Before
	public void setup() throws FileNotFoundException {
		boolean playAgain = true;
		gameNormal = new Game("TesTinG", 5);
		gameWithPunctuation = new Game("#T3STing!");
	}

	@Test
	public void testBadGuesser() {
		for (int i = 0; i < 6; i++) {
			gameNormal.guessLetter('z');
		}
		String msg = "Guessed 'z' 5 times. The game should be over.";
		assertEquals(msg, true, gameNormal.gameOver());
		msg = "But you're a bad guesser so you lost :(";
		assertEquals(msg, false, gameNormal.won());
	}

	@Test
	public void testGoodGuesser() {
		String guesses = "TesTinG";
		for (int i = 0; i < guesses.length(); i++) {
			gameNormal.guessLetter(guesses.charAt(i));
		}

		String msg = "Guessed the letters in the word The game should be over";
		assertEquals(msg, true, gameNormal.gameOver());
	}

	@Test
	public void testUnhideNonAlpha() {
		String msg = "Non alpha characters should be revealed when game is created.";
		assertEquals(msg, true, "# 3     !".equals(getWord(gameWithPunctuation
				.getDisplayedWord())));
	}

	private String getWord(HideableChar[] chars) {
		String word = "";
		for (int i = 0; i < chars.length; ++i) {
			if (chars[i].isHidden()) {
				word += " ";
			} else {
				word += chars[i].getDisplayedChar();
			}
		}
		return word;
	}
}