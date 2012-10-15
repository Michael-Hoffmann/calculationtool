package de.hoffmann.michael.onlinehome.wst;

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
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Cond20Activity extends Activity {
	
	private final int RESULT_DIALOG = 1;
	private NumberFormat numberFormat = new DecimalFormat("0.###");
	private Double result = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cond20);
        setTitle(R.string.cond20);
        
        Button button = (Button) findViewById(R.id.buttonCondCalc);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               calc();
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_cond20, menu);
        return true;
    }

	protected void calc() {
		
		EditText editTextInput = (EditText)findViewById(R.id.editTextCondInput);
    	RadioButton radioButton = (RadioButton)findViewById(R.id.radioButton2025);
    	try{
    		
    		Double value = Double.valueOf(editTextInput.getText().toString());
    		if(radioButton.isChecked()){
    			result = value * 1.116;
    		} else {
    			result = value / 1.116;
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

	
}
