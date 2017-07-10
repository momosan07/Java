package a2;

import java.io.IOException;
import java.util.Vector;
import java.io.FileReader;
//读取文件
public class ReadFile {
    //FileReader is meant for reading streams of characters. For reading streams of raw bytes, consider using a FileInputStream.
	private static FileReader fileReader;
    //读取数据返回字符串s
	public static String readTxtFile(String filePath) throws IOException {
		//f 临时存放
		Vector<Character> f = new Vector<Character>();
		String s = new String();
		fileReader = new FileReader(filePath);
		int ch = 0;
		while ((ch = fileReader.read()) != -1) {
			if ((char) ch == '0' || (char) ch == '1')
				f.add((char) ch);
		}
		fileReader.close();
		for (char c : f)
			s += c;
		System.out.println();
		return s;
	}
    //矩阵中水平方向或者垂直方向或者斜线方向连续1最多的个数
	public static int getMost1(String filePath) throws IOException {
		String s = readTxtFile(filePath);
		//n应该为8，可拓展为任意方阵
		int n = (int) Math.sqrt(s.length());
		//水平、垂直、对角线
		int rowMax = 0, colMax = 0, diagonalMax = 0;
		char tab[][] = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tab[i][j] = s.charAt(i * n + j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			int cnt=0;
			int max=0;
			for (int j = 0; j < n; j++) {
				if(tab[i][j] == '1'){
					cnt++;
					max=Math.max(cnt, max);
				}
				else{
					cnt=0;
				}
			}
			rowMax = Math.max(rowMax, max);
		}
		
		for (int i = 0; i < n; i++) {
			int cnt=0;
			int max=0;
			for (int j = 0; j < n; j++) {
				if(tab[j][i] == '1'){
					cnt++;
					max=Math.max(cnt, max);
				}
				else{
					cnt=0;
				}
			}
			colMax = Math.max(colMax, max);
		}

		int diagonalMax1 = 0;
		for (int num = 0; num <= 2 * n; num++) {
			int cnt = 0;
			int max=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(i + j == num){
					if (tab[j][i] == '1'){
						cnt++;
						max=Math.max(cnt, max);
					}
					else{
						cnt=0;
					}
					}
				}
			}
			diagonalMax1 = Math.max(diagonalMax1, max);
		}
		
		int diagonalMax2 = 0;
		for (int num = -n; num <= n; num++) {
			int cnt = 0;
			int max=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(i - j == num){
					if (tab[i][j] == '1' ){
						cnt++;
					    max=Math.max(cnt, max);
				    }
				    else{
					    cnt=0;
			       	}
					}
				}
			}
			diagonalMax2 = Math.max(diagonalMax2, max);
		}
		diagonalMax = Math.max(diagonalMax1, diagonalMax2);
		return Math.max(Math.max(rowMax, colMax), diagonalMax);
	}
	//主函数，打印结果
	public static void main(String argv[]) throws IOException {
		String filePath = "C:/Users/Zhou/Desktop/JAVA/a2/src/a2/a.txt"; 
		int t = getMost1(filePath);
		System.out.println(t);
	}
}
