import java.util.Scanner;
import playerPack.player;

public class soccerTeamRoster{
    public static void main(String []args){
        displayPlayers(initialInput());
    }

    public static void displayPlayers(player[] allPlayers){
        System.out.println();  
        System.out.println("ROSTER");
        for(int i = 0; i < allPlayers.length; i++){
            System.out.printf("Player: %d -- Jersey number: %d, Rating %d\n", i+1,  allPlayers[i].jerseyNumber, allPlayers[i].rating);
        }
    }

    public static player[] initialInput(){
        Scanner scnr = new Scanner(System.in);  
        player[] allPlayers = new player[5];

        for(int i = 0; i<5; i++){
            player ovPlayer = new player();
            System.out.printf("Enter player %d's jersey number:\n", (i+1));
            int jerseyNumber = scnr.nextInt();
            System.out.printf("Enter player %d's rating:\n", (i+1));
            int rating = scnr.nextInt();
            
            ovPlayer.jerseyNumber = jerseyNumber;
            ovPlayer.rating = rating;

            allPlayers[i] = ovPlayer;
            System.out.println();
        }

        scnr.close();
        return allPlayers;
    }
}