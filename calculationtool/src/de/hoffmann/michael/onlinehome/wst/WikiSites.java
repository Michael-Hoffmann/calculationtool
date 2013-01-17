package de.hoffmann.michael.onlinehome.wst;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class WikiSites {
	
	public static String CO2 = "http://de.wikipedia.org/wiki/CO2";
	public static String KB = "http://de.wikipedia.org/wiki/Basenkonstante";
	public static String LF = "http://www.wasser-wissen.de/abwasserlexikon/l/leitfaehigkeit.htm";
	public static String CA = "http://de.wikipedia.org/wiki/Calcium";
	public static String MG = "http://de.wikipedia.org/wiki/Magnesium";
	public static String WASSERHAERTE= "http://de.wikipedia.org/wiki/Wasserh%C3%A4rte";
	public static String MASSENKONZENTRATION= "http://de.wikipedia.org/wiki/Massenkonzentration";
	public static String HCO3= "http://de.wikipedia.org/wiki/Hydrogencarbonate";
	public static String KS= "http://www.wasser-wissen.de/abwasserlexikon/s/saeurekapazitaet.htm";
	public static String WASSERANALYSE= "http://de.wikipedia.org/wiki/Wasseranalyse";
	public static String WRMG= "http://www.gesetze-im-internet.de/wrmg/BJNR060000007.html";
	public static String STOFFMENGENKONZENTRATION= "http://de.wikipedia.org/wiki/Stoffmengenkonzentration";
	public static String MISCHUNGSKREUZ= "http://de.wikipedia.org/wiki/Mischungskreuz";
	public static String P= "http://de.wikipedia.org/wiki/Phosphor";
	public static String PO4= "http://de.wikipedia.org/wiki/Phosphate";
	public static String SI= "http://de.wikipedia.org/wiki/Silicium";
	public static String SIO2= "http://de.wikipedia.org/wiki/Silicate";
	public static String PRAEFIX= "http://de.wikipedia.org/wiki/Vors%C3%A4tze_f%C3%BCr_Ma%C3%9Feinheiten";
	
	public static void openSite(String site, Activity activity){
		Uri uri = Uri.parse(site);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		activity.startActivity(intent);
	}

}
