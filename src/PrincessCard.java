import java.util.*;

public class PrincessCard extends Card
{
    public static final int PRINCESS_VALUE = 8;
    public static final String PRINCESS_NAME = "Princess";
    public static final String PRINCESS_TEXT = "If you discard this card, you are out of the round.";

    public PrincessCard()
    {
        super(PRINCESS_VALUE, PRINCESS_NAME, PRINCESS_TEXT);
    }

    public void action(Player currentPlayer, PlayerList players)
    {
        currentPlayer.setInRound(false);
        System.out.println("You are out of the round!");
    }
}
