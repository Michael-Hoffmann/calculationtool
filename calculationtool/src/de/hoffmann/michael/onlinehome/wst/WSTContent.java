package de.hoffmann.michael.onlinehome.wst;

import java.util.Arrays;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class WSTContent extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);

		String[] values = new String[] {
				this.getString(R.string.title_activity_cond20),
				this.getString(R.string.title_activity_co2from_kb82),
				this.getString(R.string.title_activity_dhfrom_ea),
				this.getString(R.string.title_activity_hco3from_ks43),
				this.getString(R.string.title_activity_hfrom_ea),
				this.getString(R.string.title_activity_khfrom_ks43),
				this.getString(R.string.title_activity_mixcross),
				this.getString(R.string.title_activity_p),
				this.getString(R.string.title_activity_metric_prefix),
				this.getString(R.string.title_activity_si), };
		Arrays.sort(values);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String item = (String) l.getItemAtPosition(position);

		Intent intent = null;
		if (item.equals(this.getString(R.string.title_activity_cond20))) {
			Toast.makeText(getBaseContext(),
					this.getString(R.string.title_activity_cond20),
					Toast.LENGTH_SHORT).show();
			intent = new Intent(WSTContent.this, Cond20Activity.class);
		} else if (item.equals(this
				.getString(R.string.title_activity_co2from_kb82))) {
			Toast.makeText(getBaseContext(),
					this.getString(R.string.title_activity_co2from_kb82),
					Toast.LENGTH_SHORT).show();
			intent = new Intent(WSTContent.this, CO2fromKb82.class);
		} else if (item.equals(this
				.getString(R.string.title_activity_dhfrom_ea))) {
			Toast.makeText(getBaseContext(),
					this.getString(R.string.title_activity_dhfrom_ea),
					Toast.LENGTH_SHORT).show();
			intent = new Intent(WSTContent.this, DHfromEAActivity.class);
		} else if (item.equals(this
				.getString(R.string.title_activity_hco3from_ks43))) {
			Toast.makeText(getBaseContext(),
					this.getString(R.string.title_activity_hco3from_ks43),
					Toast.LENGTH_SHORT).show();
			intent = new Intent(WSTContent.this, HCO3fromKS43Activity.class);
		} else if (item
				.equals(this.getString(R.string.title_activity_hfrom_ea))) {
			Toast.makeText(getBaseContext(),
					this.getString(R.string.title_activity_hfrom_ea),
					Toast.LENGTH_SHORT).show();
			intent = new Intent(WSTContent.this, HfromEAActivity.class);
		} else if (item.equals(this
				.getString(R.string.title_activity_khfrom_ks43))) {
			Toast.makeText(getBaseContext(),
					this.getString(R.string.title_activity_khfrom_ks43),
					Toast.LENGTH_SHORT).show();
			intent = new Intent(WSTContent.this, KHfromKS43Activity.class);
		} else if (item
				.equals(this.getString(R.string.title_activity_mixcross))) {
			Toast.makeText(getBaseContext(),
					this.getString(R.string.title_activity_mixcross),
					Toast.LENGTH_SHORT).show();
			intent = new Intent(WSTContent.this, MixcrossActivity.class);
		} else if (item.equals(this.getString(R.string.title_activity_p))) {
			Toast.makeText(getBaseContext(),
					this.getString(R.string.title_activity_p),
					Toast.LENGTH_SHORT).show();
			intent = new Intent(WSTContent.this, PActivity.class);
		} else if (item.equals(this.getString(R.string.title_activity_si))) {
			Toast.makeText(getBaseContext(),
					this.getString(R.string.title_activity_si),
					Toast.LENGTH_SHORT).show();
			intent = new Intent(WSTContent.this, SiActivity.class);
		} else if (item.equals(this.getString(R.string.title_activity_metric_prefix))) {
			Toast.makeText(getBaseContext(),
					this.getString(R.string.title_activity_metric_prefix),
					Toast.LENGTH_SHORT).show();
			intent = new Intent(WSTContent.this, MetricPrefixActivity.class);
		}

		if (intent != null)
			startActivity(intent);
	}

}
