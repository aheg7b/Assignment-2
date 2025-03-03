package characters;

/**
 * Human character in Middle Earth
 * 
 * Inherits from the abstract MiddleEarthCharacter class and implements the attack and getRace methods
 *  
 * Variables:
 * - name: String - The name of the character from MiddleEarthCharacter
 * - health: double - The health of the character from MiddleEarthCharacter
 * - power: double - The power of the character from MiddleEarthCharacter
 * 
 * Methods:
 * - attack: Overrides the attack method to handle attack behavior for the Human
 * - getRace: Returns the race of the character
 */
public class Human extends MiddleEarthCharacter {
	public Human(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Orc || target instanceof Human) {
            return false; // Ineffective attack
        } else if (target instanceof Wizard) {
            target.setHealth(target.getHealth() - (1.5 * this.power)); // 1.5× damage
        } else {
            target.setHealth(target.getHealth() - this.power); // Normal damage
        }
        return true;
    }

    @Override
    public String getRace() {
        return "Human";
    }

}
