package lab7;

import java.awt.Point;

import plotter.PolylinePlotter;

public class TestPlotter {
	public static void main(String[] args) {
		PolylinePlotter plotter = new PolylinePlotter();

		// make a red square using default line width of one pixel
		plotter.startLine("red", new Point(100, 100));
		plotter.addPoint(new Point(200, 100));
		plotter.addPoint(new Point(200, 200));
		plotter.addPoint(new Point(100, 200));
		plotter.addPoint(new Point(100, 100));
		
		// make a blue triangle with a line width of 2 pixels
		plotter.startLine("blue", new Point(250, 100), 2);
		plotter.addPoint(new Point(400, 350));
		plotter.addPoint(new Point(100, 350));
		plotter.addPoint(new Point(250, 100));

		// make some green zig-zags with a thick line
		plotter.startLine("green", new Point(100, 400), 6);
		plotter.addPoint(new Point(200, 450));
		plotter.addPoint(new Point(300, 400));
		plotter.addPoint(new Point(400, 450));

	}
}