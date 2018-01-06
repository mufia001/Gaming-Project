import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * @author Muhammmad Fiaz and Sharod Celestin.
 * The room class is to create room, add doors between rooms, add items in a room, and move players between rooms. 
 *
 */

public class Rooms {

	/**A constructor uses
	 * @param name to assign a name for a room
	 * @param description to describe the room.
	 * The array list of items and doors is also created in a constructor to add multiple items and doors.
	 * @param image is used to save the image of the room
	 */
	public Rooms(String name, String description,ImageIcon image) {
		
		this.doors=new ArrayList<Doors>();
		this.roomName=name;
		this.roomDescription=description;
        this.roomitems=new ArrayList<Items>();
        this.pictures = image;
        this.random = new Random();
        this.mob = new ArrayList<Mobs>();
        this.player = new ArrayList<Players>();
	}
/**A getter which will
 * @return all the list of doors present in rooms.
 */
public ArrayList <Doors> getDoors(){
	return doors;
}
/**A setter which uses 
 * @param doors to store all the doors present in the room.
 */
public void setDoors(ArrayList<Doors>doors) {
	this.doors=doors;
}
/**A getter which will 
 * @return all the items present in an array list of roomitems.
 */
public ArrayList<Items> getitemsfromroom(){
	return roomitems;
}
/**A setter which uses 
 * @param iteminroom to store all the items present in the array list of roomitems.
 */
public void setIteminroom(Items iteminroom) {
	roomitems.add(iteminroom);
}

/**A getter which 
 * @return the image of the room.
 */
public ImageIcon getimage() {
	return pictures;
}

/**A setter which uses
 * @param addpicture to store the image in a field of ImageIcon.
 */
public void setImage(ImageIcon addpicture) {
	this.pictures = addpicture;
}

/**A setter which uses
 * @param roomN to set the name of the room.
 */
public void setName(String roomN) {
	this.roomName=roomN;
}
/**A getter which will
 * @return the name of the room.
 */
public String getName() {
	return roomName;
}

/**A setter which uses
 * @param roomD to return the description of the room.
 */
public void setRoomDescription(String roomD) {
	this.roomDescription = roomD;
}
/**A getter which will 
 * @return the description of a room.
 */
public String getRoomDescription() {
	return roomDescription;
}

/**A method which add Door between two rooms by using 
 * @param r for the room and a
 * @param d to assign door direction .
 */
public synchronized void addDoor(Rooms r,String d) {
	    Doors doors = new Doors(this,r,d);
		this.doors.add(doors);
	}

/**A method which finds the item from the array list of roomitems by using
 * @param itemtofind to see if the given item matches the item present in a room. If it does matches the given item, then 
 * @return the array list of roomitems with the given item being removed from the list. If it doesn't matches then it doesn't @return
 * anything.
 */
public Items findIteminroom(String itemtofind) {
	for(int i=0;i<roomitems.size();i++) {
		if(roomitems.get(i).getItemName().equals(itemtofind)) {
			
			return roomitems.remove(i);
		}
	}
    return null;
}

/**This method uses 
 * @param d to add items into the arraylist of roomitems.
 */
public void addItem(Items d) {
	roomitems.add(d);
}


	/**This method finds the door in a room by using 
	 * @param d, equalDirection  method from the Doors class to find the door and it's direction. If the direction is right then it 
	 * @return a player into the next room by using the method getRoom from the door class otherwise, it doesn't return anything.
	 */
	public  Rooms findDoor(String d) {
		for(int i=0; i<doors.size();i++) {
			if(doors.get(i).equalDirection(d)) {
				return doors.get(i).getRoom();
			}
		}
		return null;
	}
	
	/**This method find a random door in a room and 
	 * @return it's location.
	 */
	public synchronized Rooms findRandomdoor() {
		System.out.println("doors "+doors.size());
		int index= random.nextInt(doors.size());
		return doors.get(index).getRoom();
	}
	

/**This method is used to 
 * @return the string of items from the arraylist.
 */
public String showitems() {
   String items = "";
	for(int i= 0; i<roomitems.size();i++) {
	 items += roomitems.get(i).getItemName();
	 System.out.println();
	}
	return items;
}
/**A getter which 
 * @return the list of items present in a room.
 */
public ArrayList<Items> showroomitem(){
	return roomitems;
}
	
/**This method uses
 * @param a to add the mobs into the room.
 */
public synchronized void addmobsintotheroom(Mobs a){
	 mob.add(a);
	 System.out.println(a.name+ " list after adding mob into the room" + this.roomName + mob);
}

/**This methos uses
 * @param r to remove the mobs from room.
 */
public synchronized void removemobsfromroom(Mobs r) {
	mob.remove(r);
	
	System.out.println(r.name+ " list after removing mob from the room  "+this.roomName+ mob );
}
	/**This method 
	 * @return the mobs that are present in the the room.
	 */
	public synchronized ArrayList<Mobs> getmobs(){
		return mob;
	}
	/**This method
	 * @return the players thqt are present in the room.
	 */
	public ArrayList<Players> getplayers(){
		return player;
	}
	/**This method
	 * @param a to add the player into the room.
	 */
	public void addplayerintotheroom(Players a) {
		player.add(a);
	}
	/**This method
	 * @param r to remove the player from the room.
	 */
	public void removeplayerfromtheroom(Players r) {
		player.remove(r);
	}
	/**This method uses
	 * @param i to kill the mob and removes the mob from that room.
	 */
	public synchronized void killMob(int i) {
		
		mob.get(i).kill();
		this.removemobsfromroom(mob.get(i));
	}
	
	/**Private field for the list of doors and room items. 
	 * Private field for the name and description of rooms in a room class.
	 * Private field for imageicon.
	 */
	private ArrayList<Doors> doors;
	private String roomDescription;
	private String roomName;
	private ArrayList<Items> roomitems;
	private ImageIcon pictures;
	private Random random;
	private ArrayList<Mobs> mob;
	private ArrayList<Players> player;
}
