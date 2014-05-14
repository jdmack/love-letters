public class PriestCard extends Card
{
    public static final int PREIST_VALUE = 2;
    public static final String PREIST_NAME = "Priest";
    public static final String PREIST_TEXT = "Look at another player's hand.";

    public PriestCard()
    {
        super(PREIST_VALUE, PREIST_NAME, PREIST_TEXT);
    }

    public void action(Player currentPlayer, Player targetPlayer)
    {

    }
}
