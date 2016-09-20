package lab3;


/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel5 {

	private int population;
	private int lastYear;
	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel5() {
		population = 1;
		lastYear = 1;

	}

	/**
	 * Returns the current number of rabbits.
	 * 
	 * @return current rabbit population
	 */
	public int getPopulation() {
		// returns a dummy value so code will compile
		return population;
	}

	/**
	 * Updates the population to simulate the passing of one year.
	 */
	public void simulateYear() {
		int store = population;
		population = population + lastYear;
		lastYear = store;

	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		population = 1;

	}
}