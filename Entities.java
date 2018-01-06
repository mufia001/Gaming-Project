import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Muhammad Fiaz and Sharod Celestin
 *The class entities is a super class for character and Item (we will add the name of the items later). 
 *The class is used to create the fields for the name of the character and items.
 */

public class Entities extends Observable {

	
	/**The constructor uses
	 * @param aNames
	 * @param aLocations
	 * to get the name and location of character,rooms and items.
	 */
	public Entities (String aNames, Rooms aLocations) {
		name= aNames;
		location=aLocations;
		
	}
	
	
	/**This method uses
	 * @return to get the location of the room. It's a getter method for the room location.
	 */
	public Rooms getLocation() {
		return this.location;
		
	}
	

 /**This method uses
 * @param r  to set the location of the room. It's a setter method for room location
 */
public void setLocation(Rooms r) {
	 this.location = r;
}
	/**a protected is used for these fields because the other classes are inherited from this class. The other classes will use these fields 
	 * in their method.
	 * A protected field for room location and a string for the name.
	 * 
	 */
	protected String name;
	protected Rooms location;
	
	
}
