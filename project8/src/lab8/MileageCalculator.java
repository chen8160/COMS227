package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MileageCalculator {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<FillUp> a = helper();
		for(int i = 1; i < a.size(); i++){
			double MPG = (a.get(i).getOdometer() - a.get(i-1).getOdometer())/a.get(i).getGallons();
			System.out.println("Mileage " + i +": " + MPG);
		}
		

	}
	
	private static ArrayList<FillUp> helper() throws FileNotFoundException{
		ArrayList<FillUp> datas = new ArrayList<FillUp>();
		File data = new File("mileage.txt");
		Scanner scan = new Scanner(data);
		while(scan.hasNextLine()){
			FillUp a = new FillUp(scan.nextInt(), scan.nextDouble());
			datas.add(a);
		}
		scan.close();
		return datas;
	}

}
