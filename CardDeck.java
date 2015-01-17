// The "CardDeck" class.
import java.awt.*;
import hsa.Console;

public class CardDeck
{
    final int CARDS_IN_DECK = 52;
    final int NUMBER_OF_SUITS = 4;
    final int CARDS_IN_SUITS = 13;
    final String [] suit = {"S","H","D","C"};
    CardType [] deck = new CardType[CARDS_IN_DECK+1];
    
    //Constructor for deck.
    public CardDeck()
    {
	int card = 1; //Deck[0] not used.
	for (int whichSuit = 0; whichSuit < NUMBER_OF_SUITS; whichSuit++)
	{
	    for (int whichValue = 2; whichValue <=14; whichValue++)
	    {
		deck[card] = new CardType(whichValue,suit[whichSuit]);
		card++;
	    }
	}
    }// CardDeck constructor
    
    // Method to swap ith and jth card
    protected void swap (int i, int j)
    {
	CardType temp = deck [i];
	deck[i] = deck[j];
	deck[j] = temp;
    }//swap method
    
    //Method to shuffle deck.
    public void shuffleDeck()
    {
	for (int whichCard = 1; whichCard<=CARDS_IN_DECK;whichCard++)
	{
	    // Generate random integer between 1 and CARDS_IN_DECK.
	    int where = (int)(Math.random()*CARDS_IN_DECK+1);
	    swap(whichCard,where);
	}
    }//shuffleDeck method
    
    //Method to print deck
    public void printDeck (Console c)
    {
	for (int card = 1; card<= CARDS_IN_DECK; card++)
	{
	    c.print(deck[card].getSuit()+""+deck[card].getValue());
	    c.print(" ");
	}
    }// printDeck method
} // CardDeck class
