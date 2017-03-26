
public class BinaryShiftExperiment {

	public static void main(String args[]) {
	      int a = 60;	/* 60 = 0011 1100 */
	      int b = 13;	/* 13 = 0000 1101 */
	      int c = 0;
	      int d = -60;

	      c = a & b;        /* 12 = 0000 1100 */
	      System.out.println("a & b = " + c );

	      c = a | b;        /* 61 = 0011 1101 */
	      System.out.println("a | b = " + c );

	      c = a ^ b;        /* 49 = 0011 0001 */
	      System.out.println("a ^ b = " + c );

	      c = ~a;           /*-61 = 1100 0011 */
	      System.out.println("~a = " + c );

	      c = a << 2;       /* 240 = 1111 0000 */
	      System.out.println("a << 2 = " + c );

	      c = a >> 2;       /* 15 = 1111 */
	      System.out.println("a >> 2  = " + c );

	      c = a >>> 2;      /* 15 = 0000 1111 */
	      System.out.println("a >>> 2 = " + c );
	      
	      System.out.println(Integer.toBinaryString(-1));
	      // prints "11111111111111111111111111111111"
	      System.out.println(Integer.toBinaryString(-1 >> 16)+ " and value is:" +  (-1 >> 16));
	      // prints "11111111111111111111111111111111"
	      System.out.println("-5 is: " + Integer.toBinaryString(-5));
	      // prints "-5 is: 11111111111111111111111111111011"	      
	      System.out.println("(-5 >> 1)" +  Integer.toBinaryString(-5 >> 1)+ " and value is:" +  (-5 >> 1));
	      // prints "(-5 >> 1)11111111111111111111111111111101 and value is:-3"
	      System.out.println("(-5 >>> 1)" + Integer.toBinaryString(-5 >>> 1) + " and value is:" +  (-5 >>> 1));
	      // prints "(-5 >>> 1)1111111111111111111111111111101 and value is:2147483645"	      
	   }

}
