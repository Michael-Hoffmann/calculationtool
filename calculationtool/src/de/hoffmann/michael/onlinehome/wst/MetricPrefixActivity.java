package de.hoffmann.michael.onlinehome.wst;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MetricPrefixActivity extends Activity {

	public static final String Y = "Yotta";
	public static final String Z = "Zetta";
	public static final String E = "Exa";
	public static final String P = "Peta";
	public static final String T = "Tera";
	public static final String G = "Giga";
	public static final String M = "Mega";
	public static final String k = "Kilo";
	public static final String h = "Hekto";
	public static final String da = "Deka";
	public static final String d = "Dezi";
	public static final String c = "Zenti";
	public static final String m = "Milli";
	public static final String mu = "Mikro";
	public static final String n = "Nano";
	public static final String p = "Piko";
	public static final String f = "Femto";
	public static final String a = "Atto";
	public static final String z = "Zepto";
	public static final Double Yotta = 1000000000000000000000000.0;
	public static final Double Zetta = 1000000000000000000000.0;;
	public static final Double Exa = 1000000000000000000.0;
	public static final Double Peta = 1000000000000000.0;
	public static final Double Tera = 1000000000000.0;
	public static final Double Giga = 1000000000.0;
	public static final Double Mega = 1000000.0;
	public static final Double Kilo = 1000.0;
	public static final Double Hekto = 100.0;
	public static final Double Deka = 10.0;
	public static final Double Dezi = 0.1;
	public static final Double Zenti = 0.01;
	public static final Double Milli = 0.001;
	public static final Double Mikro = 0.000001;
	public static final Double Nano = 0.000000001;
	public static final Double Piko = 0.000000000001;
	public static final Double Femto = 0.000000000000001;
	public static final Double Atto = 0.000000000000000001;
	public static final Double Zepto = 0.000000000000000000001;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_metric_prefix);
		setTitle(R.string.title_activity_metric_prefix);

		Spinner spinner1 = (Spinner) findViewById(R.id.spinnermetrixprefixspinner1);
		Spinner spinner2 = (Spinner) findViewById(R.id.spinnermetrixprefixspinner2);

		List<String> list = new ArrayList<String>();
		list.add(Y);
		list.add(Z);
		list.add(E);
		list.add(P);
		list.add(T);
		list.add(G);
		list.add(M);
		list.add(k);
		list.add(h);
		list.add(da);
		list.add(d);
		list.add(c);
		list.add(m);
		list.add(mu);
		list.add(n);
		list.add(p);
		list.add(f);
		list.add(a);
		list.add(z);

		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter1);
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter2);

		spinner1.setSelection(0);
		spinner2.setSelection(0);

		Button button = (Button) findViewById(R.id.buttonmetrixprefix);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				calc();
			}
		});

	}

	private Double getValueOf(String s) {
		if (s.equals(Y)) {
			return Yotta;
		} else if (s.equals(Z)) {
			return Zetta;
		} else if (s.equals(E)) {
			return Exa;
		} else if (s.equals(P)) {
			return Peta;
		} else if (s.equals(T)) {
			return Tera;
		} else if (s.equals(G)) {
			return Giga;
		} else if (s.equals(M)) {
			return Mega;
		} else if (s.equals(k)) {
			return Kilo;
		} else if (s.equals(h)) {
			return Hekto;
		} else if (s.equals(da)) {
			return Deka;
		} else if (s.equals(d)) {
			return Dezi;
		} else if (s.equals(c)) {
			return Zenti;
		} else if (s.equals(m)) {
			return Milli;
		} else if (s.equals(mu)) {
			return Mikro;
		} else if (s.equals(n)) {
			return Nano;
		} else if (s.equals(p)) {
			return Piko;
		} else if (s.equals(f)) {
			return Femto;
		} else if (s.equals(a)) {
			return Atto;
		} else if (s.equals(z)) {
			return Zepto;
		}
		return null;
	}

	protected void calc() {

		EditText editTextInput = (EditText) findViewById(R.id.editTextmetrixprefix);
		Spinner spinner1 = (Spinner) findViewById(R.id.spinnermetrixprefixspinner1);
		Spinner spinner2 = (Spinner) findViewById(R.id.spinnermetrixprefixspinner2);
		try {

			String s1 = (String) spinner1.getSelectedItem();
			String s2 = (String) spinner2.getSelectedItem();

			Double value = Double.valueOf(editTextInput.getText().toString());
			Double value1 = getValueOf(s1);
			Double value2 = getValueOf(s2);

			double result = value * value1 / value2;

			StringBuilder sb = new StringBuilder();
			sb.append(INFO);
			sb.append("\n\n");
			sb.append("Wert");
			sb.append("=");
			sb.append(Double.toString(value));
			sb.append(s1);
			sb.append("[Einheit]");

			sb.append("\n\n");
			sb.append("Ergebnis:");
			sb.append("\n");
			sb.append("Wert");
			sb.append("=");
			sb.append(Double.toString(result));
			sb.append(s2);
			sb.append("[Einheit]");

			ResultActivity.showMe(sb.toString(), result, this);

		} catch (Exception e) {
			Toast.makeText(getBaseContext(),
					"Bitte geben Sie eine gültige Zahl ein", Toast.LENGTH_SHORT)
					.show();
			e.printStackTrace();
		}

	}

	private static final int INFO_DIALOG = 0;
	private final String INFO = "Umrechnung zwischen den SI-Präfixen";

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_calculation, menu);
		getMenuInflater().inflate(R.menu.menu_metricprefix, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// Show the Info of the calculation
		case R.id.info:
			showDialog(INFO_DIALOG);
			break;
		case R.id.praefix:
			WikiSites.openSite(WikiSites.PRAEFIX, this);
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