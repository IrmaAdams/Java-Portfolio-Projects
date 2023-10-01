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
        character = ' ';                // ASCII index for space is 32
        list.clear();                   // clear old lists before generating a new key
        shuffledList.clear();           // clear old lists before generating a new key

        for(int i = 32; i<127; i++){                    // using characters between 32 and 127 on the ASCII table
            list.add(Character.valueOf(character));     // take the empty list, and then add the character value of our character
            character++;                                // increment our character by 1
        }

        // How to make a copy of an array list:
        shuffledList = new ArrayList<>(list);           // initiate shuffledList[] by creating a new copy of list[]
        Collections.shuffle(shuffledList);              // method to shuffle the new array list

        System.out.println("*A new key has been generated*\n");

    }
    private void getKey(){
        System.out.println("Key: ");                    // display the new key (list of shuffled characters)

        for(Character x : list){                        // for each character x in our list,
            System.out.print(x);                        // print out character at index x
        }

        for(Character y: shuffledList){                 // for each character y in our shuffledList,
            System.out.print(y);                        // print out character at index y
        }

        System.out.println();                           // add a space after with a prinln statement

    }
    private void encrypt(){
        System.out.println("Enter the message you would like to encrypt: ");
        String message = scanner.nextLine();

        // break up the message string into an array of characters:
        letters = message.toCharArray();

        // create a for loop to iterate through each character in the array of characters called 'letters'
        for(int i=0; i<letters.length;i++){                 // create a for loop to iterate through each character in our array of characters called letters
            for(int j=0;j<list.size();j++){                 // nested for loop to look through the list to see if there
                                                                // is a matching letter to our current letter that we're looking at, within our array
                if(letters[i]==list.get(j)){                // find the character in list[] and retrieve corresponding character at index in shuffledList[]
                    letters[i]=shuffledList.get(j);         // take that letter and replace it with the character at index i in shuffledList[]
                    break;                                  // then break out of the loop
                }
            }
        }
        System.out.println("Encrypted: ");                  // display the encrypted message
        for(char x : letters){                              // for each loop to iterate through each letter in this array of characters
                                                            // for each char at index x in letters,
            System.out.print(x);                            // print character at index x
        }
        System.out.println();                               // add a space after with a prinln statement
    }
    private void decrypt(){
        // Decryption process is a similar process to the Decrypt method

        System.out.println("Enter the message you would like to decrypt: ");
        String message = scanner.nextLine();

        // break up the message string into an array of characters:
        letters = message.toCharArray();

        // create a for loop to iterate through each character in the array of characters called 'letters'
        for(int i=0; i<letters.length;i++){                 // create a for loop to iterate through each character in our array of characters called letters
            for(int j=0;j<shuffledList.size();j++){         // nested for loop to look through the shuffledList to see if there
                                                                // is a matching letter to our current letter that we're looking at, within our array
                if(letters[i]==shuffledList.get(j)){        // find the character in shuffledList[] and retrieve corresponding character at index in list[]
                    letters[i]=list.get(j);                 // take that letter and replace it with the character at index i in list[]
                    break;                                  // then break out of the loop
                }
            }
        }
        System.out.println("Decrypted: ");                  // display the decrypted message
        for(char x : letters){                              // for each loop to iterate through each letter in this array of characters
                                                                // for each char at index x in letters,
            System.out.print(x);                            // print character at index x
        }
        System.out.println();                               // add a space after with a prinln statement
    }
    private void quit(){
        // Close the program
        System.out.println("Thank you.  Have a nice day");
        System.exit(0);                              // exit out of program
    }
}
