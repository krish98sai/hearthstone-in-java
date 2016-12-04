public class Minion
{
    private String name;
    private int cost;
    private String type;
    private int damage;
    private int health;
    private String special;
    boolean canAttack = true;
    boolean isDead = false;
    
    public Minion(String datName, int datCost, String datType, int datDamage, int datHealth, String datSpecial)
    {
        name = datName;
        cost = datCost;
        type = datType;
        damage = datDamage;
        health = datHealth;
        special = datSpecial;
        if(type.equals("Charge"))
        {canAttack = true;}
        else
        {canAttack = false;}
    }
    
    public String getName()
    {return name;}
    public int getCost()
    {return cost;}
    public String getType()
    {return type;}
    public int getDamage()
    {return damage;}
    public int getHealth()
    {return health;}
    public String getSpecial()
    {return special;}
    public boolean getCanAttack()
    {return canAttack;}
    
    public void changeDamage(int newDamage)
    {damage = newDamage;}
    public void changeHealth(int newHealth)
    {health = newHealth;}
    public void doneAttack()
    {canAttack = false;}
    public void openAttack()
    {
    	canAttack = true;
    }
    public void checkDead(){
    	if (health <= 0){isDead = true;}
    }
}

