import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class PrepareTest1 {

	public static void write() {

		String fileName = "C:/test/review2.txt";
		File file = new File(fileName);

		// int num = Integer.MIN_VALUE;
		int num = Integer.MIN_VALUE / 2;
		StringBuilder sb = new StringBuilder();

		try (FileWriter fw = new FileWriter(file);) {
			while (num < Integer.MAX_VALUE) {
				if (num == 88888888) {
					num++;
					continue; // to check the not exists num is 88888888
				}
				sb.append(num).append(",");
				if (num % 10000000 == 0) {
					fw.write(sb.toString());
					System.out.println(num);
					// sb = new StringBuilder();
					sb.delete(0, sb.length());
				}
				num++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		long now = new Date().getTime();
		write();
		System.out.println(new Date().getTime() - now);
	}

}
