/**
 * The Main program for running the ATM.
 * Calls upon the ATM's functions to perform actions requested by the user.
 */
public class User {

    public static void main(String args[]) throws Exception{
        System.out.println("Welcome to Tristan's ATM. What is your name?");
        String name = ATM.scanner.nextLine();

        if(name.isEmpty()){
            throw new Exception("Enter a valid name.");
        }

        System.out.println("Welcome, " + name + ". What would you like to do today?");
        System.out.println("Press 1 to check balance.");
        System.out.println("Press 2 to withdraw funds.");
        System.out.println("Press 3 to cancel.");

        int option = ATM.scanner.nextInt();;
        do {
            switch (option) {
                case 1:
                    option = ATM.chkBal();
                    break;
                case 2:
                    option = ATM.withdraw();
                    break;
                case 3:
                    option = ATM.cancel();
                    break;
                default:
                    throw new Exception("Invalid option selected.");
            }
        }while((option == 1) || (option == 2) || (option == 3));
    }
}
