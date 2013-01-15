package de.hoffmann.michael.onlinehome.wst;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Cond20Activity extends Activity {

	private NumberFormat numberFormat = new DecimalFormat("0.###");

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cond20);
		setTitle(R.string.cond20);
		numberFormat.setRoundingMode(RoundingMode.HALF_UP);
		Button button = (Button) findViewById(R.id.buttonCondCalc);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				calc();
			}
		});

	}

	protected void calc() {

		EditText editTextInput = (EditText) findViewById(R.id.editTextCondInput);
		RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton2025);
		try {
			double result = -1;
			Double value = Double.valueOf(editTextInput.getText().toString());
			if (radioButton.isChecked()) {
				result = value * 1.116;
			} else {
				result = value / 1.116;
			}

			String text = "Das Ergebnis für eine Umrechung der Leitfähigkeit von "
					+ value
					+ " bei Referenztemperatur "
					+ (radioButton.isChecked() ? "20°C" : "25°C")
					+ " auf eine Referenztemperatur von "
					+ (radioButton.isChecked() ? "20°C" : "25°C")
					+ " lautet "
					+ result;

			ResultActivity.showMe(text, this);

		} catch (Exception e) {
			Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT)
					.show();
			e.printStackTrace();
		}

	}
	
	private static final int INFO_DIALOG = 0;
	private final String INFO = "Umrechung der Leitfähigkeit zwischen den Referenztemperaturen 20°C und 25°C";
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_calculation, menu);
		getMenuInflater().inflate(R.menu.menu_cond, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// Show the Info of the calculation
		case R.id.info:
			showDialog(INFO_DIALOG);
			break;
		case R.id.co2:
			WikiSites.openSite(WikiSites.lf, this);
			break;
		case R.id.kb:
			WikiSites.openSite(WikiSites.KB, this);
			break;

		default:
			break;
		}
		return true;
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		numberFormat.setRoundingMode(RoundingMode.HALF_UP);
		switch (id) {

		case INFO_DIALOG:
			// Show the Info of the calculation
			Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(INFO);
			builder.setCancelable(true);
			builder.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {

						}

					});

			AlertDialog dialog = builder.create();
			dialog.show();

		}

		return super.onCreateDialog(id);

	}

}

