package test.java.newfeatures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TestFileChannel {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("C:\\Users\\MANOJ\\Desktop\\TestFolder\\test.txt");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\MANOJ\\Desktop\\TestFolder\\sample.txt");
		FileChannel ifc = fis.getChannel();
		FileChannel ofc = fos.getChannel();
	}
}