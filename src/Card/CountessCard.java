public class GuardCard
{
    public static final int GUARD_VALUE = 1;
    public static final int GUARD_NAME = "Guard";
    public static final int GUARD_TEXT = "Name a non-Guard card and choose another player. If that player has that card, he or she is out of the round.";

    public GuardCard()
    {
        super(GUARD_VALUE, GUARD_NAME, GUARD_TEXT);
    }

    public void action(Player currentPlayer, Player targetPlayer)
    {

    }
}
