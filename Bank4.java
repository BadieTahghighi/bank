package bank;
/**
 * Bank4
 * 
 * @author Badie & Armaqan
 */

public class Bank4 {
    public BinarySearchTree<Integer, Account> accounts;
    public String name;

    public Bank4(String name) {
        this.accounts = new BinarySearchTree()<Integer, Accoutn>;
        this.name = name;
    }

    public boolean addAccount(Account account) {
        try {
            accounts.insert(account.getID(), account);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}