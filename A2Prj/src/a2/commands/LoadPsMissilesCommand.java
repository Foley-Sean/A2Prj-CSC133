package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class LoadPsMissilesCommand extends Command {
private GameWorld gw;
	
	public LoadPsMissilesCommand(GameWorld gw) {
		super("Load PS");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.reloadMissiles();
		//System.out.println("Load PS");
	}
}
