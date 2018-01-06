import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
/**
 * @author Muhammad Fiaz and sharod celestin 
 *       this class is called game which imports the objects and pass through methods that will be used throughout in the class UI
 */

public class Game {

	/**
	 * This constructor creates all of the objects and adds their extra features
	 * correspondingly such as a room having a door or item and mobs moving between rooms.
	 */
	
	
	Game(){
		
		items = new ArrayList<Items>();
		items.add(new Items("Knife", "Kill Something"));
		items.add(new Items("Gun","shoot something"));
		items.add(new Items("Candle","emits light"));
		items.add(new Items("Chair","sit in"));
		items.add(new Items("Table","to put stuff on"));
		items.add(new Items("Computer","to surf the web with"));
		items.add(new Items("phone", "item used to call people"));
		items.add(new Items("food","something you eat"));
		items.add(new Items("water","something you drink"));
		items.add(new Items("book","you read this"));
		items.add(new Items("charger","you use this on the phone to increase its battery"));
		items.add(new Items("sword","longer than a knife. Blade used to kill mobs"));
		items.add(new Items("helmet", "put on headfor more defense"));
		items.add(new Items("chestplate","put on chest for more defense"));
		items.add(new Items("iron boots","put on feet for more defense"));
		items.add(new Items("poster","can place on wall for decoration"));
		items.add(new Items("white flower","used for graves"));
		items.add(new Items("dirty container","used to store food, this looks unusable"));
		items.add(new Items("broom", "used for cleaning a room"));
		items.add(new Items("mp3Player","Plays music from the 90's"));
		rooms = new ArrayList<Rooms>();
		ImageIcon imageroom1 = new ImageIcon("roomimage1.jpg");
		ImageIcon imageroom2 = new ImageIcon("roomimage2.jpg");
		ImageIcon imageroom3 = new ImageIcon("room3.jpg");
		ImageIcon imageroom4 = new ImageIcon("room4.jpg");
		ImageIcon imageroom5 = new ImageIcon("room5.jpg");
		ImageIcon imageroom6 = new ImageIcon("room6.jpg");
		ImageIcon imageroom7 = new ImageIcon("room7.jpg");
		ImageIcon imageroom8 = new ImageIcon("room8.jpg");
		ImageIcon imageroom9 = new ImageIcon("room9.jpg");
		ImageIcon imageroom10 = new ImageIcon("room10.png");
		ImageIcon imageroom11 = new ImageIcon("room11.jpg");
		ImageIcon imageroom12 = new ImageIcon("room12.jpg");
		ImageIcon imageroom13 = new ImageIcon("room13.jpg");
		ImageIcon imageroom14 = new ImageIcon("room14.jpg");
		ImageIcon imageroom15 = new ImageIcon("room15.jpg");
		ImageIcon imageroom16 = new ImageIcon("room16.jpg");
		ImageIcon imageroom17 = new ImageIcon("room17.jpeg");
		ImageIcon imageroom18 = new ImageIcon("room18.jpeg");
		ImageIcon imageroom19 = new ImageIcon("room19.jpg");
		ImageIcon imageroom20 = new ImageIcon("room20.jpg");

		rooms.add(new Rooms("Room1","<html><body>You are in room 1. There is a room to the east.<br>Click 'move east' to enter that room.</body></html>", imageroom1));
		rooms.add(new Rooms("Room2","<html><body>You are in room 2. There is a room to the west and east.<br>Click 'move east' or 'move west' to enter that room.</body></html>",imageroom2));
		rooms.add(new Rooms("Room3","<html><body>You are in room 3. There is a room to the south.<br>Click 'move south' to enter that room.</body></html>", imageroom3));
		rooms.add(new Rooms("Room4","<html><body>You are in room 4. There is a room to the east.<br>Click 'move east' to enter that room.</body></html>",imageroom4));
		rooms.add(new Rooms("Room5","<html><body>You are in room 5. There is a room to the north.<br>Click 'move north' to enter that room.</body></html>", imageroom5));
		rooms.add(new Rooms("Room6","<html><body>You are in room 6. There is a room to the east.<br>Click 'move east' to enter that room.</body></html>",imageroom6));
		rooms.add(new Rooms("Room7","<html><body>You are in room 7. There is a room to the south.<br>Click 'move south' to enter that room.</body></html>", imageroom7));
		rooms.add(new Rooms("Room8","<html><body>You are in room 8. There is a room to the west.<br>Click 'move west' to enter that room.</body></html>",imageroom8));
		rooms.add(new Rooms("Room9","<html><body>You are in room 9. There is a room to the west.<br>Click 'move west' to enter that room.</body></html>", imageroom9));
		rooms.add(new Rooms("Room10","<html><body>You are in room 10.There is a room to the west.<br>Click 'move west' to enter that room.</body></html>",imageroom10));
		rooms.add(new Rooms("Room11","<html><body>You are in room 11.There is a room to the east.<br>Click 'move east' to enter that room.</body></html>", imageroom11));
		rooms.add(new Rooms("Room12","<html><body>You are in room 12.There is a room to the east.<br>Click 'move east' to enter that room.</body></html>",imageroom12));
		rooms.add(new Rooms("Room13","<html><body>You are in room 13. There is a room to the north.<br>Click 'move north' to enter that room.</body></html>", imageroom13));
		rooms.add(new Rooms("Room14","<html><body>You are in room 14. There is a room to the west.<br>Click 'move west' to enter that room.</body></html>",imageroom14));
		rooms.add(new Rooms("Room15","<html><body>You are in room 15. There is a room to the west.<br>Click 'move west' to enter that room.</body></html>", imageroom15));
		rooms.add(new Rooms("Room16","<html><body>You are in room 16. There is a room to the south.<br>Click 'move south' to enter that room.</body></html>",imageroom16));
		rooms.add(new Rooms("Room17","<html><body>You are in room 17. There is a room to the east.<br>Click 'move east' to enter that room.</body></html>", imageroom17));
		rooms.add(new Rooms("Room18","<html><body>You are in room 18. There is a room to the north.<br>Click 'move north' to enter that room.</body></html>",imageroom18));
		rooms.add(new Rooms("Room19","<html><body>You are in room 19. There is a room to the west.<br>Click 'move west' to enter that room.</body></html>", imageroom19));
		rooms.add(new Rooms("Room20","<html><body>You are in room 20. There is a room to the south.<br>Click 'move south' to enter that room.</body></html>",imageroom20));

		Rooms room1 = rooms.get(0);
		Rooms room2 = rooms.get(1);
		Rooms room3 = rooms.get(2);
		Rooms room4 = rooms.get(3);
		Rooms room5 = rooms.get(4);
		Rooms room6 = rooms.get(5);
		Rooms room7 = rooms.get(6);
		Rooms room8 = rooms.get(7);
		Rooms room9 = rooms.get(8);
		Rooms room10 = rooms.get(9);
		Rooms room11 = rooms.get(10);
		Rooms room12 = rooms.get(11);
		Rooms room13 = rooms.get(12);
		Rooms room14 = rooms.get(13);
		Rooms room15 = rooms.get(14);
		Rooms room16 = rooms.get(15);
		Rooms room17 = rooms.get(16);
		Rooms room18 = rooms.get(17);
		Rooms room19 = rooms.get(18);
		Rooms room20 = rooms.get(19);
		
		
		Items gun = items.get(1);
		Items candle = items.get(2);
		Items chair = items.get(3);
		Items table = items.get(4);
		Items computer = items.get(5);
		Items phone = items.get(6);
		Items food = items.get(7);
		Items water = items.get(8);
		Items book = items.get(9);
		Items charger = items.get(10);
		Items sword = items.get(11);
		Items helmet = items.get(12);
		Items chestplate = items.get(13);
		Items ironboots = items.get(14);
		Items poster = items.get(15);
		Items whiteflower = items.get(16);
		Items dirtycontainer = items.get(17);
		Items broom = items.get(18);
		Items mp3player = items.get(19);
		
		
		room1.addDoor(room2,"East");
		room2.addDoor(room1, "West");
		room2.addDoor(room3, "East");
		room3.addDoor(room4,"South");
		room4.addDoor(room5, "East");
		room5.addDoor(room6,"North");
		room6.addDoor(room7, "East");
		room7.addDoor(room8,"South");
		room8.addDoor(room9, "West");
		room9.addDoor(room10,"West");
		room10.addDoor(room11, "West");
		room11.addDoor(room12,"East");
		room12.addDoor(room13, "East");
		room13.addDoor(room14,"North");
		room14.addDoor(room15, "West");
		room15.addDoor(room16,"West");
		room16.addDoor(room17, "South");
		room17.addDoor(room18,"East");
		room18.addDoor(room19, "North");
		room19.addDoor(room20,"West");
		room20.addDoor(room1, "South");
		

		room1.addItem(candle);
		room2.addItem(gun);
		players = new ArrayList<Players>();
		uilist = new ArrayList<Userinterface>();
		
		players.add( new Players("Muhammad",room1));
		players.add(new Players("Sharod",room2));
		Players Muhammad = players.get(0);
		Players Sharod = players.get(1);
		Muhammad.setitemsinplayersinventory(chair);
        Sharod.setitemsinplayersinventory(book);
		mob = new ArrayList<Mobs>();
        	mob.add(new Mobs(("Mob1"),room1));
        mob.add(new Mobs(("Mob2"),room2));
        mob.add(new Mobs(("Mob3"),room3));
        mob.add(new Mobs(("Mob4"),room4));    
        mob.add(new Mobs(("Mob5"),room5));
		Mobs Mob1 = mob.get(0);
		Mobs Mob2 = mob.get(1);
		Mobs Mob3 = mob.get(2);
		Mobs Mob4 = mob.get(3);
		Mobs Mob5 = mob.get(4);
		 
		Runnable mobrunnable = Mob1.movemobs();
		Runnable mobrunnable2 = Mob2.movemobs();
		Runnable mobrunnable3 = Mob3.movemobs();
		Runnable mobrunnable4 = Mob4.movemobs();
		Runnable mobrunnable5 = Mob5.movemobs();

		service = Executors.newFixedThreadPool(5);
		service.execute(mobrunnable);
		service.execute(mobrunnable2);
		service.execute(mobrunnable3);
		service.execute(mobrunnable4);
		service.execute(mobrunnable5);
		service.shutdown();
		}
	
	
	/**
	 * a method to pick the item
	 * @param i 
	 * the player will pick up a specific item in the room depending on what they input as String i
	 */

	
	public String pickupitem(String i,Players player) {
		 return player.pickupitem(i);
	}
	/**
	 * the player will drop a certain item in his/her inventory
	 * @param d
	 *  giving what item the user wants to drop d will take that specific string and drop the corresponding item
	 */
	
	public String dropitem(String d, Players player) {
		return player.dropitem(d);
	}
	/**
	 * is a pass through method that allows the player to move
	 * @param direction 
	 * the player will move based on the string direction the user has inputed in a string.
	 */
	public void move(String direction,Players player) {
		 player.move(direction);
		
	}
	
	/**
	 * A method that takes the player object.
	 * @return gets the player from Players.
	 */
	public ArrayList<Players> getPlayer() {
		return players;
	}
	
	/**This method takes the player object and stores it into 
	 * @param player.
	 */
	public void setPlayer(ArrayList<Players> player) {
		this.players= player;
	}
	/** A pass through method to display the player location
	 * @return uses a method from the player class to get the location
	 */
	
		public String getRoomLocation(Players player) {
			return player.getLocationPlayer();
		}
	
		/**A method which
		 * @return the items present in player inventory.
		 */
		public String  displayInventory(Players player) {
			return player.showinventory();
		}
		/**A method which 
		 * @return the items present in room.
		 */
		public ArrayList<Items> itemspresentinaroom(Players player) {
			return player.showroomitems();
		}
		/**A pass through method which
		 * @return the image of room when the player is present.
		 */
		public ImageIcon showImage(Players player) {
			return player.getIcon();
		}
		/**A method which 
		 * @return the item from player inventory.
		 */
		public ArrayList<Items> playeritems(Players player){
			return player.getitemsfromplayerinventory();
		}
		/**This method uses player location and
		 * @return the mobs that are present in that location.
		 */
		public synchronized ArrayList<Mobs> getMob(Players player){
			return player.getmobsfromroom();
		}
		
		/**In this method, I am iterating through my arraylist of
		 * @param uilist and the arraylist of mobs to register each mob observable to ui.
		 **/
		public  void registermobs(ArrayList<Userinterface> uilist) {
			for(int i=0; i<uilist.size(); i++) {
				Userinterface ui = uilist.get(i);
				for(int j =0; j<mob.size();j++) {
					Mobs eachmob = mob.get(j);
					eachmob.addObserver(ui);
				}
				
			}
		}
		
		/**This method uses
		 * @param ui to stop the game and replaces the content of ui's with the winning and losing panel content.
		 */
		public void win(Userinterface ui) {
			service.shutdown();
			System.out.println("winner is "+ ui.toString());
			for(int i=0; i<uilist.size();i++) {
				Userinterface u = uilist.get(i);
				if(!ui.equals(u) ){
					u.lost();
					
					
				}
			}
			
		}
		
		/**This method uses
		 * @param uilist to register player into ui and add an observer to ui when the player changes it's position.
		 */
		public void registerplayers(ArrayList<Userinterface> uilist) {
			this.uilist = uilist;
			for(int i=0; i<uilist.size();i++) {
				Userinterface ui = uilist.get(i);
				for(int j=0; j<players.size();j++) {
					Players eachplayer = players.get(j);
					eachplayer.addObserver(ui);
				}
			}
		}
		/**This method uses
		 * @param roomnumber to 
		 * @return the starting position or room of the player.
		 */
		public Rooms getStartRoom(int roomnumber) {
			return rooms.get(roomnumber);
		}
		/**This method 
		 * @return the array list of rooms.
		 */
		public ArrayList<Rooms> getrooms () {
			return rooms;
		}
		
		/**This method uses
		 * @param player to add the player into the array list of player in the game.
		 */
		public void addPlayer(Players player) {
			players.add(player);
		}
		/**This method uses
		 * @param player to 
		 * @return the location of the player.
		 */
		public ArrayList<Players> getPlayer(Players player){
			return player.getplayerfromroom();
		}
		
		
		/**Private field for a a single player object.
	 * Private field for the array list of items and rooms. 
	 * The array list is used for items,rooms and mob object because they
	 * are present in multiple number.
	 * 
	 */
	
	private ArrayList<Players> players;
	private ArrayList<Items> items;
	private ArrayList<Rooms> rooms;
    private ArrayList<Mobs> mob;
    private ExecutorService service;
	private ArrayList<Userinterface> uilist;
	
}
