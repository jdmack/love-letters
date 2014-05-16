import java.util.*;

public class CountessCard extends Card
{
    public static final int COUNTESS_VALUE = 7;
    public static final String COUNTESS_NAME = "Countess";
    public static final String COUNTESS_TEXT = "If you have this card and the King or Prince in your hand, you must discard this card.";

    public CountessCard()
    {
        super(COUNTESS_VALUE, COUNTESS_NAME, COUNTESS_TEXT);
    }

    public void action(Player currentPlayer, ArrayList<Player> players)
    {
        // Nothing to do
    }
}
