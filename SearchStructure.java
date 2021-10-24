/**
 *
 * @author Hooman
 */
public abstract class SearchStructure
{
    abstract public boolean insert(Integer key,Integer data);
    abstract public boolean delete(Integer key);// return success
    abstract public Integer search(Integer key);// return data
    abstract public void print();
} 
