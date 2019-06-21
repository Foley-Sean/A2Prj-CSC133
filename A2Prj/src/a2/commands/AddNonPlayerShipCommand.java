package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddNonPlayerShipCommand extends Command {

private GameWorld gw;
	
	public AddNonPlayerShipCommand(GameWorld gw) {
		super("Add Non Player Ship");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if(e.getKeyEvent() != -1) {
		gw.addNonPlayerShip();
		//System.out.println("Add Non Player Ship Command");
		}
	}
}
