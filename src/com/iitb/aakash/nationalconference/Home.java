package com.iitb.aakash.nationalconference;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Home extends Activity {

	TextView txtHome, txtAbout,txtInstr, txtSchedule, txtArrangements,
			txtContact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		txtHome = (TextView) findViewById(R.id.txtHome);
		txtAbout = (TextView) findViewById(R.id.txtAbout);
		txtSchedule = (TextView) findViewById(R.id.txtSchedule);
		/*txtSpeakers = (TextView) findViewById(R.id.txtSpeaker);*/
		txtInstr = (TextView) findViewById(R.id.txtInstr);
		txtArrangements = (TextView) findViewById(R.id.txtArrangement);
		txtContact = (TextView) findViewById(R.id.txtContact);

		txtAbout.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setAlpha((float) 0.2);
				Intent infoactivity = new Intent(Home.this, About.class);
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
				Intent infoactivity = new Intent(Home.this, Schedule.class);
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
				Intent infoactivity = new Intent(Home.this, Speakers.class);
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
				Intent infoactivity = new Intent(Home.this, Arrangement.class);
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
				Intent infoactivity = new Intent(Home.this, ContactUs.class);
				startActivity(infoactivity);
				finish();
			}
		});

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
