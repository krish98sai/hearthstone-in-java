import java.io.FileNotFoundException;
import java.util.Scanner;

public class Commands{
	String command = "";
	
	public Commands(){}
	public void recieveCommand(Player isTurn, Player notTurn, String datCommand) throws FileNotFoundException
	{
		command = datCommand;
		checkCommand(isTurn, notTurn, command);
	}
	public void checkCommand(Player isTurn, Player notTurn, String datCommand) throws FileNotFoundException
	{
		Scanner in = new Scanner(System.in);
		String aCommand = command;
		
		if(aCommand.equals("PlayCard")){
			isTurn.playCard(in.next());
		}
		else if(aCommand.equals("Concede")){
			isTurn.changeHealth(0);
		}
		else if(aCommand.equals("Attack")){
			isTurn.attack(in.next(), in.next(), isTurn, notTurn);
		}
		else if(aCommand.equals("")){
			
		}
		else if(aCommand.equals("")){
			
		}
	}
	public void createPlayer(String name, String deckName) throws FileNotFoundException{
		Player p1 = new Player(name, deckName);
	}
}
