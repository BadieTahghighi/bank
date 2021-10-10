package bank;

/**
 *
 * @author hooman
 */

import java.util.*;

public class Bank {
    private String name;
    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        accounts = new ArrayList<Account>();
    }

    public Account findAccount(int id) // find the account for the given id. Returns null if not found
    {

    }

    public boolean addAccount(Account account) {

    }

    public void printAccounts() {
        for (Account acc : accounts) {
            acc.print();
        }
    }

    public double calcTotalBalance() {
        double total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }

    public ArrayList<String> populateDistinctCityList() {

    }

    public ArrayList<Double> getTotalBalancePerCity(ArrayList<String> cities) {

    }

    public ArrayList<Integer> getTotalCountPerCity(ArrayList<String> cities) {

    }

    public void reportTotalPerCity(ArrayList<String> cities, ArrayList<Integer> counts, ArrayList<Double> totals) {
        System.out.println("\n City \t \t Total Balance \t \t Average Balance");
        for (int i = 0; i < counts.size(); i++)
            System.out.println(
                    cities.get(i) + " \t \t " + totals.get(i) + " \t \t " + totals.get(i) / (double) counts.get(i));
    }

    public ArrayList<Integer> getTotalCountPerRange(ArrayList<Integer> ranges) {

    }

    public void reportRanges(ArrayList<Integer> ranges, ArrayList<Integer> counts) {
        System.out.println();
        for (int i = 0; i < ranges.size() - 1; i++) {
            System.out.println("Number of accounts between " + ranges.get(i) + " and " + ranges.get(i + 1) + " = "
                    + counts.get(i));
        }
        System.out.println();
    }
}
