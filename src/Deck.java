import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Deck
{

    public static void fillDeck(String datFileName, Minion[] arrayToFill) throws FileNotFoundException
    {
    	try{
    	Minion[] deck1 = new Minion[20];
    	String fileName = datFileName;
    	File inputFile = new File(fileName);
        Scanner in = new Scanner(inputFile);
        in.nextLine();
        for(int i = 0; i < 20; i++)
        {
        	Minion a = new Minion(in.next(), in.nextInt(),in.next(), in.nextInt(),in.nextInt(), in.next());
			deck1[i] = a;
        }
        System.arraycopy(deck1, 0, arrayToFill, 0, deck1.length);
    	}
    	catch(FileNotFoundException e)
    	{System.out.println(e.getMessage());}
    }
    
    //Fisher-Yates shuffle
    public static void shuffleDeck(Minion[] input)
    {
      Random rnd = new Random();
      for (int i = input.length - 1; i > 0; i--)
      {
        int index = rnd.nextInt(i + 1);
        Minion a = input[index];
        input[index] = input[i];
        input[i] = a;
      }
    }
    
    public static void moveCardsDownArray(Minion[] a)
    {
    	Minion[] n = new Minion[a.length];
    	int counter = 0;
    	for(int i = 0; i < a.length; i++){
    		if(!(a[i] == null)){
    			n[i-counter] = a[i];
    		}
    		else{
    			counter++;
    		}
    	}
    	System.arraycopy(n, 0, a, 0, n.length);
    }
    
    
    
    public static int countDeck(Minion[] a){
    	int count = 0;
    	for(int i = 0; i < a.length; i++)
    	{
    		if(!(a[i] == null)){count++;}
    	}
    	return count;
    }
}
