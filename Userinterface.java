import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Muhammad Fiaz and sharodcelestin 
 * The UserInterface class is where the user interacts with our game in a GUI. It extends a JPanel which puts all the different 
 * panel into itself which puts everything into a JFrame. Also, I have restructured this class in a way that it has private fields for all
 * the objects (buttons, panels, labels etc) that are present in a GUI. The objects are instantiated in a constructor and I also have several methods to perform action
 * on the objects. 
 */

public class Userinterface extends JPanel implements Observer{
	/**The UserInterface constructor instantiate all the objects and creates the mouse and action listener for my buttons and textfield. It also 
	 * has the list selection listener for my jlist of mobs.
	 * 
	 */
	public Userinterface(Game games, String name,int startroom) {
		game = games;
		moveeast = new JButton("move east");
		movewest = new JButton("move west");
		movesouth = new JButton("move south");
		movenorth = new JButton("move north");
		textfield = new JTextField();
		textfielderrors = new JTextField();
		rooms = new JPanel();
		score = 0;
		tellthescore = new JLabel("Score " + score);
		gameoveryouwon = new JLabel("Game Over " + name + " win!!!");
		gameoveryoulost = new JLabel("Game Over " + name + " lost!!!" );
		instructions = new JLabel();
		instructions.setText("<html><body>To pick an item type, You can type 'pick + item name'<br>To drop the item, You can type 'drop + item name'</body></html>");
		gameoverlostpanel = new JPanel();
		gameoverwinpanel = new JPanel();
		gameoverwinpanel.add(gameoveryouwon);
		gameoverlostpanel.add(gameoveryoulost);
		player = new Players(name, game.getStartRoom(startroom));
		Rooms r = game.getStartRoom(startroom);
		ArrayList<Rooms> s = game.getrooms();
		r.addplayerintotheroom(player);
		game.addPlayer(player);
		roomlabel = new JLabel("Rooms");
		rooms.add(roomlabel);
		roomlocation = new JLabel();
		rooms.add(roomlocation);
		showimage = new ImageIcon();
		labelfortheimage = new JLabel(showimage);
		playerdefaultmodel = new DefaultListModel<String>();
		displayplayer = new JList(playerdefaultmodel);
		mobs = new DefaultListModel<String>();
		displaymobs = new JList(mobs);
		roomitems = new DefaultListModel<String>();
		displayroomlist = new JList(roomitems);
		textpanel = new JPanel();
		imagepanel = new JPanel();
		listpanelitems = new JPanel();
		mobpanel = new JPanel();
		mobpanel.add(displaymobs);
		rooms.setLayout(new BorderLayout());
		rooms.add(textpanel, BorderLayout.NORTH);
		rooms.add(mobpanel,BorderLayout.WEST);
		rooms.add(imagepanel, BorderLayout.CENTER);
		rooms.add(listpanelitems, BorderLayout.SOUTH);
		rooms.add(displayplayer,BorderLayout.EAST);
		textpanel.setBackground(Color.getHSBColor(25,255,9));
		listpanelitems.setBackground(Color.getHSBColor(25,255,9));
		imagepanel.setBackground(Color.getHSBColor(25,255,9));
		mobpanel.setBackground(Color.getHSBColor(25,255,9));
		
		listpanelmob = new JPanel();
		playerinventory = new JPanel();
		playeritemslabel = new JLabel("Player inventory");
		playerinventory.setLayout(new BorderLayout());
		playerinventory.add(playeritemslabel,BorderLayout.NORTH);
		playerinventory.add(tellthescore,BorderLayout.CENTER);
		
		playeritem = new DefaultListModel<String>();
		displayplayerlist = new JList(playeritem);
		playerinventory.add(displayplayerlist,BorderLayout.SOUTH);
		buttoncommand = new JPanel();
		buttoncommand.setLayout(new BorderLayout());
		
		buttoncommand.add(moveeast,BorderLayout.EAST);
		buttoncommand.add(movewest,BorderLayout.WEST);
		buttoncommand.add(movesouth,BorderLayout.SOUTH);
		buttoncommand.add(movenorth,BorderLayout.NORTH);
		buttoncommand.add(instructions,BorderLayout.CENTER);
		buttonlabel = new JLabel("Button Label");
		
		
		this.setLayout(new BorderLayout());
		this.add(rooms, BorderLayout.CENTER);
		
		this.add(buttoncommand, BorderLayout.NORTH);
		this.add(playerinventory,BorderLayout.EAST);
		this.add(textfield,BorderLayout.SOUTH);
		me = this;
		
		textfield.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String nextline = textfield.getText();

				String[] input = nextline.split(" ");

				

				if (input[0].equals("pickup")) {
					
					String g = game.pickupitem(input[1],player);
					
					playeritem.addElement(g);
					
					roomitems.removeElement(g);
					
				    displayroomlist.setModel(roomitems);
					displayroomlist.repaint();
					displayroomlist.ensureIndexIsVisible(roomitems.getSize());
					displayplayerlist.repaint();
					displayplayerlist.ensureIndexIsVisible(playeritem.getSize());
					
					mainframe.repaint();
                   
				} else if (input[0].equals("drop")) {
					String h = game.dropitem(input[1],player);
					roomitems.addElement(h);
					playeritem.removeElement(h);
				    
					displayroomlist.repaint();
					displayroomlist.setModel(roomitems);
					displayplayerlist.ensureIndexIsVisible(roomitems.getSize());
					displayplayerlist.repaint();
					
					displayplayerlist.ensureIndexIsVisible(playeritem.getSize());
					mainframe.repaint();

				}
				 

			}
			

		});
		
		
		moveeast.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				game.move("East",player);
				String newroom = game.getRoomLocation(player);
				roomlocation.setText(newroom);
				ImageIcon showimageofnewroom = game.showImage(player);
				labelfortheimage.setIcon(showimageofnewroom);

				
				roomitems.removeAllElements();
				for (int i = 0; i < game.itemspresentinaroom(player).size(); i++) {
					String r = game.itemspresentinaroom(player).get(i).getItemName();
					
					
					roomitems.addElement(r);
				
				}
				displayroomlist.setModel(roomitems);
				
				mobs.removeAllElements();
				for(int i=0; i<game.getMob(player).size();i++) {
					String r = game.getMob(player).get(i).getmobname();
					
					mobs.addElement(r);
				}
				displaymobs.setModel(mobs);
				
				playerdefaultmodel.removeAllElements();
				for(int i = 0; i<player.getplayerfromroom().size();i++) {
					String l = player.getplayerfromroom().get(i).playername();
					playerdefaultmodel.addElement(l);
				}
				displayplayer.setModel(playerdefaultmodel);
			}
			

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		movewest.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				game.move("West",player);
				String newroom = game.getRoomLocation(player);
				roomlocation.setText(newroom);
				ImageIcon showimageofnewroom = game.showImage(player);
				labelfortheimage.setIcon(showimageofnewroom);

				
				roomitems.removeAllElements();
				for (int i = 0; i < game.itemspresentinaroom(player).size(); i++) {
					String r = game.itemspresentinaroom(player).get(i).getItemName();
				
					roomitems.addElement(r);
					
				}
				displayroomlist.setModel(roomitems);
				
				mobs.removeAllElements();
				for(int i=0; i<game.getMob(player).size();i++) {
					String r = game.getMob(player).get(i).getmobname();
					
					mobs.addElement(r);
				}
				displaymobs.setModel(mobs);
				
				playerdefaultmodel.removeAllElements();
				playerdefaultmodel.removeAllElements();
				for(int i = 0; i<player.getplayerfromroom().size();i++) {
					String l = player.getplayerfromroom().get(i).playername();
					playerdefaultmodel.addElement(l);
				}
				displayplayer.setModel(playerdefaultmodel);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		movesouth.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				game.move("South",player);
				String newroom = game.getRoomLocation(player);
				roomlocation.setText(newroom);
				ImageIcon showimageofnewroom = game.showImage(player);
				labelfortheimage.setIcon(showimageofnewroom);

				
				roomitems.removeAllElements();
				for (int i = 0; i < game.itemspresentinaroom(player).size(); i++) {
					String r = game.itemspresentinaroom(player).get(i).getItemName();
				
					roomitems.addElement(r);
					
				}
				displayroomlist.setModel(roomitems);
				
				mobs.removeAllElements();
				for(int i=0; i<game.getMob(player).size();i++) {
					String r = game.getMob(player).get(i).getmobname();
					
					mobs.addElement(r);
				}
				displaymobs.setModel(mobs);

				playerdefaultmodel.removeAllElements();
				for(int i = 0; i<player.getplayerfromroom().size();i++) {
					String l = player.getplayerfromroom().get(i).playername();
					playerdefaultmodel.addElement(l);
				}
				displayplayer.setModel(playerdefaultmodel);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		
		movenorth.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				game.move("North",player);
				String newroom = game.getRoomLocation(player);
				roomlocation.setText(newroom);
				ImageIcon showimageofnewroom = game.showImage(player);
				labelfortheimage.setIcon(showimageofnewroom);

				
				roomitems.removeAllElements();
				for (int i = 0; i < game.itemspresentinaroom(player).size(); i++) {
					String r = game.itemspresentinaroom(player).get(i).getItemName();
				
					roomitems.addElement(r);
					
				}
				displayroomlist.setModel(roomitems);
				
				mobs.removeAllElements();
				for(int i=0; i<game.getMob(player).size();i++) {
					String r = game.getMob(player).get(i).getmobname();
					
					mobs.addElement(r);
				}
				displaymobs.setModel(mobs);

				playerdefaultmodel.removeAllElements();
				for(int i = 0; i<player.getplayerfromroom().size();i++) {
					String l = player.getplayerfromroom().get(i).playername();
					playerdefaultmodel.addElement(l);
				}
				displayplayer.setModel(playerdefaultmodel);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		ListSelectionModel listselectionmodel = displaymobs.getSelectionModel();
		listselectionmodel.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				// TODO Auto-generated method stub
				ListSelectionModel lsm  = (ListSelectionModel) e.getSource();
				if(lsm.isSelectionEmpty()) {
					
				}
				else {
					for(int i =0; i<displaymobs.getModel().getSize();i++) {
						if(lsm.isSelectedIndex(i)) {
							
							player.location.killMob(i);
							mobs.remove(i);
							score++;
							System.out.println("score ="+score);
							if(score == 3) {
								game.win(me);
								me.mainframe.getContentPane().removeAll();
								me.mainframe.setContentPane(gameoveryouwon);
							}
							tellthescore.setText("Score " + Integer.toString(score));
							System.out.println("mob deleted " + i);
						}
					}
				}
				
			}
			
		});
		
		
	}
	
	
	
	/**My main method creates the two objects ui and game. The ui is bascially a panel which will contain all the stuff from
	 * game class. I am also calling the methods that I have created in this class on ui.
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		Game game = new Game();
		
		Userinterface ui = new Userinterface(game, "Muhammad",0);
		
		Userinterface ui2 = new Userinterface(game, "Sharod",1);
		ArrayList<Userinterface> iuse = new ArrayList<Userinterface>();
		iuse.add(ui);
		iuse.add(ui2);
		game.registerplayers(iuse);
		game.registermobs(iuse);
		
		ui.setgame(game);
		ui.setBackground(Color.DARK_GRAY);
		ui.roompanel();
		ui.mobsinroom();
		ui.itemslistinroom();
		ui.itemsinplayerinventory();
		ui.showplayer();
		
		ui2.setgame(game);
		ui2.setBackground(Color.DARK_GRAY);
		ui2.roompanel();
		ui2.mobsinroom();
		ui2.itemslistinroom();
		ui2.itemsinplayerinventory();
		ui2.showplayer();
		JFrame frame = new JFrame();
		ui.setframe(frame);
		frame.setBounds(0,0,1000,1000);
		frame.setBackground(Color.gray);
		frame.setTitle("My game");
		
		frame.add(ui);
		
		JFrame frame2 = new JFrame();
		ui2.setframe(frame2);
		frame2.setBounds(0,0,1000,1000);
		frame2.setBackground(Color.gray);
		frame2.setTitle("My game");
		
		frame2.add(ui2);
		//ui = new U
		//frame.getContentPane().add(UserInterface);
		
		frame.setVisible(true);
		frame2.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**This method uses
	 * @param games to set the new object games (which is being created in main method) to the field game.
	 */
	public void setgame(Game games) {
		game = games;
	}
	/**This method takes the text, image and location from the game and displays them into a room panel.
	 * 
	 */
	public void roompanel() {
		rooms.setBackground(Color.getHSBColor(25,255,9));
		String location = this.game.getRoomLocation(player);
		roomlocation.setText(location);
		showimage = this.game.showImage(player);
		labelfortheimage.setIcon(showimage);
		textpanel.add(roomlocation);
		imagepanel.add(labelfortheimage);
		
		
		
	}
	/**This method takes
	 * @param frame to set this frame object to the field object
	 */
	public void setframe(JFrame frame) {
		mainframe = frame;
	}
	
	/**removes the mobs from the current room list and then iterates through the mob list returning the mob information and adds that into the Jlist of mob
	 * 
	 */
	public synchronized void mobsinroom() {
			mobs.removeAllElements();
		for(int i = 0; i<this.game.getMob(player).size();i++) {
			String g = this.game.getMob(player).get(i).getmobname();
			mobs.addElement(g);
		}
		displaymobs.setModel(mobs);
		
	}
	
	/**iterates through the item list and then returns that information for the item, adding it to the JList of items in a room
	 * 
	 */
	public synchronized void itemslistinroom() {
		for(int i = 0; i < this.game.itemspresentinaroom(player).size(); i++) {
			String r = this.game.itemspresentinaroom(player).get(i).getItemName();
			roomitems.addElement(r);
		}
		listpanelitems.add(displayroomlist);
	}
	
	
	
	/**iterates through the item list and then returns that information for the item, adding it to the JList of items in the player inventory
	 * 
	 */
	public void itemsinplayerinventory() {
		for(int i = 0; i<this.game.playeritems(player).size();i++) {
			String g = this.game.playeritems(player).get(i).getItemName();
			playeritem.addElement(g);
			playerinventory.add(displayplayerlist);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * This method will update the jlist whenever the mob and player will move from one room to another.
	 */
	public synchronized void update(Observable o, Object arg) {
		System.out.println("update mobs");
		mobs.removeAllElements();
		for(int i =0; i<this.game.getMob(player).size();i++) {
			String g = this.game.getMob(player).get(i).getmobname();
			mobs.addElement(g);
			
			
		}
		displaymobs.setModel(mobs);
		System.out.println(player.playername() + player.location.toString());
		
		playerdefaultmodel.removeAllElements();
		for(int i = 0; i<this.player.getplayerfromroom().size();i++) {
			String l = this.player.getplayerfromroom().get(i).playername();
			playerdefaultmodel.addElement(l);
		}
		displayplayer.setModel(playerdefaultmodel);
		
	}
	/**This method shows the name of the player in the JList.
	 * 
	 */
	public void showplayer() {
		playerdefaultmodel.removeAllElements();
		for(int i = 0; i<this.player.getplayerfromroom().size();i++) {
			String l = this.player.getplayerfromroom().get(i).playername();
			playerdefaultmodel.addElement(l);
		}
		displayplayer.setModel(playerdefaultmodel);
	}
	
	/**This method replaces the panel content of the losing player with the gameoverlost panel.
	 * 
	 */
	public void lost() {
		
		System.out.println("Loser is" + this.toString());
		
		this.mainframe.getContentPane().removeAll();
		this.mainframe.setContentPane(gameoverlostpanel);
		this.mainframe.validate();
		this.tellthescore.setText("LOST");
	}
	
	/**
	 * private fields for the objects that are displayed in a GUI.
	 */
	private JFrame mainframe;
	private JButton moveeast;
	private JButton movewest;
	private JButton movesouth;
	private JButton movenorth;
	private JTextField textfield;
	private JTextField textfielderrors;
	private JPanel rooms;
	private JLabel roomlabel;
	private JLabel roomlocation;
	private ImageIcon showimage;
	private JLabel labelfortheimage;
	private DefaultListModel<String> mobs;
	private DefaultListModel<String> playerdefaultmodel;
	private JList displaymobs;
	private JList displayplayer;
	private DefaultListModel<String> roomitems;
	private JList displayroomlist;
	private JPanel textpanel;
	private JPanel imagepanel;
	private JPanel listpanelitems;
	private JPanel listpanelmob;
	private JPanel playerinventory;
	private JPanel mobpanel;
	private JLabel playeritemslabel;
	private DefaultListModel<String> playeritem;
	private JList displayplayerlist;
	private JPanel buttoncommand;
	private JLabel buttonlabel;
	private Game game;
	private Players player;
	private int score;
	private JLabel tellthescore;
	private JLabel gameoveryouwon;
	private JLabel gameoveryoulost;
	private JPanel gameoverlostpanel;
	private JPanel gameoverwinpanel;
	private Userinterface me;
	private JLabel instructions;
}
