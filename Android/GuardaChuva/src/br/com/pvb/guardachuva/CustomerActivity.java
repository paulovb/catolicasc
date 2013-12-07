package br.com.pvb.guardachuva;

import java.util.ArrayList;

import br.com.pvb.guardachuva.reader.LastScreenView;
import br.com.pvb.guardachuva.reader.Model;
import br.com.pvb.guardachuva.util.SystemUiHider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class CustomerActivity extends Activity {

	Button saveCustomer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.view_customer);

		Model.getInstance().setContext(getApplicationContext());

		saveCustomer = (Button) findViewById(R.id.btn_customer_save);
		saveCustomer.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

			}
		});
	}
}
