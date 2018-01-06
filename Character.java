
/**
 * @author Muhammad Fiaz and Sharod Celestin
 * this class is called Character which inherits the entities class. This class is being used to write the methods that are similar for mobs and
 * player class.
 *
 */
public class Character extends Entities {

	
	/**The constructor inherit
	 * @param aNames
	 * @param aLocations from the entities class. The @param aNames and @param aLocations 
	 * are inherited from entities and are being used to take the location and name of the character.
	 */
	public Character(String aNames, Rooms aLocations) {
		super(aNames,aLocations);
}
	/**This method  move the character from one room to another.
	 * 
	 */
	public void move() {
     Rooms r = this.getLocation();
	 this.setLocation(r);
}
}