package pgdp.casino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Casino {
    public static int player(CardDeck deck){
		System.out.println("Player cards:");
		int card;
		int cardNo = 0;
		int sum = 0;
		while (cardNo < 2) {
			card = deck.drawCard();
			cardNo++;
			System.out.println(cardNo + " : " + card);
			sum += card;
		}
		System.out.println("Current standing: " + sum);
		while (sum < 21) {
			System.out.println("(1) draw another card or (2) stay");
			int input = readInt();
			if (input == 1 ) {
				card = deck.drawCard();
				cardNo++;
				System.out.println(cardNo + " : " + card);
				sum += card;
				System.out.println("Current standing: " + sum);
			} else if (input == 2) {
				break;
			} else {
				System.out.println("What?!");
			}
		}
		return sum;
	}
	public static int dealer(CardDeck deck, int playerSum){
		System.out.println("Dealer cards:");
		int card;
		int cardNo = 0;
		int sum = 0;
		while (sum < 21 && sum <= playerSum) {//if dealer == player, dealer lose, player win
			card = deck.drawCard();
			cardNo++;
			System.out.println(cardNo + " : " + card);
			sum += card;
		}
		System.out.println("Dealer: " + sum);
		return sum;
	}
	public static int penguBlackJackRound(int finalToken, int betToken) {
		// Here is a card deck for your games :)
		// Remember for testing you can use seeds:
		// CardDeck deck = CardDeck.getDeck(420);
		CardDeck deck = CardDeck.getDeck();
		int playerSum = player(deck);
		if (playerSum > 21) {
			System.out.println("You lost " + betToken + " tokens.");
			finalToken -= betToken;
		} else if (playerSum == 21) {
			System.out.println("Blackjack! You won " + betToken*2 + " tokens.");
			finalToken += betToken*2;
		} else {
			int dealerSum = dealer(deck, playerSum);
			if (dealerSum > 21) {
				System.out.println("You won " + betToken + " tokens.");
				finalToken += betToken;
			} else {
				System.out.println("Dealer wins. You lost " + betToken + " tokens.");
				finalToken -= betToken;
			}
		}
		return finalToken;
	}

	public static String readString() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int readInt() {
		while (true) {
			String input = readString();
			try {
				return Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("This was not a valid number, please try again.");
			}
		}
	}

	public static void penguBlackJack() {
		System.out.println("Welcome to Pengu-BlackJack!");
		int initialToken = 1000;
		int finalToken = initialToken;
		while (true) {
			if (finalToken == 0) {
				System.out.println("Sorry, you are broke. Better Luck next time.");
				break;
			} else {
				System.out.println("(1) Start a game or (2) exit");
				int input = readInt();
				if (input == 1) {
					System.out.println("Your current balance: " + finalToken);
					while (true) {
						System.out.println("How much do you want to bet?");
						int betToken = readInt();
						if (betToken > 0 && betToken <= finalToken) {
							finalToken = penguBlackJackRound(finalToken, betToken);
							break;
						}
					}
				} else if (input == 2) {
					break;
				} else {
					System.out.println("What?!");
				}
			}
		}
		System.out.println("Your final balance: " + finalToken);
		if (finalToken > initialToken) {
			System.out.println("Wohooo! Ez profit! :D");
		} else {
			System.out.println("That's very very sad :(");
		}
		System.out.println("Thank you for playing. See you next time.");
	}

	public static void main(String[] args) {
		penguBlackJack();
	}
}
