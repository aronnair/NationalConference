package com.iitb.aakash.nationalconference;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class ContactUs extends Activity {

	
	WebView contact;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_us);
		
		contact = (WebView) findViewById(R.id.web_contact);
		
		contact.loadUrl("file:///android_asset/contact_us.html");
		
	}

	
}
