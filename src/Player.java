import java.util.*;

public class Player
{
    private int number;
    private String name;
    private int tokens;
    private boolean inRound;

    private ArrayList<Card> hand;
    private ArrayList<Card> cardHistory;

    public Player()
    {
        this(0, "");
    }

    public Player(int number, String name)
    {
        this.number = number;
        this.name = name;

        tokens = 0;
        inRound = true;

        hand = new ArrayList<Card>();
        cardHistory = new ArrayList<Card>();
    }
    
    public void awardToken()
    {
        tokens++;
    }

    public void drawCard(Deck deck)
    {
        hand.add(deck.dealCard());
    }

    public boolean hasCard(Card card)
    {
        for(int i = 0; i < hand.size(); i++) {
            if(hand.get(i).getClass().equals(card.getClass())) {
                return true;
            }
        }

        return false;
    }


    public void playCard()
    {
        Player targetPlayer = new Player();
        Card card = hand.get(0);

        cardHistory.add(card);

        card.action(this, targetPlayer);
    }

    public void discardCard(Card card)
    {
    }

    public void discardHand()
    {
        while(!hand.isEmpty()) {
            hand.remove(0);
        }
    }
    
    public Card getTopCard()
    {
        return hand.get(0);
    }


    //-------------------------------------------------------------------------
    //  Getters/Setters
    //-------------------------------------------------------------------------
    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getTokens()
    {
        return tokens;
    }

    public void setTokens(int tokens)
    {
        this.tokens = tokens;
    }

    public boolean getInRound()
    {
        return inRound;
    }
    public void setInRound(boolean inRound)
    {
        this.inRound = inRound;
    }

}
