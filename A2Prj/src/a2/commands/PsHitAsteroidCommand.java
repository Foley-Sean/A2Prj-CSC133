package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PsHitAsteroidCommand extends Command {
private GameWorld gw;
	
	public PsHitAsteroidCommand(GameWorld gw) {
		super("PS has hit an Asteroid");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.psCrashIntoAsteroid();
		//System.out.println("PS has hit an Asteroid");
	}

}
