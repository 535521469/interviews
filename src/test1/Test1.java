import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.BitSet;

/**
 * a file with integers which size is Integer.MAX_VALUE , about 4200000000 .
 * find a integer that not exist in the file 
 * require : 1. you have only 1G
 * momery ? 2. what about 10M momery ?
 * 
 * answer: 1. use a 4200000000 length string , use it as bit array . in java ,
 * can use BitSet 2. ?
 * 
 * @author Administrator
 * 
 */
public class Test1 {

	public static void answer1() throws FileNotFoundException {

		String fileName = "d:/test/review3.txt";
		File file = new File(fileName);
		FileInputStream reader = new FileInputStream(file);
		byte[] ins = new byte[128];
		StringBuilder sb = new StringBuilder();

		// notice
		// must set the initial size , or see the BitSet.ensureCapacity() ,
		// when not enough size , the capacity will add to double capacity
		BitSet pbs = new BitSet(Integer.MAX_VALUE); // positive number
		BitSet mbs = new BitSet(Integer.MAX_VALUE); // negative number

		int size = 0;

		int psize = 0; // plus
		int msize = 0; // minus

		try {
			int hasRead = 0;

			while ((hasRead = reader.read(ins)) > 0) {

				sb.append(new String(ins));
				int lastCommaIndex = sb.lastIndexOf(",");

				String line = sb.substring(0, lastCommaIndex);
				sb.delete(0, lastCommaIndex);

				String[] is = line.split(",");

				for (int j = 0; j < is.length; j++) {
					String str = is[j];
					size += str.length();
					if (str.equals("")) {
						continue;
					}
					int integer = Integer.valueOf(str);
					if (integer >= 0) {
						psize++;
						pbs.set(integer);
					} else {
						msize++;
						mbs.set(Math.abs(integer));
					}
				}

				System.out.println(size + "," + psize + "," + pbs.cardinality()
						+ "," + msize + "," + mbs.cardinality());
				// break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// System.out.println(bs);
		System.out.println("done .");
	}
	
	public static void answer2() throws FileNotFoundException{

		String fileName = "d:/test/review3.txt";
		File file = new File(fileName);
		FileInputStream reader = new FileInputStream(file);
		byte[] ins = new byte[128];
		StringBuilder sb = new StringBuilder();

		// notice
		// must set the initial size , or see the BitSet.ensureCapacity() ,
		// when not enough size , the capacity will add to double capacity
		BitSet pbs = new BitSet(Integer.MAX_VALUE); // positive number
		BitSet mbs = new BitSet(Integer.MAX_VALUE); // negative number

		int size = 0;

		int psize = 0; // plus
		int msize = 0; // minus

		try {
			int hasRead = 0;

			while ((hasRead = reader.read(ins)) > 0) {

				sb.append(new String(ins));
				int lastCommaIndex = sb.lastIndexOf(",");

				String line = sb.substring(0, lastCommaIndex);
				sb.delete(0, lastCommaIndex);

				String[] is = line.split(",");

				for (int j = 0; j < is.length; j++) {
					String str = is[j];
					size += str.length();
					if (str.equals("")) {
						continue;
					}
					int integer = Integer.valueOf(str);
					if (integer >= 0) {
						psize++;
						pbs.set(integer);
					} else {
						msize++;
						mbs.set(Math.abs(integer));
					}
				}

				System.out.println(size + "," + psize + "," + pbs.cardinality()
						+ "," + msize + "," + mbs.cardinality());
				// break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// System.out.println(bs);
		System.out.println("done .");
	}

	public static void main(String[] args) throws IOException {
		answer1();
		answer2();
	}
}
