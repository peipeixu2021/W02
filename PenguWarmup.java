package pgdp.warmup;

public class PenguWarmup {

	protected PenguWarmup() {
		throw new UnsupportedOperationException();
	}

	public static void penguInfoOut(int penguin) {
		// TODO
		if (penguin < 0) {
			System.out.println("Penguin " + penguin + " is not a known penguin!");
		} else {
			System.out.println("Penguin: " + penguin);
			if (penguin % 2 == 0) {
				System.out.println("This penguin is a male.");
			} else {
				System.out.println("This penguin is a female.");
			}
		}
	}

	public static int penguEvolution(int penguin, int years) {
		// TODO
		int noEvoYears = 6;
		while (years > 0) {
			if (penguin % 2 == 0) {
				int ifPowerOfTwo = penguin & penguin - 1;
				if (ifPowerOfTwo == 0) {
					penguin = 1;
				} else {
					penguin = penguin / 2;
				}
			} else {
				if (penguin == 7 && noEvoYears > 0) {
					noEvoYears--;
				} else {
					noEvoYears = 6; //reset
					penguin = penguin*3 + 1;
				}
			}
			years--;
		}
		return penguin;
	}

	public static int penguSum(int penguin) {
		// TODO
		int sum = 0;
		int remainder;
		while (penguin > 0) {
			remainder = penguin % 10;
			sum += remainder;
			penguin = (penguin - remainder)/10;
		}
		return sum;
	}

	public static long penguPermutation(long n, long k) {
		// TODO
		long result = 1;
		while (n > k) {
			result*=n;
			n--;
		}
		return result;
	}

	public static long penguPowers(int x, int i) {
		// TODO
		long result =x;
		long addElement = x;
		int addTimes;
		if (i == 0) {
			return 1;
		}
		while(i > 0){
			if (i == 1) {
				addTimes = 1;
			} else {
				addTimes = x;
			}
			while (addTimes > 1) {
				result += addElement;
				addTimes--;
			}
			addElement = result;
			i--;
		};
		return result;
	}

	/*	Die Inhalte der main()-Methode beeinflussen nicht die Bewertung dieser Aufgabe
	 *	(es sei denn natürlich, sie verursachen Compiler-Fehler).
	 */
	public static void main(String[] args) {

		// Here is a place for you to play around :)

		//penguInfoOut(-99);
		//System.out.println(penguEvolution(9, 9));
		//System.out.println(penguSum(Integer.MAX_VALUE-1));
		//System.out.println(penguPermutation(21,19));
		System.out.println(penguPowers(0, 5));
	}

}
