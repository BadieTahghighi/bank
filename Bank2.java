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
        return accounts.put(account);
    }

    public void printAccounts() {
        for (Account acc : accounts.values()) {
            acc.print();
        }
    }

    public HashMap<String, Double> getTotalBalancePerCity() {
        HashMap<String, Double> result = new HashMap<>();

        return result;
    }

    public HashMap<String, Integer> getTotalCountPerCity() {
        HashMap<String, Integer> result = new HashMap<>();

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

        return result;
    }

    public void reportRanges(ArrayList<Integer> ranges, HashMap<Integer, Integer> countsPerRange) {

    }

}
