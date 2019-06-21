package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnMlLeftCommand extends Command{
private GameWorld gw;
	
	public TurnMlLeftCommand(GameWorld gw) {
		super("Turn ML Left");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.rotateLauncher();
		//System.out.println("Turn ML Left");
	}
}
