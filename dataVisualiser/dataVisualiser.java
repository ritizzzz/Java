import java.util.Scanner;
import java.util.ArrayList;



public class dataVisualiser {
    private static boolean checkValid(String input) {
        int countCommas = input.length() - input.replace(",", "").length();
        if(countCommas > 1){
            System.out.println("Error: Too many commas in input.");
            return false;
        }else if(countCommas == 0){
            System.out.println("Error: No comma in string.");
            return false;
        }else if(countCommas == 1){
              char numChar = input.charAt(input.indexOf(",") +  2);
              String numString = Character.toString(numChar);
              try{
                   Integer num = Integer.parseInt(numString);
                   return true;
              } catch (Exception e){
                    System.out.println("Error: Comma not followed by an integer.");
                    return false;
              }
        }
        return false;
    }
    
    public static void main(String[] args) {
      
        ArrayList<String> authorName = new ArrayList<String>();
      ArrayList<Integer> bookPublished = new ArrayList<Integer>();

      Scanner scnr = new Scanner(System.in);
      
      System.out.println("Enter a title for the data:");
      String title = scnr.nextLine();
      System.out.printf("You entered: %s\n", title);
      
      System.out.println("Enter column 1 header:");
      String col1Header = scnr.nextLine();
      System.out.printf("You entered: %s\n", col1Header);
      
      System.out.println("Enter column 2 header:");
      String col2Header = scnr.nextLine();
      System.out.printf("You entered: %s\n", col2Header);
      
      System.out.println("Enter a data point (-1 to stop input):");
      String input = scnr.nextLine();
      
      while(!input.equals("-1")){
        if(checkValid(input)){
          String preName =  input.substring(0, input.indexOf(","));
          authorName.add(preName);
          Integer preBooks = Integer.parseInt(input.substring((input.indexOf(",")+2), input.length()));
          bookPublished.add(preBooks);
          
          System.out.printf("Data string: %s\n", preName);
          System.out.printf("Data integer: %d\n", preBooks);
        }
        System.out.println();
        System.out.println("Enter a data point (-1 to stop input):");
        input = scnr.nextLine();  
      }
      System.out.printf("%33s\n", title);
      System.out.printf("%-20s", col1Header );
      System.out.print("|");
      System.out.printf("%23s\n", col2Header );
      System.out.printf("--------------------------------------------\n");
      for(int i = 0; i<authorName.size(); i++){
          System.out.printf("%-20s", authorName.get(i));
          System.out.print("|");
          System.out.printf("%23d\n", bookPublished.get(i) );
      }
      System.out.println();
      for(int i = 0; i<authorName.size(); i++){
          System.out.printf("%20s ", authorName.get(i));
          for(int j = 0; j < bookPublished.get(i); j++){
            System.out.print("*");
          }
          System.out.println();
      }
   }

}
