package a2;

import java.util.Scanner;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	private static FileWriter fileWriter;
	private static Map<String, String> map = new HashMap<String, String>();
	private static String path = "C:/Users/Zhou/Desktop/JAVA/a2/src/a2/Dictionary.txt";
    //��ӵ���
	public static void add(String word, String meanning) throws IOException {
		find(word);
		fileWriter = new FileWriter(path);
		if (map.equals(word)) {
			map.replace(word, meanning);
		} else {
			map.put(word, meanning);
		}
		fileWriter.write("");
		//����map���ѵ���д��path���ļ�����
		for (Object k : map.keySet()) {
			fileWriter.write(k + " " + map.get(k) + "\n");
		}
		fileWriter.close();
	}
    //Ѱ�ҵ���
	public static String find(String word) throws IOException {
		String node = new String();
		//Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines. 
		BufferedReader fileReader = new BufferedReader(new FileReader(path));
		String[] str = new String[2];
		//���ж�ȡ���ÿո�ָ�
		while ((node = fileReader.readLine()) != null) {
			str = node.split(" ");
			if (!map.equals(str[0]))
				map.put(str[0], str[1]);
		}
		return map.get(word);
	}

	@SuppressWarnings("resource")
	//������ ����Scanner java.util.Scanner.Scanner(InputStream source)����
	public static void main(String[] args) throws IOException {
		while (true) {
			System.out.println("1.��ӵ���");
			System.out.println("2.���ҵ���");
			System.out.println("0.�˳�");
			System.out.println("�����������:");
			Scanner p;
			p = new Scanner(System.in);
			String pos = p.nextLine();
			switch (pos) {
			case "1":
				Scanner word1;
				Scanner meaning;
				System.out.println("�����뵥�ʣ�");
				word1 = new Scanner(System.in);
				String words1 = word1.nextLine();
				System.out.println("��������ͣ�");
				meaning = new Scanner(System.in);
				String meanings = meaning.nextLine();
				add(words1, meanings);
				break;
			case "2":
				Scanner word2;
				System.out.println("�����뵥�ʣ�");
				word2 = new Scanner(System.in);
				String words2 = word2.nextLine();
				if (find(words2) == null)
					System.out.println("���Ҳ���");
				else
					System.out.println("����Ϊ:");
					System.out.println(find(words2));
				break;
			case "0":
				return;
			default:
				System.out.println("������˼���޷�ʶ�������!");
				break;
			}
		}
	}
}