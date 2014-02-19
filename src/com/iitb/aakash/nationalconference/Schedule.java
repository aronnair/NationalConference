package com.iitb.aakash.nationalconference;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
	

	public class Schedule  extends Activity {

		ImageView day1,day2;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.schedule);
		
		day1=(ImageView)findViewById(R.id.button1);
		day2=(ImageView)findViewById(R.id.button2);
			
		day1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				 File pdfFile = new File("/mnt/sdcard/Coding_Standards.pdf"); 
			        if(pdfFile.exists()) 
			        {

			            Uri path = Uri.fromFile(pdfFile); 
			            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
			            pdfIntent.setDataAndType(path, "application/pdf");
			            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			            startActivity(pdfIntent);
			        }  
			         			            
			            else
			            {
			            	 Uri path = Uri.parse("file:///android_asset/CodingStandards.pdf");
			            	 Intent intent  = new Intent(Intent.ACTION_VIEW);
			            	 intent.setDataAndType(path, "application/pdf");
			            	 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			            	 startActivity(intent);
			            }
			        
		        		      
			}	
			
		});	
		
		day2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				 File pdfFile = new File("/mnt/sdcard/User Manual.pdf"); 
			        if(pdfFile.exists()) 
			        {

			            Uri path = Uri.fromFile(pdfFile); 
			            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
			            pdfIntent.setDataAndType(path, "application/pdf");
			            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			            startActivity(pdfIntent);
			        }  
			         			            
			            else
			            {
			            	 Uri path = Uri.parse("file:///android_asset/User Manual.pdf");
			            	 Intent intent  = new Intent(Intent.ACTION_VIEW);
			            	 intent.setDataAndType(path, "application/pdf");
			            	 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			            	 startActivity(intent);
			            }
			        
		        		      
			}	
			
		});	
		}

		
	}


	
