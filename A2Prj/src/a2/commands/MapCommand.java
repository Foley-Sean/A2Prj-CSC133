package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class MapCommand extends Command {
private GameWorld gw;
	
	public MapCommand(GameWorld gw) {
		super("Map");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.map();
		//System.out.println("PS has hit an Asteroid");
	}
}
