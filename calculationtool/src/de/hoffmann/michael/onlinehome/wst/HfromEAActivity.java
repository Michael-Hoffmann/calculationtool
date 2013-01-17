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

public class HfromEAActivity extends Activity {

	private NumberFormat numberFormat = new DecimalFormat("0.###");

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hfrom_ea);
        setTitle(R.string.title_activity_hfrom_ea);
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        Button button = (Button) findViewById(R.id.buttonHEACalc);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               calc();
            }
        });
        
    }


	protected void calc() {
		
		EditText editTextInputCa = (EditText)findViewById(R.id.editTextHfromEACaInput);
		EditText editTextInputMg = (EditText)findViewById(R.id.editTextHfromEAMgInput);
    	try{
    		
    		Double valueCa = Double.valueOf(editTextInputCa.getText().toString());
    		Double valueMg = Double.valueOf(editTextInputMg.getText().toString());

    		double result = valueCa / 40.08 + valueMg / 24.305;
    		
    		StringBuilder sb = new StringBuilder();
			sb.append(INFO);
			sb.append("\n\n");
			sb.append("c(Ca)");
			sb.append("=");
			sb.append(numberFormat.format(valueCa));
			sb.append("mmol/l");
			sb.append("\n");
			sb.append("c(Mg)");
			sb.append("=");
			sb.append(numberFormat.format(valueMg));
			sb.append("mmol/l");
			sb.append("\n\n");
			sb.append("Ergebnis:");
			sb.append("\n");
			sb.append("Härte");
			sb.append("=");
			sb.append(numberFormat.format(result));
			sb.append("mmol/l");
			sb.append("\n\n");
			sb.append("Wasserhärtebereich nach WRMG 2007");
			sb.append("=");
			sb.append(result<1.5 ? "weich" : (result > 2.5 ? "hart" : "mittel"));

			ResultActivity.showMe(sb.toString(), result, this);

		} catch (Exception e) {
			Toast.makeText(getBaseContext(),
					"Bitte geben Sie eine gültige Zahl ein", Toast.LENGTH_SHORT)
					.show();
			e.printStackTrace();
		}

	}

	private static final int INFO_DIALOG = 0;
	private final String INFO = "Berechnung der Gesamthärte in °DH aus den Massenkonzentrationen von Calcium und Magnesium";

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_calculation, menu);
		getMenuInflater().inflate(R.menu.menu_hfromea, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// Show the Info of the calculation
		case R.id.info:
			showDialog(INFO_DIALOG);
			break;
		case R.id.ca:
			WikiSites.openSite(WikiSites.CA, this);
			break;
		case R.id.mg:
			WikiSites.openSite(WikiSites.MG, this);
			break;
		case R.id.stoffmengenkonzentration:
			WikiSites.openSite(WikiSites.STOFFMENGENKONZENTRATION, this);
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