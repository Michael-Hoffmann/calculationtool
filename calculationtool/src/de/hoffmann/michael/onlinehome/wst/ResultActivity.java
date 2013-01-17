package de.hoffmann.michael.onlinehome.wst;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ResultActivity extends Activity {
	
	private static final String TEXT = "text";
	private static final String RESULT = "result";
	
	private String text;
	private Double result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            text = extras.getString(TEXT);
            result = extras.getDouble(RESULT);
        }
        
        EditText editTextInput = (EditText)findViewById(R.id.editTextResultInput);
        editTextInput.setText(text);
        editTextInput.setEnabled(false);
        editTextInput.setFocusable(false);
    }
    
    public static void showMe(String text, double result, Activity activity){
    	Toast.makeText(activity.getBaseContext(), activity.getString(R.string.title_activity_result), Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(activity, ResultActivity.class);
		intent.putExtra(TEXT, text);
		intent.putExtra(RESULT, result);
		activity.startActivity(intent);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
    	// send result as mail
		case R.id.mail:
			sendMail();
			break;
		case R.id.copy_all:
			copy(true);
			break;
		case R.id.copy_result:
			copy(false);
			break;
		default:
			break;
		}
    	return true;
	}


	private void copy(boolean all) {
		ClipboardManager clipboard = (ClipboardManager)
		        getSystemService(Context.CLIPBOARD_SERVICE);
		if(all){
			clipboard.setText(text);
		} else {
			clipboard.setText(result.toString());
		}
	}

	private void sendMail() {
		Intent email = new Intent(Intent.ACTION_SEND);
		email.putExtra(Intent.EXTRA_TEXT, text);
		email.setType("message/rfc822");
		startActivity(Intent.createChooser(email, "Wähle einen E-Mailclient: "));
		
	}
    
    
}
