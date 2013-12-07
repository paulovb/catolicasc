package br.com.pvb.guardachuva;

import java.util.ArrayList;

import br.com.pvb.guardachuva.reader.LastScreenView;
import br.com.pvb.guardachuva.reader.Model;
import br.com.pvb.guardachuva.reader.ProductUtil;
import br.com.pvb.guardachuva.reader.RentUtil;
import br.com.pvb.guardachuva.util.SystemUiHider;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class RentActivity extends Activity {

	Button saveButton;

	EditText rentItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.view_rent);

		Model.getInstance().setContext(getApplicationContext());
		
		
		try {
			
			rentItem = (EditText) findViewById(R.id.rent_product);
			rentItem.setHint("Produto: " + Model.getInstance().getReaderData());

			rentItem.refreshDrawableState();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		saveButton = (Button) findViewById(R.id.btn_rent_save);
		saveButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				boolean sucessfull = new RentUtil().createRent(Model.getInstance().getReaderData());

				if (sucessfull) {

					Toast.makeText(getApplicationContext(),
							"Salvo com sucesso!", Toast.LENGTH_LONG).show();

					try {
						finish();
					} catch (Throwable e) {
						e.printStackTrace();
					}

					Intent intent = new Intent(
							Model.getInstance().getContext(),
							com.google.zxing.client.android.CaptureActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
					startActivity(intent);

				}
			}
		});

	}
	
	@Override
	public void onAttachedToWindow() {
		try {
			
			rentItem.setHint("Produto: " + Model.getInstance().getReaderData());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
