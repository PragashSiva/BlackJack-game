// The "PlayBlackJackTest" class.
import java.awt.*;
import hsa.Console;

public class Play21Test
{
    static Console c;           // The output console for player
    static Console d;           // The output console for dealer

    public static void main (String[] args)
    {
	d = new Console ();
	c = new Console ();

	BlackJackTable deck = new BlackJackTable ();
	deck.shuffleDeck ();
	deck.dealHands ();
	deck.listHands (c, c);
	while (deck.checkNatural().equals("under"))
	{
	    d.println("PRESS 'h' FOR HIT AND 's' FOR STAY:");
	    if (c.getChar () == 'h')
	    {
		deck.shuffleDeck ();
		deck.dealCard (c, 2);
		d.println("********"+deck.checkNatural()+"********");
	    }
	    
	    else 
		c.println(deck.checkNatural()); 
	}
	
	
    } // main method
} // PlayBridgeTest class
