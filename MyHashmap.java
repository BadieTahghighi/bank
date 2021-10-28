import java.util.ArrayList;

public class MyHashMap<key, value> extends SearchStructure<key, value> {

	public MyLinkedList[] chain;

	public MyHashMap() {
		chain = new MyLinkedList[10000];
		for (int i = 0; i < 10000; i++) {
			chain[i] = new MyLinkedList<key, value>();
		}
	}

	@Override
	public boolean insert(key key, value data) {
		if (key != null) {
			int hashCode = getHash(key);
			if (hashCode >= 0) {
				chain[hashCode].insert(key, data);
				return true;
			} else {
				chain[Math.abs(hashCode)].insert(key, data);
				return true;

			}
		}
		return false;
	}

	@Override
	public boolean delete(key key) {
		if (key != null) {
			int hashCode = getHash(key);
			if (hashCode >= 0) {
				chain[hashCode].delete(key);
				return true;
			} else {
				chain[Math.abs(hashCode)].delete(key);
				return true;

			}
		}
		return false;
	}

	@Override
	public value search(key key) {
		if (key != null) {
			int hashCode = getHash(key);
			if (hashCode >= 0) {
				return (value) chain[hashCode].search(key);
			} else {
				return (value) chain[Math.abs(hashCode)].search(key);
			}
		}
		return null;

	}

	@Override
	public void print() {
		for (MyLinkedList list : chain) {
            list.print();
        }

	}

	public int getHash(key key) {
		int hashCode = key.hashCode();
		int result = hashCode % 10000;
		return result;
	}
	
	public ArrayList<value> values(){
		ArrayList<value> valueList = new ArrayList<value>();
		for(MyLinkedList list: chain) {
			ArrayList<value> listValues = list.values();
			for(value val: listValues) {
				valueList.add(val);
			}
		}
		return valueList;
	}
	
	public ArrayList<key> keyset(){
		ArrayList<key> keyset = new ArrayList<key>();
		for(MyLinkedList list: chain) {
			ArrayList<key> listKey = list.keyset();
			for(key val: listKey) {
				keyset.add(val);
			}
		}
		return keyset;
	}
	


}
