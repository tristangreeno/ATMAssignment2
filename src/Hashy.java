import java.util.HashMap;
import java.util.Random;

/**
 * Stores users and balances in a HashMap.
 */
public class Hashy {

    final HashMap<String, Integer> Hasher() {
        Random random = new Random();
        HashMap<String, Integer> users = new HashMap<>();
        users.put("James", random.nextInt(15000));
        users.put("Tim", random.nextInt(12000));
        users.put("Darren", random.nextInt(13000));
        users.put("John", random.nextInt(16000));
        users.put("Samantha", random.nextInt(13500));
        return users;
    }
}
