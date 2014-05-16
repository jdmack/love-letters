import java.util.*;

public class Deck
{
        
    public static final int DECK_SIZE = 16;
    public static final int GUARD_NUMBER = 5;
    public static final int PRIEST_NUMBER = 2;
    public static final int BARON_NUMBER = 2;
    public static final int HANDMAID_NUMBER = 2;
    public static final int PRINCE_NUMBER = 2;
    public static final int KING_NUMBER = 1;
    public static final int COUNTESS_NUMBER = 1;
    public static final int PRINCESS_NUMBER = 1;
    

    private ArrayList<Card> cards;
    private ArrayList<Card> discards;

    public Deck()
    {
        cards = new ArrayList<Card>();
        discards = new ArrayList<Card>();

        // create cards
        for(int i = 0; i < GUARD_NUMBER; i++) {
            cards.add(new GuardCard());
        }
        for(int i = 0; i < PRIEST_NUMBER; i++) {
            cards.add(new PriestCard());
        }
        for(int i = 0; i < BARON_NUMBER; i++) {
            cards.add(new BaronCard());
        }
        for(int i = 0; i < HANDMAID_NUMBER; i++) {
            cards.add(new HandmaidCard());
        }
        for(int i = 0; i < PRINCE_NUMBER; i++) {
            cards.add(new PrinceCard());
        }
        for(int i = 0; i < KING_NUMBER; i++) {
            cards.add(new KingCard());
        }
        for(int i = 0; i < COUNTESS_NUMBER; i++) {
            cards.add(new CountessCard());
        }
        for(int i = 0; i < PRINCESS_NUMBER; i++) {
            cards.add(new PrincessCard());
        }
    }

    public void reset()
    {
        addAll(cards, removeAll(discards));
    }

    public void shuffle()
    {
        ArrayList<Card> tempCards = new ArrayList<Card>(removeAll(cards));
        Random random = new Random();
        
        int size = tempCards.size();
        for(int i = 0; i < size; i++) {
            cards.add(tempCards.remove(random.nextInt(tempCards.size())));
        }
    }

    public Card dealCard()
    {
        Card card = cards.remove(0);
        discards.add(card);
        return card;
    }

    public ArrayList<Card> dealCards(int numOfCards)
    {
        ArrayList<Card> returnCards = new ArrayList<Card>();
        for(int i = 0; i < numOfCards; i++) {
            Card card = cards.remove(0);
            discards.add(card);
            returnCards.add(card);
        }

        return returnCards;
    }

    public void discardCards(int numOfCards)
    {
        for(int i = 0; i < numOfCards; i++) {
            Card card = cards.remove(0);
            discards.add(card);
        }
    }
    

    public boolean hasCards()
    {
        return !cards.isEmpty();
    }

    public String toString()
    {
        String str = "";
        for(int i = 0; i < cards.size(); i++) {
            if(i != 0) str += ", ";
                str += cards.get(i).toString();
        }

        return str;
    }
    //-------------------------------------------------------------------------
    //  Helper functions
    //-------------------------------------------------------------------------
    private static void addAll(ArrayList<Card> list, ArrayList<Card> elements) 
    {
        while(!elements.isEmpty()) {
            list.add(elements.remove(0));
        }
    }

    private static ArrayList<Card> removeAll(ArrayList<Card> list) 
    {
        ArrayList<Card> returnCards = new ArrayList<Card>();

        while(!list.isEmpty()) {
            returnCards.add(list.remove(0));
        }
        return returnCards;
    }
}

