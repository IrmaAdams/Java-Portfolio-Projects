import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class EncryptionProgram {

    // Declare Global variables:
    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;

    // Methods:
    EncryptionProgram(){
        // Initialize global variables within the constructor:
        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList<>();
        shuffledList = new ArrayList<>();
        character = ' ';

        // Generate a new key for the user:
        newKey();
        askQuestion();
    }

    private void askQuestion() throws IllegalStateException {
        // create a while loop to consistently prompt the user to enter a valid response
        while(true){
            System.out.println("**************************************************************************");
            System.out.println("What would you like to do?");
            System.out.println("(N) - new Key\n(G) - get Key\n(E) - encrypt\n(D) - decrypt\n(Q) - quit");

            // Store response - check if uppercase, if not, change to uppercase.  Check entire line at index 0:
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            // Check response
            switch(response){
                case 'N': newKey();
                break;
                case 'G':getKey();
                break;
                case 'E': encrypt();
                break;
                case 'D': decrypt();
                break;
                case 'Q':quit();
                break;
                default:
                    System.out.println("Not a valid entry");
            }
        }
    }
    private void newKey(){
        character = ' ';
        // clear old lists before generating a new key:
        list.clear();
        shuffledList.clear();

        for(int i = 32; i<127; i++){ // using characters between 32 and 127 on the ASCII table
            list.add(Character.valueOf(character));
            character++;
        }

        // create a new array list:
        shuffledList = new ArrayList<>(list);
        // to shuffle the new array list:
        Collections.shuffle(shuffledList);
        System.out.println("*A new key has been generated*\n");

    }
    private void getKey(){
        System.out.println("Key: ");
        for(Character x : list){
            System.out.print(x);
        }
        for(Character y: shuffledList){
            System.out.print(y);
        }
        System.out.println();

    }
    private void encrypt(){
        System.out.println("Enter the message you would like to encrypt: ");
        String message = scanner.nextLine();

        // break up the message string into an array of characters:
        letters = message.toCharArray();

        // create a for loop to iterate through each character in the array of characters called 'letters'
        for(int i=0; i<letters.length;i++){             
            for(int j=0;j<list.size();j++){
                if(letters[i]==list.get(j)){
                    letters[i]=shuffledList.get(j);
                    break;
                }
            }
        }
    }
    private void decrypt(){

    }
    private void quit(){

    }
}
