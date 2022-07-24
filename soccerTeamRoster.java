import java.util.Scanner;
import playerPack.player;

public class soccerTeamRoster{

    static Scanner scnr = new Scanner(System.in); 
    static player[] allPlayer; 
    public static void main(String []args){
        displayPlayers(initialInput());

        char option = menuOptions();
        while(option != 'q'){

            if(option == 'o'){
                displayPlayers(allPlayer);
            }
            if(option == 'u'){
                update();
                displayPlayers(allPlayer);
            }

            option = menuOptions();

        }
    }

    public static void displayPlayers(player[] allPlayers){
        System.out.println();  
        System.out.println("ROSTER");
        for(int i = 0; i < allPlayers.length; i++){
            System.out.printf("Player: %d -- Jersey number: %d, Rating %d\n", i+1,  allPlayers[i].jerseyNumber, allPlayers[i].rating);
        }
    }

    public static player[] initialInput(){  
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
        allPlayer = allPlayers;
        return allPlayers;
    }

    public static char menuOptions(){

        System.out.println();
        System.out.println("MENU");
        System.out.println("u - Update player rating");
        System.out.println("a - Output players above a rating");
        System.out.println("r - Replace player");
        System.out.println("o - Output roster");
        System.out.println("q - Quit");
        char choosenOption = scnr.next().charAt(0);
        return choosenOption;
    }

    public static void update(){
        System.out.println("Enter a jersey number:");
        int jerseyNumber = scnr.nextInt();
        System.out.println("Enter a new rating for player:");
        int rating = scnr.nextInt();
        allPlayer = player.changeRating(allPlayer, jerseyNumber, rating);
    }

}