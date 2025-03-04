package middleEarthMaddness;

public class MiddleEarthCouncil{
	private static MiddleEarthCouncil instance = new MiddleEarthCouncil();
	private CharacterManager characterManager;
	
	private MiddleEarthCouncil() {
		characterManager = new CharacterManager();
	}
	
	public static MiddleEarthCouncil getInstance() {
		return instance;
	}
	
	public CharacterManager getCharacterManager() {
		return characterManager;
	}
}