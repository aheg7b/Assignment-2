package middleEarthMadness;

import java.awt.Choice;
import java.util.Scanner;

import characters.Dwarf;
import characters.Elf;
import characters.Human;
import characters.MiddleEarthCharacter;
import characters.Orc;
import characters.Wizard;

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
	
	/**
	 * loop to handle inputs and main menu navigation
	 */
	private void run() {
		while(true) {
			Menu.displayMenu();
			int choice = getIntInput("Select: ");
			switch(choice) {
			case 1: createCharacter(); break;
			case 2: displayCharacters(); break;
			default: System.out.println("Invalid choice...");
			}
		}
	}
	
	/**
	 * Method to display all characters
	 */
	private void displayCharacters() {
		System.out.println("~~~~ All Active Characters ~~~~");
		manager.displayAllCharacters();
	}
	
	
	/**
	 * Method used to create new characters based on user inputs
	 */
	private void createCharacter() {
		Menu.displayRaces();
		String race = getStringInput("Race: ");
		String name = getStringInput("Name: ");
		double health = getDoubleInput("Health: ");
		double power = getDoubleInput("Power: ");
		MiddleEarthCharacter character = switch(race.toLowerCase()) {
		case "human" -> new Human(name, health, power);
		case "elf" -> new Elf(name, health, power);
		case "dwarf" -> new Dwarf(name, health, power);
		case "orc" -> new Orc(name, health, power);
		case "wizard" -> new Wizard(name, health, power);
		default -> null;
		};
		
		if(character != null && manager.addCharacter(character)) {
			System.out.println("Character created!");
		} else {
			System.out.println("Character Creation Failed...");
		}
		
		
	}
	
	
	/**
	 * Methods for input handling
	 * @param string input prompt
	 * @return
	 */
	private int getIntInput(String string) {
		while(true) {
			try {
				System.out.print(string);
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid number...");
			}
		}
	}

	private double getDoubleInput(String string) {
		while(true) {
			try {
				System.out.print(string);
				return Double.parseDouble(scanner.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("Invalid Choice...");
			}
		}
	}

	private String getStringInput(String string) {
		System.out.print(string);
		return scanner.nextLine();
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