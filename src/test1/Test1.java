import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.BitSet;
import java.util.Date;

/**
 * <pre>
 * a file with integers which size is Integer.MAX_VALUE , about 4200000000 .
 * find a integer that not exist in the file 
 * require : 
 * 1. you have only 1G momery ? 
 * 2. what about 10M momery ?
 * answer: 
 * 1. use a 4200000000 length string , use it as bit array . in java , use BitSet 2. ?
 * </pre>
 * 
 * @author Administrator
 * 
 */
public class Test1 {

	public static void answer1() throws FileNotFoundException {

		long now = new Date().getTime();

		String fileName = "c:/test/review3.txt";
		File file = new File(fileName);
		FileInputStream reader = new FileInputStream(file);
		byte[] ins = new byte[1024];
		StringBuilder sb = new StringBuilder();

		// notice
		// must set the initial size , or see the BitSet.ensureCapacity() ,
		// when not enough size , the capacity will add to double capacity
		BitSet pbs = new BitSet(Integer.MAX_VALUE); // positive number
		BitSet mbs = new BitSet(Integer.MAX_VALUE); // negative number

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
					if (str.equals("")) {
						continue;
					}
					int integer = Integer.valueOf(str);
					if (integer >= 0) {
						pbs.set(integer);
					} else {
						mbs.set(Integer.MAX_VALUE + integer + 1);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		long pclear = pbs.nextClearBit(0);

		if (pclear > Integer.MAX_VALUE) {
			System.out.println("all plus integer in file ");
		} else {
			System.out.println(pclear + " ---pbs");
		}

		long mclear = mbs.nextClearBit(0);

		if (mclear <= Integer.MAX_VALUE + 1) {
			System.out.println("all minus integer in file ");
		} else {
			System.out.println(mclear - Integer.MAX_VALUE - 1 + " ---mbs");
		}
		System.out.println("done .");
		System.out.println("use : " + (new Date().getTime() - now));
	}

	public static void answer2() throws FileNotFoundException {

		String fileName = "c:/test/review3.txt";
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
		// answer2();
	}
}
