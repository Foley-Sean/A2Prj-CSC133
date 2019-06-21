package com.mycompany.a2;

import java.util.Vector;
import java.util.Observable;
import  java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.geom.Point2D;

public class GameWorld extends Observable implements IGameWorld {
	
	public Vector<GameObject> store = new Vector<GameObject>();	//vector storing all game objects
	private double length;
	private double width;
	private int numLives;
	private int missileCount;
	private boolean Sound;
	private int score;
	private int time;
	
	public void init() {
		this.setLength(768);
		this.setWidth(1024);
		this.setLives(3);
		this.setMissileCount(10);
		this.setScore(0);
		this.setTime(0);
		this.setSound(true);
		
	
	}

	public void addAsteroid() {
		// Create a new asteroid
		// Values below for max/min of speed/dir 
		Random r = new Random();
		int lowS = 0;
		int highS = 20;
		int lowD = 0;
		int highD= 359;
		
		int color = ColorUtil.GREEN;
		int dir = r.nextInt(highD-lowD) + lowD;
		int speed = r.nextInt(highS-lowS) + lowS;
		
		Asteroids asteroid = new Asteroids(color,speed,dir);
		store.add(asteroid);
		asteroid.toString();
		
		System.out.println(asteroid);
		
		//TestCode
		//remove and add to proxy game world after this delivery
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
	}

	public void addNonPlayerShip() {
		// Create a non player ship
		Random r = new Random();
		int lowS = 0;
		int highS = 20;
		int lowD = 0;
		int highD= 359;
		
		int color = ColorUtil.MAGENTA;
		int dir = r.nextInt(highD-lowD) + lowD;;
		int speed = r.nextInt(highS-lowS) + lowS;
		
		NonPlayerShip NPS = new NonPlayerShip(color, speed, dir);
		store.add(NPS);
		NPS.toString();
		
		System.out.println(NPS);
		
		//TestCode
		//remove and add to proxy game world after this delivery
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
		
	}

	public void addSpaceStation() {
		// Create a blinking space station
		int color = ColorUtil.WHITE;
		
		SpaceStation BSS = new SpaceStation(color);
		store.add(BSS);
		BSS.toString();
		
		System.out.println(BSS);
		
		//TestCode
		//remove and add to proxy game world after this delivery
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
	}

	public void addPlayerShip() {
		// Add a player controlled steerable/moveable ship to the game world
		int color = ColorUtil.LTGRAY;
		int dir = 0;
		int speed = 0;
		boolean ship = false;
		for(int i = 0; i < store.size(); i++) {
			if(store.elementAt(i) instanceof PlayerShip) {
				ship = true;
			}
		}
		if(ship == true) {
			System.out.println("Error: Only one player ship allowed at a time!");
		}
		else if(ship == false) {
		PlayerShip PS = new PlayerShip(color, speed, dir);
		store.add(PS);
		PS.toString();
		
		System.out.println(PS);
		}
		
		//TestCode
		//remove and add to proxy game world after this delivery
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void firePsMissile() {
		// Fire a missile from the player ship
		//use getters and setters to determine misslecount 
		boolean playerShip = false;
		for(int i = 0; i < store.size() && !playerShip; i++) {
			//keep iterating until a player ship is found
			
			if(store.elementAt(i) instanceof PlayerShip) {
				PlayerShip ps = (PlayerShip) store.elementAt(i);
				SteerableMissileLauncher MML = ps.getMissleLauncher();
				playerShip = true;
				if(ps.getMissileCount() > 0) {
					
					ps.setMissileCount(ps.getMissileCount() - 1);
					this.setMissileCount(this.getMissileCount() - 1);
					Missile msl = new Missile(ps.getLoc(), MML.getDirection(), ps.getSpeed(), ps.getColor(), ps.getShip());
					store.add(msl);
					System.out.println("PLAYERSHIP has fired a missile!");
					
					msl.toString();
					System.out.println(msl);
					
				}
				else
					System.out.println("PLAYERSHIP has no more missiles!");
			}
			
		}
		
		if(!playerShip) {
			System.out.println("No player ship");
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
	}

	public void fireNpsMissile() {
		// Fire a missile from the nps
		boolean nonPlayerShip = false;
		for(int i = 0; i < store.size() && !nonPlayerShip; i++) {
			//iterate until nps is found
			if(store.elementAt(i) instanceof NonPlayerShip) {
				NonPlayerShip nps = (NonPlayerShip) store.elementAt(i);
				nonPlayerShip = true;
				if(nps.getMissileCount() > 0) {
					nps.setMissileCount(nps.getMissileCount() - 1);
					Missile msl = new Missile(nps.getLoc(), nps.getDirection(), nps.getSpeed(), nps.getColor(), nps.getShip());
					//need to add target (coords of PS)
					store.add(msl);
					System.out.println("NONPLAYERSHIP has fired a missile!");
					msl.toString();
					System.out.println(msl);
					
				}
				else
					System.out.println("NONPLAYERSHIP has no more missiles!");
			}
			
		}
		if(!nonPlayerShip) {
			System.out.println("No non player ship. ");
		}

		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void map() {
		// This function displays all of the information of all of the current GameWorld objects
		System.out.println("*****Printing game world state*****");
		for(int i = 0; i < store.size() && store.size() != 0; i++) {
			//loop through the game world if it isn't empty
			GameObject mobj = store.elementAt(i);
			
			System.out.println(mobj);
			
		}
		
	}

	public void print() {
		// Generates info about the game world (score etc.)
		int mag = 0;
		System.out.println("*****Printing game state values*****");
		System.out.println("Score = " + this.getScore());
		//get current missile count
		boolean playerShip = false;
		for(int i = 0; i < store.size() && !playerShip; i++) {
			//keep iterating until a player ship is found
			if(store.elementAt(i) instanceof PlayerShip) {
				PlayerShip ps = (PlayerShip) store.elementAt(i);
				playerShip = true;
				mag = ps.getMissileCount();
				
				System.out.println("Number of Player Missiles = " + mag);
			}
		}
		if(playerShip == false) {
			System.out.println("Number of Player Missiles: No Player Ship");
		}
		
		System.out.println("Elapsed Time = " + this.getTime());
		System.out.println("Number of Lives = " + this.getLives());
		
	}
	
	public void tick() {
		this.setTime(1) ;
		MoveableGameObject myObj = null;
		SpaceStation myStation = null;
		boolean obj = false;
		boolean ISS = false;
		boolean beacon = false;
		for(int i = 0; i < store.size(); i++) {
			if(store.elementAt(i) instanceof SpaceStation) {
				myStation = (SpaceStation) store.elementAt(i);
				ISS = true;
				if(this.getTime() % myStation.getBlinkRate() == 0) {
					//light is on
					//check status of light
					beacon = myStation.getLight();
					//change to opposite value to "blink"
					if(beacon) {
						myStation.setLight(false);
					}
					else if(!beacon) {
						myStation.setLight(true);
					}
				}
				
			}
			if(store.elementAt(i) instanceof MoveableGameObject) {
				myObj = (MoveableGameObject) store.elementAt(i);
				obj = true;
				myObj.move();
				if(store.elementAt(i) instanceof Missile) {
					Missile msl = (Missile) store.elementAt(i);
					msl.decFuel();
					if(msl.getFuel() <= 0) {
						store.removeElement(msl);
						if(msl.getShip() instanceof PlayerShip) {
							System.out.println("A missile fired from a Player Ship has ran out of fuel!");
						}
						else if(msl.getShip() instanceof NonPlayerShip) {
							System.out.println("A Missile fired from a non Player Ship has ran out of fuel!");
						}
					}
					
				}
			}
		}
		if(store.size() == 0) {
			System.out.println("Time has passed.");
		}
		else {
			if(obj) {
				System.out.println("Moveable objects have moved.");
				if(ISS) {
					if(myStation.getLight()) {
						System.out.println("The Space Staion light is on!");
					}
					else if(!myStation.getLight()) {
						System.out.println("The Space Station light is off!");
					}
				
				}
			}
			else if(!obj) {
				if(ISS) {
					if(myStation.getLight()) {
						System.out.println("The Space Staion light is on!");
					}
					else if(!myStation.getLight()) {
						System.out.println("The Space Station light is off!");
					}
				
				}
			}
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
 }

	//delivery 3
	
	public void rotateLauncher() {
		// Rotate the PS's moveable (steerable) missile launcher CCW by a small amount
		boolean playerShip = false;
		PlayerShip ps = null;
		for(int i = 0; i < store.size() && !playerShip; i++) {
			//keep iterating until a player ship is found
			if(store.elementAt(i) instanceof PlayerShip) {
				ps = (PlayerShip) store.elementAt(i);
				playerShip = true;
			}
		}
		
		if(!playerShip) {
			System.out.println("Error: Please add player ship first");
		}
		else if(playerShip) {
		
			SteerableMissileLauncher MML;
			MML = ps.getMissleLauncher();
			MML.rotateLeft();
		
			System.out.println("Dir of MML = " + MML.getDirectionML());
		}

		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	//added for delivery 2 A2
	public void rotateLauncherRight() {
		// Rotate the PS's moveable (steerable) missile launcher CCW by a small amount
		boolean playerShip = false;
		PlayerShip ps = null;
		for(int i = 0; i < store.size() && !playerShip; i++) {
			//keep iterating until a player ship is found
			if(store.elementAt(i) instanceof PlayerShip) {
				ps = (PlayerShip) store.elementAt(i);
				playerShip = true;
			}
			
		}
		
		if(!playerShip) {
			System.out.println("Error: Please add player ship first");
		}
		else if(playerShip) {
			SteerableMissileLauncher MML;
			MML = ps.getMissleLauncher();
			MML.rotateRight();
			System.out.println("Dir of MML = " + MML.getDirectionML());
		}

		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void reloadMissiles() {
		// This method finds a player ship and if one exists it reloads its missiles
		// cannot reload missiles if the ship already has max number
		boolean playerShip = false;
		PlayerShip ps = null;
		for(int i = 0; i < store.size() && !playerShip; i++) {
			//keep iterating until a player ship is found
			if(store.elementAt(i) instanceof PlayerShip) {
				ps = (PlayerShip) store.elementAt(i);
				playerShip = true;
			}	
		}
		if(!playerShip) {
			System.out.println("Error: Please add player ship first");
		}
		
		else if (playerShip) {
			int mag = ps.getMissileCount();
			if(mag < 10) {
				System.out.println("Reloading missiles");
				//very wonky really need to fix how missiles are stored
				ps.setMissileCount(10);
				this.setMissileCount(10);
			}
			
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
			
	}

	public void asteroidKilled() {
		// This method is called to simulate a player ship striking and destroying an asteroid
		// score should be updated if an asteroid is killed
		//first check the game world
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		
			boolean playerShip = false;
			boolean asteroid = false;
			PlayerShip ps = null;
			for(int i = 0; i < store.size(); i++) {
				//keep iterating until a player ship is found
				if(store.elementAt(i) instanceof PlayerShip) {
					playerShip = true;
					ps = (PlayerShip) store.elementAt(i);
					
				}
				if(store.elementAt(i) instanceof Asteroids) {				
					asteroid = true;
				}
			}
			if(!playerShip) {
				System.out.println("Error: Please add player ship first!");
			}
			if(!asteroid) {
				System.out.println("Error: Please add asteroid first!");
			}
			
			if(playerShip && asteroid) {
				//flag for asteroid found
				boolean flag = false;
				for(int i = 0; i < store.size() && !flag; i++) {
					if(store.elementAt(i) instanceof Asteroids) {
						store.removeElementAt(i);
						this.setScore(this.getScore() + 10);
						ps.decMissileCount();
						flag = true;
					}
				}
				System.out.println("Asteroid destroyed!");
			}

			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
	}

	public void npsShotDown() {
		// A player ship as destroyed a non player ship with a missile
		// Need to add check for player ship missile
		
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		else if(store.size() != 0) {
			boolean playerShip = false;
			boolean nonPlayerShip = false;
			boolean flag = false;
			boolean missile = false;
			PlayerShip ps = null;
			NonPlayerShip nps = null;
		
			//again this loop , need to create helper function for readability
			for(int i = 0; i < store.size() && !flag; i++) {
				if(store.elementAt(i) instanceof PlayerShip) {
					playerShip = true;
					ps = (PlayerShip) store.elementAt(i);
				}
				if(store.elementAt(i) instanceof NonPlayerShip) {
					nonPlayerShip = true;
					nps = (NonPlayerShip) store.elementAt(i);
				}
				//Flawed Logic, can still get shot down if there is no nonPlayerShip
				//will update when "closeness" matters
				if(store.elementAt(i) instanceof Missile && playerShip && nonPlayerShip) {
					Missile msl = (Missile) store.elementAt(i);
					Ship ship = msl.getShip();
						if(ship instanceof PlayerShip) {
							missile = true;
							store.removeElementAt(i);
							store.removeElement(nps);	
						}
						else {
							missile = false;
						}
				}
			}//end loop
			
		if(!playerShip) {
			System.out.println("Error: Add player ship!");
		}
		if(!nonPlayerShip) {
			System.out.println("Error: Add non player ship(s)!");
		}
		if(!missile) {
			System.out.println("Error: No player missile(s)!");
		}
		else if(playerShip && nonPlayerShip && missile) {
			System.out.println("Player has eliminated nps!");
			this.setScore(this.getScore() + 20); 
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	
		}//end else if
	}//end class


	public void psShotDown() {
		// A non player ship as struck and shot down a player ship with a missile
		//Need to bug check this
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		boolean playerShip = false;
		boolean nonPlayerShip = false;
		boolean missile = false;
		
		PlayerShip ps = null;
		NonPlayerShip nps = null;
		//first make sure the necessary elements exist
		for(int i = 0; i < store.size(); i++) {
			if(store.elementAt(i) instanceof PlayerShip) {
				playerShip = true;
				ps = (PlayerShip) store.elementAt(i);
					
			}
			if(store.elementAt(i) instanceof NonPlayerShip) {
				nonPlayerShip = true;
				nps = (NonPlayerShip) store.elementAt(i);
				
			}
			if(store.elementAt(i) instanceof Missile && playerShip && nonPlayerShip) {
				Missile msl = (Missile) store.elementAt(i);
				Ship ship = msl.getShip();
				if(ship instanceof NonPlayerShip) {
					missile = true;
					store.removeElementAt(i);
					store.removeElement(ps);	
				}
				else {
					missile = false;
				}
			}
		}
		// Situations where an nps can kill a ps
		if(!playerShip && !nonPlayerShip) {
			System.out.println("Error: Add player ship and non player ships");
		}
		if(!playerShip && nonPlayerShip) {
			System.out.println("Error: Add player ship!");
		}
		if(playerShip && !nonPlayerShip) {
			System.out.println("Error: Add non player ship(s)!");
		}
		if(!missile) {
			System.out.println("Error: There are no non player missiles");
			}
		
		else if(playerShip && nonPlayerShip && missile) {
			//again another loop to find a missile and find the ps
			this.setLives(this.getLives() - 1);
			if(this.getLives() == 0) {
				System.out.println("No lives left - Game Over!");
				this.gameOver();
				
			}
			else if(this.getLives() > 0) {
				System.out.println("Player Ship Eliminated!");
				System.out.println("Lives = " + this.getLives());
			}
		}

		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	public void psCrashIntoAsteroid() {
		// The player ship has crashed into an asteroid
		// Delete asteroid, player ship, dec lives and check for game over
		boolean playerShip = false;
		boolean Asteroid = false;
		boolean flag = false;
		Asteroids ast = null;
		PlayerShip ps = null;
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		else if(store.size() != 0) {
		
			for(int i = 0; i < store.size(); i++) {
				if(store.elementAt(i) instanceof PlayerShip) {
					playerShip = true;
					ps = (PlayerShip) store.elementAt(i);	
				}
				if(store.elementAt(i) instanceof Asteroids) {
					Asteroid = true;
					ast = (Asteroids) store.elementAt(i);
				}
			}
		}
		if(!playerShip) {
			System.out.println("Error: There is no Player Ship!");
		}
		if(!Asteroid) {
			System.out.println("Error: There is no Asteroid");
		}
		if(!playerShip && !Asteroid) {
			System.out.println("Error: There are is neither a Player Ship or Asteroid!");
		}
		
		if(playerShip && Asteroid) {
			this.setLives(this.getLives() - 1);
			if(this.getLives() == 0){
				System.out.println("Player Ship Has Crashed Into Asteroid!");
				store.removeElement(ast);
				store.removeElement(ps);
				System.out.println("Lives = " + this.getLives());
				System.out.println("Player is out of lives. Game over!.");
				this.gameOver();
			}
			else if(this.getLives() > 0) {
				System.out.println("Payer Ship Has Crashed Into Asteroid!");
				store.removeElement(ast);
				store.removeElement(ps);
				System.out.println("Lives = " + this.getLives());
			}
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}


	public void shipCollision() {
		// The player ship has collided with a non player ship
		// The NPS is to be removed, number of lives decreased by 1
		// If there are no lives left the game is over
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		boolean playerShip = false;
		boolean nonPlayerShip = false;
		boolean flag = false;
		
		//first make sure the necessary elements exist
		for(int i = 0; i < store.size(); i++) {
			if(store.elementAt(i) instanceof PlayerShip) {
				playerShip = true;
					
			}
			if(store.elementAt(i) instanceof NonPlayerShip) {
				nonPlayerShip = true;
				
			}
		}
		
		if(!playerShip) {
			System.out.println("Error: Add player ship!");
		}
		if(!nonPlayerShip) {
			System.out.println("Error: Add non player ship!");
		}
		
		if(playerShip && nonPlayerShip) {
			this.setLives(this.getLives() - 1);
			if(this.getLives() == 0) {
				System.out.println("The player ship has collided with a non player ship!");
				System.out.println("No Lives Left - Game Over");
				this.gameOver();
			}
			else if(this.getLives() > 0) {
				for(int i = 0; i < store.size() && !flag; i++) {
					if(store.elementAt(i) instanceof NonPlayerShip) {
						store.removeElementAt(i);
						System.out.println("The player ship has collided with a non player ship!");
						System.out.println("Lives Left = " + this.getLives());
						flag = true;
						
					}
				}
				
			}
		}
		//TestCode
		//remove and add to proxy game world after this delivery
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
	}

	public void asteroidCollision() {
		// This method is called when two asteroids collide
		// They are to be mutually destroyed
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		
		int asteroids= 0;;
		Asteroids ast1 = null;
		Asteroids ast0 = null;
		
		//first make sure the necessary elements exist
		for(int i = 0; i < store.size(); i++) {
			if(store.elementAt(i) instanceof Asteroids) {
				asteroids++;
				if(asteroids == 1) {
					ast0 = (Asteroids) store.elementAt(i);
				}
				else if(asteroids == 2) {
					ast1 = (Asteroids) store.elementAt(i);
				}
				}
			}
		//There must be at least 2 asteroids for a collision to occur
		if(asteroids == 0 && store.size() != 0) {
			System.out.println("Error: There are no asteroids!");
		}
		else if(asteroids == 1) {
			System.out.println("Error: There is only one asteroid!");
		}
		else if(asteroids >= 2) {
			store.removeElement(ast0);
			store.removeElement(ast1);
			System.out.println("Astroid Collision!");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));	
			
	}
		
	public void turnPsLeft() {
		// This method turns the player shift left (CCW) by a small amount
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		
			boolean playerShip = false;
			PlayerShip ps = null;
			for(int i = 0; i < store.size(); i++) {
				//keep iterating until a player ship is found
				if(store.elementAt(i) instanceof PlayerShip) {
					playerShip = true;
					ps = (PlayerShip) store.elementAt(i);
					
				}
			}
			if(playerShip) {
				ps.rotateLeft();
				System.out.println("Turned Left!");
			}
			else if(!playerShip){
				System.out.println("Error: No Player Ship!");
			}
			
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		
	}
	
	public void accelPsForward() {
		// Accelerates the PS forward
		// Cannot go faster than 20 units/second
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		
			boolean playerShip = false;
			PlayerShip ps = null;
			for(int i = 0; i < store.size(); i++) {
				//keep iterating until a player ship is found
				if(store.elementAt(i) instanceof PlayerShip) {
					playerShip = true;
					ps = (PlayerShip) store.elementAt(i);
					
				}
			}
			if(playerShip) {
				if(ps.getSpeed() == 20) {
					System.out.println("The ship can't go any faster!");
				}
				else if(ps.getSpeed() < 20) {
					ps.setSpeed(ps.getSpeed() + 1);
					System.out.println("Player ship Accelerating! Speed at: " + ps.getSpeed());
					if(ps.getSpeed() >= 20) {
						ps.setSpeed(20);
						System.out.println("Player ship at maximum velocity!");
					}
				}
				
			}
			else if(!playerShip){
				System.out.println("Error: No Player Ship!");
			}
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
	}

	public void accelPsBackwards() {
		// Accelerates the PS backwards
		//cannot go in reverse
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		
			boolean playerShip = false;
			PlayerShip ps = null;
			for(int i = 0; i < store.size(); i++) {
				//keep iterating until a player ship is found
				if(store.elementAt(i) instanceof PlayerShip) {
					playerShip = true;
					ps = (PlayerShip) store.elementAt(i);
					
				}
			}
			if(playerShip) {
				if(ps.getSpeed() == 0) {
					System.out.println("The ship is stationary!");
				}
				else if(ps.getSpeed() > 0) {
					ps.setSpeed(ps.getSpeed() - 1);
					System.out.println("Player ship Decelerating! Speed at: " + ps.getSpeed());
					if(ps.getSpeed() <= 0) {
						ps.setSpeed(0);
						System.out.println("Player has come to a stop!");
					}
				}
				
			}
			else if(!playerShip){
				System.out.println("Error: No Player Ship!");
			}

			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		
	}

	public void asteroidHitNps() {
		//Asteroid has hit and destroyed a NPS
		boolean NPS = false;
		boolean astr = false;
		Asteroids asteroid = null;
		NonPlayerShip nps = null;
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		
		for(int i = 0; i < store.size(); i++) {
			if(store.elementAt(i) instanceof Asteroids) {
				asteroid = (Asteroids) store.elementAt(i);
				astr = true;
			}
			else if(store.elementAt(i) instanceof NonPlayerShip) {
				nps = (NonPlayerShip) store.elementAt(i);
				NPS = true;
			}
		}
		if(!NPS && !astr) {
			System.out.println("Error: Please add Non Player Ship(s) and Asteroid(s)");
		}
		if(!NPS && astr) {
			System.out.println("Error: Please add Non Player Ship(s)");
		}
		if(NPS && !astr) {
			System.out.println("Error: Please add Asteroid(s)");
		}
		if(NPS && astr) {
			store.removeElement(asteroid);
			store.removeElement(nps);
			System.out.println("An asteroid has collided with and destoryed a Non Player Ship!");
		}

		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
		
	}

	public void turnPsRight() {
		// Turns the PS right
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
		
			boolean playerShip = false;
			PlayerShip ps = null;
			for(int i = 0; i < store.size(); i++) {
				//keep iterating until a player ship is found
				if(store.elementAt(i) instanceof PlayerShip) {
					playerShip = true;
					ps = (PlayerShip) store.elementAt(i);
				}
			}
			if(playerShip) {
				ps.rotateRight();
				System.out.println("Turned Right!");
			}
			else if(!playerShip){
				System.out.println("Error: No Player Ship!");
			}
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
	}

	public void JumpThroughHyperspace() {
		//"Jump through hyperspace"
		//AKA reset the player ship to its starting location
		if(store.size() == 0) {
			System.out.println("Error: The game world is empty!");
		}
			boolean playerShip = false;
			PlayerShip ps = null;
			for(int i = 0; i < store.size(); i++) {
				//keep iterating until a player ship is found
				if(store.elementAt(i) instanceof PlayerShip) {
					playerShip = true;
					ps = (PlayerShip) store.elementAt(i);
					
				}
			}
			if(playerShip) {
				final Point2D home = new Point2D(512.0, 384.0);
				ps.setLocation(home);
				ps.setSpeed(0);
				ps.setDirection(0);
				System.out.println("Player Ship Warped home!");
			}
			else if(!playerShip){
				System.out.println("Error: No Player Ship!");
			}
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		
		
	}
	
	public void gameOver() {
		System.out.println("Thanks for playing!");
		System.out.println("Score = " + this.getScore());
		System.out.println("Time = " + this.getTime());
		
		Boolean bOk = Dialog.show("Game Over", "Do you want to try again?" + "\n" + "Score: " + this.getScore()
		+ "\n" + "Time:" + this.getTime(), "Yes", "No");
		if(bOk) {
			new Game();
		}
		else if (!bOk) {
			Display.getInstance().exitApplication();
		}
	}

	public void quit() {
		// Player Induced quit
		Boolean bOk= Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel");
	     if (bOk) {
	          Display.getInstance().exitApplication();
	     }
		
	}


	//*******Getters and Setters*********

	//Getters
	public int getMissileCount() {
		return this.missileCount;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public String whatSound() {
		//Method to interact with point view
		//returns a string so it can be printed
		if(this.getSound()) {
			return  "On";
		}
		else if(!this.getSound()) {
			return "Off";
		}
		return "Off";
	}
	
	public int getLives() { 
		return this.numLives;

	}
	
	public boolean getSound() {
		return this.Sound;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getScore() {
		return this.score;
	}
	
	
	//Setters
	public void setScore(int s) {
		this.score = s;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public void setSound(boolean sound) {
		this.Sound = sound;
		//this is for PointView
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public void setTime(int t) {
		this.time = this.getTime() + t;	
	}
	
	private void setMissileCount(int i) {
		this.missileCount = i;
	
	}
	
	
	private void setLives(int i) {
		this.numLives = i;
	}
	
}//End Class
