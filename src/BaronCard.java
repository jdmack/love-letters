public class BaronCard extends Card
{
    public static final int BARON_VALUE = 3;
    public static final String BARON_NAME = "Baron";
    public static final String BARON_TEXT = "You and another player secretly compare hands. The player with the lower value is out of the round.";

    public BaronCard()
    {
        super(BARON_VALUE, BARON_NAME, BARON_TEXT);
    }

    public void action(Player currentPlayer, Player targetPlayer)
    {

    }
}
