package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class NpsDestroyPsCommand extends Command{
private GameWorld gw;
	
	public NpsDestroyPsCommand(GameWorld gw) {
		super("NPS has killed PS");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.psShotDown();
		//System.out.println("Fire Player Ship Missile");
	}
}
