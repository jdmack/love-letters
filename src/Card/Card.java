
public class Card
{
    private int value;
    private String name;
    private String text;
 
    public Card(int value, String name, String text)  
    {
        this.value = value;
        this.name = name;
        this.text = text;
    }
  
    public void action(Player currentPlayer, Player targetPlayer)
    {

    }
    

    //--------------------------------------------------------------------------
    //  Getters / Setters
    //--------------------------------------------------------------------------

    public int getValue()
    {
        return value;  
    }
  
    public void setValue(int value)
    {
        this.value = value; 
    }
 
    public int getName()
    {
        return name;  
    }
  
    public void setName(String value)
    {
        this.value = value; 
    }
 
    public String getText()
    {
        return value;  
    }
  
    public void setText(String value)
    {
        this.value = value; 
    }
}
