import java.util.ArrayList;
import java.util.HashMap;

/**
 * Bank3
 * @author Badie & Armaqan
 */

public class Bank3 {
	
	public String name;
	public MyHashMap<Integer, Account> accounts; 
	
	public Bank3(String name) {
		this.name = name;
		accounts = new MyHashMap<Integer, Account>();
	}
	
	public Account findAccount(Integer id) {
		return accounts.search(id);
	}
	
	public boolean addAccount(Account account) {
		for(Account acc: accounts.values()) {
			if(acc.getID() == account.getID()) {
				return false;
			}
		}
		accounts.insert(account.getID(), account);
		return true;
	}
	
	public void printAccounts() {
		for(Account acc: accounts.values()) {
			acc.print();
		}
	}
	
	public MyHashMap<String, Double> getTotalBalancePerCity(){
		MyHashMap<String, Double> balances = new MyHashMap<String,Double>();
		for(Account acc: accounts.values()) {
			Double bal=balances.search(acc.getCity());
            if (bal!=null)
            {
                balances.insert(acc.getCity(),bal+acc.getBalance());
            }
            else
            {
                balances.insert(acc.getCity(),acc.getBalance());
            }
        }
        return balances;
		}
	
	 public MyHashMap<String, Integer> getTotalCountPerCity() {
	    	MyHashMap<String,Integer> counts=new MyHashMap<String,Integer>();
	        for(Account acc:accounts.values())
	        {
	            Integer count=counts.search(acc.getCity());
	            if (count!=null)
	            {
	                counts.insert(acc.getCity(),count+1);
	            }
	            else
	            {
	                counts.insert(acc.getCity(),1);
	            }
	        }
	        return counts;
	    }
	 
	 public void reportCity(MyHashMap<String, Double> balances, MyHashMap<String, Integer> counts) {
	        System.out.println();
	        System.out.println("\nCity \t \t Total Balance \t \t Average Balance");
	        for (String city : balances.keyset()) {
	            System.out.println(
	                    city + "\t \t " + balances.search(city) + " \t \t " + balances.search(city) / (double) counts.search(city));
	        }
	    }
	 
	 public ArrayList<Integer> getTotalCountPerRange(ArrayList<Integer> ranges) {
	        MyHashMap<Integer, Integer> result = new MyHashMap<>();
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
	            result.insert(ranges.get(index + 1), count);
	        }
	        return wrapper(result);
	    }
	 
	 public void reportRanges(ArrayList<Integer> ranges, MyHashMap<Integer, Integer> countsPerRange) {
	        for (int index = 0; index < ranges.size() - 1; index++) {
	            int count = countsPerRange.search(ranges.get(index + 1));
	            System.out.println(count + (count == 1 ? " account is in range of" : " accounts are in range of") + "\t"
	                    + ranges.get(index) + " - " + ranges.get(index + 1));
	        }
	    }
	 public double calcTotalBalance() {
			double totalBalance = 0;
			for(Account acc: accounts.values()) {
				totalBalance += acc.getBalance();
			}
			return totalBalance;
		}
	 
	 public ArrayList<Integer> wrapper(MyHashMap<Integer, Integer> input){
			ArrayList<Integer> res = new ArrayList<Integer>();
			for(Integer i: input.values()) {
				res.add(i);
			}
			return res;
		}
	 
	}

