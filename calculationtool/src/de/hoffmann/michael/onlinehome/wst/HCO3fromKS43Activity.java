package de.hoffmann.michael.onlinehome.wst;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HCO3fromKS43Activity extends Activity {

	private NumberFormat numberFormat = new DecimalFormat("0.###");

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hco3from_ks43);
		setTitle(R.string.title_activity_hco3from_ks43);
		numberFormat.setRoundingMode(RoundingMode.HALF_UP);
		Button button = (Button) findViewById(R.id.buttonHCO3Calc);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				calc();
			}
		});

	}

	protected void calc() {

		EditText editTextInput = (EditText) findViewById(R.id.editTextHCO3fromKS43Input);
		try {

			Double value = Double.valueOf(editTextInput.getText().toString());

			double result = value * 61.02;

			StringBuilder sb = new StringBuilder();
			sb.append(INFO);
			sb.append("\n\n");
			sb.append("KS4,3");
			sb.append("=");
			sb.append(numberFormat.format(value));
			sb.append("mmol/l");
			sb.append("\n\n");
			sb.append("Ergebnis:");
			sb.append("\n");
			sb.append("β(HCO3)");
			sb.append("=");
			sb.append(numberFormat.format(result));
			sb.append("mg/l");

			ResultActivity.showMe(sb.toString(), result, this);

		} catch (Exception e) {
			Toast.makeText(getBaseContext(),
					"Bitte geben Sie eine gültige Zahl ein", Toast.LENGTH_SHORT)
					.show();
			e.printStackTrace();
		}

	}

	private static final int INFO_DIALOG = 0;
	private final String INFO = "Berechnung von Hydrogencarbonat aus der Säurekapazität bid pH 4,3";

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_calculation, menu);
		getMenuInflater().inflate(R.menu.menu_hco3fromks43, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// Show the Info of the calculation
		case R.id.info:
			showDialog(INFO_DIALOG);
			break;
		case R.id.hco3:
			WikiSites.openSite(WikiSites.HCO3, this);
			break;
		case R.id.ks43:
			WikiSites.openSite(WikiSites.KS, this);
			break;
		case R.id.wasseranalyse:
			WikiSites.openSite(WikiSites.WASSERANALYSE, this);
			break;

		default:
			break;
		}
		return true;
	}

	@Override
	protected Dialog onCreateDialog(int id) {

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