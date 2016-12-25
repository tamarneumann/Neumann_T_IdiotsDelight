package exceptions;

public class DeckFinishedException extends RuntimeException{
	public DeckFinishedException(){
		super("THE DECK OF CARDS ARE FINISHED");
	}
}
