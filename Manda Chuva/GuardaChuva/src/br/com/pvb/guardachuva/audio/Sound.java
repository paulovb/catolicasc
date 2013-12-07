package br.com.pvb.guardachuva.audio;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class Sound {

	public static void readerDataSucessfull(Context context) {
		AssetFileDescriptor afd;
		try {
			afd = context.getAssets().openFd("reader.wav");
			
			MediaPlayer player = new MediaPlayer();
		    player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
		    player.prepare();
		    player.start();
		    
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
