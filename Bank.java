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
        return accounts.get(id);
    }

    public boolean addAccount(Account account) {
        return accounts.add(account);
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
        ArrayList<String> cities = new ArrayList<>();
        for (Account account : accounts) {
            String city = account.getCity();
            boolean cityAlreadyExists = false;
            for (String ct : cities) {
                if (ct.equals(city)) {
                    cityAlreadyExists = true;
                    break;
                }
            }
            if (!cityAlreadyExists) {
                cities.add(city);
            }
        }
        return cities;
    }

    public ArrayList<Double> getTotalBalancePerCity(ArrayList<String> cities) {
        ArrayList<Double> result = new ArrayList<>();
        for (String city : cities) {
            double totalBalanceOfTheCity = 0;
            for (Account account : accounts) {
                if (account.getCity().equals(city)) {
                    totalBalanceOfTheCity += account.getBalance();
                }
            }
            result.add(totalBalanceOfTheCity);
        }
        return result;
    }

    public ArrayList<Integer> getTotalCountPerCity(ArrayList<String> cities) {
        ArrayList<Integer> result = new ArrayList<>();
        for (String city : cities) {
            int persons = 0;
            for (Account account : accounts) {
                if (account.getCity().equals(city)) {
                    persons++;
                }
            }
            result.add(persons);
        }
        return result;
    }

    public void reportTotalPerCity(ArrayList<String> cities, ArrayList<Integer> counts, ArrayList<Double> totals) {
        System.out.println("\n City \t \t Total Balance \t \t Average Balance");
        for (int i = 0; i < counts.size(); i++)
            System.out.println(
                    cities.get(i) + " \t \t " + totals.get(i) + " \t \t " + totals.get(i) / (double) counts.get(i));
    }

    public ArrayList<Integer> getTotalCountPerRange(ArrayList<Integer> ranges) {
        ArrayList<Integer> result = new ArrayList<>();
    
        for (int index = 0; index < ranges.size()-1; index++) {
            int count = 0;
            int min = ranges.get(index);
            int max = ranges.get(index + 1);
            for (Account account : accounts) {
                double balance = account.getBalance();
                if (balance >= min && balance < max) {
                   count++; 
                }
            }
            result.add(count);
        }
        return result;
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
