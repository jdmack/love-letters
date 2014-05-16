import java.util.*;

public class HandmaidCard extends Card
{
    public static final int HANDMAID_VALUE = 4;
    public static final String HANDMAID_NAME = "Handmaid";
    public static final String HANDMAID_TEXT = "Name a non-Handmaid card and choose another player. If that player has that card, he or she is out of the round.";

    public HandmaidCard()
    {
        super(HANDMAID_VALUE, HANDMAID_NAME, HANDMAID_TEXT);
    }

    public void action(Player currentPlayer, ArrayList<Player> players)
    {
        currentPlayer.setImmune(true);
    }
}
