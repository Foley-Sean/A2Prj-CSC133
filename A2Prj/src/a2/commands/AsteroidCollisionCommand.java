package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AsteroidCollisionCommand extends Command {
private GameWorld gw;
	
	public AsteroidCollisionCommand(GameWorld gw) {
		super("Asteroids Collided");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.asteroidCollision();
		//System.out.println("Asteroids Collided");
	}

}
