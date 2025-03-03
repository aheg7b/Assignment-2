package characters;

/**
 * Abstract class for character in Middle Earth
 * 
 * variables:
 * -name: String - characters name
 * -health: double - charachter's numerical value for health
 * -power: double - character's power in a numerical value
 */

public abstract class MiddleEarthCharacter {
	protected String name;
    protected double health;
    protected double power;

    public MiddleEarthCharacter(String name, double health, double power) {
        this.name = name;
        this.health = health;
        this.power = power;
    }

    public abstract boolean attack(MiddleEarthCharacter target);
    public abstract String getRace();

    public void displayInfo() {
        System.out.println("Name: " + name + ", Race: " + getRace() + ", Health: " + health + ", Power: " + power);
    }

    public String getName() { return name; }
    public double getHealth() { return health; }
    public double getPower() { return power; }
    public void setHealth(double health) { this.health = health; }
    public void setPower(double power) { this.power = power; }
}
