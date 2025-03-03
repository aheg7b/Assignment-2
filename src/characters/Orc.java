package characters;

/**
 * Orc character in Middle Earth
 * 
 * Inherits from the abstract MiddleEarthCharacter class and implements the attack and getRace methods
 *  
 * Variables:
 * - name: String - The name of the character from MiddleEarthCharacter
 * - health: double - The health of the character from MiddleEarthCharacter
 * - power: double - The power of the character from MiddleEarthCharacter
 * 
 * Methods:
 * - attack: Overrides the attack method to handle attack behavior for the Orc
 * - getRace: Returns the race of the character
 */

public class Orc extends MiddleEarthCharacter {
	public Orc(String name, double health, double power) {
		super(name, health, power);
	}
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Orc || target instanceof Elf) {
			return false;
		}else if (target instanceof Human) {
			target.setHealth(target.getHealth()-(1.5*this.power));
		}else {
			target.setHealth(target.getHealth()-this.power);
		}
		return true;
	}
	@Override
	public String getRace() {
		return "Orc";
	}
}
