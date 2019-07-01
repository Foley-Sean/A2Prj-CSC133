package com.mycompany.a2;

import com.codename1.media.Media;
import java.io.InputStream;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class BGSounds implements Runnable {
	private Media m;
	
	public BGSounds (String fileName) {
		try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+fileName);
			m = MediaManager.createMedia(is, "audio/wav/mp3", this);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void pause() {m.pause();}
	public void play() {m.play();}
	
	@Override
	public void run() {
		// causes audio to continuously play
		m.setTime(0);
		m.play();
		
	}
}
