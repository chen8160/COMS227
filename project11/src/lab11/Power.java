package lab11;

import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int pow = in.nextInt();
		System.out.println(power(num, pow));
	}
	
	public static int power(int num, int pow){
		if(pow == 0){
			return 1;
		}
		return num * power(num, pow - 1);
	}

}
