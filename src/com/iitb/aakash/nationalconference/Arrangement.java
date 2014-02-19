package com.iitb.aakash.nationalconference;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class Arrangement extends Activity {
	
	WebView arrangement;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.arrangement);
		arrangement=(WebView)findViewById(R.id.web_arrangement);
		arrangement.loadUrl("file:///android_asset/arrangement.html");	
		
	}

	

}
