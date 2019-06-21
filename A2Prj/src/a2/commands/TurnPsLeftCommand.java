package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnPsLeftCommand extends Command {
private GameWorld gw;
	
	public TurnPsLeftCommand(GameWorld gw) {
		super("Turn Left");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.turnPsLeft();
		//System.out.println("Turn PS Left");
	}
}
