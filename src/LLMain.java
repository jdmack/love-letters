import java.util.*;


public class LLMain
{
    public static ArrayList<Player> players;

    public static void main(String args[])
    {
        int roundNumber = 0;
        Deck deck = new Deck();
        int winnerPlayer = 0;
        int numOfPlayers = initializePlayers();

        // Round loop
        while(true) {
            roundNumber++;

            // If 2 players, discard 3 cards face up
            if(numOfPlayers == 2) {
                deck.discardCards(3);
            }

            // Each player draws 1 card for initial hand
            for(int i = 0; i < numOfPlayers; i++) {
                players.get(i).drawCard(deck);
            }

            // Determine first player
            int currentPlayerIndex;
            if(roundNumber == 1) {
                Random random = new Random();
                currentPlayerIndex = random.nextInt(numOfPlayers) + 1;
            }
            else {
                currentPlayerIndex = winnerPlayer;
            }

            // Turn loop
            while(true) {
                Player currentPlayer = players.get(i);

                // Check if player is still in round 
                if(!currentPlayer.getInRound()) continue;

                // Draw card, add to hand
                currentPlayer.drawCard(deck);

                // Choose one card, play it by discarding face up
                currentPlayer.playCard();

                // Cards are discarded face up in front of the player who played it

                // Next turn player to the left

                // If a player is out of round, discard hand faceup in front of player (don't carrying out card effect)


                // round ends if deck is empty at end of a turn
                if(!deck.hasCards()) break;
                // round also ends if all but one player is out
                i = ++i % numOfPlayers;
            }
            
            // round winner is whoever has the highest card in hand
                // if tie, player with the highest total value of cards wins
            
            // winner receives a token of affection

        }

        // A player wins when they get a number of tokens
            // 2 players: 7 tokens
            // 3 players: 5 tokens
            // 4 players: 4 tokens

    }

    public static int initializePlayers()
    {
        Scanner keyboard = new Scanner(System.in);
        players = new ArrayList<Player>();
        System.out.println("How many players? ");
        int numOfPlayers = keyboard.nextInt();

        for(int i = 1; i <= numOfPlayers; i++) {
            System.out.println("Player " + i);
            System.out.println("\tName: ");
            String playerName = keyboard.nextLine();

            players.add(new Player(i, playerName));
        }
            
        return numOfPlayers;
    }
}
