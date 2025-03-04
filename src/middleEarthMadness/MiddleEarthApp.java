package middleEarthMadness;

import java.util.Scanner;

public class MiddleEarthApp {
	private Scanner scanner = new Scanner(System.in);
	private CharacterManager manager;
	
	public static void main(String[] args) {
		MiddleEarthApp app = new MiddleEarthApp();
		app.run();
	}
	
	public MiddleEarthApp() {
		this.manager = MiddleEarthCouncil.getInstance().getCharacterManager();
	}
	
	private void run() {
		while(true) {
			displayMenu();
			int choice = getInput("Select: ");
			switch(choice) {
			case 1: createCharacter(); break;
			}
		}
	}
	
	private int getInput(String string) {
		while(true) {
			try {
				System.out.print(string);
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid number...");
			}
		}
	}

	private void createCharacter() {
		System.out.println("Creating Character!");
		
	}

	private void displayMenu() {
		System.out.println("1. Add new Character");
		System.out.println("2. Exit");
	}
}
/**
*Here I plan to build the actual funcionatlity of the app
*it will ask for inputs from the user to do all of the following
*1 add new character
*2 view all characters
*3 update characters
*4 delete characters
*5 attack eachother
*6 exit
*
*everything should be set up in the character manager and you just need to call each of the functions
*maybe use a case system?
*make sure it loops so that it all can run over and over again and again
*
*/