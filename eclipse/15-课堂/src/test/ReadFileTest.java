package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileTest {
	public static void main(String[] args) throws IOException {
		File file = new File("");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] b = new byte[1024];
		int read = 0;
		while(-1!=(read = fileInputStream.read(b))) {
			String string = new String(b,0,read);
			System.out.println(string);
		}
		
	}
}
