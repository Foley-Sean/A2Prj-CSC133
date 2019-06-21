package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class FirePlayerShipMissleCommand extends Command {
private GameWorld gw;
	
	public FirePlayerShipMissleCommand(GameWorld gw) {
		super("Fire Player Ship");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.firePsMissile();
		//System.out.println("Fire Player Ship Missile");
	}
}
