/**
 * The Main program for running the ATM.
 * Calls upon the ATM's functions to perform actions requested by the user.
 */
public class User {
    public static void main(String args[]) throws Exception {


        while (true) {
            ATM.setName();

            int option = ATM.scanner.nextInt();
                do{
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
                    case 4:
                        option = ATM.delete();
                        break;
                    default:
                        throw new Exception("Invalid option selected.");
                }
            } while ((option == 1) || (option == 2) || (option == 3));
        }
    }
}
