
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
    	HashMap<String,Double> balances=new HashMap<String,Double>();
        for(Account acc:accounts.values())
        {
            Double bal=balances.get(acc.getCity());
            if (bal!=null)
            {
                balances.put(acc.getCity(),bal+acc.getBalance());
            }
            else
            {
                balances.put(acc.getCity(),acc.getBalance());
            }
        }
        return balances;
    
    }

    public double calcTotalBalance() {
        double totalBalance = 0;
        for (Account account : accounts.values()) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public HashMap<String, Integer> getTotalCountPerCity() {
    	HashMap<String,Integer> counts=new HashMap<String,Integer>();
        for(Account acc:accounts.values())
        {
            Integer count=counts.get(acc.getCity());
            if (count!=null)
            {
                counts.put(acc.getCity(),count+1);
            }
            else
            {
                counts.put(acc.getCity(),1);
            }
        }
        return counts;
    }

    public void reportCity(HashMap<String, Double> balances, HashMap<String, Integer> counts) {
        System.out.println();
        System.out.println("\nCity \t \t Total Balance \t \t Average Balance");
        for (String city : balances.keySet()) {
            System.out.println(
                    city + "\t \t " + balances.get(city) + " \t \t " + balances.get(city) / (double) counts.get(city));
        }
    }

    public ArrayList<Integer> getTotalCountPerRange(ArrayList<Integer> ranges) {
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
           
        }
        return wrapper(result);
    }

    public void reportRanges(ArrayList<Integer> ranges, HashMap<Integer, Integer> countsPerRange) {
        for (int index = 0; index < ranges.size() - 1; index++) {
            int count = countsPerRange.get(ranges.get(index + 1));
            System.out.println(count + (count == 1 ? " account is in range of" : " accounts are in range of") + "\t"
                    + ranges.get(index) + " - " + ranges.get(index + 1));
        }
    }

	
	
	public ArrayList<Integer> wrapper(HashMap<Integer, Integer> input){
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(Integer i: input.values()) {
			res.add(i);
		}
		return res;
	}
	

}
