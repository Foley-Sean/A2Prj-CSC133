package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class IncreasePlayerSpeedCommand extends Command {
private GameWorld gw;
	
	public IncreasePlayerSpeedCommand(GameWorld gw) {
		super("Accelerate");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.accelPsForward();
		//System.out.println("Accelerate");
	}
}
