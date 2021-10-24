import java.util.ArrayList;
import java.util.HashMap;

/**
 * Bank4
 * 
 * @author Badie & Armaqan
 */

public class Bank4 {
    public BinarySearchTree<Integer, Account> accounts;
    public String name;

    public Bank4(String name) {
        this.accounts = new BinarySearchTree<>();
        this.name = name;
    }

    public Account findAccount(int id) {
        return accounts.search(id);
    }

    public HashMap<String, Double> getTotalBalancePerCity() {
        HashMap<String, Double> result = new HashMap<>();
        HashMap<Integer, Account> accs = accounts.iterator();
        for (Account account : accs.values()) {
            String city = account.getCity();
            double ct = result.get(city) == null ? 0 : result.get(city);
            if (ct != 0) {
                result.put(city, ct + 1);
            } else {
                result.put(city, 1.0);
            }
        }
        return result;
    }

    public HashMap<Integer, Integer> getTotalCountPerRange(ArrayList<Integer> ranges) {
        HashMap<Integer, Integer> result = new HashMap<>();
        HashMap<Integer, Account> accs = accounts.iterator();
        for (int index = 0; index < ranges.size() - 1; index++) {
            int min = ranges.get(index);
            int max = ranges.get(index + 1);
            int count = 0;
            for (Account account : accs.values()) {
                double balance = account.getBalance();
                if (balance >= min && balance < max) {
                    count++;
                }
            }
            result.put(ranges.get(index + 1), count);
        }
        return result;
    }

    public double calcTotalBalance() {
        double totalBalance = 0;
        HashMap<Integer, Account> accs = accounts.iterator();
        for (Account account: accs.values()) {
            totalBalance =+ account.getBalance();
        }
        return totalBalance;
    }

    public boolean addAccount(Account account) {
        return accounts.insert(account.getID(), account);
    }
}