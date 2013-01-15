package de.hoffmann.michael.onlinehome.wst;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        
        Button button = (Button) findViewById(R.id.buttonstart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent intent = new Intent(WelcomeActivity.this, WSTContent.class);
            	if(intent!=null)
        			startActivity(intent);
            }
        });
        
    }

   
}
