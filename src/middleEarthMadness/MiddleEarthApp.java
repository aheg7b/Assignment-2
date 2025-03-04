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
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
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
			case 3: updateCharacter(); break;
			case 4: deleteCharacter(); break;
			default: System.out.println(ANSI_RED + "Invalid choice..." + ANSI_RESET);
			}
		}
	}
	
	private void deleteCharacter() {
		String name = getStringInput("Character to delete: ");
		MiddleEarthCharacter character = manager.getCharacter(name);
		if(character != null && manager.deleteCharacter(character)) {
			System.out.println(ANSI_GREEN + "Character Deleted!" + ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "Charcter Deletion Failed..." + ANSI_RESET);
		}
		
	}

	private void updateCharacter() {
		String name = getStringInput("\nCharacter to update: ");
		MiddleEarthCharacter character = manager.getCharacter(name);
		
		if(character == null) {
			System.out.println(ANSI_RED + "Character Not Found..." + ANSI_RESET);
			return;
		}
		double newHealth = getDoubleInput("New Health (" + character.getHealth() + "):");
		double newPower = getDoubleInput("New Power (" + character.getPower() + "):");
		
		if(manager.updateCharacter(character, name, newHealth, newPower)) {
			System.out.println(ANSI_GREEN + "\nCharacter Updated!" + ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "No Changes Made!" + ANSI_RESET);
		}
		
	}

	/**
	 * Method to display all characters
	 */
	private void displayCharacters() {
		System.out.println(ANSI_YELLOW + "\n~~~~ All Active Characters ~~~~" + ANSI_RESET);
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
			System.out.println(ANSI_GREEN + "Character created!" + ANSI_RESET);
		} else {
			System.out.println(ANSI_RED + "Character Creation Failed..." + ANSI_RESET);
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
				System.out.println(ANSI_RED + "Invalid number..." + ANSI_RESET);
			}
		}
	}

	private double getDoubleInput(String string) {
		while(true) {
			try {
				System.out.print(string);
				return Double.parseDouble(scanner.nextLine());
			} catch(NumberFormatException e) {
				System.out.println(ANSI_RED + "Invalid Choice..." + ANSI_RESET);
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