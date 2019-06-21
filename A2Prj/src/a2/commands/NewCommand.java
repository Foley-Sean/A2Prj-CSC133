package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class NewCommand extends Command {
	
	public NewCommand() {
		super("New");
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		
		Dialog.show("Save", "I don't do anything.", "OK", "Cancel");
		
		//System.out.println("About");
	}
}
