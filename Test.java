public class Test
{
    public static void main(String args[])
    {
        Deck deck = new Deck();
        
        System.out.println(deck.toString());
        deck.shuffle();
        System.out.println(deck.toString());

        while(deck.hasCards()) {
            System.out.println("\t" + deck.dealCard().toString());
        }
        System.out.println(deck.toString());
        
        deck.reset();
        System.out.println(deck.toString());

    }

    
}
