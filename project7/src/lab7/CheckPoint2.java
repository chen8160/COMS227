package lab7;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import plotter.PolylinePlotter;

public class CheckPoint2 {

	public static void main(String[] args) throws FileNotFoundException {
		PolylinePlotter plotter = new PolylinePlotter();
		File a = new File("hello.txt");
		Scanner scanner = new Scanner(a);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.trim().length() == 0 || line.startsWith("#")) {
				continue;
			}

			int pixels;
			String color;
			int x;
			int y;
			Scanner draw = new Scanner(line);
			if(draw.hasNextInt()){
				pixels = draw.nextInt();
				color = draw.next();
				x = draw.nextInt();
				y = draw.nextInt();
				plotter.startLine(color, new Point(x, y), pixels);
			} else{
				color = draw.next();
				x = draw.nextInt();
				y = draw.nextInt();
				plotter.startLine(color, new Point(x, y));
			}
			
			while(draw.hasNextInt()){
				x = draw.nextInt();
				y = draw.nextInt();
				plotter.addPoint(new Point(x, y));
			}
		}
		scanner.close();
	}

}
