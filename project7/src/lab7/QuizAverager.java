package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizAverager {
	public static void main(String[] args) throws FileNotFoundException {
		int pointsPossible = 50;

		// open the file
		File file = new File("scores.txt");
		Scanner scanner = new Scanner(file);

		// while there are more lines...
		while (scanner.hasNextLine()) {
			// get the next line
			String line = scanner.nextLine();

			// process the line
			findAverage(line, pointsPossible);
		}

		// close the file
		scanner.close();
	}

	private static void findAverage(String line, int pointsPossible) {
		// construct a temporary scanner, just to read data from this line
		Scanner temp = new Scanner(line);

		// get the first and last name
		String first = temp.next();
		String last = temp.next();

		// add up all the scores
		double total = 0.0;
		while (temp.hasNextInt()) {
			int value = temp.nextInt();
			total += value;
		}

		// print the average
		double average = total / pointsPossible;
		System.out.println(first + " " + last + " " + average);
	}
}