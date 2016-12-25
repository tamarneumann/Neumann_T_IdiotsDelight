//Tamar Neumann
package cards;

public class Card {

	private Rank rank; 
	private Suit suit;
	private Color color;
	
	/**
	 * Constructor to set the cards rank, suit, and color
	 * @param rank The rank of the card.
	 * @param suit The Suit of the card.
	 * @param color The Color of the card.
	 */
	public Card(Rank rank, Suit suit, Color color){
		this.rank=rank;
		this.suit=suit;
		this.color=color;
		
	}
	/**
	 * Getter method for Rank.
	 * @return The Rank of the card.
	 */
	public Rank getRank(){
		return rank;
	}
	/**
	 * Getter method for Suit.
	 * @return The Suit of the card.
	 */
	public Suit getSuit(){
		return suit;
	}
	/**
	 * Getter method for Color.
	 * @return The Color of the card.
	 */
	public Color getColor(){
		return color;
	}
	
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		
		sb.append(rank+" of "+suit);
		
		return sb.toString();
	}
}
