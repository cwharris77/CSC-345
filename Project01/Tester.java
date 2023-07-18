
public class Tester {
	public static void main(String[] args) {
		test_1Through4();
		test_0s();
		testWholeArray();
		testMiddle();
		test();
		test_all0();
		
		
		Array a = new Array(12);

		for (int i = 0; i < a.length(); i++) {
			a.setVal(i, i); 
		}
		a.setVal(0, 11);
		a.setVal(3, 0);
//		
//		a.setVal(5, 13);
//		a.setVal(6, 12);
		
		int largestProduct = Part1.maxProduct(a, 5);
		System.out.println(a.toString());
		System.out.println("This program ran and produced this output: " + largestProduct);
		
	}
	
	static void test_1Through4() {
		Array a = new Array(5);
		
		for (int i = 0; i < a.length(); i++) {
			a.setVal(i, i); 
		}
		
		int ret = Part1.maxProduct(a, 3);
		System.out.println(a.toString());
		System.out.println("ret: " + ret + "\n");
		
		System.out.println(ret);
		
	}
	
	static void test_0s() {
		Array a = new Array(10);
		
		for (int i = 0; i < a.length(); i++) {
			a.setVal(i, 0); 
		}
		a.setVal(9, 1);
		int ret = Part1.maxProduct(a, 3);
		System.out.println(a.toString());
		System.out.println("ret: " + ret + "\n");
		
		//assertEquals(ret, 0);
		System.out.println(ret);
		
	}
	
	static void testWholeArray() {
		Array a = new Array(6);
		
		for (int i = 1; i < a.length(); i++) {
			a.setVal(i, i); 
		}
		a.setVal(0, 1);
		
		int ret = Part1.maxProduct(a, 8);
		System.out.println("whole: " + a.toString());
		System.out.println("ret: " + ret + "\n");
		
		//assertEquals(120, ret);
		System.out.println(ret);
		
	}
	
	static void testMiddle() {
		Array a = new Array(6);
		
		
		a.setVal(0, 0);
		a.setVal(1, 10);
		a.setVal(2, 9);
		a.setVal(3, 7);
		a.setVal(5, 8);
		
		int ret = Part1.maxProduct(a, 3);
		System.out.println("middle: " + a.toString());
		System.out.println("ret: " + ret + "\n");
		
		//assertEquals(630, ret);
		System.out.println(ret);
		
	}
	
	static void test() {
		Array a = new Array(12);
		
		for (int i = 11; i > 0; i--) {
			a.setVal(i, i);
		}

		
		
		int ret = Part1.maxProduct(a, 1);
		System.out.println("test: " + a.toString());
		System.out.println("ret: " + ret + "\n");
		
//		assertEquals(11, ret);
		System.out.println(ret);
		
	}
	static void test_all0() {
		Array a = new Array(5);
		
		for (int i = 0; i < a.length(); i++) {
			a.setVal(i, 0); 
		}
		
		int ret = Part1.maxProduct(a, 3);
		System.out.println(a.toString());
		System.out.println("all0: " + ret + "\n");
		
//		assertEquals(0, ret);
		System.out.println(ret);
	}
}
