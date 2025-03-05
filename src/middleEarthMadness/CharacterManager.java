package middleEarthMadness;
import characters.*;

/**
 * The CharacterManager class manages a collection of MiddleEarthCharacter objects
 * It allows adding, updating, deleting, retrieving, displaying, and executing attacks between characters
 * 
 * Variables:
 * - characters: MiddleEarthCharacter[] - array that stores the characters being managed
 * - size: int - The current number of characters in array
 * - INITIAL_CAPACITY: final int - The initial capacity of the character array defaults to 10
 * 
 * Methods:
 * - addCharacter: Adds a new character to the array and resizes as needed
 * - resizeArray: Doubles the size of the character array when the array is full
 * - getCharacter: Retrieves a character by name if none then null
 * - updateCharacter: Updates the health and power of a character
 * - deleteCharacter: Deletes a specified character from the array and shifts other elements to fill the gap
 * - displayAllCharacters: Displays information for all characters currently in manager
 * - executeAllAttacks: Executes attacks between all characters in manager
 * - getCharacterCount: returns the size of the character array
 */

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public CharacterManager() {
        this.characters = new MiddleEarthCharacter[INITIAL_CAPACITY];
        this.size = 0;
    }

    public boolean addCharacter(MiddleEarthCharacter c) {
        if (size == characters.length) {
            resizeArray();
        }
        characters[size++] = c;
        return true;
    }

    private void resizeArray() {
        MiddleEarthCharacter[] newArray = new MiddleEarthCharacter[characters.length * 2];
        System.arraycopy(characters, 0, newArray, 0, characters.length);
        characters = newArray;
    }

    public MiddleEarthCharacter getCharacter(String name) {
        for (int i = 0; i < size; i++) {
            if (characters[i].getName().equalsIgnoreCase(name)) {
                return characters[i];
            }
        }
        return null;
    }

    public boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
        if (character != null) {
            character.setHealth(health);
            character.setPower(power);
            return true;
        }
        return false;
    }

    public boolean deleteCharacter(MiddleEarthCharacter character) {
        for (int i = 0; i < size; i++) {
            if (characters[i] == character) {
                System.arraycopy(characters, i + 1, characters, i, size - i - 1);
                characters[--size] = null;
                return true;
            }
        }
        return false;
    }

    public void displayAllCharacters() {
        if (size == 0) {
            System.out.println("No characters available.");
            return;
        }
        for (int i = 0; i < size; i++) {
            characters[i].displayInfo();
        }
    }
    
    public int getCharacterCount() {
    	return size;
    }

    public void executeAllAttacks() {
        if (size < 2) {
            System.out.println("Not enough characters to perform attacks.");
            return;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    characters[i].attack(characters[j]);
                }
            }
        }
        for(int i = size-1;i>=0; i--) {
        	if(characters[i].getHealth() <= 0) {
        		System.out.println(characters[i].getName() + " has fallen in battle!");
        		deleteCharacter(characters[i]);
        	}
        }
    }

}
