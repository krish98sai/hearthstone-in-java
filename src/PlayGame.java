import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class PlayGame extends Board{
	public static void main(String[]args) throws FileNotFoundException, CloneNotSupportedException{
		boolean endTurn = false;
		Commands tell = new Commands();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter player 1's name and deck file name.");
		Player p1 = new Player(in.next(), in.next()+".txt");
		System.out.println("Enter player 2's name and deck file name.");
		Player p2 = new Player(in.next(), in.next()+".txt");
		Player isTurn;
		Player notTurn;
		int counter = 0;
		Random rand = new Random();
		int playerTurn = rand.nextInt(1);
		if(playerTurn == 0){isTurn = (Player)p1.clone(); notTurn = (Player) p2.clone(); counter = 1;}
		else{isTurn = (Player) p2.clone(); notTurn = (Player) p1.clone(); counter = 2;}
		
		//Start game
		while(p1.getHealth() > 0 && p2.getHealth() > 0)
		{
			
			counter++;
			if(counter % 2 == 0){isTurn = (Player) p1.clone(); notTurn = (Player) p2.clone();}else{isTurn = (Player) p2.clone(); notTurn = (Player) p1.clone();}
			System.out.println("It is " + isTurn.getName() + "'s turn!");
			isTurn.setMinionsToCanAttack();
			isTurn.increaseMaxMana();
			isTurn.changeMana(isTurn.getMaxMana());
			endTurn = false;
			isTurn.fillHand();
			while(!endTurn){
				printBoard(isTurn, p1, p2);
				System.out.println("Your health: " + isTurn.getHealth());
				System.out.println(notTurn.getName() + "'s health: " + notTurn.getHealth());
				System.out.println("Your mana: " + isTurn.getMana());
				String command = in.next();
				
				if(command.equals("upupdowndownleftrightleftrightbastart")){
					notTurn.changeHealth(0);
					endTurn = true;
					if(counter % 2 == 0){
						p1 = (Player) isTurn.clone();
						p2 = (Player) notTurn.clone();
					}else{
						p2 = (Player) isTurn.clone();
						p1 = (Player) notTurn.clone();
					}
				}
				else if(!(command.equals("EndTurn"))){
					tell.recieveCommand(isTurn, notTurn, command);
					}
				else{
					endTurn = true;
					if(counter % 2 == 0){
						p1 = (Player) isTurn.clone();
						p2 = (Player) notTurn.clone();
					}else{
						p2 = (Player) isTurn.clone();
						p1 = (Player) notTurn.clone();
					}
					}
		}
			}
		String winner = "";
		if(p1.getHealth() <= 0){winner = p2.getName();}
		else{winner = p1.getName();}
		System.out.println("Game Over! The Winner is " + winner);
		
		in.close();
	}
}
