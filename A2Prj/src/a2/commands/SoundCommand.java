package a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.BGSounds;
import com.mycompany.a2.Game;
import com.mycompany.a2.GameWorld;

public class SoundCommand extends Command {
private GameWorld gw;
	
	public SoundCommand(GameWorld gw) {
		super("Toggle Sound");
		this.gw = gw;
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		BGSounds bgs = Game.getAudio();
		if(gw.getSound()) {
			gw.setSound(false);
			bgs.pause();
			
		}
		else if(!gw.getSound()) {
			gw.setSound(true);
			bgs.play();
		}
		
	}
	
}
