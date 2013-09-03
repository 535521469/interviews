import java.util.BitSet;

public class Test {

	public static void main(String[] args) {

		// short[][] shorts = new short[Short.MAX_VALUE][Short.MAX_VALUE];
		// System.out.println(shorts.length);

		System.out.println(Short.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE / Short.MIN_VALUE);

//		short i = 9;
//		System.out.println(i | 8);

		BitSet[] bs = new BitSet[Short.MAX_VALUE];
		
		for (BitSet bitSet : bs) {
			bitSet = new BitSet(Short.MAX_VALUE);
		}
		
		System.out.println(bs.length);
		
	}

}
