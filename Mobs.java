import java.util.ArrayList;
import java.util.Random;

/**
 * @author Muhammad Fiaz and Sharod Celestin
 * This class is being used to create and perform actions on Mobs. It extends the character class to get the name and location 
 * of mobs.
 *
 */
public class Mobs extends Character  {

	
	/**The
	 * @param aName takes the character(mob) name
	 * @param aLocation takes the location of character.
	 */
	public Mobs(String aName, Rooms aLocation) {
		super (aName , aLocation);
		this.location = aLocation;
		rand = new Random();
		dead = false;
	}
	/**This method is used to move mobs between rooms. It 
	 * @return the runnable thread for each mob unless if the mob is not dead. It moves the mobs to the new room after specific milliseconds.
	 */
	public synchronized Runnable movemobs() {
		return() -> {
			while(!dead) {
			System.out.println(this.name+"mob previous location "  + location.getName() +getmobname());
			Rooms newRoom = location.findRandomdoor();

			if(newRoom == null) {
				
			}else {
				Rooms prev = this.location;
				this.setLocation(newRoom);
				prev.removemobsfromroom(this);
				newRoom.addmobsintotheroom(this);
				setChanged();
				notifyObservers();
				System.out.println(this.dead+ this.name+"mob new location "  + newRoom.getName() +getmobname());
				try {
					Thread.sleep(rand.nextInt(5000) + 2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
		};
	}
	/**This method 
	 * @return the mob name.
	 */
	public synchronized String getmobname() {
		return name;
		
	}
	
	/**
	 * Method to kill the mob.
	 */
	public synchronized void kill() {
		
		dead = true;
	}
	private Random rand;
	private Boolean dead;
	
	}
	
	
	

