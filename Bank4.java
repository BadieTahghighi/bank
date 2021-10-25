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

    public BinarySearchTree<String, Double> getTotalBalancePerCity() {
        BinarySearchTree<String, Double> result = new BinarySearchTree<>();
        HashMap<Integer, Account> accs = accounts.iterator();
        for (Account account : accs.values()) {
            String city = account.getCity();
            double ct = result.search(city) == null ? 0 : result.search(city);
            if (ct != 0) {
                result.insert(city, ct + account.getBalance());
            } else {
                result.insert(city, ct);
            }
        }
        return result;
    }

    public BinarySearchTree<String, Integer> getTotalCountPerCity() {
        BinarySearchTree<String, Integer> result = new BinarySearchTree<>();
        HashMap<Integer, Account> accs = accounts.iterator();
        for (Account account : accs.values()) {
            String city = account.getCity();
            int ct = result.search(city) == null ? 0 : result.search(city);
            if (ct != 0) {
                result.insert(city, ct + 1);
            } else {
                result.insert(city, 1);
            }
        }
        return result;
    }

    public ArrayList<Integer> getTotalCountPerRange(ArrayList<Integer> ranges) {
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
        return (ArrayList<Integer>) result.values();
    }

    public double calcTotalBalance() {
        double totalBalance = 0;
        HashMap<Integer, Account> accs = accounts.iterator();
        for (Account account : accs.values()) {
            totalBalance = +account.getBalance();
        }
        return totalBalance;
    }

    public boolean addAccount(Account account) {
        return accounts.insert(account.getID(), account);
    }

    public void reportCity(ArrayList<String> cities, BinarySearchTree<String, Double> counts,
            BinarySearchTree<String, Integer> totals) {
        System.out.println("\n City \t \t Total Balance \t \t Average Balance");
        for (int i = 0; i < counts.iterator().size(); i++)
            System.out.println(
                    cities.get(i) + " \t \t " + totals.search(i + "") + " \t \t " + totals.search(i + "") / (double) counts.search(i + ""));
    }

}