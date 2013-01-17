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

public class MixcrossActivity extends Activity {

	private NumberFormat numberFormat = new DecimalFormat("0.###");

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mixcross);
        setTitle(R.string.title_activity_mixcross);
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        Button button = (Button) findViewById(R.id.buttonMixCross);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               calc();
            }
        });
        
    }

   

	protected void calc() {
		
		EditText editTextInputL1 = (EditText)findViewById(R.id.editTextmixcrossL1Input);
		EditText editTextInputL2 = (EditText)findViewById(R.id.editTextmixcrossL2Input);
		EditText editTextInputLEnd = (EditText)findViewById(R.id.editTextmixcrossLEndInput);
		EditText editTextInputVEnd = (EditText)findViewById(R.id.editTextmixcrossVEndInput);
    	try{
    		
    		Double valueL1 = Double.valueOf(editTextInputL1.getText().toString());
    		Double valueL2 = Double.valueOf(editTextInputL2.getText().toString());
    		Double valueLEnd = Double.valueOf(editTextInputLEnd.getText().toString());
    		Double valueVEnd = Double.valueOf(editTextInputVEnd.getText().toString());

    		double result1 = (valueLEnd - valueL2) / (valueL1 - valueLEnd);
    		result1 = valueVEnd / (1+(1/result1));
    		double result2 = valueVEnd - result1;
    		    		
    		StringBuilder sb = new StringBuilder();
			sb.append(INFO);
			sb.append("\n\n");
			sb.append("Konzentration Lösung1");
			sb.append("=");
			sb.append(numberFormat.format(valueL1));
			sb.append("Konzentration Lösung2");
			sb.append("=");
			sb.append(numberFormat.format(valueL2));
			sb.append("Konzentration Endlösung");
			sb.append("=");
			sb.append(numberFormat.format(valueLEnd));
			sb.append("\n\n");
			sb.append("Ergebnis:");
			sb.append("\n");
			sb.append("Mengenanteil Lösung1");
			sb.append("=");
			sb.append(numberFormat.format(result1));
			sb.append("Mengenanteil Lösung2");
			sb.append("=");
			sb.append(numberFormat.format(result2));

			ResultActivity.showMe(sb.toString(), result1, this);

		} catch (Exception e) {
			Toast.makeText(getBaseContext(),
					"Bitte geben Sie eine gültige Zahl ein", Toast.LENGTH_SHORT)
					.show();
			e.printStackTrace();
		}

	}

	private static final int INFO_DIALOG = 0;
	private final String INFO = "Mischungskreuz zur Berechung der Mengenverhälnisse beim Mischen von Lösungen mit unterschiedlichen Ausgangskonzentrationen zu einer bestimmten Endkonzentration";

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_calculation, menu);
		getMenuInflater().inflate(R.menu.menu_mixcross, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// Show the Info of the calculation
		case R.id.info:
			showDialog(INFO_DIALOG);
			break;
		case R.id.ks43:
			WikiSites.openSite(WikiSites.KS, this);
			break;
		case R.id.wasserhaerte:
			WikiSites.openSite(WikiSites.WASSERHAERTE, this);
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