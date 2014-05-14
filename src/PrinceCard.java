public class PrinceCard extends Card
{
    public static final int PRINCE_VALUE = 5;
    public static final String PRINCE_NAME = "Prince";
    public static final String PRINCE_TEXT = "Choose any player (including yourself) to discard his or her hand and draw a new card.";

    public PrinceCard()
    {
        super(PRINCE_VALUE, PRINCE_NAME, PRINCE_TEXT);
    }

    public void action(Player currentPlayer, Player targetPlayer)
    {

    }
}
