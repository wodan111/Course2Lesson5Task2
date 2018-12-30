package ua.testov.test;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("f.txt");
		File l = new File("l.txt");
		System.out.println(CopyTwoFiles.сopyTwoFiles(f, l));
	}

}
