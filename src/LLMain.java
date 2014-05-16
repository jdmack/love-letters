import java.util.*;

public class LLMain
{
    public static Deck deck;
    public static ArrayList<Player> players;

    public static void main(String args[])
    {
        int roundNumber = 0;
        deck = new Deck();
        int winnerPlayer = 0;
        int numOfPlayers = initializePlayers();
        int winCondition = winCondition(numOfPlayers);
        Player lastWinner;

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
                Player currentPlayer = players.get(currentPlayerIndex);

                // Check if player is still in round 
                if(!currentPlayer.getInRound()) continue;

                // Draw card, add to hand
                currentPlayer.drawCard(deck);

                // Choose one card, play it by discarding face up
                currentPlayer.playCard(players);

                // round ends if deck is empty at end of a turn
                if(!deck.hasCards()) break;

                // round also ends if all but one player is out
                if(numOfActivePlayers(players) == 1) break;


                currentPlayerIndex = ++currentPlayerIndex % numOfPlayers;
            }
            
            // round winner is whoever has the highest card in hand
                // if tie, player with the highest total value of cards wins
            lastWinner = determineRoundWinner(players); 
            
            if(lastWinner.getTokens() == winCondition) {
                break;
            }

            // winner receives a token of affection

        }


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

    public static void printCards(ArrayList<Card> cards, String message)
    {
        System.out.println(message);
        
        for(int i = 0; i <= cards.size(); i++) {
            System.out.println("\t" + (i + 1) + ") " + cards.get(i).toString()); 
        }
    }

    public static Card chooseCard(ArrayList<Card> cards, String message)
    {
        System.out.println(message);
        
        for(int i = 0; i <= cards.size(); i++) {
            System.out.println("\t" + (i + 1) + ") " + cards.get(i).toString()); 
        }
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Choose Card: ");
        int choice = keyboard.nextInt();
        
        return cards.get(choice - 1);

    }

    public static Player choosePlayer(ArrayList<Player> players, String message)
    {
        System.out.println(message);
        
        for(int i = 0; i <= players.size(); i++) {
            System.out.println("\t" + (i + 1) + ") " + players.get(i).toString()); 
        }
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Choose Player: ");
        int choice = keyboard.nextInt();
        
        return players.get(choice - 1);

    }

    public static int winCondition(int numOfPlayers)
    {
        // A player wins when they get a number of tokens

        // 2 players: 7 tokens
        if(numOfPlayers == 2) return 7;

        // 3 players: 5 tokens
        if(numOfPlayers == 3) return 5;

        // 4 players: 4 tokens
        if(numOfPlayers == 4) return 4;

        else return 0;
    }

    public static int numOfActivePlayers(ArrayList<Player> players)
    {
        int count = 0;
        for(int i = 0; i < players.size(); i++) {
            if(players.get(i).getInRound())
                count++;
        }

        return count;
    }

    public static Player determineRoundWinner(ArrayList<Player> players)
    {
        ArrayList<Player> sortedPlayers = new ArrayList<Player>(players);
        
        Collections.sort(players, new PlayerComparator());

        // TODO Add tie condition
        return sortedPlayers.get(0);
    }

    public static ArrayList<Player> getActivePlayers(ArrayList<Player> players)
    {
        ArrayList<Player> activePlayers = new ArrayList<Player>();

        for(int i = 0; i < players.size(); i++) {
            if((players.get(i).getInRound()) && (!players.get(i).getImmune())) {
                activePlayers.add(players.get(i));        
            }
        }

        return activePlayers;
    }

}
