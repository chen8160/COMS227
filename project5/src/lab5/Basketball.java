package lab5;

public class Basketball {
	double circumference;
	boolean isInflated;
	public Basketball(double givenCircumference) {
		circumference = givenCircumference;
		isInflated = false;
	}

	public boolean isDribbleable() {
		return isInflated;
	}

	public double getCircumference() {
		return circumference;
	}

	public void inflate() {
		isInflated = true;
	}
}
