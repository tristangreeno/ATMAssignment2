import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Used to do the ATM's primary functions.
 * Can check balance (chkBal), withdraw, or cancel.
 * Also streamlines scanning for the User class.
 */
class ATM {
    final static Scanner scanner = new Scanner(System.in);

    static int chkBal() {
        System.out.println("Your current balance: $100");
        System.out.println("Press 1 to check balance again, 2 to withdraw, or 3 to cancel.");
        return scanner.nextInt();
    }

    static int withdraw() throws Exception {
        try{
            System.out.println("How much would you like to withdraw?");
            int amount = scanner.nextInt();
            int balance = 100;

            if(amount > 100){
                throw new Exception("Insufficient funds.");
            }

            if(amount <= 0){
                throw new Exception("Invalid amount to withdraw.");
            }

            System.out.println("Amount withdrawn: $" + amount);
            System.out.println("Amount remaining: $" + (balance - amount));
            System.out.println("Please remove cash from dispenser.");
            System.out.println("Press 1 to check balance, 2 to withdraw, or 3 to cancel.");
            return scanner.nextInt();
        }
        catch(InputMismatchException e){
            throw new Exception("No amount entered. Please try again.");
        }
    }

    static int cancel() {
        System.out.println("Thank you. Please come again.");
        return 5;
    }

}
