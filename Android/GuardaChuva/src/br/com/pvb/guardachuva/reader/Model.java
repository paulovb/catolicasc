package br.com.pvb.guardachuva.reader;

import android.content.Context;

public class Model {
	
	private static Model instance;
		
	private Model() { }
	
	public static Model getInstance() {
		if ( instance == null ) {
			instance = new Model();
		}
		
		return instance;
	}


	private String readerData;
	
	private LastScreenView.Screen lastScreenView;
	
	private Context context;
	
	
	public String getReaderData() {
		return readerData;
	}

	public void setReaderData(String readerData) {
		this.readerData = readerData;
	}

	public LastScreenView.Screen getLastScreenView() {
		return lastScreenView;
	}

	public void setLastScreenView(LastScreenView.Screen lastScreenView) {
		this.lastScreenView = lastScreenView;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}


}
