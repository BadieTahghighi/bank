public abstract class SearchStructure<key,value> {
    abstract public boolean insert(key key, value data);
    abstract public boolean delete(key key);
    abstract public value search(key key);
    abstract public void print();
}
