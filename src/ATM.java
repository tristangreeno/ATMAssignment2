import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Used to do the ATM's primary functions.
 * Can check balance (chkBal), withdraw, or cancel.
 * Also streamlines scanning for the User class.
 */
class ATM {
    final static Scanner scanner = new Scanner(System.in);
    private static Hashy hashy = new Hashy();
    private static HashMap<String, Integer> users = hashy.Hasher();
    private static String name;

    static void setName() throws Exception {
        System.out.println("Welcome to Tristan's ATM. What is your name?");
        name = ATM.scanner.nextLine();

        if(!(users.containsKey(name))){
            System.out.println("User not found. Would you like to create a new account (Y / N)?");
            if(scanner.nextLine().equalsIgnoreCase("Y")){
                System.out.println("Created new account for " + name + ".");
                System.out.println("How much would you like to deposit to your account?");
                users.put(name, scanner.nextInt());
            }

            if(scanner.nextLine().equalsIgnoreCase("N")){
                throw new Exception("User terminated session.");
            }
        }

        System.out.println("Welcome, " + name + ". What would you like to do today?");
        System.out.println("Press 1 to check balance.");
        System.out.println("Press 2 to withdraw funds.");
        System.out.println("Press 3 to cancel.");
    }

    static int chkBal() {
        System.out.println("Your current balance: $" + users.get(name));
        System.out.println("Press 1 to check balance again, 2 to withdraw, or 3 to cancel.");
        return scanner.nextInt();
    }

    static int withdraw() throws Exception {
        try{
            System.out.println("How much would you like to withdraw?");
            int amount = scanner.nextInt();
            int balance = users.get(name);

            if(amount > users.get(name)){
                throw new Exception("Insufficient funds.");
            }

            if(amount <= 0){
                throw new Exception("Invalid amount to withdraw.");
            }

            balance -= amount;
            users.put(name, users.getOrDefault(name, 0) - amount);
            System.out.println("Amount withdrawn: $" + amount);
            System.out.println("Amount remaining: $" + balance);
            System.out.println("Please remove cash from dispenser.");
            System.out.println("Press 1 to check balance, 2 to withdraw, or 3 to cancel.");
            return scanner.nextInt();
        }
        catch(InputMismatchException e){
            throw new Exception("No amount entered. Please try again.");
        }
    }

    static int delete() throws Exception{
        System.out.println("Please confirm deletion by entering your name.");
        if(scanner.nextLine().equalsIgnoreCase(name)){
            users.remove(name);
            throw new Exception("Account deleted.");
        }

        else {
            throw new Exception("Wrong name entered. Please try again.");
        }
    }

    static int cancel() {
        System.out.println("Thank you. Please come again.");
        String nothing = scanner.nextLine(); // Needed not to have the option selection be read as a name
        return 5;
    }

}
