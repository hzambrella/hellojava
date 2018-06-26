package testAndtry;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TestSystemIn {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String s = in.nextLine();
			System.out.println(s);
			String[] numStr = s.split(" ");
			Integer[] num = new Integer[numStr.length];
			for (int i = 0; i < num.length; i++) {
				try {
					num[i] = Integer.parseInt(numStr[i]);
				} catch (NumberFormatException ne) {
					ne.printStackTrace();
				}
			}
			//
			Arrays.toString(num);
			System.out.println(Arrays.binarySearch(num, 3));
		}
		// ctrl+z½áÊø
		in.close();
		// try {
		// PrintWriter pw=new PrintWriter("SystemIn.txt");
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public static <E> void printArray(E[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			E el = array[i];
			System.out.print(el);
			if (i != array.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]\n");
	}
}
