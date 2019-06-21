package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnMlRightCommand extends Command {
private GameWorld gw;
	
	public TurnMlRightCommand(GameWorld gw) {
		super("Turn ML Right");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.rotateLauncherRight();
		//System.out.println("Turn ML Right");
	}
}
