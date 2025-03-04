package middleEarthMadness;

/**
 * Concrete class using the singleton design pattern to 
 * control access to character manager
 */

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance = new MiddleEarthCouncil();
	private CharacterManager characterManager;
	
	private MiddleEarthCouncil() {
		characterManager = new CharacterManager();
	}
	
	
	/**
	 * Gets instance
	 * @return Council instance
	 */
	public static MiddleEarthCouncil getInstance() {
		return instance;
	}
	
	
	/**
	 * Provides access to character manager
	 * @return Character manager instance
	 */
	public CharacterManager getCharacterManager() {
		return characterManager;
	}
}
