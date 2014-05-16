import java.util.*;

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
  
    public void action(Player currentPlayer, PlayerList players)
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
 
    public String getName()
    {
        return name;  
    }
  
    public void setName(String name)
    {
        this.name = name; 
    }
 
    public String getText()
    {
        return name;  
    }
  
    public void setText(String text)
    {
        this.text = text; 
    }

    public String toString()
    {
        return name;
    }
}
