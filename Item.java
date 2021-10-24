

public class Item<key,value> {
    public key key;
    public value data;

    public Item() {
    }

    public Item(key key, value data) {
        this.key = key;
        this.data = data;
    }

    public String toString(){
        return key + "->" + data;
    }
}
