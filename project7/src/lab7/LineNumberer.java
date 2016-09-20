package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineNumberer {
	public static void main(String[] args) throws FileNotFoundException {
		File c = new File("src/lab7/LineNumberer.java");
		Scanner scanner = new Scanner(c);
		int lineCount = 1;
		File a = new File("LineNumberer.txt");
		PrintWriter b = new PrintWriter(a);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			b.print(lineCount + " ");
			b.println(line);
			lineCount += 1;
		}
		b.close();
		scanner.close();
	}
}