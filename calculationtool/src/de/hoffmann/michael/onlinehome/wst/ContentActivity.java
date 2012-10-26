package de.hoffmann.michael.onlinehome.wst;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContentActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
//      TODO: Unknown Method, why?
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        String[] values = new String[] { this.getString(R.string.title_activity_wstcontent), this.getString(R.string.title_activity_finance_content)};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        
            
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_overview, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//    	TODO: Unknown code, why?
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String item = (String) l.getItemAtPosition(position);
		
		Intent intent = null;
		if(item.equals(this.getString(R.string.title_activity_wstcontent))){
			Toast.makeText(getBaseContext(), this.getString(R.string.title_activity_wstcontent), Toast.LENGTH_SHORT).show();
			intent = new Intent(ContentActivity.this, WSTContent.class);
		} else if(item.equals(this.getString(R.string.title_activity_finance_content))){
			Toast.makeText(getBaseContext(), this.getString(R.string.title_activity_finance_content), Toast.LENGTH_SHORT).show();
			intent = new Intent(ContentActivity.this, FinanceContent.class);
		}
		
		if(intent!=null)
			startActivity(intent);
	}

    
}
