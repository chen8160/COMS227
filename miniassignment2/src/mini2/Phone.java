package mini2;

/**
 * Model of a phone. A phone has a state, which is represented by the constants
 * READY, DIALING, WAITING, CONNECTED, DISCONNECTED. It also has a string
 * representing a phone number currently being entered, and a counter for
 * minutes of talking for the current call.
 */
public class Phone {
	/**
	 * Constant indicating READY state. In the READY state the minutes are
	 * always zero and the display string is an empty string. The keyPress()
	 * method transitions the phone into the DIALING state and adds the entered
	 * digit to the display string.
	 */
	public static final int READY = 0;

	/**
	 * Constant indicating DIALING state. Additional digits can be added to the
	 * display string with the keyPress() method. The call() method transitions
	 * the phone into the WAITING state, if the number is valid, or the
	 * DISCONNECTED state, if the number is invalid. The hangUp() method
	 * transitions the phone to the DISCONNECTED state.
	 */
	public static final int DIALING = 1;

	/**
	 * Constant indicating WAITING state. The answer() method transitions the
	 * phone into the CONNECTED state and adds 1 to the minutes. The noAnswer()
	 * or the hangUp() methods transition the phone into the DISCONNECTED state.
	 */
	public static final int WAITING = 2;

	/**
	 * Constant indicating CONNECTED state. In the CONNECTED state, the talk()
	 * method adds 1 to the minutes. The hangUp() method transitions the phone
	 * into the DISCONNECTED state.
	 */
	public static final int CONNECTED = 3;

	/**
	 * Constant indicating DISCONNECTED state. In the DISCONNECTED state the
	 * display string continues to show the digits that were dialed prior to
	 * reaching this state. If this state was reached from the CONNECTED state,
	 * getMinutes() will show the minutes for the call. The clear() method
	 * transitions the phone into the READY state and clears the display string
	 * and minutes.
	 */
	public static final int DISCONNECTED = 4;

	/**
	 * Number of digits in a valid phone number.
	 */
	private int requiredDigits;

	/**
	 * Current state of this phone.
	 */
	private int state;

	/**
	 * Display string for digits dialed using the keyPress() method.
	 */
	private String digitsDialed;

	/**
	 * Number of minutes of current call.
	 */
	private int minutes;
	
	/**
	 * Constructs a new phone for which a valid phone number has the given
	 * number of digits. The phone is initially in the ready state.
	 * 
	 * @param givenRequiredDigits
	 *            number of digits in a valid phone number
	 */
	public Phone(int givenRequiredDigits) {
		requiredDigits = givenRequiredDigits;
		state = READY;
		digitsDialed = "";

	}

	/**
	 * Returns the current state of this phone as one of the strings "READY",
	 * "DIALING", "WAITING", "CONNECTED", or "DISCONNECTED".
	 * 
	 * @return state of the phone as a string
	 */
	public String getstate() {
		String currentState =null;
		if (state == 0) {
			currentState = "READY";
		} 
		else if (state == 1) {
			currentState = "DIALING";
		} 
		else if (state == 2) {
			currentState = "WAITING";
		} 
		else if (state == 3) {
			currentState = "CONNECTED";
		} 
		else if (state == 4) {
			currentState = "DISCONNECTED";
		}
		return currentState;
	}

	/**
	 * Returns a string containing the digits that have been dialed so far.
	 * 
	 * @return string of digits dialed so far
	 */
	public String getDigits() {
		return digitsDialed;
	}

	/**
	 * Returns the number of minutes for the current call. This value is zero in
	 * the READY, DIALING, or WAITING states.
	 * 
	 * @return number of minutes for current call
	 */
	public int getMinutes() {
		if (state == 3 || state == 4) {
			return minutes;
		} 
		else {
			return 0;
		}
	}

	/**
	 * Adds another digit to the phone number on the display. Has no effect if
	 * the given number is outside the range 0 through 9. If state is READY,
	 * phone switches to state DIALING. Has no effect if state is anything other
	 * than READY or DIALING.
	 * 
	 * @param digit
	 *            digit to be added to the phone number being dialed
	 */
	public void keyPress(int digit) {
		if (digit >= 0 && digit < 10) {
			if (state == 0 || state == 1) {
				state = 1;
				digitsDialed = digitsDialed + digit;
			}
		}

	}

	/**
	 * Places a call to the phone number currently on the display. If the state
	 * is DIALING and the phone number is valid (has required number of digits),
	 * state changes to WAITING. If state is DIALING and the phone number is
	 * invalid, state changes to DISCONNECTED. Method has no effect if state is
	 * anything other than DIALING.
	 */
	public void call() {
		if (state == 1) {
			if (digitsDialed.length() == requiredDigits) {
				state = 2;
			} 
			else {
				state = 4;
			}
		}

	}

	/**
	 * Changes state to CONNECTED, provided that state is currently WAITING, and
	 * adds one to the minutes for the call. Method has no effect if state is
	 * anything other than WAITING.
	 */
	public void answer() {
		if (state == 2) {
			state = 3;
			minutes++;
		}

	}

	/**
	 * Increments minutes by one if state is currently CONNECTED. Method has no
	 * effect if state is anything other than CONNECTED.
	 */
	public void talk() {
		if(state == 3){
			minutes++;
		}
	}

	/**
	 * Changes state to DISCONNECTED if state is currently WAITING. Method has
	 * no effect if state is anything other than WAITING.
	 */
	public void noAnswer() {
		if(state == 2){
			state = 4;
		}
		
	}

	/**
	 * Changes state to DISCONNECTED if current state is anything other than
	 * READY. Method has no effect if state is READY.
	 */
	public void hangUp() {
		if(state != 0){
			state = 4;
		}
	}

	/**
	 * Sets state to READY and clears the minutes and the display string,
	 * provided that current state is DISCONNECTED.
	 */
	public void clear() {
		if(state == 4){
			state = 0;
			minutes = 0;
			digitsDialed = "";
		}
	}

}