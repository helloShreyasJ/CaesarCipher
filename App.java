import java.util.Scanner;
class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        
        
        //Variables
        String userChoice;
        String userInput;
        int shiftValue;

        //setting up a while loop
        while(true){
            
            //User Interface
            System.out.println("Enter (e) for Encryption, (d) for Decryption. Return to exit");
            userChoice = sc.nextLine().toLowerCase();

            while(userChoice.isEmpty()){
                return;
            }
            
            //error handling: making sure that the user cannot invalid input
            if (!userChoice.equals("e") && !userChoice.equals("d")) {
                System.out.println("Invalid choice. Please enter 'e' or 'd'.");
                continue;
            }

            System.out.println("Enter message: ");
            userInput = sc.nextLine().toLowerCase();
            
            System.out.println("Enter the shift value: ");
            shiftValue = Integer.valueOf(sc.nextLine());
            
            
            if(userChoice.equalsIgnoreCase("e")){
                System.out.println(encrypt(userInput,shiftValue));
            } else if(userChoice.equalsIgnoreCase("d")){
                System.out.println(decrypt(userInput,shiftValue));    
            }     
        }
    }

    public static String encrypt(String userInput, int shiftValue){
        StringBuilder encryptedString = new StringBuilder();
        
        // Variable turning string Input to character so that we can
        //  preform mathematical operations on it.
        char inputToChar;

        for(int i = 0; i<userInput.length();i++){
            inputToChar = userInput.charAt(i);

            if(Character.isLetter(inputToChar)){
                inputToChar = (char)((inputToChar - 'a' + shiftValue)%26 + 'a');
            }
            encryptedString.append(inputToChar);
        }
        return "Encrypted String: " + encryptedString.toString();
    }
    
    public static String decrypt(String userInput, int shiftValue){
        StringBuilder decryptedString = new StringBuilder();
        char inputToChar;
        for(int i =0; i < userInput.length();i++){
            inputToChar = userInput.charAt(i);
            
            if(Character.isLetter(inputToChar)){
                inputToChar = (char)((inputToChar - 'a' - shiftValue + 26)%26+'a');
            }
            decryptedString.append(inputToChar);
        } return "Decrypted String: " + decryptedString.toString();
    }
}
