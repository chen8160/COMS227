package lab3;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel2 {

	private int population;
	private int year;

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel2() {
		population = 0;
		year = 0;

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
		if (year%5 == 0){
			population = 0;
		}
		else{
			population ++;
		}
		year++;

	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		population = 0;

	}
}