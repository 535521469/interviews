import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PrepareTest1 {

	public static void main(String[] args) throws IOException {
		String fileName = "d:/test/review3.txt";
		File file = new File(fileName);

		FileWriter fw = new FileWriter(file);

		Random r = new Random();
		long max = 400000L;
		StringBuilder sb = new StringBuilder();
		while (max > 0) {
			int maxx = 10000;
			while (maxx > 0) {
				sb.append(String.valueOf(r.nextInt())).append(",");
				maxx--;
			}
			fw.write(sb.toString());
			max--;
			System.out.println(max);
			sb = new StringBuilder();
		}

	}

}
