package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PrintCommand extends Command {
private GameWorld gw;
	
	public PrintCommand(GameWorld gw) {
		super("Print Command");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.print();
		//System.out.println("Asteroids Collided");
	}

}
