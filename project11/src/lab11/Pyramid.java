package lab11;

import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int level = in.nextInt();
		System.out.println(getPyramidCount(level));
	}

	public static int getPyramidCount(int level){
		if(level == 1){
			return 1;
		}
		return Power.power(level, 2) + getPyramidCount(level - 1);
	}
}
