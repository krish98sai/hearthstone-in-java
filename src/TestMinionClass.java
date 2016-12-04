import java.io.FileNotFoundException;

public class TestMinionClass extends Deck
{
    public static void main(String[]args) throws FileNotFoundException
    {
        
        Minion[] deck1 = new Minion[20];
        fillDeck("filedeck1.txt", deck1);
        
        System.out.println(deck1[1].getName());
        System.out.println(deck1[1].getHealth());
        System.out.println(deck1[2].getName());
        System.out.println(deck1[2].getHealth());
        //deck1[1].attack(deck1[2]);
        System.out.println(deck1[1].getHealth());
        System.out.println(deck1[2].getHealth());
        
        /*
        Minion[] g = new Minion[20];
		g = p1.getDeck();
		System.out.println(g[0].getName());
		System.out.println(g[1].getName());
		System.out.println(g[2].getName());
		System.out.println(g[3].getName());
		*/
    }
}