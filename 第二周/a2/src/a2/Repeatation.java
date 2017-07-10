package a2;

import java.io.File;
import java.util.Vector;
     
public class Repeatation {
	//FileLists
	private static Vector<MyFile> fl = new Vector<MyFile>();
	//判断有无重复文件
	public static boolean isRepeat(MyFile file) {
		String fName = new String();
		int pos = file.getName().lastIndexOf('.');
		String fileName = (file.getName().substring(0, pos));
		for (MyFile f : fl) {
			pos = f.getName().lastIndexOf('.');
			fName = (f.getName().substring(0, pos));
			if (fName.equals(fileName) && f.getSize() == file.getSize() && f.getPath() != file.getPath()) {
				return true;
			}
		}
		return false;
	}
    //遍历所有文件
	public static void AllFiles(File dir) throws Exception {
		//File[] java.io.File.listFiles()  Returns an array of abstract pathnames denoting the files in the directory denoted by this abstract pathname. 
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			//boolean java.io.File.isDirectory() Tests whether the file denoted by this abstract pathname is a directory. 
			if (!fs[i].isDirectory())
				fl.add(new MyFile(fs[i].getAbsolutePath(), fs[i].getName()));
			if (fs[i].isDirectory()) {
				AllFiles(fs[i]);
			}
		}
	}
    //主函数
	public static void main(String[] args) throws Exception {
		File root = new File(args[0]);
		boolean rep = false;
		AllFiles(root);
		for (MyFile f : fl) {
			if (isRepeat(f)) {
				rep = true;
				System.out.println(f.getPath() + " " + f.getName());
			}
		}
		if (!rep)
			System.out.println("没有重复文件");
	}

}
