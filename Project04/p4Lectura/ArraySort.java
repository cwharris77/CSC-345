
public class ArraySort {

	public static void sort(Array array, int testNum, int d) {
		if (testNum == 1) {
			sort1(array);
		} else if (testNum == 2) {
			sort2(array);
		} else if (testNum == 3) {
			sort3(array);
		} else if (testNum == 4) {
			sort4(array, d);
		} else if (testNum == 5) {
			sort5(array);
		} else if (testNum == 6) {
			sort6(array);
		} else {
			sort7(array);
		}
	}

	private static void sort1(Array array) {
		int i = 0;
		int j = array.length() - 1;
		// swap elements at opposite ends of the array
		while (i < array.length() / 2 ) {
			array.swap(i, j);
			i++; 
			j--;
		}
	}

	private static void sort2(Array array) {
		// Put the array into heap order
		int length = array.length();
		int floor = length / 2;
		for (int i = floor; i >= 0; i--) {
			sink(array, i, length);
		}
		// sortdown
		int m = length - 1;
		while (m > 0) {
			array.swap(0, m);
			sink(array, 0, m);
			m--;
		}
	}
	
	private static void sink(Array a, int start, int size) {
		int current = a.getVal(start);
		
		while (start * 2 + 1 < size) {
			int i = start * 2 + 1; 
			int first = a.getVal(i); // left child
			// if the second child is greater than the first
			// it will be swapped
			if ((i + 1 < size) && a.getVal(i + 1) > first){
				i++;
			}
			
			if (current > a.getVal(i)) {
				break;
			}
			a.swap(start, i);
			start = i;
		}
	}

	private static void sort3(Array array) {
		shell(array);
	}
	
	private static void sort4(Array array, int d) {
		shell(array);
	}

	private static void sort5(Array array) {
		shell(array);
	}

	private static void sort6(Array array) {
		// version of merge sort from the slides
		array.initExtra(array.length());
		sortAux(array, 0, array.length() - 1);
	}

	private static void sortAux(Array array, int i, int j) {
		if (j - i < 1) {
			return;
		}
		int m = (j + i) / 2;
		
		sortAux(array, i, m);
		sortAux(array, m + 1, j);
		
		merge(array, i, m, m+1, j);
	}

	private static void merge(Array array, int a, int b, int x, int y) {
		int k = a;
		int c = a;
		
		while (a <= b || x <= y) {
			if (a > b) {
				array.setExtraVal(c, array.getVal(x));
				c++;
				x++;
			} else if (x > y) {
				array.setExtraVal(c, array.getVal(a));
				c++;
				a++;
			} else if (array.getVal(a) <= array.getVal(x)) {
				array.setExtraVal(c, array.getVal(a));
				c++;
				a++;
			} else {
				array.setExtraVal(c, array.getVal(x));
				c++;
				x++;
			}
		}
		for (int i = k; i <= y; i++) {
			array.setVal(i, array.getExtraVal(i));
		}
	}

	private static void sort7(Array array) {
		quick(array);
	}
	
	private static void insertionSort(Array array, int step) {
		for (int i = 1; i < array.length(); i += 1) {
			int j = i;
			while (j - step >= 0) {
				if (array.getVal(j) < array.getVal(j - step)) {
					array.swap(j, j - step);
					j -= step;
				}
				else {
					break;
				}
			}
		}
	}
	
	private static void shell(Array a) {
		a.initExtra(a.length());
		a.setExtraVal(0, 1);
		
		int firstIndex = 0;
		
		for (int i = 1; i < a.length(); i++) {
			int value = 3 * a.getExtraVal(i - 1) + 1;
			a.setExtraVal(i, value);
			
			if (value >= a.length() / 3) {
				firstIndex = i;
				break;
			}
		}
	
		for (int j = firstIndex; j >= 0; j--) {
			insertionSort(a, a.getExtraVal(j)); 
		}
	}
	
	private static void quick(Array a) {
		// 3 way quicksort from the slides
		pivot(a, 0, a.length() - 1);
	}

	private static void pivot(Array a, int i, int j) {
		if (i > j) {
			return;
		}
		if (i < 0 || i >= a.length() || j >= a.length()) {
			return;
		}
		int x = a.getVal(i);
		int p = i;
		int f = i + 1;
		for (int k = f; k <= j; k++) {
			int kVal = a.getVal(k);
			if (kVal < x) {
				a.swap(f, k);
				a.swap(p, f);
				p++;
				f++;
			} else if (kVal == x) {
				a.swap(f, k);
				f++;
			}
		}
		pivot(a, i, p-1);
		pivot(a, f, j);
	}
}
