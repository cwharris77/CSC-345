
public class Tests {
	public static void main(String[] args) throws EmptyListException {
//		testArr();
//		testAddFirst(10);
//		try {
//			testRemoveFirst();
//		} catch (EmptyListException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//testLast();
		testRemoveLast();
	}
	
	public static void testArr() {
		ArrList a = new ArrList(3);
		
//		for (int i = 9; i >= 0; i--) {
//			a.addLast(i);
//		}
//		
//		for (int i = 0; i < a.size(); i++) {
//			System.out.print(a.get(i) + ", ");
//		}
//		
		a.addFirst(10);
		a.addFirst(45);
//		a.addLast(10);
//		a.addFirst(3);
//		a.addFirst(2);
		System.out.println("\n");
		System.out.print(a.toString());

		a.addFirst(13);
//		a.addFirst(3);
//		a.addFirst(3);
//		a.addFirst(3);
		System.out.println("\n");
		System.out.print(a.toString());
		a.addFirst(3);
		System.out.println("\n");
		System.out.print(a.toString());
		System.out.println("\n");
		System.out.println("front: " + a.front);
		System.out.println("back: " + a.back);
		System.out.println("size: " + a.size());
	}
	
	public static void testAddFirst(int m) {
		ArrList a = new ArrList(m);
		for (int i = 0; i < 10; i++) {
			a.addFirst(i);
//			System.out.println("a: " + a.toString());
		}
		a.addFirst(23);
		a.addLast(46);
		a.addFirst(90);
		System.out.println(a.toString());
		System.out.println("front: " + a.front);
		System.out.println("a.get: " + a.get(14));
	}
	
	public static void testRemoveFirst() throws EmptyListException {
		ArrList a = new ArrList(15);
		a.addLast(9);
		a.addLast(7);
		a.addFirst(5);
		System.out.println(a.front);
		System.out.println(a.toString());
		a.removeFirst();
		a.addFirst(3);
		System.out.println(a.front);
		System.out.println(a.toString());
	}
	
	public static void testLast() {
		ArrList a = new ArrList(10);
		
		a.addLast(10);
		a.addFirst(9);
		a.addFirst(9);
		a.addLast(10);
		a.addLast(10);
		
		System.out.println(a.toString());
		int b = 10;
		System.out.println("last index of " + b + " : " + a.lastIndexOf(b));
			
	}
	public static void testRemoveLast() throws EmptyListException {
		ArrList a = new ArrList(15);
		a.addLast(9);
		//a.addLast(7);
		a.addFirst(5);
//		System.out.println(a.front);
		System.out.println(a.toString());
		a.removeLast();
		a.removeLast();
		//a.addFirst(3);
//		System.out.println(a.front);
		System.out.println(a.toString());
	}
}
