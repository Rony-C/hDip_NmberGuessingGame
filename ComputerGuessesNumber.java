package ie.gmit.dip;

import java.util.Scanner;

public class ComputerGuessesNumber {

	private Scanner s;
	private final int MAX_GUESSES = 10;
	private int guessCounter = 0;
	private boolean notGuessed = true;

	public static void newLine() {
		System.out.println("");
	}

	public static void guessAgainText() {
		System.out.println("Hmmmm, let me guess again......");
	}

	public static void gameTitle() {
		System.out.println("##########################################");
		System.out.println("########## Number Guessing Game ##########");
		System.out.println("##########################################");
		newLine();
	}

	public static void gameRules() {
		System.out.println("############################################");
		System.out.println("### Enter 'Too high', 'Too low' or 'Yes' ###");
		System.out.println("############################################");
		newLine();
	}

	public void startGuessing(int minRange, int maxRange) {

		int computerGuess = ((maxRange - minRange) / 2 + minRange);

		while ((notGuessed == true) && (guessCounter < MAX_GUESSES)) {
			guessCounter++;
			System.out.println("Is your number " + computerGuess + " ?");
			String myInput = s.nextLine();

			if (guessCounter >= MAX_GUESSES) {
				System.out.println("You're out of guesses");
				return;
			} else if (myInput.equals("Yes")) {
				notGuessed = false;
				System.out.println("I win!");
			} else if (myInput.equals("Too high")) {
				newLine();
				guessAgainText();
				newLine();
				startGuessing(minRange, computerGuess);

			} else if (myInput.equals("Too low")) {
				newLine();
				guessAgainText();
				newLine();
				minRange = computerGuess;
				startGuessing(computerGuess, maxRange);
			} else {
				System.out.println("Invalid input try again.");
			}

		}
	}

	public ComputerGuessesNumber() {
		s = new Scanner(System.in);
	}

	public static void main(String[] args) {
		gameTitle();
		gameRules();
		new ComputerGuessesNumber().startGuessing(1, 100);
	}

}
