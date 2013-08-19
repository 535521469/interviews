package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
	public static void main(String[] args) throws IOException {
		// String fileName = "d:/test/review2.txt";
		// File file = new File(fileName);
		// FileInputStream reader = new FileInputStream(file);
		// byte[] ins = new byte[1024];
		// StringBuilder sb = new StringBuilder();
		// Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();
		// int hasRead = 0;
		// try {
		// int i = 0;
		// while ((hasRead = reader.read(ins)) > 0) {
		// sb.append(new String(ins));
		// if (sb.charAt(sb.length() - 1) == ',') {
		// String[] ints = sb.toString().split(",");
		// System.out.println(sb.toString());
		// break;
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		StringBuilder sb = new StringBuilder();
		int i = Integer.MAX_VALUE;

		System.out.println(i);
		
		String x ="";
		System.out.println(x.split(",").length);

	}
}
