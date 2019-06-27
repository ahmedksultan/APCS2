import java.util.HashSet;
import java.util.Set;

public class HashST<Key,Value>{

  private static class Node{
     private Object key;
	   private Object value;
	   private Node next;
	   public Node(Object key, Object value, Node next) {
  	   this.key = key;
  	   this.value = value;
  	   this.next = next;
	   }
   }

    // instance variables
    private int m;   // # of buckets
    private Node[] buckets;
    private HashSet<Key> keys;

    public HashST(int capacity){
    	m = capacity;
    	buckets = new Node[m];
    	keys = new HashSet<Key> ();
    }

    public int hash(Object key){
	    return Math.abs(key.hashCode()) % m;
    }

    //returns the # of key, value pairs
    public int size() {
      return keys.size();
    }

    //returns true if key is within the symbol table
    public boolean containsKey(Key key) {
      return keys.contains(key);
    }

    //returns set of keys
    public Set<Key> getKeys() {
      return keys;
    }

    private Node getNode(Key key) {
      if (containsKey(key)) {
        return
      }
    }

    public 

    /*

 d. private Node getNode(Key key){ }
    // returns the Node that holds the key,value pair
    // null is returned if not found.


 e. public Value get(Key key){}
    // returns the value associated with the given key
    // null is returned if key not found

 f.  public Value put(Key key, Value value){}
    // puts the new key, value pair into the map and returns
    // the replaced value. If the key,value pair is a new entry
    // null is returned and keys is updated.

 g.  public void printTable(){}
     // prints current state of the hash table.

     Here is a sample input of a table with 13 buckets

     java HashST cat lemon cherry frog zebra cherry orange

     public Value remove(Key key) {
      (1) if key is not found, return null
      (2) key, value pair is at the front of the linked list buckets[i] is involved
      (3) key, value pair is in the interior of the linked list4
     }
   }
  */

    public static void main(String [] args){
	    HashST<String, Integer> d = new HashST<String, Integer> (13);
    }

}
