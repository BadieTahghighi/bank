import java.util.ArrayList;

public class MyLinkedList<key,value> extends SearchStructure<key,value>{
    public class Node<key,value>{
        public Item<key,value> item;
        public Node<key,value> next;
        Node<key,value> previous;

        public Node(key key , value data) {
            this.item = new Item<key,value>(key,data);
            next = null;
            previous = null;
        }
    }

    public Node<key, value> head = null;

    public MyLinkedList(){

    }

    @Override
    public boolean insert(key key, value data) {
        Node<key,value> node = new Node(key, data);
        node.next = null;

        if (head == null){
            head = node;
        }else {
            Node<key, value> last = head;
            while (last.next != null){
                if (last.item.key.equals(key)){
                    last.item.data = data;
                    return false;
                }else {
                    last = last.next;
                }
            }
            if (last.item.key.equals(key)){
                last.item.data = data;
            }else {
                last.next = node;
            }
        }
        return true;
    }

    @Override
    public boolean delete(key key) {
        if (head == null){
            return false;
        }
        if (head.item.key.equals(key)){
            head = head.next;
            return true;
        }

        Node<key, value> prev = head;
        Node<key, value> pointer = head.next;

        while (pointer != null){
            if (pointer.item.key.equals(key)){
                prev = pointer.next;
                return true;
            }
            prev = pointer;
            pointer = pointer.next;
        }
        return false;
    }

    @Override
    public value search(key key) {
        Node<key, value> pointer = head;
        while (pointer != null){
            if (pointer.item.key.equals(key)){
                return pointer.item.data;
            }
            pointer = pointer.next;
        }
        return null;
    }

    @Override
    public void print() {
        Node<key, value> pointer = head;
        while (pointer != null){
            System.out.print(pointer.item);
            pointer=pointer.next;
        }
        System.out.println();
    }
    
    public ArrayList<value> values(){
    	ArrayList<value> valueList = new ArrayList<value>();
    	 Node<key, value> pointer = head;
         while (pointer != null){
        	 value val = pointer.item.data;
        	 valueList.add(val);
        	 pointer = pointer.next;
         }
         return valueList;
    }
    
    public ArrayList<key> keyset(){
    	ArrayList<key> keyset = new ArrayList<key>();
    	Node<key, value> pointer = head;
    	while (pointer != null) {
    		key key = pointer.item.key;
    		keyset.add(key);
    		pointer = pointer.next;
    	}
    	return keyset;
    }
    
   
}
