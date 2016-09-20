package lab3;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel1 {

	private int population;
	
	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel1() {
		population = 2;

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
		population = population + 1;

	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		population = 2;

	}
}