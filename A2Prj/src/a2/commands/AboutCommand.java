package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {
	
	public AboutCommand() {
		super("About");
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		
		Dialog.show("About", "This is my Asteroid game coded for CSC133 in the Summer of 2019. Thanks for checking it out."
				+ "Version .5", "OK", "Cancel");
		
		//System.out.println("About");
	}
}
