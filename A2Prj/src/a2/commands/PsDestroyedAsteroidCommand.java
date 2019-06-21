package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PsDestroyedAsteroidCommand extends Command {
private GameWorld gw;
	
	public PsDestroyedAsteroidCommand (GameWorld gw) {
		super("PS Killed Asteroid");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.fireNpsMissile();
		//System.out.println("PS Killed Asteroid");
	}
}
