package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class NpsFireMissileCommand extends Command {
private GameWorld gw;
	
	public NpsFireMissileCommand(GameWorld gw) {
		super("Fire NPS Missile");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.fireNpsMissile();
		//System.out.println("Fire NPS Missile");
	}
}
