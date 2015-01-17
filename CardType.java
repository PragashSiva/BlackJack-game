// The "CardType" class.
import java.awt.*;
import hsa.Console;

public class CardType
{
    protected int value;
    protected String suit;
    
    //Constructor.
    public CardType (int value, String suit)
    {
	this.value = value;
	this.suit = suit;
    } //CardType constructor
    
    //Method to get value of card.
    public int getValue()
    {
	return value;
    }// getValue method
    
    public String getSuit()
    {
	return suit;
    }// getSuit method
} // CardType class
