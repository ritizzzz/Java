import java.util.Scanner;

public class soccerTeamRoster{

    static Scanner scnr = new Scanner(System.in); 
    static int[][] allPlayer;
    public static void main(String []args){
        displayPlayers(initialInput(), "ROSTER");

        char option = menuOptions();
        while(option != 'q'){

            if(option == 'o'){
                displayPlayers(allPlayer, "ROSTER");
            }
            if(option == 'u'){
                update();
                displayPlayers(allPlayer, "ROSTER");
            }
            if(option == 'r'){
                replace();
                displayPlayers(allPlayer, "ROSTER");
            }
            if(option == 'a'){
                aboveCertainRating();
            }
            option = menuOptions();

        }
    }

    public static void displayPlayers(int[][] js, String displayText){
        System.out.println();  
        System.out.println(displayText);
        for(int i = 0; i < js.length; i++){
            System.out.printf("Player: %d -- Jersey number: %d, Rating %d\n", i+1,  js[i][0], js[i][1]);
        }
    }

    public static int[][] initialInput(){  
        
        int[][] allPlayerInit = new int[5][];


        for(int i = 0; i<5; i++){
            
            System.out.printf("Enter player %d's jersey number:\n", (i+1));
            int jerseyNumber = scnr.nextInt();
            System.out.printf("Enter player %d's rating:\n", (i+1));
            int rating = scnr.nextInt();

            allPlayerInit[i] = new int[] {jerseyNumber, rating};
        }
        allPlayer = allPlayerInit;
        return allPlayerInit;
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
        for(int i = 0; i<allPlayer.length; i++){
            if(allPlayer[i][0] == jerseyNumber){
                allPlayer[i][1] = rating;
            }
        }
    }

    public static void replace(){
        System.out.println("Enter a jersey number:");
        int jerseyNumber = scnr.nextInt();
        System.out.println("Enter a new jersey number:");
        int newJerseyNumber = scnr.nextInt();
        System.out.println("Enter a new rating:");
        int rating = scnr.nextInt();
        for(int i = 0; i<allPlayer.length; i++){
            if(allPlayer[i][0] == jerseyNumber){
                allPlayer[i][0] = newJerseyNumber;
                allPlayer[i][1] = rating;
            }
        }
    }

   public static void aboveCertainRating(){
        System.out.println("Enter a rating");
        int rating = scnr.nextInt();
        int index = 0;
        for(int i = 0; i<allPlayer.length; i++){
            if(allPlayer[i][1] > rating){
                index++;
            }
        }
        int[][] allPlayerAbove = new int[index][];

        int otherIndex = 0;
        for(int i = 0; i<allPlayer.length; i++){
            if(allPlayer[i][1] > rating){
                allPlayerAbove[otherIndex] = allPlayer[i];
                otherIndex++;
            }
        }
        displayPlayers(allPlayerAbove, "Above" + " " + rating);
   } 
}