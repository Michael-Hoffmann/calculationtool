package de.hoffmann.michael.onlinehome.wst;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SimpleInterestActivity extends Activity {
	
	private final int RESULT_DIALOG = 1;
	private NumberFormat numberFormat = new DecimalFormat("0.00");
	private Double result = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest);
        
        Button button = (Button) findViewById(R.id.buttonSICalculate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               calc();
            }
        });
        
    }

    protected void calc() {
		
    	Double k0 = null;
    	Double p = null;
    	Double i = null;
    	Double n = null;
    	
    	   	
    	try{
    		k0 = Double.valueOf(((EditText)findViewById(R.id.editTextSIInitial_Capital)).getText().toString());
    	}catch(NumberFormatException e){
    		Toast.makeText(getBaseContext(), getString(R.string.initial_capital) + "\n\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
    		e.printStackTrace();
    		return;
    	}
    	
    	try{
    		p = Double.valueOf(((EditText)findViewById(R.id.editTextSIPrincipal)).getText().toString());
    	}catch(NumberFormatException e){
//    		Toast.makeText(getBaseContext(), getString(R.string.principal) + "\n\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
    		e.printStackTrace();
    	}
    	
    	try{
    		i = Double.valueOf(((EditText)findViewById(R.id.editTextSiInterestRatePeriod)).getText().toString());
    	}catch(NumberFormatException e){
//    		Toast.makeText(getBaseContext(), getString(R.string.interest_rate_period) + "\n\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
    		e.printStackTrace();
    	}
    	
    	try{
    		n = Double.valueOf(((EditText)findViewById(R.id.editTextSINumberOfPeriods)).getText().toString());
    	}catch(NumberFormatException e){
    		Toast.makeText(getBaseContext(), getString(R.string.number_of_periods) + "\n\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
    		e.printStackTrace();
    		return;
    	}
    	
    	if(p == null && i == null){
    		Toast.makeText(getBaseContext(), "calculation not possible\n\n" + getString(R.string.principal) + " and "  + getString(R.string.interest_rate_period) + "are empty", Toast.LENGTH_SHORT).show();
    		return;
    	}
    	
    	try{
    		
    		if(i==null){
    			result = k0 * (1+p/100*n);
    		} else {
    			result = k0 * (1+i*n);
    		}
    		
    		showDialog(RESULT_DIALOG);
    		
    	}catch(Exception e){
    		Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    		e.printStackTrace();
    	}
    	
	}
	
	
	
	@Override
	protected Dialog onCreateDialog(int id) {
		
	  switch (id) {
	  
	    case RESULT_DIALOG:
	    // Show the Result of the calculation
	    Builder builder = new AlertDialog.Builder(this);
	    builder.setMessage("The Result is " + numberFormat.format(result));
	    builder.setCancelable(true);
	    builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){

			public void onClick(DialogInterface dialog, int which) {
				
			}
	    	
	    });
	    
	    AlertDialog dialog = builder.create();
	    dialog.show();
	    
	   }
	  
	  return super.onCreateDialog(id);
	  
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_simple_interest, menu);
        return true;
    }
}
