import java.io.FileNotFoundException;
import java.lang.Cloneable;

public class Player extends Deck implements Cloneable
{
	String name = "";
    int mana = 0;
    int maxMana = 0;
    int health = 30;
    Minion[] deck = new Minion [20];
    Minion[] hand = new Minion[5];
    Minion[] playedCards = new Minion[7];
    boolean turn;
    
    
    public void playCard(String name)
    {
    	int place = findMinionInArray(name, hand);
    	if(playedCards[6] == null && mana >= hand[place].getCost()){
    		mana = mana - hand[place].getCost();
    		playedCards[6] = hand[place];
    		hand[place] = null;
    	}
    	else{System.out.println("Your board is full or you do not have enough mana!");}
    	moveCardsDownArray(playedCards);
    	moveCardsDownArray(hand);
    	
    }
    
    public int findMinionInArray(String name, Minion[] arr){
    	boolean checking = true;
    	int place = 0;
    	while(checking){
    		if(arr[place].getName().equals(name)){
    			checking = false;
    			}
    		else{place++;}
    	}
    	return place;
    }
    
    protected Object clone() throws CloneNotSupportedException
    {
    	return super.clone();
    }
    
    public void fillHand(){
    	for (int i = 0; i < hand.length; i++){
    		int amountInHand = countDeck(hand);
    		int amountInDeck = countDeck(deck);
    		if(amountInDeck > 0 && amountInHand < 5){
    			if(hand[i] == null){
    				hand[i] = deck[i];
    				deck[i] = null;
    			}
    		}
    	}
    	moveCardsDownArray(deck);
    }
    
    public Player(String datName, String deckName) throws FileNotFoundException
    {
    	name = datName;
        fillDeck(deckName, deck);
        shuffleDeck(deck);
    }
    
    public void increaseMaxMana()
    {
    	if(maxMana < 10){
			maxMana++;
		}
    }
    
    public void setMinionsToCanAttack()
    {
    	for(int i = 0; i < 7; i++)
    	{
    		if(!(playedCards[i] == null))
    		{playedCards[i].openAttack();}
    	}
    }
    
    public void attack(String attacker, String target, Player isTurn, Player notTurn){
    	int placeInAttacker = findMinionInArray(attacker, isTurn.getPlayedCards());
    	int placeInTarget = findMinionInArray(target, notTurn.getPlayedCards());
    	if(playedCards[placeInAttacker].getCanAttack())
        {
    		if(target.equals("Hero")){
    			notTurn.changeHealth(notTurn.getHealth()-playedCards[placeInAttacker].getDamage());
    		}
    		else{
            notTurn.getPlayedCards()[placeInTarget].changeHealth(notTurn.getPlayedCards()[placeInTarget].getHealth() - playedCards[placeInAttacker].getDamage());
            isTurn.getPlayedCards()[placeInAttacker].changeHealth(getPlayedCards()[placeInAttacker].getHealth() - notTurn.getPlayedCards()[placeInTarget].getDamage());
            playedCards[placeInAttacker].doneAttack();
            playedCards[placeInAttacker].checkDead();
            notTurn.getPlayedCards()[placeInTarget].checkDead();
            isTurn.removeDeadMinions();
            notTurn.removeDeadMinions();
    		}
        }
    	else{System.out.println("Give that Minion a turn to get ready!");}
    }
    
    public void removeDeadMinions()
    {
    	for(int i = 0; i < 7; i++){
    		if(playedCards[i] == null || !(playedCards[i].getHealth() <= 0)){}
    		else{
    			playedCards[i] = null;
    		}
    	}
    }
    
    public void changeMana(int newValue){
    	mana = newValue;
    }

    public String getName(){
    	return name;
    }
    public int getHealth(){
    	return health;
    }
    public void changeHealth(int newValue){
    	health = newValue;
    }
    public Minion[] getDeck(){
    	return deck;
    }
    public Minion[] getPlayedCards(){
    	return playedCards;
    }
    public Minion[] getHand(){
    	return hand;
    }
    public int getMana(){
    	return mana;
    }
    public int getMaxMana(){
    	return maxMana;
    }
    
}