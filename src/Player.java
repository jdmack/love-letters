import java.util.*;

public class Player
{
    private int number;
    private String name;
    private int tokens;
    private boolean inRound;
    private boolean immune;

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


    public void playCard(ArrayList<Player> players)
    {
        Player targetPlayer = new Player();
        Card card;
        if((hasCard(new HandmaidCard())) && (hasCard(new KingCard()) || hasCard(new PrinceCard()))) {

            card = getCard(new HandmaidCard()); 
        }
        else {
            card = LLMain.chooseCard(hand, "Which card to play?");
        }

        cardHistory.add(card);

        System.out.println("Playing " + card.toString());
        card.action(this, players);
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

    public Card getCard(Card card)
    {
        for(int i = 0; i < hand.size(); i++) {
            if(hand.get(i).getClass().equals(card.getClass())) {
                return hand.get(i);
            }
        }

        return card;
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

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public void setHand(ArrayList<Card> hand)
    {
        this.hand = hand;
    }

    public boolean getImmune()
    {
        return immune;
    }

    public void setImmune(boolean immune)
    {
        this.immune = immune;
    }

}
