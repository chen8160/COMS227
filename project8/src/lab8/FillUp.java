package lab8;

/**
 * Data container for recording the odometer reading and gallons from filling up
 * the gas tank of a vehicle.
 */
public class FillUp {
	/**
	 * Odometer reading when the tank was filled.
	 */
	private final int odometer;

	/**
	 * Gallons needed to fill the tank.
	 */
	private final double gallons;

	/**
	 * Constructs a new FillUp object with the given data.
	 * 
	 * @param givenOdometer
	 *            odometer reading
	 * @param givenGallons
	 *            number of gallons
	 */
	public FillUp(int givenOdometer, double givenGallons) {
		odometer = givenOdometer;
		gallons = givenGallons;
	}

	/**
	 * Returns the odometer reading.
	 * 
	 * @return the odometer reading
	 */
	public int getOdometer() {
		return odometer;
	}

	/**
	 * Returns the number of gallons.
	 * 
	 * @return number of gallons
	 */
	public double getGallons() {
		return gallons;
	}
}