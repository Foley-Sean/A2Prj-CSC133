package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class SaveCommand extends Command {
	public SaveCommand() {
		super("Save");
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		
		Dialog.show("Save", "I don't do anything","OK", "Cancel");
		
		//System.out.println("About");
	}
}
