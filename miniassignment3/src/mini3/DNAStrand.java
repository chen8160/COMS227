package mini3;

public class DNAStrand {
	// instances
	private String data;

	// constructor
	public DNAStrand(String givenData) {
		data = givenData;
	}

	// methods
	public int countMatchesWithLeftShift(DNAStrand other, int shift) {
		String space = ""; // Could use help method
		int count = 0;
		for (int i = 0; i < shift; i++) {
			space += " ";
		}
		String modifiedData = space + data;
		for (int i = 0; i < Math.min(modifiedData.length(), other.toString().length()); i++) {
			if (modifiedData.charAt(i) == 'A' && other.toString().charAt(i) == 'T'
					|| modifiedData.charAt(i) == 'T' && other.toString().charAt(i) == 'A'
					|| modifiedData.charAt(i) == 'C' && other.toString().charAt(i) == 'G'
					|| modifiedData.charAt(i) == 'G' && other.toString().charAt(i) == 'C') {
				count++;
			}
		}
		return count;
	}

	public int countMatchesWithRightShift(DNAStrand other, int shift) {
		String space = ""; // Could use help method
		int count = 0;
		for (int i = 0; i < shift; i++) {
			space += " ";
		}
		String modifiedOther = space + other.toString();
		for (int i = 0; i < Math.min(data.length(), modifiedOther.length()); i++) {
			if (data.charAt(i) == 'A' && modifiedOther.charAt(i) == 'T'
					|| data.charAt(i) == 'T' && modifiedOther.charAt(i) == 'A'
					|| data.charAt(i) == 'C' && modifiedOther.charAt(i) == 'G'
					|| data.charAt(i) == 'G' && modifiedOther.charAt(i) == 'C') {
				count++;
			}
		}
		return count;
	}

	public DNAStrand createComplement() {
		String complement = "";
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == 'A') {
				complement += 'T';
			} else if (data.charAt(i) == 'T') {
				complement += 'A';
			} else if (data.charAt(i) == 'C') {
				complement += 'G';
			} else {
				complement += 'C';
			}
		}
		DNAStrand complementDNA = new DNAStrand(complement);
		return complementDNA;
	}

	public String findMatchesWithLeftShift(DNAStrand other, int shift) {
		String result = "";
		String space = ""; // Could use help method
		for (int i = 0; i < shift; i++) {
			space += " ";
		}
		String modifiedData = space + data;
		for (int i = 0; i < modifiedData.length(); i++) {
			if (i >= other.length()) {
				result += ("" + modifiedData.charAt(i)).toLowerCase();
			} else if (modifiedData.charAt(i) == ' ') {
				continue;
			} else if (modifiedData.charAt(i) == 'A' && other.toString().charAt(i) == 'T'
					|| modifiedData.charAt(i) == 'T' && other.toString().charAt(i) == 'A'
					|| modifiedData.charAt(i) == 'C' && other.toString().charAt(i) == 'G'
					|| modifiedData.charAt(i) == 'G' && other.toString().charAt(i) == 'C') {
				result += modifiedData.charAt(i);
			} else {
				result += ("" + modifiedData.charAt(i)).toLowerCase();
			}
		}

		return result;
	}

	public String findMatchesWithRightShift(DNAStrand other, int shift) {
		String result = "";
		String space = ""; // Could use help method
		for (int i = 0; i < shift; i++) {
			space += " ";
		}
		String modifiedOther = space + other;
		for (int i = 0; i < data.length(); i++) {
			if (i >= modifiedOther.length()) {
				result += ("" + data.charAt(i)).toLowerCase();
			} else if (data.charAt(i) == 'A' && modifiedOther.charAt(i) == 'T'
					|| data.charAt(i) == 'T' && modifiedOther.charAt(i) == 'A'
					|| data.charAt(i) == 'C' && modifiedOther.charAt(i) == 'G'
					|| data.charAt(i) == 'G' && modifiedOther.charAt(i) == 'C') {
				result += data.charAt(i);
			} else {
				result += ("" + data.charAt(i)).toLowerCase();
			}
		}
		return result;
	}

	public int findMaxPossibleMatches(DNAStrand other) {
		int result = 0;
		String space = "";
		for (int i = 1; i < data.length(); i++) {
			space += " ";
		}
		DNAStrand modifiedOther = new DNAStrand(space + other);
		int runningTimes = data.length() + other.length() - 1;
		for (int i = 0; i < runningTimes; i++) {
			result = Math.max(result,
					countMatchesWithLeftShift(modifiedOther, i));
		}
		return result;
	}

	public boolean isValid() {
		int validCount = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == 'A' || data.charAt(i) == 'T'
					|| data.charAt(i) == 'C' || data.charAt(i) == 'G') {
				validCount++;
			}
		}
		if (validCount == data.length()) {
			return true;
		}
		return false;
	}

	public int length() {
		return data.length();
	}

	public int letterCount(char ch) {
		int count = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}

	public boolean matches(char c1, char c2) {
		if (c1 == 'A' && c2 == 'T' || c1 == 'T' && c2 == 'A' || 
				c1 == 'C' && c2 == 'G' || c1 == 'G' && c2 == 'C') {
			return true;
		}
		return false;
	}

	public String toString() {
		return data;
	}

}
