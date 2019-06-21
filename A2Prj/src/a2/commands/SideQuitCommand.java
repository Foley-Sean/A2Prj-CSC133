package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class SideQuitCommand extends Command {
private GameWorld gw;
	
	public SideQuitCommand(GameWorld gw) {
		super("Side Quit Command");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.quit();
		//System.out.println("Asteroid NPS Collision");
	}
}
