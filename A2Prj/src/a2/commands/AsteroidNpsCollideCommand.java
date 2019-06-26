package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AsteroidNpsCollideCommand extends Command {
private GameWorld gw;
	
	public AsteroidNpsCollideCommand(GameWorld gw) {
		super("Asteroid NPS Collision");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.asteroidHitNps();
		//System.out.println("Asteroid NPS Collision");
	}

}
