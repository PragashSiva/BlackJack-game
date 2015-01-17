// The "BlackJackTable" class.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.applet.*;
import java.io.*;
import java.net.URL;
import javax.imageio.*;
import hsa.Console;
public class BlackJackTable extends CardDeck
{
    //Additional constants and variables.
    static int NUMBER_OF_HANDS = 2;
    static int CARDS_IN_DEALERSHAND = 2;
    static int CARDS_IN_PLAYERSHAND = 2;
    static int cardPosition = 100;
    static int CARDS_IN_HAND = 2;
    CardType hand[] [] = new CardType [NUMBER_OF_HANDS + 1] [CARDS_IN_HAND + 5];
    static int player;
    static int dealer;
    static String hiddenCard = "";
    static int hiddenValue = 0;
    static String card = "c1";
    static boolean background = true; 
    static int dealerPos = 300; 
    
    //Method for dealing hands from deck.
    public void dealHands ()
    {
	//Deal one card to each hand in turn repeatedly.
	int card = 1;
	for (int cardCount = 1 ; cardCount <= CARDS_IN_HAND ; cardCount++)
	{
	    for (int handCount = 1 ; handCount <= NUMBER_OF_HANDS ; handCount++)
	    {
		hand [handCount] [cardCount] = deck [card];
		//Move to deal next card.
		card++;
	    }
	}
    } //dealHands method
    
    //Deals individual cards for hit
    public void dealCard (Console c, int player)
    {
	//a new card is dealt from the now shuffled pack
	CARDS_IN_HAND++;
	card = (deck [2].suit + "" + deck [2].value);
	paint(c, false);
	hand [player] [CARDS_IN_HAND] = deck [2];

    } //dealCard method


    //Checks for naturals
    public String checkNatural ()
    {
	int sum = 0;
	String status = "";
	for (int whichHand = 2 ; whichHand <= NUMBER_OF_HANDS ; whichHand++)
	{
	    for (int whichCard = 1 ; whichCard <= CARDS_IN_HAND ; whichCard++)
		sum = sum + (hand [whichHand] [whichCard].value);
	}
	if (sum <= 21)
	    status = "under";
	if (sum == 21)
	    status = "natural";
	if (sum >= 21)
	    status = "bust";
	    
	sum = 0;
	return status;
    } // Checking for naturals method 

    public void listHands (Console d, Console c)
    {
	//Setting up the background
	paint(d,false);
	background = true; 
	paint(c,false);
	
	//Hands are listed one card to a line unsorted.
	for (int whichHand = 1 ; whichHand <= NUMBER_OF_HANDS ; whichHand++)
	{
	    if (whichHand == 1)
	    {
		for (int whichCard = 1 ; whichCard <= CARDS_IN_HAND ; whichCard++)
		{
		    card = (hand [whichHand] [whichCard].suit + hand [whichHand] [whichCard].value);
		    paint(d, true);
		    deck [whichCard].value = 0;
		}
	    }
	    else
	    {
		d.println ("PLAYER " + (whichHand - 1));
		for (int whichCard = 1 ; whichCard <= CARDS_IN_HAND ; whichCard++)
		{
		    card = (hand [whichHand] [whichCard].suit + hand [whichHand] [whichCard].value);
		    paint(c, false);
		    deck [whichCard].value = 0;
		}
	    }
	}
    } //listHands method

    
    public void paint (Console a, boolean dealer)
    {
	// to ensure the background is drawn at the origin
	if (background == true) {
	    Image myPicture = loadImage ("background.jpg"); //Loads the background table
	    a.drawImage (myPicture, 0, 0, null);
	    background = false; 
	    return; 
  
	}
	
	// ELSE -------
	    Image myPicture = loadImage ("c1.png");     // default picture
	    //clubs
	    if (card.equals ("C1"))
		myPicture = loadImage ("c1.png");
	    else if (card.equals ("C2"))
		myPicture = loadImage ("c2.png");
	    else if (card.equals ("C3"))
		myPicture = loadImage ("c3.png");
	    else if (card.equals ("C4"))
		myPicture = loadImage ("c4.png");
	    else if (card.equals ("C5"))
		myPicture = loadImage ("c5.png");
	    else if (card.equals ("C6"))
		myPicture = loadImage ("c6.png");
	    else if (card.equals ("C7"))
		myPicture = loadImage ("c7.png");
	    else if (card.equals ("C8"))
		myPicture = loadImage ("c8.png");
	    else if (card.equals ("C9"))
		myPicture = loadImage ("c9.png");
	    else if (card.equals ("C10"))
		myPicture = loadImage ("c10.png");
	    else if (card.equals ("C11"))
		myPicture = loadImage ("c11.png");
	    else if (card.equals ("C12"))
		myPicture = loadImage ("c12.png");
	    else if (card.equals ("C13"))
		myPicture = loadImage ("c13.png");
	    else if (card.equals ("C14"))
		myPicture = loadImage ("c13.png");

	    //diamonds
	    else if (card.equals ("D1"))
		myPicture = loadImage ("d1.png");
	    else if (card.equals ("D2"))
		myPicture = loadImage ("d2.png");
	    else if (card.equals ("D3"))
		myPicture = loadImage ("d3.png");
	    else if (card.equals ("D4"))
		myPicture = loadImage ("d4.png");
	    else if (card.equals ("D5"))
		myPicture = loadImage ("d5.png");
	    else if (card.equals ("D6"))
		myPicture = loadImage ("d6.png");
	    else if (card.equals ("D7"))
		myPicture = loadImage ("d7.png");
	    else if (card.equals ("D8"))
		myPicture = loadImage ("d8.png");
	    else if (card.equals ("D9"))
		myPicture = loadImage ("d9.png");
	    else if (card.equals ("D10"))
		myPicture = loadImage ("d10.png");
	    else if (card.equals ("D11"))
		myPicture = loadImage ("d11.png");
	    else if (card.equals ("D12"))
		myPicture = loadImage ("d12.png");
	    else if (card.equals ("D13"))
		myPicture = loadImage ("d13.png");
	    else if (card.equals ("D14"))
		myPicture = loadImage ("d13.png");

	    //hearts
	    else if (card.equals ("H1"))
		myPicture = loadImage ("h1.png");
	    else if (card.equals ("H2"))
		myPicture = loadImage ("h2.png");
	    else if (card.equals ("H3"))
		myPicture = loadImage ("h3.png");
	    else if (card.equals ("H4"))
		myPicture = loadImage ("h4.png");
	    else if (card.equals ("H5"))
		myPicture = loadImage ("h5.png");
	    else if (card.equals ("H6"))
		myPicture = loadImage ("h6.png");
	    else if (card.equals ("H7"))
		myPicture = loadImage ("h7.png");
	    else if (card.equals ("H8"))
		myPicture = loadImage ("h8.png");
	    else if (card.equals ("H9"))
		myPicture = loadImage ("h9.png");
	    else if (card.equals ("H10"))
		myPicture = loadImage ("h10.png");
	    else if (card.equals ("H11"))
		myPicture = loadImage ("h11.png");
	    else if (card.equals ("H12"))
		myPicture = loadImage ("h12.png");
	    else if (card.equals ("H13"))
		myPicture = loadImage ("h13.png");
	    else if (card.equals ("H14"))
		myPicture = loadImage ("h13.png");
		
	    //spades
	    else if (card.equals ("S1"))
		myPicture = loadImage ("s1.png");
	    else if (card.equals ("S2"))
		myPicture = loadImage ("s2.png");
	    else if (card.equals ("S3"))
		myPicture = loadImage ("s3.png");
	    else if (card.equals ("S4"))
		myPicture = loadImage ("s4.png");
	    else if (card.equals ("S5"))
		myPicture = loadImage ("s5.png");
	    else if (card.equals ("S6"))
		myPicture = loadImage ("s6.png");
	    else if (card.equals ("S7"))
		myPicture = loadImage ("s7.png");
	    else if (card.equals ("S8"))
		myPicture = loadImage ("s8.png");
	    else if (card.equals ("S9"))
		myPicture = loadImage ("s9.png");
	    else if (card.equals ("S10"))
		myPicture = loadImage ("s10.png");
	    else if (card.equals ("S11"))
		myPicture = loadImage ("s11.png");
	    else if (card.equals ("S12"))
		myPicture = loadImage ("s12.png");
	    else if (card.equals ("S13"))
		myPicture = loadImage ("s13.png");
	    else if (card.equals ("S14"))
		myPicture = loadImage ("s13.png");
	    cardPosition = cardPosition +15;
	    
	    if (!dealer) a.drawImage (myPicture, cardPosition+100, 
						    cardPosition-100+dealerPos, null); 
	    
	    else a.drawImage (myPicture, cardPosition+100, cardPosition-80, null);
	  
	    
	// Place the drawing code here
    } // paint method


    public static Image loadImage (String path)
    {
	File f = new File (path);
	Image img = null;

	try
	{
	    img = ImageIO.read (f);
	}
	catch (IOException e)
	{
	    System.out.println ("Error: Could not find image");
	}
	return img;
    } //LoadImage method
} // BlackJackTable class

