package hw2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is a JUnit test class of HideableChar.
 * 
 * @author Yuxiang Chen
 * 
 */
public class HideableCharTest {
	private HideableChar a;
	private HideableChar b;

	@Before
	public void setup() {
		a = new HideableChar('a');
		b = new HideableChar('.');
	}

	// For Character.
	
	@Test
	public void testGetDisplayedCharAfterConstructingCharacter() {
		String msg = "After constructing a character, getDisplayedChar should return null.";
		assertEquals(msg, null, a.getDisplayedChar());
	}

	@Test
	public void testGetHiddenCharAfterConstructingCharacter() {
		String msg = "After constructing a character, getHidenChar should return the character.";
		assertEquals(msg, "a", a.getHiddenChar());
	}

	@Test
	public void testHiddenStatusAfterConstructingCharacter() {
		String msg = "After constrcting a character, isHidden should return true.";
		assertEquals(msg, true, a.isHidden());
	}

	@Test
	public void testHiddenStatusAfterUnhidingOfChar() {
		a.unHide();
		String msg = "After unhiding a hidden character, isHidden should return false.";
		assertEquals(msg, false, a.isHidden());
	}

	@Test
	public void testHiddenStatusAfterHidingAnUnhiddenChracter() {
		a.unHide();
		a.hide();
		String msg = "After hiding an unhidden character, isHidden should return true.";
		assertEquals(msg, true, a.isHidden());
	}

	@Test
	public void testMatchesUnderHiddenStatusForTrueOfChar() {
		String msg = "Test if the character matches the same character under hidden status, matches should return true.";
		assertEquals(msg, true, a.matches('a'));
	}

	@Test
	public void testMatchesUnderHiddenStatusForFalseOfChar() {
		String msg = "Test if the character matches a different character under hidden status, matches should return false.";
		assertEquals(msg, false, a.matches('c'));
	}

	@Test
	public void testMatchesUnderUnhiddenStatusForTrueOfChar() {
		a.unHide();
		String msg = "Test if the character matches the same character under unhidden status, matches should return true.";
		assertEquals(msg, true, a.matches('a'));
	}

	@Test
	public void testMatchesUnderUnhiddenStatusForFalseOfChar() {
		a.unHide();
		String msg = "Test if the character matches a different character under unhidden status, matches should return false.";
		assertEquals(msg, false, a.matches('c'));
	}

	@Test
	public void testGetDisplayedCharUnderUnhiddenStatusOfChar() {
		a.unHide();
		String msg = "Test getDisplayedChar under unhidden status, should return the character.";
		assertEquals(msg, "a", a.getDisplayedChar());
	}

	@Test
	public void testGetDisplayedCharAfterHidingAnUnhiddenCharacterOfChar() {
		a.unHide();
		a.hide();
		String msg = "Test getDisplayedChar after hiding an unhidden character, should return null.";
		assertEquals(msg, null, a.getDisplayedChar());
	}

	@Test
	public void testGetHiddenCharUnderHiddenStatusOfChar() {
		a.hide();
		String msg = "Test getHiddenChar under hidden status, should return the character.";
		assertEquals(msg, "a", a.getHiddenChar());
	}

	@Test
	public void testGetHiddenCharAfterHidingAnUnhiddenCharacterOfChar() {
		a.unHide();
		a.hide();
		String msg = "Test getHiddenChar after hiding an unhidden character, should return the character.";
		assertEquals(msg, "a", a.getHiddenChar());
	}

	// For symbol.

	@Test
	public void testGetDisplayedCharAfterConstructingSymbol() {
		String msg = "After constructing a symbol, getDisplayedChar should return the symbol.";
		assertEquals(msg, ".", b.getDisplayedChar());
	}

	@Test
	public void testGetHiddenCharAfterConstructingSymbol() {
		String msg = "After constructing a character, getHidenChar should return the symbol.";
		assertEquals(msg, ".", b.getHiddenChar());
	}

	@Test
	public void testHiddenStatusAfterConstructingSymbol() {
		String msg = "After constrcting a symbol, isHidden should return false.";
		assertEquals(msg, false, b.isHidden());
	}

	@Test
	public void testHiddenStatusAfterHiding() {
		b.hide();
		String msg = "After hiding an unhidden symbol, isHidden should return true.";
		assertEquals(msg, true, b.isHidden());
	}

	@Test
	public void testHiddenStatusAfterUnhidingAHiddenSymbol() {
		b.hide();
		b.unHide();
		String msg = "After unhiding a hidden symbol, isHidden should return false.";
		assertEquals(msg, false, b.isHidden());
	}

	@Test
	public void testMatchesUnderUnhiddenStatusForTrueOfSymbol() {
		String msg = "Test if the symbol matches the same symbol under unhidden status, matches should return true.";
		assertEquals(msg, true, b.matches('.'));
	}

	@Test
	public void testMatchesUnderUnhiddenStatusForFalseOfSymbol() {
		String msg = "Test if the symbol matches a different symbol under unhidden status, matches should return false.";
		assertEquals(msg, false, b.matches(','));
	}

	@Test
	public void testMatchesUnderHiddenStatusForTrueOfSymbol() {
		b.hide();
		String msg = "Test if the symbol matches the same symbol under hidden status, matches should return true.";
		assertEquals(msg, true, b.matches('.'));
	}

	@Test
	public void testMatchesUnderHiddenStatusForFalseOfSymbol() {
		b.hide();
		String msg = "Test if the symbol matches a different symbol under hidden status, matches should return false.";
		assertEquals(msg, false, b.matches(','));
	}

	@Test
	public void testGetDisplayedCharUnderHiddenStatusOfSymbol() {
		b.hide();
		String msg = "Test getDisplayedChar under hidden status, should return null.";
		assertEquals(msg, null, b.getDisplayedChar());
	}

	@Test
	public void testGetDisplayedCharAfterUnhidingAnHiddenCharacterOfSymbol() {
		b.hide();
		b.unHide();
		String msg = "Test getDisplayedChar after unhiding a hidden symbol, should return the symbol.";
		assertEquals(msg, ".", b.getDisplayedChar());
	}

	@Test
	public void testGetHiddenCharUnderUnhiddenStatusOfSymbol() {
		b.unHide();
		String msg = "Test getHiddenChar under unhidden status, should return the symbol.";
		assertEquals(msg, ".", b.getHiddenChar());
	}

	@Test
	public void testGetHiddenCharAfterUnhidingAnHiddenCharacterOfSymbol() {
		b.hide();
		b.unHide();
		String msg = "Test getHiddenChar after unhiding a hidden character, should return the symbol.";
		assertEquals(msg, ".", b.getHiddenChar());
	}

}
