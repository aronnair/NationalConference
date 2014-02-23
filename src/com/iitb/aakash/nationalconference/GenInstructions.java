package com.iitb.aakash.nationalconference;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GenInstructions extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gen_instructions);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gen_instructions, menu);
		return true;
	}

}
