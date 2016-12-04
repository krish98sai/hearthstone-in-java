public class Board{
	
	public static void printBoard(Player current, Player p1, Player p2){
		printP1Side(p1);
		printP2Side(p2);
		printHand(current);
	}
	public static void printP1Side(Player p1){
		System.out.println(p1.getName() + "'s Minions");
		Minion[] p1Played = p1.getPlayedCards();
		for (Minion m : p1Played)
		{
			if(m==null)break;
			System.out.println("--------------------------");
			System.out.println("Name: " + m.getName());
			System.out.println("Health: " + m.getHealth());
			System.out.println("Damage: " + m.getDamage());
			System.out.println("Type: " + m.getType());
			System.out.println("--------------------------");
		}
	}
	public static void printP2Side(Player p2){
		System.out.println(p2.getName() + "'s Minions");
		for (Minion m : p2.getPlayedCards())
		{
			if(m==null)break;
			System.out.println("--------------------------");
			System.out.println("Name: " + m.getName());
			System.out.println("Health: " + m.getHealth());
			System.out.println("Damage: " + m.getDamage());
			System.out.println("Type: " + m.getType());
			System.out.println("--------------------------");
		}
	}
	public static void printHand(Player current){
		System.out.println(current.getName() + "'s Cards");
		for (Minion m : current.getHand())
		{
			if(m==null)break;
			System.out.println("--------------------------");
			System.out.println("Name: " + m.getName());
			System.out.println("Cost: " + m.getCost());
			System.out.println("Health: " + m.getHealth());
			System.out.println("Damage: " + m.getDamage());
			System.out.println("Type: " + m.getType());
			System.out.println("--------------------------");
		}
	}
}