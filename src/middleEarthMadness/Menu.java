package middleEarthMadness;

public class Menu {
	
	/**
	 * used for colored terminal outputs
	 */
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	
	/**
	 * Methods for menu displays
	 */
	public static void displayMenu() {
		System.out.println(ANSI_YELLOW + "\n~~~~ Middle Earth Maddness ~~~~" + ANSI_RESET);
		System.out.println("1. Add New Character");
		System.out.println("2. View All Characters");
		System.out.println("3. Update Character");
		System.out.println("4. Delete Character");
		System.out.println("5. Execute All Attacks");
		System.out.println("6. Exit");
		System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
	}
	
	public static void displayRaces() {
		System.out.println(ANSI_YELLOW + "\n~~~~ Pick Your Race ~~~~" + ANSI_RESET);
		System.out.println("Human");
		System.out.println("Elf");
		System.out.println("Dwarf");
		System.out.println("Orc");
		System.out.println("Wizard");
		System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
		
	}
	
}
