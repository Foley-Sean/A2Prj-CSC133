package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class JumpThroughHyperSpaceCommand extends Command {
private GameWorld gw;
	
	public JumpThroughHyperSpaceCommand (GameWorld gw) {
		super("Jump Home");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		gw.JumpThroughHyperspace();
		//System.out.println("Jump Home");
	}
}
