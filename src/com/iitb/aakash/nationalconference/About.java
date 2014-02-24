package com.iitb.aakash.nationalconference;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.TextView;

public class About extends Activity {

	TextView txtHome, txtAbout, txtSchedule, txtInstr, txtArrangements,
			txtContact;
	WebView about;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

		txtHome = (TextView) findViewById(R.id.txtHome);
		txtAbout = (TextView) findViewById(R.id.txtAbout);
		txtSchedule = (TextView) findViewById(R.id.txtSchedule);
		txtInstr = (TextView) findViewById(R.id.txtInstr);
		txtArrangements = (TextView) findViewById(R.id.txtArrangement);
		txtContact = (TextView) findViewById(R.id.txtContact);

		txtHome.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setAlpha((float) 0.2);
				Intent infoactivity = new Intent(About.this, Home.class);
				startActivity(infoactivity);
				finish();
			}
		});

		txtSchedule.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setAlpha((float) 0.2);
				Intent infoactivity = new Intent(About.this, Schedule.class);
				startActivity(infoactivity);
				finish();
			}
		});

		/*txtSpeakers.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setAlpha((float) 0.2);
				Intent infoactivity = new Intent(About.this, Speakers.class);
				startActivity(infoactivity);
				finish();
			}
		});*/
		
		txtInstr.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				File pdfFile = new File("/mnt/sdcard/schedule/geninstr.pdf");
				if (pdfFile.exists()) {

					Uri path = Uri.fromFile(pdfFile);
					Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
					pdfIntent.setDataAndType(path, "application/pdf");
					pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(pdfIntent);
				}
	
			}
		});

		txtArrangements.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setAlpha((float) 0.2);
				Intent infoactivity = new Intent(About.this, Arrangement.class);
				startActivity(infoactivity);
				finish();
			}
		});

		txtContact.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setAlpha((float) 0.2);
				Intent infoactivity = new Intent(About.this, ContactUs.class);
				startActivity(infoactivity);
				finish();
			}
		});

		about = (WebView) findViewById(R.id.web_arrangement);
		about.loadUrl("file:///android_asset/about.html");
	}

	/*** code for On back pressed dialog box **/
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitByBackKey();

			// moveTaskToBack(false);

			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	protected void exitByBackKey() {

		AlertDialog alertbox = new AlertDialog.Builder(this)
				.setMessage("Do you want to exit application?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {

							// do something when the button is clicked
							public void onClick(DialogInterface arg0, int arg1) {

								finish();
								// close();

							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {

					// do something when the button is clicked
					public void onClick(DialogInterface arg0, int arg1) {
					}
				}).show();

	}

}
