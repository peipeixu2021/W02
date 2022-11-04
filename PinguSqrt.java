package pgdp.math;
import java.util.*;

public class PinguSqrt {

	public static void sqrt(double n) {
		if (n < 0) {
			System.out.println("Keine negativen Wurzeln!");
		} else {
			System.out.println("Wurzel aus " + n);
			System.out.println();
			long nTransformed = (long) (n*10000); //move decimal point
			ArrayList<Integer> zifferGruppeArray = new ArrayList<Integer>();
			for (int i = 0; nTransformed > 0; i++) {
				zifferGruppeArray.add((int) nTransformed % 100); //from last digits to first digits
				nTransformed = (nTransformed - zifferGruppeArray.get(i)) / 100;
			}
			if (zifferGruppeArray.size() == 0) {
				zifferGruppeArray.add(0);
			}
			int ergebnis = 0;
			int rest = 0;
			for (int i = zifferGruppeArray.size() - 1; i >= 0; i--) {
				ergebnis = ergebnis * 10;
				int ergebnisZiffer = 0;
				int minuend = rest*100 + zifferGruppeArray.get(i);
				System.out.println(minuend);
				System.out.println("--------");
				int subtrahend = ergebnis*2 + 1;
				while (minuend - subtrahend >=0) {
					minuend -= subtrahend;
					System.out.println("-" + subtrahend);
					ergebnisZiffer++;
					subtrahend += 2;
				}
				rest = minuend;
				System.out.println("--------");
				System.out.println("Rest: " + rest);
				System.out.println("neue Ergebnis Ziffer: " + ergebnisZiffer);
				System.out.println();
				ergebnis += ergebnisZiffer;
			}
            System.out.println("Ergebnis: " + (double) ergebnis/100);
		}
	}

	public static void main(String[] args) {
		// test your implementation here
		//sqrt(1);
		//sqrt(40005);
		//sqrt(0.0004);
		//sqrt(4.0);
		//sqrt(0);
		//sqrt(0.00001);
		//sqrt(1049.76);
		//sqrt(-100);
		//sqrt(Integer.MAX_VALUE);
//		if (Integer.MAX_VALUE * 10000 <= Long.MAX_VALUE) {
//			System.out.println("Good");
//		}
	}

}
