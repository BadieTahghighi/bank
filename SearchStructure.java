public abstract class SearchStructure<k, v> {
    abstract public boolean insert(k key, v data);

    abstract public boolean delete(k key);

    abstract public v search(k key);

    abstract public void print();
}
