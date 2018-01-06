import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * @author Muhammad Fiaz and Sharod Celestin
 *The player inherits character class. This class is being used to generate and perform actions on a player object.
 */
public class Players extends Character {

	
	/**The constructor uses
	 * @param aName
	 * @param aLocation to get the name and location of the player. The  @param aName @param aLocation
	 * are inherited from the super class character. A new array list of Items is also build in constructor where the player stores it's inventory items.
	 */
	public Players(String aName, Rooms aLocation) {
		super(aName, aLocation);
		this.Inventoryitems = new ArrayList<Items>();
	}

	
	/**A getter method for the items in player inventory. The method
	 * @return the items that are present in player inventory list.
	 */
	public ArrayList<Items> getitemsfromplayerinventory() {
		return Inventoryitems;
	}

	/**A setter method for the items in player inventory. The method uses
	 * @param item to store the items of player inventory.
	 */
	public void setitemsinplayersinventory(Items item) {
		Inventoryitems.add(item);

	}

	public String playername() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see Entities#setLocation(Rooms)
	 * 
	 */
	public void setLocation(Rooms aLocation) {
		this.location = aLocation;
	}
	
	/**A getter for the player location and room description. This method
	 * @return the location of the player and the room description and the items from the roomItems.
	 */
	public String getLocationPlayer() {
		return location.getRoomDescription() + "\n" + " There is a item " + location.showitems();
	}
	/**This method 
	 * @return the items that are present in a room location of a player.
	 */
	public ArrayList<Items> showroomitems() {
		return location.showroomitem();
	}

	/**This method finds the item in a player inventory. It uses
	 * @param itemtofindinplayerinventory to find the specific item in a players inventory and if the item is present then it 
	 * @return the inventory list by removing that specific item otherwise it doesn't @return anything.
	 */
	public Items findPlayerItem(String itemtofindinplayerinventory) {
		for (int i = 0; i < Inventoryitems.size(); i++) {
			if (Inventoryitems.get(i).getItemName().equals(itemtofindinplayerinventory)) {
				return Inventoryitems.remove(i);
			}
		}
		return null;
	}

	/**This method uses
	 * @param i to find the item from room and stores it into the player inventory list.
	 */
	public String pickupitem(String i) {
		
		Items item = location.findIteminroom(i);
		if(item == null) {
		     return "this item is not in the room";
		     
	} 
		else {
			Inventoryitems.add(item);
			return item.getItemName();
		}
		
		
	  
	
		
	
}
	/**This method 
	 * @return the items from player inventory.
	 */
	public String showinventory() {
		   String items = "";
			for(int i= 0; i<Inventoryitems.size();i++) {
			 items += 	Inventoryitems.get(i).getItemName();
			 System.out.println();
			}
			return items;
		}
	
	/**This method uses
	 * @param d to find the item from players inventory list and stores it into the items list in room class.
	 */
	public String dropitem(String d) {
		Items item = findPlayerItem(d);
		if (item == null) {
			return "this item is not in player inventory";
		}
		else
			location.setIteminroom(item);
		    return item.getItemName();
	}
	/**A pass through method which
	 * @return the image of room at player location.
	 */
	public ImageIcon getIcon() {
		return location.getimage();
	}

	/* (non-Javadoc)
	 * @see Character#move(java.lang.String)
	 * Further more, this method uses findDoor method to find a door to another room. If the door is present, then the player moves to 
	 * the next room, Otherwise, it prints out "no room".
	 */
	public void move(String d) {
		Rooms newRoom = location.findDoor(d);
		if (newRoom == null) {
			System.out.println();
		} else {
			Rooms prev = this.location;
			this.setLocation(newRoom);
			prev.removeplayerfromtheroom(this);
			newRoom.addplayerintotheroom(this);
			setChanged();
			notifyObservers();
		
	}
	}
	/**This method 
	 * @return the number of mobs that are present in the room.
	 */
	public synchronized ArrayList<Mobs> getmobsfromroom(){
		return location.getmobs();
	}
	/**This method
	 * @return the location of the player.
	 */
	public ArrayList<Players> getplayerfromroom(){
		return location.getplayers();
	}
	
	/**An arraylist field for the items in player inventory.
	 * 
	 */
	private ArrayList<Items> Inventoryitems;
	
}
