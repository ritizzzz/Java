package playerPack;
public class player{
    public int jerseyNumber;
    public int rating;

    public static player[] changeRating(player[] playerArray,  int jerseyNumber, int rating){
        for(int i = 0; i < playerArray.length; i++){
            if(playerArray[i].jerseyNumber == jerseyNumber){
                playerArray[i].rating = rating;
            }
        }
        return playerArray;
    }

}