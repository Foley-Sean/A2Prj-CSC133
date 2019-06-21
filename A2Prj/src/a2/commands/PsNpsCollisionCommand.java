package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PsNpsCollisionCommand extends Command {
private GameWorld gw;
	
	public PsNpsCollisionCommand(GameWorld gw) {
		super("PS has crashed into NPS");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.shipCollision();
		//System.out.println("PS has crashed into NPS");
	}

}
