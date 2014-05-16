import java.util.*;

public class PlayerList
{
    private ArrayList<Player> playerList;

    public PlayerList()
    {
        playerList = new ArrayList<Player>();
    }

    public PlayerList(PlayerList players)
    {
        playerList = new ArrayList<Player>(players.getPlayerList());
        // copy constructor
    }

    public ArrayList<Player> getPlayerList()
    {
        return playerList;
    }

    public static ArrayList<Player> getActivePlayers()
    {
        ArrayList<Player> activePlayers = new ArrayList<Player>();

        int size = size();
        for(int i = 0; i < size; i++) {
            if((playerList.get(i).getInRound()) && (!playerList.get(i).getImmune())) {
                activePlayers.add(playerList.get(i));
            }
        }

        return activePlayers;
    }

    public static Player getRoundWinner()
    {
        if(numOfActivePlayers(playerList) == 1) {
            for(int i = 0; i < playerList.size(); i++) {
                if(playerList.get(i).getInRound()) {
                    return playerList.get(i);
                }
            }
            return playerList.get(0);
        }
        else {
            // round winner is whoever has the highest card in hand
            // if tie, player with the highest total value of cards wins
            ArrayList<Player> sortedPlayers = new ArrayList<Player>(playerList);

            Collections.sort(playerList, new PlayerComparator());

            // TODO Add tie condition
            return sortedPlayers.get(0);
        }
    }

    public static int getNumOfActivePlayers()
    {
        int count = 0;
        for(int i = 0; i < playerList.size(); i++) {
            if(playerList.get(i).getInRound())
                count++;
        }

        return count;
    }

    public Player get(int i)
    {
        return playerList.get(i);
    }

    public int indexOf(Player player)
    {
        return playerList.indexOf(player);
    }

    public int size()
    {
        return playerList.size();
    }

    public void add(Player player)
    {
        return playerList.add(player);
    }


}
