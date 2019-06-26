package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class UndoCommand extends Command {
	
	public UndoCommand() {
		super("Undo");
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		
		Dialog.show("Undo", "I don't do anything.", "OK", "Cancel");
		
		//System.out.println("About");
	}
}
