package lab8;

import java.util.Random;

public class DeckTest {
	public static void main(String[] args) {
		Random a = new Random();
		Deck deck = new Deck(a);
		Card[] hand = deck.select(5);
		System.out.println(Card.toString(hand));
	}
}