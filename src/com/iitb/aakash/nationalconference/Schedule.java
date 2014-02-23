package com.iitb.aakash.nationalconference;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Schedule extends Activity {

	TextView txtHome, txtAbout, txtSchedule, txtInstr, txtArrangements,
			txtContact, day1, day2;
	File checkTar;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedule);
		txtHome = (TextView) findViewById(R.id.txtHome);
		txtAbout = (TextView) findViewById(R.id.txtAbout);
		txtSchedule = (TextView) findViewById(R.id.txtSchedule);
		txtInstr = (TextView) findViewById(R.id.txtInstr);
		txtArrangements = (TextView) findViewById(R.id.txtArrangement);
		txtContact = (TextView) findViewById(R.id.txtContact);
		checkTar = new File("/mnt/sdcard/schedule.zip");

		day1 = (TextView) findViewById(R.id.day1);
		day2 = (TextView) findViewById(R.id.day2);
	
		day1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			
				File pdfFile = new File("/mnt/sdcard/schedule/day1schedule.pdf");
				if (pdfFile.exists()) {

					Uri path = Uri.fromFile(pdfFile);
					Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
					pdfIntent.setDataAndType(path, "application/pdf");
					pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(pdfIntent);
				}

				else {
					startDownload();
					
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Uri path = Uri.fromFile(pdfFile);
					Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
					pdfIntent.setDataAndType(path, "application/pdf");
					pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(pdfIntent);

				}

			}

		});

		day2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				File pdfFile = new File("/mnt/sdcard/schedule/day2schedule.pdf");
				if (pdfFile.exists()) {
					
					
					Uri path = Uri.fromFile(pdfFile);
					Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
					pdfIntent.setDataAndType(path, "application/pdf");
					pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(pdfIntent);
				}

				else {

					startDownload();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Uri path = Uri.fromFile(pdfFile);
					Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
					pdfIntent.setDataAndType(path, "application/pdf");
					pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(pdfIntent);


				}

			}

		});

		txtAbout.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setAlpha((float) 0.2);
				Intent infoactivity = new Intent(Schedule.this, About.class);
				startActivity(infoactivity);
				finish();
			}
		});

		txtHome.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.setAlpha((float) 0.2);
				Intent infoactivity = new Intent(Schedule.this, Home.class);
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
				Intent infoactivity = new Intent(Schedule.this, Speakers.class);
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
				Intent infoactivity = new Intent(Schedule.this,
						Arrangement.class);
				startActivity(infoactivity);
				finish();
			}
		});

		txtContact.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generat	ed method stub
				v.setAlpha((float) 0.2);
				Intent infoactivity = new Intent(Schedule.this, ContactUs.class);
				startActivity(infoactivity);
				finish();
			}
		});

	}

	/******************/
	

	private final boolean isInternetOn() {
		// check internet connection via wifi
		ConnectivityManager connec = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED
				|| connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING
				|| connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING
				|| connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {

			return true;
		} else if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED
				|| connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
			// System.out.println(“Not Connected”);
			return false;
		}
		return false;
	}

	private void spinner() {
		// will start spinner first and then extraction

		// start spinner to show extraction progress

		String zipFile = Environment.getExternalStorageDirectory()
				+ "/schedule.zip";
		String unzipLocation = Environment.getExternalStorageDirectory() + "/";
		new File("mnt/sdcard/schedule").mkdir();
		/*new File("mnt/sdcard/schedule/day1schedule.pdf").mkdir();
		new File("mnt/sdcard/schedule/day2schedule.pdf").mkdir();
*/
		Decompress d = new Decompress(zipFile, unzipLocation);
		d.unzip();
		// Toast.makeText(context, "unzipped", Toast.LENGTH_SHORT).show();

	}

	class DownloadFileAsync extends AsyncTask<String, String, String> {
		/**
		 * download zip from URL and write in '/mnt/sdcard'
		 **/
		@Override
		public void onPreExecute() {
			super.onPreExecute();
		}

		public String doInBackground(String... aurl) {
			int count;

			try {
				URL url = new URL(aurl[0]);
				URLConnection conexion = url.openConnection();
				conexion.connect();

				int lenghtOfFile = conexion.getContentLength();

				InputStream input = new BufferedInputStream(url.openStream());
				OutputStream output = new FileOutputStream(
						"/mnt/sdcard/schedule.zip");

				byte data[] = new byte[1024];

				long total = 0;

				while ((count = input.read(data)) != -1) {
					total += count;
					publishProgress("" + (int) ((total * 100) / lenghtOfFile));
					output.write(data, 0, count);
				}
				output.flush();
				output.close();
				input.close();
			} catch (Exception e) {
			}
			return null;

		}

		public void onProgressUpdate(String... progress) {
			// mProgressDialog.setProgress(Integer.parseInt(progress[0]));
		}

		public void onPostExecute(String unused) {

			if (checkTar.exists()) {
				spinner();

			}
			new Thread() {
				public void run() {
					try {
						// just doing some long operation
						Thread.sleep(10000);
					} catch (Exception e) {
					}
					// handle the exception somehow, or do nothing

					// run code on the UI thread
					runOnUiThread(new Runnable() {

						public void run() {
							// progressBar.dismiss();
							Intent intent = getIntent();
							finish();
							startActivity(intent);
						}
					});
				}
			}.start();

			// progressBar.dismiss();

		}

	}

	/**********/

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
	
	public void startDownload() {
		if (isInternetOn()) {
			// INTERNET IS AVAILABLE, DO STUFF..
			Toast.makeText(getApplicationContext(), "Connected to network",
					Toast.LENGTH_SHORT).show();
		} else {
			// NO INTERNET AVAILABLE, DO STUFF..
			Toast.makeText(getApplicationContext(), "Network disconnected",
					Toast.LENGTH_SHORT).show();
			// rebootFlag = 1;
			AlertDialog.Builder builder = new AlertDialog.Builder(Schedule.this);
			builder.setMessage(
					"No Connection Found, please check your network setting!")
					.setCancelable(false)
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									finish();
									android.os.Process
											.killProcess(android.os.Process
													.myPid());
								}
							});
			AlertDialog alert = builder.create();
			alert.show();

		}
		/**
		 * link for schedule pdf files
		 **/
		String url = "http://www.it.iitb.ac.in/AakashApps/repo/schedule.zip";
		new DownloadFileAsync().execute(url);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.schedule, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.update:

			 // call to export function
			startDownload();

			return true;
		
		default:
			return super.onOptionsItemSelected(item);
		}

		// respond to menu item selection

	}

	
	
}
