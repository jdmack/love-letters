import java.util.*;

public class PlayerComparator implements Comparator<Player>
{
    public int compare(Player playerA, Player playerB)
    {
        Card aCard = playerA.getTopCard();
        Card bCard = playerB.getTopCard();

        if(aCard.getValue() > bCard.getValue()) return 1;
        else if(aCard.getValue() < bCard.getValue()) return -1;
        else return 0;

    }

}
