package lab2;

/**
 * Model of an atom.
 * 
 * @author yuxiangc
 * 
 */
public class Atom {
	/**
	 * Amount of protons.
	 */
	private int proton;
	/**
	 * Amount of neutrons.
	 */
	private int neutron;
	/**
	 * Amount of electrons.
	 */
	private int electron;

	/**
	 * Generate an atom with given amount of protons, neutrons and electrons.
	 * 
	 * @param givenProtons 
	 *            The amount of protons.
	 * @param givenNeutrons
	 *            The amount of neutrons.
	 * @param givenElectrons
	 *            The amount of electrons.
	 */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons) {
		proton = givenProtons;
		neutron = givenNeutrons;
		electron = givenElectrons;
	}
	/**
	 * Return the amount of the atomic mass.
	 * @return 
	 * the atomic mass.
	 */
	public int getAtomicMassNumber() {
		return proton + neutron;
	}

	/**
	 * Return the value of the atomic charge.
	 * @return
	 * the atomic charge.
	 */
	public int getAtomicCharge() {
		return proton - electron;
	}

	/**
	 * Decreases the number of protons by 2 and the number of neutrons by 2.
	 */
	public void decay(){
		proton = proton - 2;
		neutron = neutron - 2;
	}
}
