package a2;

import java.io.File;

public class MyFile {
	private String path;
	private String name;
	private long size;

	public MyFile() {
		super();
	}

	public MyFile(String path,String name) {
		super();
		this.path = path;
		this.name = name;
		File file = new File(path);
		this.size = file.length();
	}
	
	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}
	
	public long getSize(){
		return size;
	}
}
