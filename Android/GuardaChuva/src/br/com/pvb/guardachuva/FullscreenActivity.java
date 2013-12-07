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
public class FullscreenActivity extends Activity {

	Button registryCustomer;

	Button registryUmbrela;

	Button rentUmbrela;

	Button returnUmbrela;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_fullscreen);

		Model.getInstance().setContext(getApplicationContext());

		registryCustomer = (Button) findViewById(R.id.registrycustomer);
		registryCustomer.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Intent intent = new Intent(getApplicationContext(),CustomerActivity.class);
				startActivity(intent);
				
			}
		});

		registryUmbrela = (Button) findViewById(R.id.registryumbrela);
		registryUmbrela.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Model.getInstance().setLastScreenView(
						LastScreenView.Screen.Registry);

				Intent intent = new Intent(getApplicationContext(),
						com.google.zxing.client.android.CaptureActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);

			}
		});

		rentUmbrela = (Button) findViewById(R.id.rentumbrela);
		rentUmbrela.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Model.getInstance().setLastScreenView(
						LastScreenView.Screen.Rent);

				Intent intent = new Intent(getApplicationContext(),
						com.google.zxing.client.android.CaptureActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);

			}
		});

		returnUmbrela = (Button) findViewById(R.id.returnumbrela);
		returnUmbrela.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Model.getInstance().setLastScreenView(
						LastScreenView.Screen.Return);

				Intent intent = new Intent(getApplicationContext(),
						com.google.zxing.client.android.CaptureActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);

			}
		});

	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == 1) {
				// Handle successful scan
				String capturedQrValue = intent.getStringExtra("RESULT");

				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

				// String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				Toast.makeText(this, "Scan Result:" + capturedQrValue,
						Toast.LENGTH_SHORT).show();

			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
			}
		} else {

		}
	}

}
