import java.util.*;

public class BaronCard extends Card
{
    public static final int BARON_VALUE = 3;
    public static final String BARON_NAME = "Baron";
    public static final String BARON_TEXT = "You and another player secretly compare hands. The player with the lower value is out of the round.";

    public BaronCard()
    {
        super(BARON_VALUE, BARON_NAME, BARON_TEXT);
    }

    public void action(Player currentPlayer, ArrayList<Player> players)
    {
        Player targetPlayer = LLMain.choosePlayer(LLMain.getActivePlayers(players), "Choose target player: ");

        LLMain.printCards(currentPlayer.getHand(), currentPlayer.getName() + "'s hand: ");
        LLMain.printCards(targetPlayer.getHand(), targetPlayer.getName() + "'s hand: ");

        if(currentPlayer.getTopCard().getValue() > targetPlayer.getTopCard().getValue()) {
            targetPlayer.setInRound(false);
            System.out.println(targetPlayer.getName() + " is out of the round!");
        }
        else if(currentPlayer.getTopCard().getValue() < targetPlayer.getTopCard().getValue()) {
            currentPlayer.setInRound(false);
            System.out.println("You are out of the round!");
        }


    }
}
