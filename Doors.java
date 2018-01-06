
/**
 * @author Muhammad Fiaz and Sharod Celestin
 *The door class is used to create the connection between rooms, so the player can enter from one room to another.
 */
public class Doors {
	
	
	
	
	/**The constructor uses 
	 * @param r1 to create the room which will connect to
	 * @param r2
	 * @param d1  is use to assign the direction to the door in a room.
	 */
	public Doors(Rooms r1, Rooms r2,String d1) {
		this.direction1= d1;
		
		this.room1=r1;
		this.room2=r2;

}
	
	/**private fields for the direction of the door and two rooms which will be connected to each other.
	 * 
	 */
	private String direction1;
	private Rooms room1;
	private Rooms room2;
	
	public void add(Rooms r, String d) {
		// TODO Auto-generated method stub
		
	}
	
	/**A boolean method which uses
	 * @param d to check if the door is in the direction of a player. If it is in the direction of the player than it 
	 * @return true otherwise, it @return false.
	 */
	public boolean equalDirection(String d)	{
		
		if (direction1.equals(d)) {
			return true;
		}
		else {
				return false;
			}
		
		
	}
	/**A getter for the second room which will
	 * @return the second room. It's also being used as a pass through method in a room class.
	 */
	public synchronized Rooms getRoom() {
		 return this.room2;
	}
	}
