@SuppressWarnings("unchecked")
public class Hashtable<K, V> {
    //constructor--default table size is 11
    public Hashtable() {
	//TO BE IMPLEMENTED
    }

    //constructor
    public Hashtable(int m) {
	//TO BE IMPLEMENTED
    }

    //returns the value associated with key <key>
    //return null if key is not in table
    //do not forget that you will have to cast the result to (V)
    public V get(K key) {
	//TO BE IMPLEMENTED
    }

    //puts (key, val) into the table or updates value
    //if the key is already in the table
    //resize to getNextNum(2*m) if (double)n/m exceeds alphaHigh after the insert
    public void put(K key, V val) {//System.out.println("put: " + key + ", " + val);
	//TO BE IMPLEMENTED
    }

    //removes the (key, value) pair associated with <key>
    //returns the deleted value or null if the element was not in the table
    //resize to getNextNum(m/2) if m/2 >= 11 AND (double)n/m < alphaLow after the delete
    public V delete(K key) {
	//TO BE IMPLEMENTED
    }

    //return true if table is empty
    public boolean isEmpty() {
	//TO BE IMPLEMENTED
    }

    //return the number of (key,value) pairs in the table
    public int size() {
	//TO BE IMPLEMENTED
    }

    //This method is used for testing only. Do not use this method yourself for any reason
    //other than debugging. Do not change this method.
    public Pair[] getTable() {
	//TO BE IMPLEMENTED
    }

    //PRIVATE
    
    //gets the next multiple of 6 plus or minus 1,
    //which has a decent probability of being prime.
    //Use this method when resizing the table.
    private int getNextNum(int num) {
	if(num == 2 || num == 3)
	    return num;
	int rem = num % 6;
	switch(rem) {
	case 0: num++; break;
	case 2: num+=3; break;
	case 3: num+=2; break;
	case 4: num++; break;
	}
	return num;
    }
}
      
