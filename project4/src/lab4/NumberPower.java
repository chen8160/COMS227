package lab4;

import java.util.Scanner;

public class NumberPower {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int first = getNumber(in);
		int second = getNumber(in);

		int result = (int) Math.pow(first, second);
		System.out.println(first + " ^ " + second + " = " + result);

	}

	public static int getNumber(Scanner in) {
		System.out.print("Enter a number: ");
		int next;
		if (in.hasNextInt())
		{
			next = in.nextInt();
			return next;
		}
		else
		{
			in.next();
			return 1;
		}
	
	}
}
