package ua.testov.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyTwoFiles {

	public CopyTwoFiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String readTextFromFile(File file) {
		String str = "";
		String strRes = "";
		try (BufferedReader f = new BufferedReader(new FileReader(file))) {
			for (; (str = f.readLine()) != null;) {
				strRes += str;
			}
		} catch (IOException e) {
			System.out.println("ERROR");
		}
		return strRes;
	}

	public static File writeTextToFile(String text, String path) {
		String t = path;
		File f = new File(t, "result.txt");
		try (PrintWriter a = new PrintWriter(f)) {
			a.println(text);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}
		return f;
	}

	public static int lengthOfTwoMass(String[] massOne, String[] massTwo) {
		int length = 0;
		if (massOne.length > massTwo.length) {
			length = massOne.length;
		} else {
			length = massTwo.length;
		}
		return length;
	}

	public static String convertMassToStr(String[] mass) {
		String res = "";
		for (String string : mass) {
			if (string == null) {
				res += "";
			} else {
				res += string;
				res += " ";
			}
		}

		return res;
	}

	public static File сopyTwoFiles(File oneFile, File twoFile) {
		String[] massOne = readTextFromFile(oneFile).split(" ");
		String[] massTwo = readTextFromFile(twoFile).split(" ");
		String[] massThree = new String[lengthOfTwoMass(massOne, massTwo)];
		for (int i = 0; i < massOne.length; i++) {
			for (int j = 0; j < massTwo.length; j++) {
				if (massOne[i].equals(massTwo[j])) {
					massThree[i] = massOne[i];
				}
			}
		}
		File file = writeTextToFile(convertMassToStr(massThree),
				oneFile.getAbsolutePath().substring(0, oneFile.getAbsolutePath().lastIndexOf(oneFile.getName())));
		return file;
	}
}
