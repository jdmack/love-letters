public class KingCard extends Card
{
    public static final int KING_VALUE = 6;
    public static final String KING_NAME = "King";
    public static final String KING_TEXT = "Trade hands with another player of your choice.";

    public KingCard()
    {
        super(KING_VALUE, KING_NAME, KING_TEXT);
    }

    public void action(Player currentPlayer, Player targetPlayer)
    {

    }
}
