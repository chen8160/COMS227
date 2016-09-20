package lab8;

import java.util.Random;

public class Rand {
	public static void main(String[] args){
		Random a = new Random(0);
		for(int i = 0; i < 5; i++){
		System.out.println(a.nextInt(52));
		}
	}

}
