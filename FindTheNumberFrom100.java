import java.util.*; //importing all classes needed for this program to work

public class FindTheNumberFrom100
{
  public static void main(String [] args)
  {
    Random rnd = new Random(); //Initializing the Random Class
    Scanner input = new Scanner(System.in); //Initializing the Scanner class
    
    int [][] array = new int [10][10]; //Initializing the array used for the most part of the program, setting it as a 10 by 10 box
    int  [] history = new int [100]; //Initializing a "history" array to prevent the random numbers from repeating. This 1D array acts as a double check to prevent repeated numbers
    int num = 0; //Initializing the random number at 0. It can be filled in later
    int x = 1; //Used in the second half of the program to ask if the user can input 1 2 3 ... 100
    int index = 0; //Used as an index place for the history array
    
    for (int row = 0; row < 10; row++) { //This loop is used to generate the random numbers, double check numbers with the history array, and re-randomize if necessary
      for (int col = 0; col < 10; col++) {
        num = rnd.nextInt(100) + 1;
        
        boolean flag = true; //Boolean used for non-repeating number verification
 
        while (flag) { // While the boolean is true
          flag = false; //Change boolean to false
          for (int y = 0; y < 100; y++) {
            if (num == history[y]) { //Used to re-randomize the number if it exists in the history array 
              flag = true; //Resets value to true to continue loop so that history array goes from index 0 - 99
              num = rnd.nextInt(100) + 1; 
            }
          }
        }
        history[index] = num; //When the number is not existing in the history array, store it in history array as well as the number in the original array
        index++; //Index increases to account for each space in the array
        
        array[row][col] = num;
            
       System.out.print(array[row][col]+"\t"); //Prints out the array
      }
      System.out.println(""); //Prints out a tab once the row is done; to go onto the next row
    }
    
    
    for (int row = 0; row < 10; row++) {
      for (int col = 0; col < 10; col++) {
        
        System.out.println("Enter the coordinate location of "+x+":"); //Asks for the coordinate location of 1 going to 100. Coordinates go as (ROW, COLUMN)
        System.out.println("Row:");
        int r = input.nextInt(); //Stores row number in "r"
        System.out.println("Column");
        int c = input.nextInt(); //Stores column number in "c"
        
        
        while (num <= 100) { //This loops allows for the user to input the locations of 1 - 100
          
          if (array[r][c] == x) {
            array[r][c] = 0; //If the array at the position of the array given by the user is = to 1, the value of the array at this position is replaced with the value of 0
            x++; //Increments the value of x from 1 to 2, then from 2 to 3, and so on
            
            for (int row2 = 0; row2 < 10; row2++) {
              for (int col2 = 0; col2 < 10; col2++) {
                System.out.print(array[row2][col2]+"\t"); //This reprints the array, put with the number 1 -100 with the value 0
              }
              System.out.println(""); //Once the row finished, print a space that goes to the next line  
            }
            System.out.println("Good, now find the location of "+x); //Now ask for the position of the new value of x, so after 1 would  be 2, after 2 would be 3,and so on.
            System.out.println("Row");
            r = input.nextInt(); //Stores new row value in "r"
            System.out.println("Column"); 
            c = input.nextInt(); //Stores new column value in "c"
            
            
          } else { //If it doesnt match the value of "x"
 
            System.out.println("Sorry, Your location is incorrect, please enter the location of "+x+":"); //Repeats the question
            System.out.println("Row");
            r = input.nextInt(); //Asks for which row the user thinks the value of "x" is located
            System.out.println("Column");
            c = input.nextInt(); //Asks for which column the user thinks the value of "x" is located
          }
          System.out.println(""); //Prints a new line
          num++; //Increases the "num" variable so that it continues looping until it is greater than 100
        }
      }
    }
  }
}