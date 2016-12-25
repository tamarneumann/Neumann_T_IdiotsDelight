//Tamar Neumann
package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import exceptions.*;

public class Deck {
	
	private ArrayList <Card>cardArrayList; //Array list to hold a deck of cards.
	
	public Deck(){
		
		cardArrayList=new ArrayList<>(52); //create array list for 52 cards.
		
		Color color; //The color of the card.
		
		//For every rank of 13 cards, create a card for each suit.
		for(Rank rank: Rank.values())
		{
		
			
			for(int j=0;j<4;j++)
			{
				
				if(Suit.values()[j]==Suit.HEARTS||Suit.values()[j]==Suit.DIAMONDS)
					color=Color.RED;
				else
					color=Color.BLACK;
				
				cardArrayList.add(new Card(rank,Suit.values()[j],color));
			}
		}
			
	}
	/**
	 * Method that shuffles the deck of cards.
	 */
		public void shuffleDeck(){
			
			Random random=new Random(System.currentTimeMillis());	//create instance of Random class.
			int swap;  //the index of the card being swapped.
			
			//create a random index number for each card and swap it with the current card.
			for(int i=0;i<cardArrayList.size();i++)
			{
				swap=random.nextInt(52);
				Collections.swap(cardArrayList, i, swap);
			
			}
		}
	
		/**
		 * Method that deals a card.
		 * @return the card that was dealt.
		 */
		public Card dealCard(){
			
			if(cardArrayList.isEmpty())
				throw new DeckFinishedException();
			
			//remove the card from the deck.
			return cardArrayList.remove(cardArrayList.size()-1);
		}
		
		/**
		 * Method to see if the deck of cards is finished.
		 * @return Boolean value to check if the deck has more cards.
		 */
		public boolean isEmpty(){
			return cardArrayList.isEmpty();
		}
		
		public int dealsLeft(){
			return cardArrayList.size()>0?cardArrayList.size()/4:0;
		}
	
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		
		for(Card x:cardArrayList)
		{
			sb.append(x+"\n");
		}
		
		return sb.toString();
	}
}
