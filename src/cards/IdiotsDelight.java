//Tamar Neumann
package cards;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import exceptions.*;

public class IdiotsDelight {

	    private int cardsLeft;		  //The number cards that need to be discarded to win.
		private Deck deckOfCards;     
		private Stack<Card>[] stacks; //An array that holds four stacks of cards.
		
		public IdiotsDelight(){
			//The game begins with 52 cards.
			cardsLeft=52;  
			
			//Create a new deck of cards.
			deckOfCards=new Deck(); 
			
			//Shuffle the deck of cards.
			deckOfCards.shuffleDeck(); 
			
			//Create an array to hold 4 stacks.
			stacks = new Stack[4];
			
			//Assign each index a stack of cards.
			   for(int i=0;i<stacks.length;i++)
			   {
				   stacks[i]=new Stack<Card>();
			   }
		
			   //Method that deals 4 cards.
			   deal();
		}
		/**
		 * Method to discard cards based on similar Rank.
		 * @param num1 The first stack that contains the card to be discarded.
		 * @param num2 The second stack that contains the card to be discarded.
		 */
			public void discard(int num1, int num2){
				if(stacks[num1-1].empty() || stacks[num2-1].empty())
					throw new EmptyStackException();
				
				Card card1=stacks[num1-1].peek(), //The first card being compared.
					 card2=stacks[num2-1].peek(); //The second card being compared.
						
				//if the ranks of the 2 cards match, pop each one from its stack.
				if(card1.getRank().getValue() == card2.getRank().getValue())
				{
					stacks[num1-1].pop();
					stacks[num2-1].pop();	
					
					//decrement the amount of cards left by 2.
					cardsLeft-=2;
				}
				else
					//if the ranks of the 2 cards don't match, throw an exception.
					throw new IllegalMoveException();
			}
			
			/**
			 * Method to discard cards based on similar Suits.
			 * @param num The stack that contains the lower number of a card with matching Suits.
			 */
			public void discard( int num){

				if(stacks[num-1].isEmpty())
					throw new EmptyStackException();
				
				Card card1=stacks[num-1].peek(); //The card being compared.		
				
				int i=0; //To loop through the stacks.
				
				boolean success=false; //to see if a card was discarded.
				
				//Loop through the first card of each stack to find the matching Suits.
					for(i=0;i<stacks.length && !success;i++)
					{
						//don't compare the stack of the current card or with a null column.
						if(num-1==i || stacks[i].empty())
							continue;
						
						if(card1.getSuit().equals(stacks[i].peek().getSuit())&&
						   card1.getRank().getValue()<stacks[i].peek().getRank().getValue())
						{
							stacks[num-1].pop();
							cardsLeft--;
							success=true;
						}
						
					}
					//If the card was not successfully discarded, then throw an exception.
					if(!success)
						throw new IllegalMoveException();
				
				
			}
			/**
			 * Method that deals a card into each stack.
			 */
			public void deal(){
			
				for(int i=0;i<stacks.length;i++)
				{
					stacks[i].push(deckOfCards.dealCard());
							   
				}
					
			}
			/**
			 * Method that displays the top card of each stack.
			 */
			public void display(){
				System.out.println("Stack 1\t\t\tStack 2\t\t\tStack 3\t\t\tStack 4\t\tCards Left: "+cardsLeft+"\t\tDeals left: "+deckOfCards.dealsLeft());
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
				for(int i=0;i<stacks.length;i++)
					{
						if(stacks[i].empty())
							System.out.print("\t-\t\t");
						else
						{
						System.out.printf("%-23s",stacks[i].peek());
						}
					}
		}
			
			/**
			 * Method to see if the deck was completely discarded
			 * @return Boolean value if the deck is empty, and the game was won.
			 */
			public boolean gameWon(){
				
				return (cardsLeft==0);
			}
}
