package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PsDestroyNpsCommand extends Command {
private GameWorld gw;
	
	public PsDestroyNpsCommand(GameWorld gw) {
		super("PS Destroyed NPS");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.npsShotDown();
		//System.out.println("Fire Player Ship Missile");
	}

}
