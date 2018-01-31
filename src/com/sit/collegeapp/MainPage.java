package com.sit.collegeapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainPage extends Activity {
Button but1,but2,but3,but4,but5,but6,but7,but8,but9;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		 addListenerOnButton();
	}

	public void addListenerOnButton() {
		final Context context = this;
		but1 = (Button) findViewById(R.id.button1);
		but1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(context, AboutUs.class);
                 startActivity(intent);  
			}
		});
		
		but2 = (Button) findViewById(R.id.Button01);
		but2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(context, AboutCollege.class);
                 startActivity(intent);  
			}
		});
		
		
		but3 = (Button) findViewById(R.id.Button02);
		but3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(context, BranchesPage.class);
                 startActivity(intent);  
			}
		});
		
		
		but4 = (Button) findViewById(R.id.Button03);
		but4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(context, StaffPage.class);
                 startActivity(intent);  
			}
		});
		
		but5 = (Button) findViewById(R.id.Button04);
		but5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 
				 Intent intent = new Intent(context, FaciPage.class);
                 startActivity(intent);  
			}
		});

		
		but6 = (Button) findViewById(R.id.Button05);
		but6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(context, NotificationPage.class);
                 startActivity(intent);  
			}
		});
		
		
		but7 = (Button) findViewById(R.id.Button06);
		but7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(context, Attendance.class);
                 startActivity(intent);  
			}
		});
		
		but8 = (Button) findViewById(R.id.Button07);
		but8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(context, ResultPage.class);
                 startActivity(intent);  
			}
		});
		
		but9 = (Button) findViewById(R.id.Button08);
		but9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 finish();
				 System.exit(0);
			}
		});
		
		
	}
}
