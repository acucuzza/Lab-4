package base;

import exceptions.DeckException;
import pokerBase.Card;
import pokerBase.Deck;


public class TestPlay {

	public static void main (String[] args) throws DeckException
	{
		Deck d = new Deck();
		Card c = d.Draw();
		
	}
}
