import java.util.*;

public class GuardCard extends Card
{
    public static final int GUARD_VALUE = 1;
    public static final String GUARD_NAME = "Guard";
    public static final String GUARD_TEXT = "Name a non-Guard card and choose another player. If that player has that card, he or she is out of the round.";

    public GuardCard()
    {
        super(GUARD_VALUE, GUARD_NAME, GUARD_TEXT);
    }

    public void action(Player currentPlayer, ArrayList<Player> players)
    {
        Player targetPlayer = LLMain.choosePlayer(players, "Choose target player: ");

        ArrayList<Card> cardList = new ArrayList<Card>();
        cardList.add(new BaronCard());
        cardList.add(new CountessCard());
        cardList.add(new GuardCard());
        cardList.add(new HandmaidCard());
        cardList.add(new KingCard());
        cardList.add(new PriestCard());
        cardList.add(new PrinceCard());
        cardList.add(new PrincessCard());

        Card cardGuess = LLMain.chooseCard(cardList, "Choose a card to guess: ");
    
        if(targetPlayer.hasCard(cardGuess)) {
            targetPlayer.setInRound(false);
            System.out.println(targetPlayer.getName() + " is out of the round!");
        }
        else {
            System.out.println(targetPlayer.getName() + " does not have that card.");
        }
    }
}
