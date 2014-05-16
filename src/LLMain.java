import java.util.*;

public class LLMain
{
    public static Deck deck;
    public static PlayerList players;

    public static void main(String args[])
    {
        int roundNumber = 0;
        deck = new Deck();
        int numOfPlayers = initializePlayers();
        int winCondition = calculateWinCondition(numOfPlayers);
        Player lastWinner = players.get(0);

        // Round loop
        while(true) {
            roundNumber++;
            deck.shuffle();

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
                currentPlayerIndex = random.nextInt(numOfPlayers);
            }
            else {
                currentPlayerIndex = players.indexOf(lastWinner);
            }
            System.out.println(players.get(currentPlayerIndex).getName() + " goes first."); 

            // Turn loop
            while(true) {
                Player currentPlayer = players.get(currentPlayerIndex);

                System.out.println("\n" + currentPlayer.getName() + "'s turn:");
                System.out.println("-----------------------------------------------");

                // Reset immune status
                if(currentPlayer.getImmune()) {
                    currentPlayer.setImmune(false);
                }

                // Check if player is still in round 
                if(!currentPlayer.getInRound()) continue;

                // Draw card, add to hand
                currentPlayer.drawCard(deck);

                // Choose one card, play it by discarding face up
                currentPlayer.playCard(players);

                // round ends if deck is empty at end of a turn
                if(!deck.hasCards()) break;

                // round also ends if all but one player is out
                if(players.getNumOfActivePlayers() == 1) break;

                currentPlayerIndex = ++currentPlayerIndex % numOfPlayers;
            }
            
            lastWinner = players.getRoundWinner(); 

            // winner receives a token of affection
            lastWinner.awardToken();

            System.out.println(lastWinner.getName() + " wins the round!\n");
            System.out.println("===============================================");
            System.out.println("===============================================\n");

            
            if(lastWinner.getTokens() == winCondition) {
                break;
            }
            
            for(int i = 0; i < players.size(); i++) {
                players.get(i).resetRound();
            } 

            deck.reset();
        }

        System.out.println(lastWinner.getName() + " won the game!!!");


    }

    public static int initializePlayers()
    {
        Scanner keyboard = new Scanner(System.in);
        players = new PlayerList();
        System.out.println("How many players? ");
        int numOfPlayers = Integer.parseInt(keyboard.nextLine());

        for(int i = 1; i <= numOfPlayers; i++) {
            System.out.print("Player " + i + " Name: ");
            String playerName = keyboard.nextLine();

            players.add(new Player(i, playerName));
        }
            
        return numOfPlayers;
    }

    public static int calculateWinCondition(int numOfPlayers)
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
    
    //-------------------------------------------------------------------------
    // Input/Output functions
    //-------------------------------------------------------------------------

    public static void printCards(ArrayList<Card> cards, String message)
    {
        System.out.println(message);
        
        for(int i = 0; i < cards.size(); i++) {
            System.out.println("\t" + (i + 1) + ") " + cards.get(i).toString()); 
        }
    }

    public static Card chooseCard(ArrayList<Card> cards, String message)
    {
        System.out.println(message);
        
        for(int i = 0; i < cards.size(); i++) {
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
        
        for(int i = 0; i < players.size(); i++) {
            System.out.println("\t" + (i + 1) + ") " + players.get(i).getName()); 
        }
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Choose Player: ");
        int choice = keyboard.nextInt();
        
        return players.get(choice - 1);
    }

}
