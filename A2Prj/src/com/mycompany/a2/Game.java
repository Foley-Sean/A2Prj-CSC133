package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

import a2.commands.AddAsteroidCommand;
import a2.commands.AddNonPlayerShipCommand;
import a2.commands.AddPlayerShipCommand;
import a2.commands.AddSpaceStationCommand;
import a2.commands.AsteroidCollisionCommand;
import a2.commands.AsteroidNpsCollideCommand;
import a2.commands.ButtonListener;
import a2.commands.DecreasePlayerSpeedCommand;
import a2.commands.FirePlayerShipMissleCommand;
import a2.commands.IncreasePlayerSpeedCommand;
import a2.commands.JumpThroughHyperSpaceCommand;
import a2.commands.LoadPsMissilesCommand;
import a2.commands.MapCommand;
import a2.commands.NpsDestroyPsCommand;
import a2.commands.NpsFireMissileCommand;
import a2.commands.PrintCommand;
import a2.commands.PsDestroyNpsCommand;
import a2.commands.PsDestroyedAsteroidCommand;
import a2.commands.PsHitAsteroidCommand;
import a2.commands.PsNpsCollisionCommand;
import a2.commands.QuitCommand;
import a2.commands.SoundCommand;
import a2.commands.TickCommand;
import a2.commands.TurnMlLeftCommand;
import a2.commands.TurnMlRightCommand;
import a2.commands.TurnPsLeftCommand;
import a2.commands.TurnPsRightCommand;

import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String;

public class Game extends Form {
	
	private GameWorld gw;
	
	public Game() {
		gw = new GameWorld();
		
		MapView mv = new MapView();
		PointsView pv = new PointsView();
		gw.addObserver(mv);
		gw.addObserver(pv);
		gw.init();
		setLayout(new BorderLayout());
		//play is no longer needed?
		//play();
		createButtons();
		createBindings();
		createSideMenu();
		add(BorderLayout.NORTH, pv);
		pv.getStyle().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
		add(BorderLayout.CENTER, mv);
		mv.getStyle().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));

		//createCommandObjects();
		
		this.show();
	
	}
	

	private void createSideMenu() {
		// Create Side Menu and add items to it
		
		//create side menu and add items
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		this.setTitle("Asteroids");
		//quit
		Button sideMenuItem1 = new Button("Quit");
		myToolbar.addComponentToLeftSideMenu(sideMenuItem1);
		QuitCommand myQuit = new QuitCommand(gw);
		sideMenuItem1.setCommand(myQuit);
		
		//Sound
		Button sideMenuItem2 = new Button("Toggle Sound");
		myToolbar.addComponentToLeftSideMenu(sideMenuItem2);
		SoundCommand mySound = new SoundCommand(gw);
		sideMenuItem2.setCommand(mySound);
		
		//About
		Button sideMenuItem3 = new Button("About");
		myToolbar.addComponentToLeftSideMenu(sideMenuItem3);
		AboutCommand myAbout = new AboutCommand();
		sideMenuItem3.setCommand(myAbout);
		
		//Commands that do nothing
		//New
		Button sideMenuItem4 = new Button("New");
		myToolbar.addComponentToLeftSideMenu(sideMenuItem4);
		NewCommand myNew = new NewCommand();
		sideMenuItem4.setCommand(myNew);
		//Save
		Button sideMenuItem5 = new Button("Save");
		myToolbar.addComponentToLeftSideMenu(sideMenuItem5);
		SaveCommand mySave = new SaveCommand();
		sideMenuItem5.setCommand(mySave);
		//Undo
		Button sideMenuItem6 = new Button("Undo");
		myToolbar.addComponentToLeftSideMenu(sideMenuItem6);
		UndoCommand myUndo = new UndoCommand();
		sideMenuItem6.setCommand(myUndo);
		
	}


	private void createBindings() {
		// Map key bindings that don't have buttons
		//accel PS
		
		IncreasePlayerSpeedCommand myAccel = new IncreasePlayerSpeedCommand(gw);
		addKeyListener(-91, myAccel);
		//Deccel PS
		DecreasePlayerSpeedCommand myDeccel = new DecreasePlayerSpeedCommand(gw);
		addKeyListener(-92, myDeccel);
		//Turn PS Left
		TurnPsLeftCommand myTurnLeft = new TurnPsLeftCommand(gw);
		addKeyListener(-93, myTurnLeft);
		//Turn PS Right
		TurnPsRightCommand myTurnRight = new TurnPsRightCommand(gw);
		addKeyListener(-94, myTurnRight);
		//Turn MML Left
		TurnMlLeftCommand myRotateLeft = new TurnMlLeftCommand(gw);
		addKeyListener(44, myRotateLeft);
		//Turn MML Right
		TurnMlRightCommand myRotateRight = new TurnMlRightCommand(gw);
		addKeyListener(46, myRotateRight);
		//Fire NPS Missile
		NpsFireMissileCommand myNpsFireMsl = new NpsFireMissileCommand(gw);
		addKeyListener('L', myNpsFireMsl);
		//Load PS with missiles
		LoadPsMissilesCommand  myPsLoad = new LoadPsMissilesCommand(gw);
		addKeyListener('n', myPsLoad);
		//PS has destroyed asteroid
		PsDestroyedAsteroidCommand myPsKill = new PsDestroyedAsteroidCommand(gw);
		addKeyListener('k', myPsKill);
		//PS has killed a NPS
		PsDestroyNpsCommand myPsDestroy = new PsDestroyNpsCommand(gw);
		addKeyListener('e', myPsDestroy);
		//NPS has killed PS
		NpsDestroyPsCommand myNpsDestroy = new NpsDestroyPsCommand(gw);
		addKeyListener('E', myNpsDestroy);
		//PS has crashed into an asteroid
		PsHitAsteroidCommand myPsAsteroidCollision = new PsHitAsteroidCommand(gw);
		addKeyListener('c', myPsAsteroidCollision);
		//PS and NPS crash
		PsNpsCollisionCommand myPsNpsCrash = new PsNpsCollisionCommand(gw);
		addKeyListener('h', myPsNpsCrash);
		//Asteroid Collision
		AsteroidCollisionCommand myAsteroids = new AsteroidCollisionCommand(gw);
		addKeyListener('x', myAsteroids);
		//Asteroid hit NPS
		AsteroidNpsCollideCommand myNpsAst = new AsteroidNpsCollideCommand(gw);
		addKeyListener('I', myNpsAst);
		//Tick the game clock
		TickCommand myTick = new TickCommand(gw);
		addKeyListener('t', myTick);
		//Quit the game
		QuitCommand myQuit = new QuitCommand(gw);
		addKeyListener('Q', myQuit);
		//display game state info
		//This is a temporary function
		MapCommand myMap = new MapCommand(gw);
		addKeyListener('m', myMap);
		//display value info (points lives etc)
		//Temporary
		PrintCommand myPrint = new PrintCommand(gw);
		addKeyListener('p', myPrint);
	}


	private void createCommandObjects() {
		// TODO Auto-generated method stub;
	}

	private void createButtons() {
		// create container with all of the buttons
		// also create the key bindings for button commands
		
		Container buttonContainer = new Container();
		buttonContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		this.add(BorderLayout.WEST, buttonContainer);
		buttonContainer.add(new Label ("Commands"));
		//add all of the buttons
		//might be a better way of doing this
		Button buttonOne = new Button("+ Asteroid");  
		buttonContainer.add(buttonOne);
		AddAsteroidCommand myAddAsteroid = new AddAsteroidCommand(gw);
		buttonOne.setCommand(myAddAsteroid);
		
		Button buttonTwo = new Button("+ NPS");  
		buttonContainer.add(buttonTwo);
		AddNonPlayerShipCommand myAddNonPlayerShip = new AddNonPlayerShipCommand(gw);
		buttonTwo.setCommand(myAddNonPlayerShip);
		
		Button buttonThree = new Button("+ Space Station");  
		buttonContainer.add(buttonThree);
		AddSpaceStationCommand myAddSpaceStation = new AddSpaceStationCommand(gw);
		buttonThree.setCommand(myAddSpaceStation);
		
		Button buttonSeven = new Button("+ PS (1)");  
		buttonContainer.add(buttonSeven);
		AddPlayerShipCommand myAddPlayerShip = new AddPlayerShipCommand(gw);
		buttonSeven.setCommand(myAddPlayerShip);
		
		Button buttonFive = new Button("PS Fire");  
		buttonContainer.add(buttonFive);
		FirePlayerShipMissleCommand myFirePlayerShip = new FirePlayerShipMissleCommand(gw);
		buttonFive.setCommand(myFirePlayerShip);
		addKeyListener(-90, myFirePlayerShip);
		
		Button buttonSix = new Button("Jump");
		buttonContainer.add(buttonSix);
		JumpThroughHyperSpaceCommand myJump = new JumpThroughHyperSpaceCommand(gw);
		buttonSix.setCommand(myJump);
		addKeyListener('j', myJump);
		
		//button formatting
		//buttonOne
		buttonOne.getAllStyles().setBgTransparency(255);
		buttonOne.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		buttonOne.getAllStyles().setFgColor(ColorUtil.CYAN);
		
		buttonOne.getAllStyles().setPadding(TOP, 5);
		buttonOne.getAllStyles().setPadding(BOTTOM, 5);
		
		//buttonTwo
		buttonTwo.getAllStyles().setBgTransparency(255);
		buttonTwo.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		buttonTwo.getAllStyles().setFgColor(ColorUtil.CYAN);
		
		buttonTwo.getAllStyles().setPadding(TOP, 5);
		buttonTwo.getAllStyles().setPadding(BOTTOM, 5);
		
		//buttonThree
		buttonThree.getAllStyles().setBgTransparency(255);
		buttonThree.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		buttonThree.getAllStyles().setFgColor(ColorUtil.CYAN);
		
		buttonThree.getAllStyles().setPadding(TOP, 5);
		buttonThree.getAllStyles().setPadding(BOTTOM, 5);
		
		//buttonSeven
		buttonSeven.getAllStyles().setBgTransparency(255);
		buttonSeven.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		buttonSeven.getAllStyles().setFgColor(ColorUtil.CYAN);
		
		buttonSeven.getAllStyles().setPadding(TOP, 5);
		buttonSeven.getAllStyles().setPadding(BOTTOM, 5);
		
		//buttonFive
		buttonFive.getAllStyles().setBgTransparency(255);
		buttonFive.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		buttonFive.getAllStyles().setFgColor(ColorUtil.CYAN);
		
		buttonFive.getAllStyles().setPadding(TOP, 5);
		buttonFive.getAllStyles().setPadding(BOTTOM, 5);
		
		//buttonSix
		buttonSix.getAllStyles().setBgTransparency(255);
		buttonSix.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		buttonSix.getAllStyles().setFgColor(ColorUtil.CYAN);
		
		buttonSix.getAllStyles().setPadding(TOP, 5);
		buttonSix.getAllStyles().setPadding(BOTTOM, 5);
		
		this.show();
		
	}

	private void play() {
		
		//leagacy function, no longer needed
		//keeping for reference
		Label myLabel = new Label ("Enter a command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			String sCommand=myTextField.getText().toString();
			myTextField.clear();
			if(!sCommand.isEmpty() && sCommand.length() == 1) {
			switch(sCommand.charAt(0)) {
		
				//Second Delivery 
			//add new asteroid
			case 'a' :
				gw.addAsteroid();
				break;
			//add non player ship
			case 'y' :
				gw.addNonPlayerShip();
				break;
			//add a new blinking space station
			case 'b' :
				gw.addSpaceStation();
				break;
			//add a player ship
			case 's' :
				gw.addPlayerShip();
				break;
			//fire a missile from the player ship
			case 'f' :
				gw.firePsMissile();
				break;
			//launch a missile from the front of the non player ship	
			case 'L' :
				gw.fireNpsMissile();
				break;
			//print a map showing the current world state	
			case 'm' :
				gw.map();
				break;
			//print current game state values	
			case 'p' :
				gw.print();
				break;
				
			//third delivery
			//rotate PS MML CCW
			case '>':
				gw.rotateLauncher();
				break;
			//reload with a new supply of missiles	
			case 'n':
				gw.reloadMissiles();
				break;
			//PS missile has destroyed an asteroid	
			case 'k':
				gw.asteroidKilled();
				break;
			//NPS missile has killed a PS	
			case 'E':
				gw.psShotDown();
				break;
			//PS has shot down an NPS
			case 'e' :
				gw.npsShotDown();
				break;
			//PS has crashed into an asteroid	
			case 'c':
				gw.psCrashIntoAsteroid();
				break;
			//PS has crashed into a NPS	
			case 'h':
				gw.shipCollision();
				break;
			//Two asteroids have collided and mutually destroyed each other	
			case 'x':
				gw.asteroidCollision();
				break;
			//Turn the PS left by a small amount	
			case 'l':
				gw.turnPsLeft();
				break;
				
			//Delivery 1 A2 (remnants of A1)
			//increase the player ship speed by a small amount
				
			case 'i':
				gw.accelPsForward();
				break;
			//decrease the player ship speed by a small amount
				//note: the ship cannot go backwards
			case 'd':
				gw.accelPsBackwards();
				break;
			//an asteroid has collided with a non player ship
			case 'I':
				gw.asteroidHitNps();
				break;
			//turn the player ship right by a small amount
			case 'r':
				gw.turnPsRight();
				break;
			//"Jump through hyperspace"
			//AKA reset the player ship to its starting location
			case 'j':
				gw.JumpThroughHyperspace();
				break;
			//"tick" increment the game time by 1
			case 't':
				gw.tick();
				break;
			//quit ends the program
			case 'q':
				quit();
				break;
				
				
			default:
				System.out.println("Error: Invalid Input.");
			}//switch
					
			}//if
			else{
				System.out.println("Error: Invalid input, one character at a time please.");//if too big;
			}
			}//actionPerformed
		}//new actionListener()
		); //add actionlistener
	}//play
	
	public void quit() {
		Label myLabel = new Label ("Are you sure you want to quit? (y/n):");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			String qCommand=myTextField.getText().toString();
			myTextField.clear();
			if(!qCommand.isEmpty() && qCommand.length() == 1) {
				switch(qCommand.charAt(0)){
				case 'y':
					System.out.println("Thanks for playing!");
					System.exit(0);
					break;
				case 'n': 
					System.out.println("That's the spirit! Returning to game.");
					myTextField.remove();
					myLabel.remove();
					break;
				default:
					System.out.println("Invalid input. y/n");
					}
				}
			else {
				System.out.println("Error: Invalid input. One character at a time please.");
			}
			}
			
		}
		);
	}
		
}//game
