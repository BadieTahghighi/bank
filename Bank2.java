package bank;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hooman
 */

import java.util.*;

class Bank2 {
    public String name;
    public HashMap<Integer, Account> accounts;

    public Bank2(String name) {
        this.name = name;
        accounts = new HashMap<Integer, Account>();
    }

    public Account findAccount(int id) // find the account for the given id. Returns null if not found
    {
        return accounts.get(id);
    }

    public boolean addAccount(Account account) {
        for (Account acc : accounts.values()) {
            if (acc.getID() == account.getID()) {
                return false;
            }
        }
        accounts.put(account.getID(), account);
        return true;
    }

    public void printAccounts() {
        for (Account acc : accounts.values()) {
            acc.print();
        }
    }

    // update required
    public HashMap<String, Double> getTotalBalancePerCity() {
        HashMap<String, Double> result = new HashMap<>();
        for (Account account : accounts.values()) {
            double balance = account.getBalance();
            String city = account.getCity();
            boolean cityExists = false;
            for (String ct : result.keySet()) {
                if (ct.equals(city)) {
                    cityExists = true;
                    break;
                }
            }
            if (cityExists) {
                double oldBalance = result.get(city);
                result.put(city, oldBalance + balance);
            } else {
                result.put(city, balance);
            }
        }
        return result;
    }

    public HashMap<String, Integer> getTotalCountPerCity() {
        HashMap<String, Integer> result = new HashMap<>();
        for (Account account : accounts.values()) {
            String city = account.getCity();
            int ct = result.get(city);
            if (ct != 0) {
                result.put(city, ct + 1);
            } else {
                result.put(city, 1);
            }
        }
        return result;
    }

    public void reportCity(HashMap<String, Double> balances, HashMap<String, Integer> counts) {
        System.out.println();
        System.out.println("\n City \t \t Total Balance \t \t Average Balance");
        for (String city : balances.keySet()) {
            System.out.println(
                    city + "\t \t " + balances.get(city) + " \t \t " + balances.get(city) / (double) counts.get(city));
        }
    }

    public HashMap<Integer, Integer> getTotalCountPerRange(ArrayList<Integer> ranges) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int index = 0; index < ranges.size() - 1; index++) {
            int min = ranges.get(index);
            int max = ranges.get(index + 1);
            int count = 0;
            for (Account account : accounts.values()) {
                double balance = account.getBalance();
                if (balance >= min && balance < max) {
                    count++;
                }
            }
            result.put(ranges.get(index + 1), count);
            // Armaqan IQ 400 :O
        }
        return result;
    }

    public void reportRanges(ArrayList<Integer> ranges, HashMap<Integer, Integer> countsPerRange) {
        for (int index = 0; index < ranges.size() - 1; index++) {
            int count = countsPerRange.get(ranges.get(index + 1));
            System.out.println(count + "accounts are in range of\t" + ranges.get(index) + ", " + ranges.get(index + 1));
        }
    }

}
