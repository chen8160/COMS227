package hw1;

/**
 * This is a simple model of a coin-operated parking meter.
 * 
 * @author Yuxiang Chen
 * 
 */
public class ParkingMeter {
	/**
	 * Value of dime coin in cents.
	 */
	public static final int DIME_VALUE = 10;
	/**
	 * Value of nickel coin in cents.
	 */
	public static final int NICKEL_VALUE = 5;
	/**
	 * Value of quarter coin in cents.
	 */
	public static final int QUARTER_VALUE = 25;

	/**
	 * Number of minutes to be added for each nickel inserted.
	 */
	private int minutesForNickel;
	/**
	 * Number of minutes to be added for each dime inserted.
	 */
	private int minutesForDime;
	/**
	 * Number of minutes to be added for each quarter inserted.
	 */
	private int minutesForQuarter;
	/**
	 * Maximum amount of time that can be purchased.
	 */
	private int maxTime;
	/**
	 * Maximum number of coins that can be inserted.
	 */
	private int maxCoins;
	/**
	 * Number of coins currently contained in the parking meter.
	 */
	private int numOfCoins;
	/**
	 * Amount of minutes remaining.
	 */
	private int minutesRemaining;
	/**
	 * Number of quarters currently contained in the parking meter.
	 */
	private int numOfQuarter;
	/**
	 * Number of dime currently contained in the parking meter.
	 */
	private int numOfDime;
	/**
	 * Number of nickel currently contained in the parking meter.
	 */
	private int numOfNickel;

	/**
	 * It constructs a new ParkingMeter that is initially expired and contains
	 * no coins.
	 * 
	 * @param givenMinutesForNickel
	 *            number of minutes to be added for each nickel inserted
	 * @param givenMinutesForDime
	 *            number of minutes to be added for each dime inserted
	 * @param givenMinutesForQuarter
	 *            number of minutes to be added for each quarter inserted
	 * @param givenMaxTime
	 *            maximum amount of time that can be purchased
	 * @param givenMaxCoins
	 *            maximum number of coins that can be inserted
	 */
	public ParkingMeter(int givenMinutesForNickel, 
						int givenMinutesForDime,
						int givenMinutesForQuarter, 
						int givenMaxTime, 
						int givenMaxCoins) {
		
		minutesForNickel = givenMinutesForNickel;
		minutesForDime = givenMinutesForDime;
		minutesForQuarter = givenMinutesForQuarter;
		maxTime = givenMaxTime;
		maxCoins = givenMaxCoins;
		numOfCoins = 0;
		minutesRemaining = 0;
		numOfDime = 0;
		numOfNickel = 0;
		numOfNickel = 0;

	}

	/**
	 * Empties all coins from this meter, without modifying the remaining time.
	 */
	public void emptyCoins() {
		numOfDime = 0;
		numOfNickel = 0;
		numOfQuarter = 0;
		numOfCoins = 0;
	}

	/**
	 * Returns the total amount of money, in cents, contained in this meter.
	 * 
	 * @return the total amount of money, in cents, contained in this meter.
	 */
	public int getCents() {
		int totalMoneyInCent = numOfDime * DIME_VALUE + numOfNickel	* NICKEL_VALUE + numOfQuarter * QUARTER_VALUE;
		return totalMoneyInCent;
	}

	/**
	 * Returns a String representing the total amount of money in this meter as
	 * a dollar amount showing exactly two decimal places.
	 * 
	 * @return the total amount of money, in dollars, contained in this meter.
	 */
	public String getDollarString() {
		double totalDollars = (double) this.getCents() / 100;
		String result = String.format("%01.2f", totalDollars);
		return result;

	}

	/**
	 * Returns a String representing the time remaining on this meter in the
	 * form "hh:mm".
	 * 
	 * @return the remaining time of this meter in the form "hh:mm".
	 */
	public String getHourMinuteString() {
		int hours = minutesRemaining / 60;
		int minutes = minutesRemaining % 60;
		String result = String.format("%02d:%02d", hours, minutes);
		return result;

	}

	/**
	 * Returns the amount of time, in minutes, remaining on this meter.
	 * 
	 * @return the amount of time, in minutes, remaining on this meter.
	 */
	public int getMinutesRemaining() {
		return minutesRemaining;

	}

	/**
	 * Returns the number of coins currently in this meter.
	 * 
	 * @return tne number of coins currently in this meter.
	 */
	public int getTotalCoins() {
		return numOfCoins;

	}

	/**
	 * Insert dimes to the parking meter.
	 * 
	 * @param howMany
	 *            The amount of dimes inserted.
	 */
	public void insertDimes(int howMany) {
		howMany = this.insertCoinshelper(howMany);
		numOfDime = numOfDime + howMany;
		minutesRemaining = Math.min(minutesRemaining + howMany * minutesForDime, maxTime);

	}

	/**
	 * Insert nickels to the parking meter.
	 * 
	 * @param howMany
	 *            The amount of nickels inserted.
	 */
	public void insertNickels(int howMany) {
		howMany = this.insertCoinshelper(howMany);
		numOfNickel = numOfNickel + howMany;
		minutesRemaining = Math.min(minutesRemaining + howMany * minutesForNickel, maxTime);
	}

	/**
	 * Insert quarters to the parking meter.
	 * 
	 * @param howMany
	 *            The amount of quarters inserted.
	 */
	public void insertQuarters(int howMany) {
		howMany = this.insertCoinshelper(howMany);
		numOfQuarter = numOfQuarter + howMany;
		minutesRemaining = Math.min(minutesRemaining + howMany * minutesForQuarter, maxTime);
	}

	/**
	 * Returns true if there is no time remaining, false otherwise.
	 * 
	 * @return true if there is no time remaining, false otherwise.
	 */
	public boolean isExpired() {
		if (minutesRemaining > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Simulates the passage of time for the given number of minutes.
	 * 
	 * @param minutes
	 *            the time, in minutes, simulated to be spent.
	 */
	public void simulateTime(int minutes) {
		minutes = Math.max(0, minutes);
		minutesRemaining = Math.max(minutesRemaining - minutes, 0);
	}

	/**
	 * Returns a String representation of this object in exactly the following
	 * format: hw1.ParkingMeter [Time remaining/limit, Coins count/maxCoins,
	 * Value totalCents]
	 */
	public String toString() {
		String representationOfParkingMeter = String.format(
				"hw1.ParkingMeter [time %d/%d, coins %d/%d, value %d]",	minutesRemaining, maxTime, numOfCoins, maxCoins, this.getCents());
		return representationOfParkingMeter;
	}

	/**
	 * This is a helper method. It helps to count the total number of coins when
	 * coins are inserted into the meter. It also helps to limit the amount of
	 * coins in the proper range.
	 * 
	 * @param amountOfCoinsInserted
	 *            the amount of coins inserted.
	 * @return the actual amount of the coins inserted into the meter.
	 */
	private int insertCoinshelper(int amountOfCoinsInserted) {
		amountOfCoinsInserted = Math.min(amountOfCoinsInserted, maxCoins - numOfCoins);	//This statement helps make sure that the amount of coins doesn't exceed the max limitation.
		amountOfCoinsInserted = Math.max(0, amountOfCoinsInserted);						//This statement helps make sure that the amount of coins inserted is proper, not negative.
		numOfCoins = numOfCoins + amountOfCoinsInserted;
		return amountOfCoinsInserted;
	}

}
