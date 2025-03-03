package characters;

/**
 * Dwarf character in Middle Earth
 * 
 * Inherits from the abstract MiddleEarthCharacter class and implements the attack and getRace methods
 *  
 * Variables:
 * - name: String - The name of the character from MiddleEarthCharacter
 * - health: double - The health of the character from MiddleEarthCharacter
 * - power: double - The power of the character from MiddleEarthCharacter
 * 
 * Methods:
 * - attack: Overrides the attack method to handle attack behavior for the Dwarf
 * - getRace: Returns the race of the character
 */

public class Dwarf extends MiddleEarthCharacter {
	public Dwarf(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Dwarf || target instanceof Wizard) {
            return false; // Ineffective attack
        } else if (target instanceof Elf) {
            target.setHealth(target.getHealth() - (1.5 * this.power)); // 1.5× damage
        } else {
            target.setHealth(target.getHealth() - this.power); // Normal damage
        }
        return true;
    }

    @Override
    public String getRace() {
        return "Dwarf";
    }
}