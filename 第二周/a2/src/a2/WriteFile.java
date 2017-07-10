package a2;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
    //写文档
public class WriteFile {
	//FileWriter is meant for writing streams of characters. For writing streams of raw bytes, consider using a FileOutputStream.
	private static FileWriter fileWriter;
    //写文档，参数为路径和新建文档的名字
	public static void WriteTxtFile(String filepath, String name) throws IOException {
		File file = new File(filepath, name);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		fileWriter = new FileWriter(file.getPath());
		for (int i = 1; i <= 10000; i++) {
			if (TestPrime(i)) {
				fileWriter.write(String.valueOf(i) + "\n");
			}
		}
		fileWriter.close();
	}
    //判断素数，循环，进行了简化
	public static boolean TestPrime(int n) {
		if (n == 1)
			return false;
		else if (n == 2)
			return true;
		else if ((n % 2) == 0)
			return false;
		for (int i = 3; i <= (int) Math.sqrt((double) n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
    //主函数
	public static void main(String argv[]) throws IOException {
		WriteTxtFile("C:/Users/Zhou/Desktop/JAVA/a2/src/a2","b.txt");
	}
}
