
public class ArrList {
	private int size;
	public int front, back;
	private boolean hasRan;
	public Array a;
	
	public ArrList() {
		size = 0;
		front = -1;
		back = -1;
	
		a = new Array(10);
		
	}
	public ArrList(int cap) {
		size = 0;
		front = -1;
		back = -1;
		a = new Array(cap);
	}
	/***
	 * adds a value to the back of the list
	 * @param num the value to add
	 */
	public void addLast(int num) {
		int aLen = a.length();
		if (size == aLen - 1) {
			a.resize(aLen * 2, 0, size);
		}
		
		if (back == aLen - 1) {
			back = 0;
		} else if (front == -1){
			front = 0;
			back = 0;
		} else {
			back ++;	
		}
		a.setVal(back, num);
		size++;
		hasRan = true;
	}
	/***
	 * adds an element to the front of the list
	 * @param num the value to add
	 */
	public void addFirst(int num) {
		int aLen = a.length();
		if (size == aLen || (front == back + 1)) {
			a.resize(aLen * 2, 0, size * 2);
		}
		if (front == 0) {
			front = aLen - 1;
		} else if (back == -1) {
			front = 0;
			back = 0;
		}
		else {
			front --;
		}
		
		a.setVal(front, num);
		size++;
		hasRan = true;
	}
	/***
	 * gets the value at the specified index
	 * @param i the index to get the value of 
	 * @return the value at index i
	 */
	public int get(int i) {
		int aLen = a.length();
		if (front + i < aLen) {
			return a.getVal(i + front);
		} else {
			return a.getVal(i - (a.length() - front));
		}
		
	}
	/***
	 * finds the first occurrence of i
	 * @param i the value to search for
	 * @return the index where i is first found
	 */
	public int indexOf(int i) {
		int j;
		int k = 0;
		for (j = front; j < a.length(); j++) {
			if (a.getVal(j) == i) {
				 return k;
			}
			k++;
		}
		int l = k;
		for (j = 0; j < front; j++) {
			if (a.getVal(j) == i) {
				return l;
			}
			l++;
		}
		return -1;
	}
	/***
	 * finds the last index in the list that contains the specified value
	 * @param i the value to search for
	 * @return the last index of i
	 */
	public int lastIndexOf(int i) {
		int k = 0;
		int temp = -1;
	
		int j = 0;
		while (j <= size) {
			if (j == a.length() - 1) {
				j = 0;
			}
			if (a.getVal(j) == i) {
				temp = k;
			}
			j++;
			k++;
		}
		
		return temp;
	}
	/***
	 * 
	 * @param num check if this number is in the list
	 * @return true if the list contains num
	 */
	public boolean contains(int num) {
		for (int i=0; i < a.length(); i++) {
			if (a.getVal(i) == num) {
				return true;
			}
		}
		return false;
	}
	/***
	 * removes the first value in the list
	 * @return the removed value
	 * @throws EmptyListException
	 */
	public int removeFirst() throws EmptyListException { 
		if (this.isEmpty()) {
			throw new EmptyListException();
		}
		int ret = a.getVal(front);
		if (back == front) {
			back = 0;
			front = 0;
		} else if (front == a.length() - 1) {
				front = 0;
		} else {
			front++;
		}
		
		size --;
		
		
		if (size < a.length() / 4  && a.length() / 4 >= 10) {
			a.resize(a.length() / 2, front, size);
		}
		return ret;
	}
	/***
	 * removes the last value of the list
	 * @return the removed value
	 * @throws EmptyListException
	 */
	public int removeLast() throws EmptyListException {
		if (this.isEmpty()) {
			throw new EmptyListException();
		}
		int ret = a.getVal(back);
		
		if (back == front) {
			back = 0;
			front = 0;
		} else if (back == 0) {
			back = a.length() - 1;
		} else {
			back --;
		}
		
		size--;
		
		if (size < a.length() / 4 && a.length() / 4 >= 10) {
			a.resize(a.length() / 2, front, size);
		}
		return ret;
	}
	/***
	 * removes the value at the specified index
	 * @param i the index to remove
	 * @return the removed value
	 * @throws EmptyListException
	 */
	public int removeByIndex(int i) throws EmptyListException {
		if (this.isEmpty()) {
			throw new EmptyListException();
		}
		int ret = this.get(i);
		boolean check = true;
		
		for (int j = i; j <= a.length() && j < front - 1; j++) {
			if (j != a.length()) {
				set(j, this.get(j + 1));
			} else {
				set(j, this.get(0));
				check = false;
			}
		}
		if (check) {
			back--;
		} else {
			back = 0;
		}
		
		return ret;
	}
	/***
	 * removes the first occurrence of a value from the list
	 * @param num the value to remove
	 * @return true if the value was removed
	 * @throws EmptyListException
	 */
	public boolean removeByValue(int num) throws EmptyListException {
		int index = this.indexOf(num);
		if (index == -1) {
			return false;
		}
		this.removeByIndex(index);
		
		return true;
	}
	/***
	 * 
	 * @param i - the index to set
	 * @param num - the value to set index i to
	 * @return i index that was set
	 */
	public int set(int i, int num) {
		if (front + i < a.length()) {
			a.setVal((i + front), num);
		} else {
			a.setVal(i - (size - front), num);
		}
		return i;
	}
	/***
	 * 
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	/***
	 * 
	 * @return size of the array
	 */
	public int size() {
		return size;
	}
	
	public String toString() {
		return a.toString();
	}
}
