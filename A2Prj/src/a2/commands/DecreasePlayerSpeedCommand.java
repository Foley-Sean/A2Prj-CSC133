package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class DecreasePlayerSpeedCommand extends Command{
private GameWorld gw;
	
	public DecreasePlayerSpeedCommand(GameWorld gw) {
		super("Deccelerate");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.accelPsBackwards();
		//System.out.println("Deccelerate");
	}
}
