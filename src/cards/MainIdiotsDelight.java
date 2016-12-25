//Tamar Neumann
package cards;

import java.util.EmptyStackException;
import java.util.Scanner;
import exceptions.*;

public class MainIdiotsDelight {

	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		
		IdiotsDelight game=new IdiotsDelight();
		
		int answer, //players menu choice.
		    stack1, //the 1st stack chosen
		    stack2; //the 2nd stack being chosen.
		
		System.out.println("WELCOME TO IDIOTS DELIGHT: THE GAME IN WHICH YOUR MENTAL CAPACITY IS DETERMINED BY YOUR PLEASURE OF PLAYING! "
				+ "\nRULES: A DECK OF CARDS IS DEALT INTO 4 STACKS."
				+"\nEACH ROUND YOU HAVE THE OPTION OF REMOVING CARDS ACCORDING TO CARD RANK OR SUIT. "
				+"\n\t-IF 2 CARDS HAVE THE SAME RANK, BOTH ARE DISCARDED."
				+"\n\t-THE ROYAL CARDS HAVE THE SAME RANK AS 10"
				+"\n\t-IF 2 CARDS ARE THE SAME SUIT, ONLY THE CARD WITH THE LOWER RANK IS DISCARDED."
				+"\nGOOD LUCK AND ENJOY!");
		do{
			//display the 4 stacks.
			game.display();
			
			//receive the players answer from the menu.
			answer=menu();
			
		 try{
			switch (answer){
		
		
			case 1:
				
				System.out.println("Enter the first stack of a matching rank:");
				stack1=input.nextInt();
				
					while(stack1<1||stack1>4)
					{
						System.out.println("ENTER A VALID OPTION:");
						stack1=input.nextInt();
					}
					
				System.out.println("Second stack:");
				stack2=input.nextInt();
				
					while(stack1<1||stack1>4||stack1==stack2)
					{
						System.out.println("Enter the second stack of a matching rank:");
						stack1=input.nextInt();
					}
				//discard the 2 cards with matching ranks.
				game.discard(stack1, stack2);
				
			break;
		
			case 2:
				System.out.println("Enter the stack with the lower Rank:");
				stack1=input.nextInt();
				
					while(stack1<1||stack1>4)
					{
						System.out.println("ENTER A VALID OPTION:");
						stack1=input.nextInt();
					}
				//discard the lower ranking card of matching suits.
				game.discard(stack1);
						
			break;
			
			case 3:
				//deal 4 cards into the stacks and see if it was successful.
				game.deal();
				  
			break;
			
			case 0: 
				System.out.println("THANK YOU FOR PLAYING IDIOTS DELIGHT.\nIF YOU ENJOYED... THE TITLE SAYS IT ALL");
				System.exit(0);
			}
		 }
		 catch(IllegalMoveException im)
		 {
			 System.out.println("ILLEGAL MOVE PLEASE TRY AGAIN.");
		 }
		 catch(EmptyStackException es)
		 {
			 System.out.println("STACK IS EMPTY PLEASE TRY AGAIN.");

		 }
		 catch(DeckFinishedException ed)
		 {
			 System.out.println("THE DECK OF CARDS ARE FINISHED");
		 }
			
			
		}
		while(!game.gameWon());
		System.out.println("CONGRATULATIONS!YOU WON!!");
		
		
	}
	public static int menu(){
		Scanner input=new Scanner(System.in);
		
		int answer;
		
		System.out.println("\n1.Discard by Rank\n2.Discard by Suit\n3.Deal cards\n0.Exit");
		answer=input.nextInt();
		
			while(answer<0||answer>3)
			{
				System.out.println("ENTER A VALID OPTION");
				answer=input.nextInt();
			}
		return answer;
	}
}
